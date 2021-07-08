import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author IronSid
 * @create 2021-07-08 20:40
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        int max = 0;
        Set<Character> set = new HashSet<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            for (; j < s.length(); j++) {
                if (!set.add(s.charAt(j))) {
                    break;
                }
            }
            if (j == s.length()) {
                if (j - i > max)
                    return j - i;
            } else {
                max = Math.max(max, j - i);
            }
            set.clear();
        }
        return max;
    }
}
