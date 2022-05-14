package Contest0514;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author IronSid
 * @since 2022-05-14 22:26
 */
public class Solution {
    // T1

    public int divisorSubstrings(int num, int k) {
        String s = "" + num;
        int cnt = 0;
        for (int i = 0; i + k <= s.length(); i++) {
            int sub = Integer.parseInt(s.substring(i, i + k));
            if (sub == 0) continue;
            if (num % sub == 0) cnt++;
        }
        return cnt;
    }


    // T2
    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        long pre = 0;
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            pre += nums[i];
            sum -= nums[i];
            if (pre >= sum) res++;
        }
        return res;
    }

    // T3
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, Comparator.comparingInt(o -> o[0]));
        int max = 0;
        int cnt = tiles[0][1] - tiles[0][0] + 1;
        max = Math.min(cnt, carpetLen);
        for (int i = 0, j = 1; Math.max(i, j) < tiles.length; i++) {
            int head = tiles[i][0];
            for (; j < tiles.length && tiles[j][0] < head + carpetLen; j++) {
                cnt += tiles[j][1] - tiles[j][0] + 1;
            }
            max = Math.max(max, cnt - Math.max(0, (tiles[j - 1][1] + 1 - tiles[i][0] - carpetLen)));
            cnt -= tiles[i][1] - tiles[i][0] + 1;
        }
        return max;
    }
    @Test
    public void maximumWhiteTilesTest1() {
        int[][] tiles = {{1,5},{10,11},{12,18},{20,25},{30,32}};
        int carpetLen = 10;
        Solution solution = new Solution();
        int expected = 9;
        int actual = solution.maximumWhiteTiles(tiles, carpetLen);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void maximumWhiteTilesTest2() {
        int[][] tiles = {{1,1}, {2,2}, {5,5}};
        int carpetLen = 2;
        Solution solution = new Solution();
        int expected = 2;
        int actual = solution.maximumWhiteTiles(tiles, carpetLen);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void maximumWhiteTilesTest3() {
        int[][] tiles = {{1,1}};
        int carpetLen = 1;
        Solution solution = new Solution();
        int expected = 1;
        int actual = solution.maximumWhiteTiles(tiles, carpetLen);
        Assert.assertEquals(expected, actual);
    }

    // T4
    public int largestVariance(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[][] pre = new int[n + 1][];
        int[] t = new int[26];
        pre[0] = Arrays.copyOf(t, 26);
        for (int i = 0; i < n; i++) {
            t[c[i] - 'a']++;
            pre[i + 1] = Arrays.copyOf(t, 26);
        }
        int variance = 0;
        int[] freq = new int[26];
        for (int i = 0; i < c.length; i++) {
            for (int j = i; j < c.length; j++) {
                for (int i1 = 0; i1 < freq.length; i1++) {
                    freq[i1] = pre[j + 1][i1] - pre[i][i1];
                }
                int min = s.length(), max = 0;
                for (int i1 = 0; i1 < freq.length; i1++) {
                    if (freq[i1] != 0) min = Math.min(min, freq[i1]);
                    max = Math.max(max, freq[i1]);
                }
                variance = Math.max(variance, max - min);
                Arrays.fill(freq, 0);
            }
        }
        return variance;
    }

    @Test
    public void largestVarianceTest1() {
        String s = "aababbb";
        Solution solution = new Solution();
        int actual = solution.largestVariance(s);
        int expected = 3;
        Assert.assertEquals(expected, actual);
    }
}
