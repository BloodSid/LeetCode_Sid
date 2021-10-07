package leetcode.editor.cn;
//所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复
//序列有时会对研究非常有帮助。 
//
// 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC","CCCCCAAAAA"]
// 
//
// 示例 2： 
//
// 
//输入：s = "AAAAAAAAAAAAA"
//输出：["AAAAAAAAAA"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 105 
// s[i] 为 'A'、'C'、'G' 或 'T' 
// 
// Related Topics 位运算 哈希表 字符串 滑动窗口 哈希函数 滚动哈希 
// 👍 208 👎 0


import java.util.*;

/**
 * 重复的DNA序列
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-08 00:39:52 
 */
public class RepeatedDnaSequencesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
// 方法二 20ms
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String segment = s.substring(i, i + 10);
            int count = map.getOrDefault(segment, 0);
            count++;
            map.put(segment, count);
            if (count == 2) {
                ans.add(segment);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
// 方法一 16ms
class Solution1 {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> ans = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String segment = s.substring(i, i + 10);
            if (!set.add(segment)) {
                ans.add(segment);
            }
        }
        return new ArrayList<>(ans);
    }
}
}
