package Contest0319.T4;

public class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        // 统计同余
        int[] f = new int[value];
        for (int i = 0; i < nums.length; i++) {

            f[(nums[i] % value + value) % value]++;
        }
        int mex = 0;
        for (; f[mex % value] > 0; mex++) {
            f[mex % value]--;
        }
        return mex;
    }
}