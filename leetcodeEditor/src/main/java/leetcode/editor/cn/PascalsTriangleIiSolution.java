package leetcode.editor.cn;

import java.util.*;

/**
 * 杨辉三角 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-06 12:01:20
 */
public class PascalsTriangleIiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        int[] array = new int[rowIndex];
        array[0] = 1;
        for (int i = 1; i < rowIndex; i++) {
            for (int j = i; j >= 1; j--) {
                array[j] = array[j] + array[j - 1];
            }
        }
        List<Integer> result = new ArrayList<>(rowIndex);
        for (int i : array) {
            result.add(i);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
