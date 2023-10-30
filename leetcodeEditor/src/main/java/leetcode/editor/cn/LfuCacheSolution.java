package leetcode.editor.cn;
//请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。 
//
// 实现 LFUCache 类： 
//
// 
// LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象 
// int get(int key) - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。 
// void put(int key, int value) - 如果键 key 已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量 
//capacity 时，则应该在插入新项之前，移除最不经常使用的项。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最久未使用 的键。 
// 
//
// 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。 
//
// 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
//
// 
//
// 示例： 
//
// 
//输入：
//["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", 
//"get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
//输出：
//[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
//
//解释：
//// cnt(x) = 键 x 的使用计数
//// cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
//LFUCache lfu = new LFUCache(2);
//lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
//lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
//lfu.get(1);      // 返回 1
//                 // cache=[1,2], cnt(2)=1, cnt(1)=2
//lfu.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
//                 // cache=[3,1], cnt(3)=1, cnt(1)=2
//lfu.get(2);      // 返回 -1（未找到）
//lfu.get(3);      // 返回 3
//                 // cache=[3,1], cnt(3)=2, cnt(1)=2
//lfu.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
//                 // cache=[4,3], cnt(4)=1, cnt(3)=2
//lfu.get(1);      // 返回 -1（未找到）
//lfu.get(3);      // 返回 3
//                 // cache=[3,4], cnt(4)=1, cnt(3)=3
//lfu.get(4);      // 返回 4
//                 // cache=[3,4], cnt(4)=2, cnt(3)=3 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 10⁴ 
// 0 <= key <= 10⁵ 
// 0 <= value <= 10⁹ 
// 最多调用 2 * 10⁵ 次 get 和 put 方法 
// 
//
// 👍 792 👎 0


import java.util.*;

/**
 * LFU 缓存
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-10-30 17:30:27 
 */
public class LfuCacheSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class LFUCache {

    private final int capacity;
    // 存储所有节点
    private final HashMap<Integer, Node<Integer, Integer>> cache;
    // 按频率存储双向队列的头节点
    private final HashMap<Integer, Node<Integer, Integer>> freq;
    private int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        freq = new HashMap<>();
        minFreq = 0;
    }
    
    public int get(int key) {
        Node<Integer, Integer> node = readNode(key);
        return node != null ? node.value : -1;
    }
    
    public void put(int key, int value) {
        Node<Integer, Integer> node = readNode(key);
        // 该节点存在，更新
        if (node != null) {
            node.value = value;
            return;
        }
        // 该节点不存在
        if (cache.size() == capacity) {
            // 缓存容量满，淘汰一个节点
            Node<Integer, Integer> preHead = freq.get(minFreq);
            // 删除队尾节点
            Node<Integer, Integer> tailNode = preHead.prev;
            cache.remove(tailNode.key);
            tailNode.remove();
        }

        node = new Node<>(key, value);
        cache.put(key, node);
        addFirst(node, 1);
        minFreq = 1;
    }

    // 访问节点，并增加节点频率计数
    private Node<Integer, Integer> readNode(int key) {
        if (!cache.containsKey(key)) {
            return null;
        }
        Node<Integer, Integer> node = cache.get(key);
        // 将该节点从原来的链表中取出
        node.remove();
        Node<Integer, Integer> preHead = freq.get(node.freq);
        if (preHead.next == preHead) {
            if (node.freq == minFreq) {
                minFreq++;
            }
        }
        // 放入频率加一的链表
        node.freq++;
        addFirst(node, node.freq);
        return node;
    }

    // 在指定链表头插入一个节点
    private void addFirst(Node<Integer, Integer> node, int f) {
        Node<Integer, Integer> preHead = freq.computeIfAbsent(f, k -> newList());
        node.prev = preHead;
        node.next = preHead.next;
        node.prev.next = node;
        node.next.prev = node;
    }

    private Node<Integer, Integer> newList() {
        Node<Integer, Integer> preHead = new Node<>(0, 0);
        preHead.next = preHead;
        preHead.prev = preHead;
        return preHead;
    }



    // 双向链表节点
    class Node<K, V> {
        K key;
        V value;
        int freq;
        Node<K, V> prev, next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            freq = 1;
        }

        // 从所在的链表删除该节点
        private void remove() {
            this.next.prev = this.prev;
            this.prev.next = this.next;
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
