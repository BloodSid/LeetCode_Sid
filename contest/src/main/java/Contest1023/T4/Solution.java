package Contest1023.T4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author IronSid
 * @since 2022-10-23 10:53
 */
public class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        long res = 0;
        int n = nums.length;
        List<Integer> nm = new ArrayList<>();
        List<Integer> tg = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[j] % 2 == i) nm.add(nums[j]);
                if (target[j] % 2 == i) tg.add(target[j]);
            }
            nm.sort(Comparator.naturalOrder());
            tg.sort(Comparator.naturalOrder());
            for (int i1 = 0; i1 < nm.size(); i1++) {
                Integer o = nm.get(i1);
                Integer t = tg.get(i1);
                if (o > t) res += o - t;
            }
            nm.clear();
            tg.clear();
        }
        return res / 2;
    }
}
