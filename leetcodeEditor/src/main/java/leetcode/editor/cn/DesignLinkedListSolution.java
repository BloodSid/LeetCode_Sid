package leetcode.editor.cn;

import java.util.*;

/**
 * 设计链表
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-15 02:23:21
 */
public class DesignLinkedListSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class MyLinkedList {
    Node head;
    Node last;
    int size;

    public MyLinkedList() {
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.val;
    }

    public void addAtHead(int val) {
        head = new Node(val, head);
        if (size == 0) {
            last = head;
        }
        size++;
    }

    public void addAtTail(int val) {
        if (size == 0) {
            head = new Node(val);
            last = head;
        } else {
            last.next = new Node(val);
            last = last.next;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index == size) {
            addAtTail(val);
        } else if (index < size && index > 0) {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            prev.next = new Node(val, prev.next);
            size++;
        } else if (index <= 0) {
            addAtHead(val);
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            prev.next = prev.next.next;
            if (index == size - 1) {
                last = prev;
            }
        }
        size--;
    }
}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + "," + next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
