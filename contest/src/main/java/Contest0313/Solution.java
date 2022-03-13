package Contest0313;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author IronSid
 * @since 2022-03-13 11:07
 */
public class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> keyIdx = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                keyIdx.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        loop:
        for (int i = 0; i < nums.length; i++) {
            for (Integer idx : keyIdx) {
                if (Math.abs(idx - i) <= k) {
                    res.add(i);
                    continue loop;
                }
            }
        }
        return res;
    }

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] cnt = new int[artifacts.length];
        for (int i = 0; i < artifacts.length; i++) {
            int r1 = artifacts[i][0], c1 = artifacts[i][1], r2 = artifacts[i][2], c2 = artifacts[i][3];
            cnt[i] = (r2 - r1 + 1) * (c2 - c1 + 1);
            for (int r = r1; r <= r2; r++) {
                for (int c = c1; c <= c2; c++) {
                    map.put(r * n + c, i);
                }
            }
        }
        int dug = 0;
        for (int[] ints : dig) {
            int r = ints[0], c = ints[1];
            if (map.containsKey(r * n + c)) {
                int i = map.get(r * n + c);
                cnt[i]--;
                if (cnt[i] == 0) {
                    dug++;
                }
            }
        }
        return dug;
    }

    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        if (n == 1 & k % 2 == 1) {
            return -1;
        }
        int max = 0;
        for (int i = 0; i < k - 1 & i < n; i++) {
            max = Math.max(max, nums[i]);
        }
        if (k < n) {
            max = Math.max(max, nums[k]);
        }
        return max;
    }

    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        // 最小生成树？
        return 0;
    }

}
