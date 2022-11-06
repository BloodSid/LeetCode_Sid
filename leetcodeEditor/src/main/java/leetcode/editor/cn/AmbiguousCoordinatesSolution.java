package leetcode.editor.cn;
//我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表
//中。 
//
// 原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数
//来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。 
//
// 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。 
//
// 
//
// 
//示例 1:
//输入: "(123)"
//输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
// 
//
// 
//示例 2:
//输入: "(00011)"
//输出:  ["(0.001, 1)", "(0, 0.011)"]
//解释: 
//0.0, 00, 0001 或 00.01 是不被允许的。
// 
//
// 
//示例 3:
//输入: "(0123)"
//输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 
//3)"]
// 
//
// 
//示例 4:
//输入: "(100)"
//输出: [(10, 0)]
//解释: 
//1.0 是不被允许的。
// 
//
// 
//
// 提示: 
//
// 
// 4 <= S.length <= 12. 
// S[0] = "(", S[S.length - 1] = ")", 且字符串 S 中的其他元素都是数字。 
// 
//
// 
// 👍 49 👎 0


import java.util.*;
import java.util.regex.Pattern;

/**
 * 模糊坐标
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-11-07 00:16:28 
 */
public class AmbiguousCoordinatesSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 有前置 0 非法
    public static final Pattern P_1 = Pattern.compile("^0\\d");
    // 小数点后有后置 0 非法
    public static final Pattern P_2 = Pattern.compile("\\.\\d*0$");

    public List<String> ambiguousCoordinates(String s) {
        List<String> res = new ArrayList<>();
        s = s.substring(1, s.length() - 1);
        for (int i = 1; i < s.length(); i++) {
            String x = s.substring(0, i);
            String y = s.substring(i);
            // 枚举小数点位置，其中 i = 0 表示不加小数点
            for (int i1 = 0; i1 < x.length(); i1++) {
                String tx = i1 == 0 ? x : x.substring(0, i1) + "." + x.substring(i1);
                for (int i2 = 0; i2 < y.length(); i2++) {
                    String ty = i2 == 0 ? y : y.substring(0, i2) + "." + y.substring(i2);
                    if (isLegal(tx) && isLegal(ty)) {
                        res.add("(" + tx + ", " + ty + ")");
                    }
                }
            }
        }
        return res;
    }

    boolean isLegal(String s) {
        if (P_1.matcher(s).find()) return false;
        if (P_2.matcher(s).find()) return false;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
