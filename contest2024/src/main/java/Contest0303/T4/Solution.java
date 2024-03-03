package Contest0303.T4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author IronSid
 * @since 2024-03-03 10:35
 */
public class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> a1 = new ArrayList<>(), a2 = new ArrayList<>();
        int n = nums.length;
        // 离散化 nums
        int[] copy = nums.clone();
        Arrays.sort(copy);
        HashMap<Integer, Integer> ord = new HashMap<>();
        for (int i = n; i > 0; i--) {
            ord.put(copy[i - 1], i);
        }
        BIT t1 = new BIT(n);
        BIT t2 = new BIT(n);
        a1.add(nums[0]);
        t1.add(ord.get(nums[0]), 1);
        a2.add(nums[1]);
        t2.add(ord.get(nums[1]), 1);
        for (int i = 2; i < n; i++) {
            int ni = nums[i];
            int gc1 = t1.sumRange(ord.get(ni) + 1, n);
            int gc2 = t2.sumRange(ord.get(ni) + 1, n);
            if (gc1 > gc2) {
                a1.add(ni);
                t1.add(ord.get(ni), 1);
            } else if (gc1 < gc2) {
                a2.add(ni);
                t2.add(ord.get(ni), 1);
            } else {
                if (a1.size() <= a2.size()) {
                    a1.add(ni);
                    t1.add(ord.get(ni), 1);
                } else {
                    a2.add(ni);
                    t2.add(ord.get(ni), 1);
                }
            }
        }
        int[] res = new int[n];
        int ri = 0;
        for (Integer i : a1) res[ri++] = i;
        for (Integer i : a2) res[ri++] = i;
        return res;
    }


    class BIT {

        private final int[] t;
        private final int n;

        public BIT(int n) {
            t = new int[n + 1];
            this.n = n;
        }

        int query(int x) {
            int ans = 0;
            for (int i = x; i > 0; i &= i - 1) {
                ans += t[i];
            }
            return ans;
        }

        void add(int x, int u) {
            for (int i = x; i <= n; i += i & -i) {
                t[i] += u;
            }
        }

        int sumRange(int left, int right) {
            return query(right) - query(left - 1);
        }
    }
}
