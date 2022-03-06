package Contest0306;

import binaryTree.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @author IronSid
 * @since 2022-03-06 10:33
 */
public class Solution {
    public List<String> cellsInRange(String s) {
        char c1 = s.charAt(0);
        char r1 = s.charAt(1);
        char c2 = s.charAt(3);
        char r2 = s.charAt(4);
        List<String> list = new ArrayList<>();
        for (char c = c1; c <= c2; c++) {
            for (char r = r1; r <= r2; r++) {
                list.add("" + c + r);
            }
        }
        return list;
    }

    public long minimalKSum(int[] nums, int k) {
        long sum = (long) (k + 1) * k / 2;
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        for (int num : nums) {
            if (set.contains(num)) {
                continue;
            }
            set.add(num);
            if (num <= k) {
                k++;
                sum = sum - num + k;
            }
        }
        return sum;
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> notRoot = new HashSet<>();
        for (int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            boolean isLeft = description[2] == 1;
            if (!map.containsKey(parent)) {
                map.put(parent, new TreeNode(parent));
            }
            if (!map.containsKey(child)) {
                map.put(child, new TreeNode(child));
            }
            notRoot.add(child);
            if (isLeft) {
                map.get(parent).left = map.get(child);
            } else {
                map.get(parent).right = map.get(child);
            }
        }
        for (Integer val : map.keySet()) {
            if (!notRoot.contains(val)) {
                return map.get(val);
            }
        }
        return null;
    }

    boolean flag;
    public List<Integer> replaceNonCoprimes(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode head = new ListNode(nums[0]), cur = head;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        flag = true;
        while (flag) {
            flag = false;
            head = replace(head);
            cur = head;
            while (cur != null && cur.next != null) {
                int a = cur.val;
                int b = cur.next.val;
                int gcd = gcd(a, b);
                if (gcd > 1) {
                    cur.val = (int) ((long) a * b / gcd);
                    cur.next = cur.next.next;
                    flag = true;
                } else {
                    cur = cur.next;
                }
            }
        }
        cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        return list;
    }

    ListNode replace(ListNode cur) {
        if (cur == null || cur.next == null) {
            return cur;
        }
        cur.next = replace(cur.next);
        int a = cur.val;
        int b = cur.next.val;
        int gcd = gcd(a, b);
        if (gcd > 1) {
            flag = true;
            cur.next.val = (int) ((long) a * b / gcd);
            return cur.next;
        } else {
            return cur;
        }
    }

    int gcd(int a, int b) {
        // gcd(a,b) = gcd(b,a mod b)
        while (b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }

    class ListNode {
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

        @Override
        public String toString() {
            return val + ", " + next;
        }
    }

    static Solution solution = new Solution();

    @Test
    public void test1() {
        int[] nums = {287, 41, 49, 287, 899, 23, 23, 20677, 5, 825};
        System.out.println(gcd(2009, 899));
        System.out.println(gcd(20677, 899));
        System.out.println(solution.replaceNonCoprimes(nums));
    }
}
