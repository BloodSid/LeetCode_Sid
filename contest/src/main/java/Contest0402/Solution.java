package Contest0402;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

/**
 * @author IronSid
 * @since 2022-04-02 22:27
 */
public class Solution {
    // T1
    public int minBitFlips(int start, int goal) {
        int cnt = 0;
        for (; start != 0 || goal != 0; start >>= 1, goal >>= 1) {
            cnt += (start & 1) ^ (goal & 1);
        }
        return cnt;
    }
    // T2
    public int triangularSum(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                nums[j] = (nums[j] + nums[j + 1]) % 10;
            }
        }
        return nums[0];
    }

    // T3
    public long numberOfWays(String s) {
        int n = s.length();
        char[] array = s.toCharArray();
        int[] pre = new int[n];
        int t = 0;
        for (int i = 0; i < n; i++) {
            pre[i] = t;
            t += array[i] - '0';
        }
        int[] suf = new int[n];
        t = 0;
        for (int i = n - 1; i >= 0; i--) {
            suf[i] = t;
            t += array[i] - '0';
        }
        long sum = 0;
        for (int i = 1; i < n - 1; i++) {
            if (array[i] == '0') {
                sum += (long) pre[i] * suf[i];
            } else {
                sum += (long) (i - pre[i]) * (n - i - 1 - suf[i]);
            }
        }
        return sum;
    }

    // T4
    class Str {
        int hash;
        char[] value;
        int start, end;

        public Str(char[] value, int start, int end) {
            this.value = value;
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            Str str = (Str) o;
            if (value == str.value && start == str.start && end == str.end) {
                return true;
            }
            for (int i = start, j = str.start; i < end; i++, j++) {
                if (value[i] != str.value[i]) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public int hashCode() {
            int h = hash;
            if (h == 0) {
                for (int i = start; i < end; i++) {
                    h = 31 * h + value[i];
                }
                hash = h;
            }
            return h;
        }
    }

    public long sumScores(String s) {
        long score = 0;
        int n = s.length();
        char[] value = s.toCharArray();
        HashSet<Str> pre = new HashSet<>();
        for (int i = 0; i <= n; i++) {
            pre.add(new Str(value, 0, i));
        }
        for (int i = n - 1; i >= 0; i--) {
            int l = 0, r = n - i;
            while (l <= r) {
                int mid = l + r >> 1;
                if (pre.contains(new Str(value, i, i + mid))){
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            score += r;
        }
        return score;
    }

    static Solution solution = new Solution();
    @Test
    public void T4test1() {
        String s = "babab";
        long expected = 9;
        long actual = solution.sumScores(s);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void T4test2() {
        String s = "azbazbzaz";
        long expected = 14;
        long actual = solution.sumScores(s);
        Assert.assertEquals(expected, actual);
    }

}
