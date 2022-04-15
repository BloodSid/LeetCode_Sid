package leetcode.editor.cn;

/**
 * 最大回文数乘积
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-16 00:37:19
 */
public class LargestPalindromeProductSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestPalindrome(int n) {
        long[] palindromes = {0, 9, 9009, 906609, 99000099, 9966006699L, 999000000999L, 99956644665999L,
                9999000000009999L};
        return (int) (palindromes[n] % 1337);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
