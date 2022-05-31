package leetcode.editor.cn;
//现有一种使用英语字母的外星文语言，这门语言的字母顺序与英语顺序不同。 
//
// 给定一个字符串列表 words ，作为这门语言的词典，words 中的字符串已经 按这门新语言的字母顺序进行了排序 。 
//
// 请你根据该词典还原出此语言中已知的字母顺序，并 按字母递增顺序 排列。若不存在合法字母顺序，返回 "" 。若存在多种可能的合法字母顺序，返回其中 任意一种
// 顺序即可。 
//
// 字符串 s 字典顺序小于 字符串 t 有两种情况： 
//
// 
// 在第一个不同字母处，如果 s 中的字母在这门外星语言的字母顺序中位于 t 中字母之前，那么 s 的字典顺序小于 t 。 
// 如果前面 min(s.length, t.length) 字母都相同，那么 s.length < t.length 时，s 的字典顺序也小于 t 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["wrt","wrf","er","ett","rftt"]
//输出："wertf"
// 
//
// 示例 2： 
//
// 
//输入：words = ["z","x"]
//输出："zx"
// 
//
// 示例 3： 
//
// 
//输入：words = ["z","x","z"]
//输出：""
//解释：不存在合法字母顺序，因此返回 "" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 100 
// words[i] 仅由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 269 题相同： https://leetcode-cn.com/problems/alien-dictionary/ 
// 👍 91 👎 0


import java.util.ArrayList;
import java.util.List;

/**
 * 外星文字典
 *
 * @author IronSid
 * @since 2022-05-31 17:20:56 
 * @version 1.0
 */
public class Jf1JuTSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String alienOrder(String[] words) {
        // 枚举所有的单词对，对字母进行建图，返回其中一种拓扑排序，
        int n = words.length;
        boolean[][] map = new boolean[26][26];
        int[] in = new int[26];
        boolean[] exist = new boolean[26];
        char[][] ch = new char[n][];
        for (int i = 0; i < n; i++) {
            ch[i] = words[i].toCharArray();
        }
        // 建图
        for (int i = 0; i < n; i++) {
            for (char c : ch[i]) {
                exist[c - 'a'] = true;
            }
            for (int j = i + 1; j < n; j++) {
                int k = 0;
                int min = Math.min(ch[i].length, ch[j].length);
                for (; k < min; k++) {
                    int lower = ch[i][k] - 'a', higher = ch[j][k] - 'a';
                    if (lower != higher) {
                        if (!map[lower][higher]) {
                            map[lower][higher] = true;
                            in[higher]++;
                        }
                        break;
                    }
                }
                // 若短单词和长单词前面完全相同，但长单词排在前面，则不存在合法排序
                if (k == min && ch[i].length > min) return "";
            }
        }
        // 拓扑排序
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (exist[i]) list.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!list.isEmpty()) {
            list.sort((o1, o2) -> in[o1] - in[o2]);
            int cur = list.get(0);
            if (in[cur] > 0) return "";
            list.remove(0);
            sb.append((char) ('a' + cur));
            for (int j = 0; j < 26; j++) {
                if (map[cur][j]) {
                    in[j]--;
                }
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
