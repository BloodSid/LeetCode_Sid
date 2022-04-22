package leetcode.editor.cn;

/**
 * 检查整数及其两倍数是否存在
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-19 09:31:13
 */
public class CheckIfNAndItsDoubleExistSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int OFFSET = 2002;

    public boolean checkIfExist(int[] arr) {
        int[] hash = new int[4020];
        for (int i : arr) {
            hash[i + OFFSET]++;
        }
        for (int i : arr) {
            if (i == 0) {
                if (hash[i + OFFSET] >= 2) return true;
            } else if (hash[(i << 1) + OFFSET] != 0) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
