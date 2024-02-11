package Contest0211.T4;

/**
 * @author IronSid
 * @since 2024-02-11 10:03
 */
public class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int[] text = new int[nums.length - 1];
        int n = text.length;
        int m = pattern.length;
        for (int i = 0; i < n; i++) {
            text[i] = Integer.signum(nums[i + 1] - nums[i]);
        }
        int[] lps = computeLPSArray(pattern);
        int i = 0;
        int j = 0;
        int cnt = 0;
        while (i < n) {
            if (pattern[j] == text[i]) {
                i++;
                j++;
            }
            if (j == m) {
                cnt++;
                j = lps[j - 1];
            } else if (i < n && pattern[j] != text[i]) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return cnt;
    }

    private int[] computeLPSArray(int[] pattern) {
        int m = pattern.length;
        int[] lps = new int[m];
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < m) {
            if (pattern[i] == pattern[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}
