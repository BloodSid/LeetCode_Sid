package leetcode.editor.cn;

import java.util.*;

/**
 * 两个数组的交集 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-29 20:46:19 
 */
public class IntersectionOfTwoArraysIiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n = 1001;
        int[] freq1 = new int[n];
        int[] freq2 = new int[n];
        for (int i : nums1) {
            freq1[i]++;
        }
        for (int i : nums2) {
            freq2[i]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < Math.min(freq1[i], freq2[i]); i1++) {
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
