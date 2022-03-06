package linkedList;

/**
 * @author IronSid
 * @since 2021-08-29 19:29
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(String list) {
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

