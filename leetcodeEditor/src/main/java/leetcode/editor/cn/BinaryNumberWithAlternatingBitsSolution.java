package leetcode.editor.cn;

/**
 * 交替位二进制数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-28 00:19:50 
 */
public class BinaryNumberWithAlternatingBitsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean hasAlternatingBits(int n) {
        int a = n ^ (n >> 1);
        return (a & (a + 1)) == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
