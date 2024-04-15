package leetcode.editor.cn;

/**
 * 设计哈希映射
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-05 20:27:39
 */
public class DesignHashmapSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class MyHashMap {

    private final int m;
    private final Node[] data;
    class Node {
        int key;
        int val;
        Node next;
        Node(int key) {
            this.key = key;
        }

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public MyHashMap() {
        m = 13337;
        data = new Node[m];
    }

    public void put(int key, int value) {
        Node head = data[key % m];
        if (head == null) {
            data[key % m] = new Node(key, value);
            return;
        }
        while (true) {
            if (head.key == key) {
                head.val = value;
                return;
            }
            if (head.next == null) {
                break;
            }
            head = head.next;
        }
        // 尾插法
        head.next = new Node(key, value);
    }

    public int get(int key) {
        return getVal(data[key % m], key);
    }

    public void remove(int key) {
        Node pre = new Node(-1);
        int offset = key % m;
        pre.next = data[offset];
        for (Node cur = pre; cur.next != null; cur = cur.next) {
            if (cur.next.key == key) {
                cur.next = cur.next.next;
                break;
            }
        }
        data[offset] = pre.next;
    }

    private int getVal(Node head, int key) {
        for (; head != null; head = head.next) {
            if (head.key == key) return head.val;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
