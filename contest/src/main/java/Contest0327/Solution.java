package Contest0327;

import java.util.*;

/**
 * @author IronSid
 * @since 2022-03-27 10:23
 */
public class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        Set<Integer> temp = new HashSet<>();
        for (int i : nums1) {
            if (!set2.contains(i)) {
                temp.add(i);
            }
        }
        List<List<Integer>> res = new LinkedList<>();
        res.add(new LinkedList<>(temp));
        temp.clear();
        for (int i : nums2) {
            if (!set1.contains(i)) {
                temp.add(i);
            }
        }
        res.add(new LinkedList<>(temp));
        return res;
    }

    public int minDeletion(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.size() % 2 == 0) {
                list.add(nums[i]);
            } else {
                if (nums[i] == list.get(list.size() - 1)) {
                    continue;
                } else {
                    list.add(nums[i]);
                }
            }
        }
        if (list.size() % 2 == 1) {
            list.remove(list.size() - 1);
        }
        return nums.length - list.size();
    }

    public long[] kthPalindrome(int[] queries, int intLength) {
        long lower = (int) Math.pow(10, intLength - 1 >> 1);
        long upper = lower * 10 - 1;
        long[] res = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long left = lower + queries[i] - 1;
            if (left > upper) {
                res[i] = -1;
            } else {
                res[i] = getPalindrome(left, intLength);
            }
        }
        return res;
    }

    long getPalindrome(long left, int inLength) {
        String s = Long.toString(left);
        StringBuilder sb = new StringBuilder(s);
        for (int i = s.length() - (inLength % 2 == 0 ? 1 : 2); i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return Long.parseLong(sb.toString());
    }

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int length = 0;
        int m = piles.size();
        int[][] dp = new int[m + 1][k + 1];
        for (int i = 1; i <= m; i++) {
            List<Integer> pile = piles.get(i - 1);
            int[] v = new int[pile.size() + 1];
            int temp = 0;
            for (int i1 = 0; i1 < pile.size(); i1++) {
                temp += pile.get(i1);
                v[i1 + 1] = temp;
            }
            for (int j = 1; j <= k; j++) {
                int max = 0;
                for (int p = 0; p <= pile.size() && p <= j; p++) {
                    max = Math.max(max, dp[i - 1][j - p] + v[p]);
                }
                dp[i][j] = max;
            }
        }
        return dp[m][k];
    }

}

