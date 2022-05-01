package leetcode.editor.cn;

import java.util.*;

/**
 * 含最多 K 个可整除元素的子数组
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-05-01 18:12:34
 */
public class KDivisibleElementsSubarraysSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        class Array {
            int[] val;
            int hash;

            public Array(int[] val) {
                this.val = val;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Array array = (Array) o;
                return Arrays.equals(val, array.val);
            }

            @Override
            public int hashCode() {
                if (hash == 0) hash = Arrays.hashCode(val);
                return hash;
            }
        }
        int n = nums.length;
        HashSet<Array> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            loop:
            for (int j = i + 1; j <= n; j++) {
                for (int m = i, cnt = 0; m < j; m++) {
                    if (nums[m] % p == 0) cnt++;
                    if (cnt > k) break loop;
                }
                set.add(new Array(Arrays.copyOfRange(nums, i, j)));
            }
        }
        return set.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
