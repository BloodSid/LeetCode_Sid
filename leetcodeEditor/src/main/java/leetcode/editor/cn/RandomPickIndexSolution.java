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

    private final HashMap<Integer, List<Integer>> map;
    private Random random = new Random();

    public Solution(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get(random.nextInt(list.size()));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
