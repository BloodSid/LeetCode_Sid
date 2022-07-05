package leetcode.editor.cn;

import java.util.*;

/**
 * 三数之和
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-05 00:21:12
 */
public class ThreeSumSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        return new java.util.AbstractList<List<Integer>>() {

            public static final int N = (int) 5e4;
            int size = 0;

            // data 提交时应改为 static
            List[] data = new List[N];
            boolean initialized = false;

            void init() {
                if (initialized) return;
                Arrays.sort(nums);
                for (int p1 = 0; p1 < nums.length; p1++) {
                    if (p1 > 0 && nums[p1] == nums[p1 - 1]) {
                        continue;
                    }
                    int p3 = nums.length - 1;
                    for (int p2 = p1 + 1; p2 < p3; p2++) {
                        if (p2 > p1 + 1 && nums[p2] == nums[p2 - 1]) {
                            continue;
                        }
                        while (p2 < p3 && nums[p1] + nums[p2] + nums[p3] > 0) {
                            p3--;
                        }
                        if (p2 != p3 && nums[p1] + nums[p2] + nums[p3] == 0) {
                            data[size++] = Arrays.asList(nums[p1], nums[p2], nums[p3]);
                        }
                    }
                }
                initialized = true;
            }

            @Override
            public List<Integer> get(int index) {
                init();
                return data[index];
            }

            @Override
            public int size() {
                init();
                return size;
            }
        };
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
