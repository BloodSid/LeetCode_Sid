package Contest0319.T3;

public class Solution {

    private int ans;
    private int[] nums;
    private int k;

    public int beautifulSubsets(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        ans = 0;
        dfs(0, 0);
        return ans;
    }

    void dfs(int i, int sub) {
        if (i == nums.length) {
            if (sub != 0) ans++;
            return;
        }

        // 不加入
        dfs(i + 1, sub);
        // 判断当前元素能否加入
        for (int j = 0; j < i; j++) {
            if ((sub >> j & 1) == 1 && Math.abs(nums[j] - nums[i]) == k) return;
        }
        // 加入
        dfs(i + 1, sub | (1 << i));
    }
}
