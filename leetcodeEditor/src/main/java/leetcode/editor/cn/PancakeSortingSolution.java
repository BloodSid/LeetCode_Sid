package leetcode.editor.cn;

import java.util.*;

/**
 * 煎饼排序
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-19 00:32:47
 */
public class PancakeSortingSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        for (int i = n; i > 1; i--) {
            int p = i - 1;
            for (; p >= 0; p--) {
                if (arr[p] == i) break;
            }
            reverse(arr, 0, p);
            if (p + 1 > 1) list.add(p + 1);
            reverse(arr, 0, i - 1);
            list.add(i);
        }
        return list;
    }

    void reverse(int[] arr, int left, int right) {
        for (; left < right; left++, right--) {
            int tem = arr[left];
            arr[left] = arr[right];
            arr[right] = tem;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
