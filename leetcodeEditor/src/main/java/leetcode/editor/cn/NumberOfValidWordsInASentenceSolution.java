package leetcode.editor.cn;

import java.util.*;

/**
 * 句子中的有效单词数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-27 13:33:27
 */
public class NumberOfValidWordsInASentenceSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countValidWords(String sentence) {
        String[] words = sentence.split("\\s");
        int cnt = 0;
        loop:
        for (String word : words) {
            if (word.length() == 0) {
                continue loop;
            }
            char[] arr = word.toCharArray();
            boolean hasHyphen = false;
            for (int i = 0; i < arr.length; i++) {
                char chr = arr[i];
                if (chr >= '0' && chr <= '9') {
                    continue loop;
                } else if (chr == '-') {
                    if (hasHyphen) {
                        continue loop;
                    } else {
                        hasHyphen = true;
                        if (i <= 0 || i >= arr.length - 1 || arr[i - 1] < 'a' || arr[i - 1] > 'z'
                                || arr[i + 1] < 'a' || arr[i + 1] > 'z') {
                            continue loop;
                        }
                    }
                } else if (chr == '!' || chr == '.' || chr == ',') {
                    if (i != arr.length - 1) {
                        continue loop;
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
