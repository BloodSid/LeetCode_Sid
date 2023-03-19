package Contest0319_1.T3;

import java.util.Arrays;

public class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a ,b) -> nums[a] != nums[b] ? nums[a] - nums[b] : a - b);
        long res = 0;
        boolean[] mark = new boolean[n];
        for (int i = 0; i < n; i++) {
            int id = idx[i];
            if (!mark[id]) {
                res += nums[id];
                mark[id] = true;
                if (id > 0) mark[id - 1] = true;
                if (id < n - 1) mark[id + 1] = true;
            }
        }
        return res;
    }
}

