package leetcode.editor.cn;

import java.util.*;

/**
 * 键盘行
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-31 10:16:15
 */
public class KeyboardRowSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findWords(String[] words) {
        String[] lines = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        int[] value = new int[128];
        for (int j = 0; j < lines.length; j++) {
            for (int i = 0; i < lines[j].length(); i++) {
                int index = lines[j].charAt(i);
                value[index] = j;
                value[index - 32] = j;
            }
        }
        List<String> ans = new ArrayList<>();
        flag:
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                if (value[word.charAt(i)] != value[word.charAt(0)]) {
                    continue flag;
                }
            }
            ans.add(word);
        }
        return ans.toArray(new String[0]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
