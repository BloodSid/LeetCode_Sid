package leetcode.editor.cn;

/**
 * UTF-8 编码验证
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-13 00:01:25
 */
public class Utf8ValidationSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validUtf8(int[] data) {
        int i = 0;
        int n = data.length;
        int width = 0;
        while (i < n) {
            // 1000 0000
            int b = data[i];
            if ((b & 128) == 0) {
                width = 1;
            // 1110 0000
            } else if ((b & 224) == 192) {
                width = 2;
            // 1111 0000
            } else if ((b & 240) == 224) {
                width = 3;
            // 1111 1000
            } else if ((b & 248) == 240) {
                width = 4;
            } else {
                return false;
            }
            for (int j = i + 1; j < i + width && j < n; j++) {
                // 1100 0000
                if ((data[j] & 192) != 128) {
                    return false;
                }
            }
            i += width;
        }
        return i == n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
