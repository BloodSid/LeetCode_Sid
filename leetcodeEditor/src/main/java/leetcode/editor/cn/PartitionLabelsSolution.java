package leetcode.editor.cn;

import java.util.*;

/**
 * 划分字母区间
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-10 13:01:47
 */
public class PartitionLabelsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String s) {
        char[] arr = s.toCharArray();
        int[] last = new int[26];
        for (int i = 0; i < arr.length; i++) {
            last[arr[i] - 'a'] = i;
        }
        List<Integer> partion = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            end = Math.max(end, last[arr[i] - 'a']);
            if (i == end) {
                partion.add(end - start + 1);
                start = end + 1;
            }
        }
        return partion;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
