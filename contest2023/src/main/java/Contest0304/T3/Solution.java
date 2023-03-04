package Contest0304.T3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static final int MOD = (int) (1e9 + 7);

    public int countWays(int[][] ranges) {
        // 合并区间
        Arrays.sort(ranges, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> list = new ArrayList<>();
        list.add(ranges[0]);
        for (int i = 1; i < ranges.length; i++) {
            int[] prev = list.get(list.size() - 1);
            if (ranges[i][0] <= prev[1]) {
                prev[1] = Math.max(ranges[i][1], prev[1]);
            } else {
                list.add(ranges[i]);
            }
        }
        long ans = 1;
        for (int i = 0; i < list.size(); i++) {
            ans = ans * 2 % MOD;
        }
        return (int) ans;

    }
}
