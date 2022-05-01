package Contest0430;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author IronSid
 * @since 2022-04-30 22:28
 */
public class Solution {
    // T1
    public int countPrefixes(String[] words, String s) {
        HashSet<String> set = new HashSet<>();
        for (int i = 1; i <= s.length(); i++) {
            set.add(s.substring(0, i));
        }
        int cnt = 0;
        for (String word : words) {
            if (set.contains(word)) cnt++;
        }
        return cnt;
    }

    // T2
    public int minimumAverageDifference(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long minDiff = Long.MAX_VALUE;
        int idx = 0;
        int n = nums.length;
        long leftSum = 0;
        for (int i = 0; i < n; i++) {
            leftSum += nums[i];
            long diff = Math.abs(leftSum / (i + 1) - (i == n - 1 ? 0 : (sum - leftSum) / (n - i - 1)));
            if (diff < minDiff) {
                minDiff = diff;
                idx = i;
            }
        }
        return idx;
    }

    // T3
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
return 0;
    }

    // T4

    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    List<int[]> fires;

    public int maximumMinutes(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        fires = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) fires.add(new int[]{i, j});
            }
        }
        int l = 0, r = 20000;
        while (l <= r) {
            int mid = l + r >> 1;

        }
        return r;
    }

}
