package Contest0227;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author IronSid
 * @since 2022-02-27 10:04
 */
public class Solution {
    public int minSteps(String s, String t) {
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        for (char c : t.toCharArray()) {
            freq[c]--;
        }
        int cnt = 0;
        for (int i : freq) {
            cnt += Math.abs(i);
        }
        return cnt;
    }

    public long minimumTime(int[] time, int totalTrips) {
        long l = 0;
        long r = (long) 1e14;
        while (l < r) {
            long mid = l + r >> 1;
            long sum = 0;
            for (int i : time) {
                sum += mid / i;
            }
            if (sum < totalTrips) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    @Test
    public void minimumTimeTest() {
        int[] time = {1,2,3};
        int totolTrips = 5;
        Solution solution = new Solution();
        long expected = 3;
        long actual = solution.minimumTime(time, totolTrips);
        assertEquals(expected, actual);
    }

    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        int n = tires.length;
        int[][] minAvg = new int[n][2];
        for (int i = 0; i < n; i++) {

        }
        return 0;
    }
}
