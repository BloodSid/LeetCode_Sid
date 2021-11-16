package leetcode.editor.cn;

/**
 * @author IronSid
 * @since 2021-08-29 19:29
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(String list) {
        String[] strs = list.split(",");
        this.val = Integer.parseInt(strs[0]);
        ListNode curr = this;
        for (int i = 1; i < strs.length; i++) {
            curr.next = new ListNode(Integer.parseInt(strs[i]));
            curr = curr.next;
        }
    }

    @Override

    public String toString() {
        return val + "," + next;
    }
}

