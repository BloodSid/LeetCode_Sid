package leetcode.editor.cn;

import java.util.*;

/**
 * 随机数索引
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-25 16:11:22 
 */
public class RandomPickIndexSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private Random random = new Random();
    private int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        int cnt = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                cnt++;
                if (random.nextInt(cnt) == 0) {
                    res = i;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
