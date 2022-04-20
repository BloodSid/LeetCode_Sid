package leetcode.editor.cn;

/**
 * 山羊拉丁文
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-21 00:10:37 
 */
public class GoatLatinSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String toGoatLatin(String sentence) {
        String[] s = sentence.split(" ");
        boolean[] isVowel = new boolean[128];
        for (char c : "aeiouAEIOU".toCharArray()) {
            isVowel[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            String cur = s[i];
            sb.append('a');
            if (isVowel[cur.charAt(0)]) {
                s[i] = cur + "ma" + sb;
            } else {
                s[i] = cur.substring(1) + cur.charAt(0) + "ma" + sb;
            }
        }
        return String.join(" ", s);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
