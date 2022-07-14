package leetcode.editor.cn;
//设计一个包含一些单词的特殊词典，并能够通过前缀和后缀来检索单词。 
//
// 实现 WordFilter 类： 
//
// 
// WordFilter(string[] words) 使用词典中的单词 words 初始化对象。 
// f(string pref, string suff) 返回词典中具有前缀 prefix 和后缀 suff 的单词的下标。如果存在不止一个满足要求的下标，
//返回其中 最大的下标 。如果不存在这样的单词，返回 -1 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["WordFilter", "f"]
//[[["apple"]], ["a", "e"]]
//输出
//[null, 0]
//解释
//WordFilter wordFilter = new WordFilter(["apple"]);
//wordFilter.f("a", "e"); // 返回 0 ，因为下标为 0 的单词：前缀 prefix = "a" 且 后缀 suff = "e" 。
//
// 
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 10⁴ 
// 1 <= words[i].length <= 7 
// 1 <= pref.length, suff.length <= 7 
// words[i]、pref 和 suff 仅由小写英文字母组成 
// 最多对函数 f 执行 10⁴ 次调用 
// 
// 👍 152 👎 0


import java.util.HashMap;

/**
 * 前缀和后缀搜索
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-07-14 20:28:38 
 */
public class PrefixAndSuffixSearchSolution {

//leetcode submit region begin(Prohibit modification and deletion)
class WordFilter {

    HashMap<String, Integer> map = new HashMap<>();

    public WordFilter(String[] words) {
        int idx = 0;
        for (String word : words) {
            for (int i = 1; i <= word.length(); i++) {
                String suff = word.substring(0, i);
                for (int j = 0; j < word.length(); j++) {
                    String pref = word.substring(j);
                    map.put(suff + '*' + pref, idx);
                }
            }
            idx++;
        }
    }
    
    public int f(String pref, String suff) {
        return map.getOrDefault(pref + '*' + suff, -1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
