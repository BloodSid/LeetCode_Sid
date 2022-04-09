package leetcode.editor.cn;

import java.util.*;

/**
 * 两个数组间的距离值
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-09 22:49:40
 */
public class FindTheDistanceValueBetweenTwoArraysSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int cnt = 0;
        for (int i : arr1) {
            int l = 0, r = arr2.length - 1;
            while (l <= r) {
                int mid = l + r >> 1;
                if (arr2[mid] > i) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if ((r == -1 || i - arr2[r] > d) && (l == arr2.length || arr2[l] - i > d)) {
                cnt++;
            }
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
