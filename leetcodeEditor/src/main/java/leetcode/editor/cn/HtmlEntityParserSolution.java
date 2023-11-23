package leetcode.editor.cn;
//「HTML 实体解析器」 是一种特殊的解析器，它将 HTML 代码作为输入，并用字符本身替换掉所有这些特殊的字符实体。 
//
// HTML 里这些特殊字符和它们对应的字符实体包括： 
//
// 
// 双引号：字符实体为 &quot; ，对应的字符是 " 。 
// 单引号：字符实体为 &apos; ，对应的字符是 ' 。 
// 与符号：字符实体为 &amp; ，对应对的字符是 & 。 
// 大于号：字符实体为 &gt; ，对应的字符是 > 。 
// 小于号：字符实体为 &lt; ，对应的字符是 < 。 
// 斜线号：字符实体为 &frasl; ，对应的字符是 / 。 
// 
//
// 给你输入字符串 text ，请你实现一个 HTML 实体解析器，返回解析器解析后的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：text = "&amp; is an HTML entity but &ambassador; is not."
//输出："& is an HTML entity but &ambassador; is not."
//解释：解析器把字符实体 &amp; 用 & 替换
// 
//
// 示例 2： 
//
// 
//输入：text = "and I quote: &quot;...&quot;"
//输出："and I quote: \"...\""
// 
//
// 示例 3： 
//
// 
//输入：text = "Stay home! Practice on Leetcode :)"
//输出："Stay home! Practice on Leetcode :)"
// 
//
// 示例 4： 
//
// 
//输入：text = "x &gt; y &amp;&amp; x &lt; y is always false"
//输出："x > y && x < y is always false"
// 
//
// 示例 5： 
//
// 
//输入：text = "leetcode.com&frasl;problemset&frasl;all"
//输出："leetcode.com/problemset/all"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 10^5 
// 字符串可能包含 256 个ASCII 字符中的任意字符。 
// 
//
// 👍 46 👎 0


import java.util.HashMap;

/**
 * HTML 实体解析器
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-11-23 10:20:03
 */
public class HtmlEntityParserSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    static HashMap<String, Character> map = new HashMap<>();

    static {
        map.put("&quot;", '\"');
        map.put("&apos;", '\'');
        map.put("&amp;", '&');
        map.put("&gt;", '>');
        map.put("&lt;", '<');
        map.put("&frasl;", '/');
    }

    public String entityParser(String text) {
        StringBuilder sb = new StringBuilder();
        char[] ch = text.toCharArray();
        for (int i = 0; i < ch.length; ) {
            if (ch[i] == '&') {
                int len;
                boolean replace = false;
                for (len = 4; len <= 7; len++) {
                    if (i + len > ch.length) break;
                    String sub = new String(ch, i, len);
                    if (map.containsKey(sub)) {
                        sb.append(map.get(sub));
                        i += len;
                        replace = true;
                        break;
                    }
                }
                // 不能转义
                if (!replace) {
                    sb.append('&');
                    i++;
                }
            } else {
                sb.append(ch[i]);
                i++;
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
