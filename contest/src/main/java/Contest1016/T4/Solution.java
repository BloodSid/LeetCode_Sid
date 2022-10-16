package Contest1016.T4;

/**
 * @author IronSid
 * @since 2022-10-16 11:12
 */
public class Solution {

    private long res;
    private int[] nums;
    private int minK;
    private int maxK;

    public long countSubarrays(int[] nums, int minK, int maxK) {
        this.nums = nums;
        this.minK = minK;
        this.maxK = maxK;
        res = 0;
        int pre = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxK || nums[i] < minK) {
                calc(pre + 1, i - 1);
                pre = i;
            }
        }
        calc(pre + 1, nums.length - 1);
        return res;
    }

    void calc(int l, int r) {
        int cntMin = 0;
        int cntMax = 0;
        for (int i = l, j = l; j <= r; j++) {
            if (nums[j] == minK) cntMin++;
            if (nums[j] == maxK) cntMax++;
            while (i <= j && cntMax > 0 && cntMin > 0) {
                if (nums[i] == minK) cntMin--;
                if (nums[i] == maxK) cntMax--;
                i++;
            }
            res += (j - l + 1) - (j - i + 1);
        }
    }
}
