package leetcode.editor.cn;
//你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。 
//
// 注意：本题中，每个活字字模只能使用一次。 
//
// 
//
// 示例 1：
//
// 
//输入："AAB"
//输出：8
//解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
// 
//
// 示例 2： 
//
// 
//输入："AAABBC"
//输出：188
// 
//
// 示例 3： 
//
// 
//输入："V"
//输出：1 
//
// 
//
// 提示： 
//
// 
// 1 <= tiles.length <= 7 
// tiles 由大写英文字母组成 
// 
//
// 👍 169 👎 0


import java.util.*;

/**
 * 活字印刷
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-05-19 00:04:09 
 */
public class LetterTilePossibilitiesSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private char[] ch;
    private HashSet<String> set;

    public int numTilePossibilities(String tiles) {
        ch = tiles.toCharArray();
        StringBuilder buf = new StringBuilder();
        set = new HashSet<>();
        dfs(0, buf);
        // 减去空字符串
        return set.size() - 1;
    }

    private void dfs(int status, StringBuilder buf) {
        set.add(buf.toString());
        if (status == (1 << ch.length) - 1) {
            return;
        }
        int len = buf.length();
        for (int i = 0; i < ch.length; i++) {
            if ((status >> i & 1) == 1) continue;
            buf.append(ch[i]);
            dfs(status | 1 << i, buf);
            // 回溯
            buf.setLength(len);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
