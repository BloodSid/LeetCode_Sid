package leetcode.editor.cn;

import java.util.*;

/**
 * 颜色分类
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-05 19:54:26
 */
public class SortColorsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        int[] cnt = new int[3];
        for (int num : nums) {
            cnt[num]++;
        }
        int index = 0;
        for (int i = 0; i < cnt.length; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                nums[index] = i;
                index++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
