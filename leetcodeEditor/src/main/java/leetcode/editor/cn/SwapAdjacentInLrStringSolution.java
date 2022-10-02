package leetcode.editor.cn;
//在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。一次移动操作指用一个"LX"替换一个"XL"，或
//者用一个"XR"替换一个"RX"。现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回
//True。 
//
// 
//
// 示例 : 
//
// 输入: start = "RXXLRXRXL", end = "XRLXXRRLX"
//输出: True
//解释:
//我们可以通过以下几步将start转换成end:
//RXXLRXRXL ->
//XRXLRXRXL ->
//XRLXRXRXL ->
//XRLXXRRXL ->
//XRLXXRRLX
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(start) = len(end) <= 10000。 
// start和end中的字符串仅限于'L', 'R'和'X'。 
// 
// 👍 192 👎 0


/**
 * 在LR字符串中交换相邻字符
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-10-02 13:46:23 
 */
public class SwapAdjacentInLrStringSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canTransform(String start, String end) {
        char[] c1 = start.toCharArray();
        char[] c2 = end.toCharArray();
        int n = c1.length;
        int p1 = 0; int p2 = 0;
        while (true) {
            while (p1 != n && c1[p1] == 'X') p1++;
            while (p2 != n && c2[p2] == 'X') p2++;
            if (p1 == n || p2 == n) return p1 == p2;
            if (c1[p1] != c2[p2]) return false;
            else if (c1[p1] == 'R') {
                if (p1 > p2) return false;
            } else if (c1[p1] == 'L') {
                if (p2 > p1) return false;
            }
            p1++;
            p2++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
