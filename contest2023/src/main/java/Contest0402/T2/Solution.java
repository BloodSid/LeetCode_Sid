package Contest0402.T2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        int[] f = new int[n + 1];
        for (int i = 0; i < nums.length; i++) {
            f[nums[i]]++;
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < f.length; i++) {
            while (res.size() < f[i]) {
                res.add(new ArrayList<>());
            }
            for (int j = 0; j < f[i]; j++) {
                res.get(j).add(i);
            }
        }
        return res;
    }
}
