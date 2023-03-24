package leetcode.editor.cn;
//设计一个算法：接收一个字符流，并检查这些字符的后缀是否是字符串数组 words 中的一个字符串。 
//
// 例如，words = ["abc", "xyz"] 且字符流中逐个依次加入 4 个字符 'a'、'x'、'y' 和 'z' ，你所设计的算法应当可以检测到
// "axyz" 的后缀 "xyz" 与 words 中的字符串 "xyz" 匹配。 
//
// 按下述要求实现 StreamChecker 类： 
//
// 
// StreamChecker(String[] words) ：构造函数，用字符串数组 words 初始化数据结构。 
// boolean query(char letter)：从字符流中接收一个新字符，如果字符流中的任一非空后缀能匹配 words 中的某一字符串，返回 
//true ；否则，返回 false。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["StreamChecker", "query", "query", "query", "query", "query", "query", 
//"query", "query", "query", "query", "query", "query"]
//[[["cd", "f", "kl"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"], 
//["i"], ["j"], ["k"], ["l"]]
//输出：
//[null, false, false, false, true, false, true, false, false, false, false, 
//false, true]
//
//解释：
//StreamChecker streamChecker = new StreamChecker(["cd", "f", "kl"]);
//streamChecker.query("a"); // 返回 False
//streamChecker.query("b"); // 返回 False
//streamChecker.query("c"); // 返回n False
//streamChecker.query("d"); // 返回 True ，因为 'cd' 在 words 中
//streamChecker.query("e"); // 返回 False
//streamChecker.query("f"); // 返回 True ，因为 'f' 在 words 中
//streamChecker.query("g"); // 返回 False
//streamChecker.query("h"); // 返回 False
//streamChecker.query("i"); // 返回 False
//streamChecker.query("j"); // 返回 False
//streamChecker.query("k"); // 返回 False
//streamChecker.query("l"); // 返回 True ，因为 'kl' 在 words 中
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 2000 
// 1 <= words[i].length <= 200 
// words[i] 由小写英文字母组成 
// letter 是一个小写英文字母 
// 最多调用查询 4 * 10⁴ 次 
// 
//
// 👍 111 👎 0


/**
 * 字符流
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-03-24 10:18:37 
 */
public class StreamOfCharactersSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class StreamChecker {

    Trie trie = new Trie();
    private StringBuilder sb = new StringBuilder();

    public StreamChecker(String[] words) {
        for (String word : words) {
            // 单词的逆序构造
            char[] rev = word.toCharArray();
            for (int i = 0, j = rev.length - 1; i < j; i++, j--) {
                char t = rev[i];
                rev[i] = rev[j];
                rev[j] = t;
            }
            trie.add(new String(rev));
        }
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        return trie.query(sb);
    }

    class Trie{
        TrieNode root = new TrieNode();
        int maxLength = 0;

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            String word = null;
        }

        void add(String s) {
            TrieNode cur = root;
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';
                if (cur.children[c] == null) {
                    cur.children[c] = new TrieNode();
                }
                cur = cur.children[c];
            }
            cur.word = s;
            maxLength = Math.max(maxLength, s.length());
        }

        boolean query(StringBuilder sb) {
            TrieNode cur = root;
            for (int i = 0; i < maxLength; i++) {
                int idx = sb.length() - 1 - i;
                if (idx < 0) break;
                int c = sb.charAt(idx) - 'a';
                cur = cur.children[c];
                if (cur == null) break;
                if (cur.word != null) return true;
            }
            return false;
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
