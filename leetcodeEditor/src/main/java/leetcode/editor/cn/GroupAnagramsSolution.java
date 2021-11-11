package leetcode.editor.cn;

import java.util.*;

/**
 * 字母异位词分组
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-11 14:45:00 
 */
public class GroupAnagramsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String num = letterNumber(str);
            map.putIfAbsent(num, new ArrayList<>());
            map.get(num).add(str);
        }
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
    String letterNumber(String str) {
        char[] number = new char[26];
        for (int i = 0; i < str.length(); i++) {
            number[str.charAt(i) - 'a']++;
        }
        return new String(number);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
