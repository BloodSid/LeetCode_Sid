package Contest0319;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author IronSid
 * @since 2022-03-19 18:50
 */
public class Solution {
    // T1
    public boolean divideArray(int[] nums) {
        int[] freq = new int[501];
        for (int num : nums) {
            freq[num]++;
        }
        for (int i : freq) {
            if (i % 2 == 1) return false;
        }
        return true;
    }

    public long maximumSubsequenceCount(String text, String pattern) {
        StringBuilder sb = new StringBuilder();
        char c1 = pattern.charAt(0);
        char c2 = pattern.charAt(1);
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == c1 || c == c2) {
                sb.append(c);
            }
        }
        int n = sb.length();
        if (n == 0) {
            return 0;
        }
        int[] cnt1 = new int[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) == c1) {
                cnt++;
            }
            cnt1[i] = cnt;
        }
        int f1 = cnt1[n - 1];
        if (c1 == c2) {
            return (long) f1 * (f1 + 1) / 2;
        }
        int f2 = n - f1;
        long max = 0;
        // 若是第二个字符，则计算它前面有多少第一个字符
        for (int i = n - 1; i >= 0;i--) {
            if (sb.charAt(i) == c2) {
                max += cnt1[i];
            }
        }
        return max + Math.max(f1, f2);
    }

    public int halveArray(int[] nums) {
        PriorityQueue<Double> heap = new PriorityQueue<>(Comparator.reverseOrder());
        double sum = 0;
        for (int num : nums) {
            heap.offer((double) num);
            sum += num;
        }
        double diff = 0;
        int cnt = 0;
        while (sum / 2 - diff> 1e-5) {
            double cur = heap.poll();
            diff += cur / 2;
            heap.offer(cur / 2);
            cnt++;
        }
        return cnt;
    }

    static Solution solution = new Solution();
    @Test
    public void testhalveArray1() {
        int[] nums = {5,19,8,1};
        System.out.println(solution.halveArray(nums));
    }
    @Test
    public void testhalveArray2() {
        int[] nums = {3,8,20};
        System.out.println(solution.halveArray(nums));
    }

    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int m = numCarpets, n = floor.length();
        int[][] dp = new int[m + 1][n];
        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (floor.charAt(i) == '1') {
                temp++;
            }
            dp[0][i] = temp;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                if (j < carpetLen) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - carpetLen], dp[i][j - 1] + (floor.charAt(j) == '1' ? 1 : 0));
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[m][n - 1];
    }


    @Test
    public void minimumWhiteTilesTest1() {
        String floor = "10110101";
        int numCarpets = 2;
                int carpetLen = 2;
        System.out.println(solution.minimumWhiteTiles(floor, numCarpets, carpetLen));
    }

    @Test
    public void minimumWhiteTilesTest2() {
        String floor = "11111";
        int numCarpets = 2;
        int carpetLen = 3;
        System.out.println(solution.minimumWhiteTiles(floor, numCarpets, carpetLen));
    }
}
