package Contest0501;

import java.util.*;

/**
 * @author IronSid
 * @since 2022-05-01 10:23
 */
public class Solution {
    // T1
    public String removeDigit(String number, char digit) {
        int n = number.length();
        char[] ch = number.toCharArray();
        for (int i = 0; i < n - 1; i++) {
            if (ch[i] == digit && ch[i + 1] > ch[i]) return number.substring(0, i) + number.substring(i + 1);
        }
        for (int i = n - 1; i >= 0; i--) {
            if (ch[i] == digit) return number.substring(0, i) + number.substring(i + 1);
        }
        return "";
    }

    // T2
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = cards.length;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(cards[i])) {
                map.put(cards[i], new ArrayList<>());
            }
            map.get(cards[i]).add(i);
        }
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() < 2) continue;
            for (int i = 0; i < list.size() - 1; i++) {
                min = Math.min(min, list.get(i + 1) - list.get(i) + 1);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    // T3
    public int countDistinct(int[] nums, int k, int p) {
        class Array{
            int[] val;

            public Array(int[] val) {
                this.val = val;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Array array = (Array) o;
                return Arrays.equals(val, array.val);
            }

            @Override
            public int hashCode() {
                return val[0];
            }
        }
        int n = nums.length;
        HashSet<Array> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            loop:
            for (int j = i + 1; j <= n; j++) {
                for (int m = i, cnt = 0; m < j; m++) {
                    if (nums[m] % p == 0) cnt++;
                    if (cnt > k) continue loop;
                }
                set.add(new Array(Arrays.copyOfRange(nums, i, j)));
            }
        }
        return set.size();
    }

    // T4
    public long appealSum(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        TreeSet<Integer>[] set = new TreeSet[26];
        for (int i = 0; i < 26; i++) {
            set[i] = new TreeSet<>();
        }
        for (int i = 0; i < n; i++) {
            set[ch[i] - 'a'].add(i);
        }
        long[] dp = new long[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            // k 是[0, i]的一个数，表示ch[i]加在dp[i-1]代表的全部子数组后，“引力”的增加值
            Integer lower = set[ch[i] - 'a'].lower(i);
            if (lower == null) lower = -1;
            int k = i - (lower + 1);
            dp[i] = dp[i - 1] + k + 1;
        }
        long sum = 0;
        for (long l : dp) {
            sum += l;
        }
        return sum;
    }

}
// aaa
// 1 2 3