package leetcode.editor.cn;
//你有一个单词列表 words 和一个模式 pattern，你想知道 words 中的哪些单词与模式匹配。 
//
// 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。 
//
// （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。） 
//
// 返回 words 中与给定模式匹配的单词列表。 
//
// 你可以按任何顺序返回答案。 
//
// 
//
// 示例： 
//
// 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
//输出：["mee","aqq"]
//解释：
//"mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
//"ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
//因为 a 和 b 映射到同一个字母。 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 50 
// 1 <= pattern.length = words[i].length <= 20 
// 
// 👍 163 👎 0


import java.util.*;

/**
 * 查找和替换模式
 *
 * @author IronSid
 * @since 2022-06-12 15:41:37 
 * @version 1.0
 */
public class FindAndReplacePatternSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 字符集大小
    public static final int C = 128;

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        char[] pat = pattern.toCharArray();
        for (String word : words) {
            char[] ch = word.toCharArray();
            // 若双射成立，则加入结果集
            if (mapTo(ch, pat) && mapTo(pat, ch)) {
                res.add(word);
            }
        }
        return res;
    }

    // 验证单射
    boolean mapTo(char[] ch1, char[] ch2) {
        char[] map = new char[C];
        for (int i = 0; i < ch1.length; i++) {
            if (map[ch1[i]] == 0) {
                map[ch1[i]] = ch2[i];
            } else if (map[ch1[i]] != ch2[i]){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
