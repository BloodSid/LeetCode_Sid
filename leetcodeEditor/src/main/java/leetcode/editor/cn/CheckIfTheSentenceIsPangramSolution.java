package leetcode.editor.cn;
//全字母句 指包含英语字母表中每个字母至少一次的句子。 
//
// 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。 
//
// 如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
//输出：true
//解释：sentence 包含英语字母表中每个字母至少一次。
// 
//
// 示例 2： 
//
// 
//输入：sentence = "leetcode"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= sentence.length <= 1000 
// sentence 由小写英语字母组成 
// 
// 👍 36 👎 0


/**
 * 判断句子是否为全字母句
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-12-13 01:06:51 
 */
public class CheckIfTheSentenceIsPangramSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkIfPangram(String s) {
        int f = 0;
        int mask = (1 << 26) - 1;
        for (char c : s.toCharArray()) {
            f |= 1 << c - 'a';
            if (f == mask) return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
