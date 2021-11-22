package leetcode.editor.cn;

import java.util.*;

/**
 * 亲密字符串
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-23 07:18:13
 */
public class BuddyStringsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            cnt[ch - 'a']++;
            if (ch != goal.charAt(i)) {
                list.add(i);
                if (list.size() > 2) {
                    return false;
                }
            }
        }
        switch (list.size()) {
            case 0:
                for (int i : cnt) {
                    if (i >= 2) {
                        return true;
                    }
                }
                return false;
            case 1:
                return false;
            case 2:
                int a = list.get(0);
                int b = list.get(1);
                return s.charAt(a) == goal.charAt(b) && s.charAt(b) == goal.charAt(a);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
