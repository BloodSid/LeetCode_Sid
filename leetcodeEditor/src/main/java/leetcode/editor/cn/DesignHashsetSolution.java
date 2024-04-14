package leetcode.editor.cn;
//不使用任何内建的哈希表库设计一个哈希集合（HashSet）。 
//
// 实现 MyHashSet 类： 
//
// 
// void add(key) 向哈希集合中插入值 key 。 
// bool contains(key) 返回哈希集合中是否存在这个值 key 。 
// void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。 
// 
//
// 示例： 
//
// 
//输入：
//["MyHashSet", "add", "add", "contains", "contains", "add", "contains", 
//"remove", "contains"]
//[[], [1], [2], [1], [3], [2], [2], [2], [2]]
//输出：
//[null, null, null, true, false, null, true, null, false]
//
//解释：
//MyHashSet myHashSet = new MyHashSet();
//myHashSet.add(1);      // set = [1]
//myHashSet.add(2);      // set = [1, 2]
//myHashSet.contains(1); // 返回 True
//myHashSet.contains(3); // 返回 False ，（未找到）
//myHashSet.add(2);      // set = [1, 2]
//myHashSet.contains(2); // 返回 True
//myHashSet.remove(2);   // set = [1]
//myHashSet.contains(2); // 返回 False ，（已移除） 
//
// 
//
// 提示： 
//
// 
// 0 <= key <= 10⁶ 
// 最多调用 10⁴ 次 add、remove 和 contains 
// 
//
// 👍 342 👎 0


/**
 * 设计哈希集合
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-04-14 14:45:19 替换字符可以得到的最晚时间
 */
public class DesignHashsetSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class MyHashSet {

    private final int m;
    private final Node[] data;
    class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public MyHashSet() {
        // 1e4 次调用，装载因子0.75，设计用 13337 做模
        m = 13337;
        data = new Node[m];
    }


    
    public void add(int key) {
        int offset = key % m;
        if (!has(data[offset], key)) {
            Node t = data[offset];
            data[offset] = new Node(key);
            data[offset].next = t;
        }
    }
    
    public void remove(int key) {
        Node pre = new Node(-1);
        int offset = key % m;
        pre.next = data[offset];
        for (Node cur = pre; cur.next != null; cur = cur.next) {
            if (cur.next.val == key) {
                cur.next = cur.next.next;
                break;
            }
        }
        data[offset] = pre.next;
    }
    
    public boolean contains(int key) {
        return has(data[key % m], key);
    }

    private boolean has(Node head, int val) {
        for (; head != null; head = head.next) {
            if (head.val == val) return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
