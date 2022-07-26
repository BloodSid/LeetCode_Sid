package leetcode.editor.cn;
//不使用任何库函数，设计一个 跳表 。 
//
// 跳表 是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思
//想与链表相似。 
//
// 例如，一个跳表包含 [30, 40, 50, 60, 70, 90] ，然后增加 80、45 到跳表中，以下图的方式操作： 
//
// 
//Artyom Kalinin [CC BY-SA 3.0], via Wikimedia Commons 
//
// 跳表中有很多层，每一层是一个短的链表。在第一层的作用下，增加、删除和搜索操作的时间复杂度不超过 O(n)。跳表的每一个操作的平均时间复杂度是 O(log(
//n))，空间复杂度是 O(n)。 
//
// 了解更多 : https://en.wikipedia.org/wiki/Skip_list 
//
// 在本题中，你的设计应该要包含这些函数： 
//
// 
// bool search(int target) : 返回target是否存在于跳表中。 
// void add(int num): 插入一个元素到跳表。 
// bool erase(int num): 在跳表中删除一个值，如果 num 不存在，直接返回false. 如果存在多个 num ，删除其中任意一个即可。 
//
// 
//
// 注意，跳表中可能存在多个相同的值，你的代码需要处理这种情况。 
//
// 
//
// 示例 1: 
//
// 
//输入
//["Skiplist", "add", "add", "add", "search", "add", "search", "erase", "erase",
// "search"]
//[[], [1], [2], [3], [0], [4], [1], [0], [1], [1]]
//输出
//[null, null, null, null, false, null, true, false, true, false]
//
//解释
//Skiplist skiplist = new Skiplist();
//skiplist.add(1);
//skiplist.add(2);
//skiplist.add(3);
//skiplist.search(0);   // 返回 false
//skiplist.add(4);
//skiplist.search(1);   // 返回 true
//skiplist.erase(0);    // 返回 false，0 不在跳表中
//skiplist.erase(1);    // 返回 true
//skiplist.search(1);   // 返回 false，1 已被擦除
// 
//
// 
//
// 提示: 
//
// 
// 0 <= num, target <= 2 * 10⁴ 
// 调用search, add, erase操作次数不大于 5 * 10⁴ 
// 
// 👍 205 👎 0


import java.util.*;

/**
 * 设计跳表
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-07-26 21:35:12 
 */
public class DesignSkiplistSolution {

//leetcode submit region begin(Prohibit modification and deletion)
class Skiplist {

    // MAX_LEVEL = -log(P, n) n 取 5e4
    public static final double P = 0.25;
    public static final int MAX_LEVEL = 8;
    private final Random random = new Random();
    private final Node head;

    public Skiplist() {
        // 哨兵节点
        head = new Node(-1);
    }

    // 查出每一层严格比 target 小的第一个节点
    void find(int target, Node[] update) {
        Node cur = head;
        for (int i = MAX_LEVEL - 1; i >= 0; i--) {
            while (cur.ne[i] != null && cur.ne[i].val < target) {
                cur = cur.ne[i];
            }
            update[i] = cur;
        }
    }
    
    public boolean search(int target) {
        Node[] find = new Node[MAX_LEVEL];
        find(target, find);
        return find[0].ne[0] != null && find[0].ne[0].val == target;
    }
    
    public void add(int num) {
        // 最底层必然要插入，然后从下往上以 P 的概率进行传递
        Node[] find = new Node[MAX_LEVEL];
        find(num, find);
        Node newNode = new Node(num);
        for (int i = 0; i < MAX_LEVEL; i++) {
            newNode.ne[i] = find[i].ne[i];
            find[i].ne[i] = newNode;
            // (1 - P) 的概率会中断，即 P 的概率继续
            if (random.nextDouble() >= P) break;
        }
    }
    
    public boolean erase(int num) {
        // 从下往上进行删除
        Node[] find = new Node[MAX_LEVEL];
        find(num, find);
        if (find[0].ne[0] == null || find[0].ne[0].val != num) {
            return false;
        }
        Node cur = find[0].ne[0];
        for (int i = 0; i < MAX_LEVEL; i++) {
            if (find[i].ne[i] != cur) break;
            find[i].ne[i] = find[i].ne[i].ne[i];
        }
        return true;
    }

    private class Node {
        int val;
        Node[] ne = new Node[MAX_LEVEL];

        public Node(int val) {
            this.val = val;
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
