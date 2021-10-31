package leetcode.editor.cn;

import java.util.*;

/**
 * 删除无效的括号
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-27 23:22:43
 */
public class RemoveInvalidParenthesesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int lRemove = 0;
        int rRemove = 0;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        Set<String> ans = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    left.add(i);
                    lRemove++;
                    break;
                case ')':
                    right.add(i);
                    if (lRemove == 0) {
                        rRemove++;
                    } else {
                        lRemove--;
                    }
            }
        }
        int lStatus = 1 << left.size();
        int rStatus = 1 << right.size();
        List<Integer> lValidStatus = new ArrayList<>();
        for (int i = 0; i < lStatus; i++) {
            if (Integer.bitCount(i) == lRemove) {
                lValidStatus.add(i);
            }
        }
        for (int i = 0; i < rStatus; i++) {
            if (Integer.bitCount(i) == rRemove) {
                for (Integer j : lValidStatus) {
                    if (isValid(j, i, left, right)) {
                        ans.add(recoverStr(s, j, i));
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }

    boolean isValid(int lMask, int rMask, List<Integer> left, List<Integer> right) {
        for (int lIndex = 0, rIndex = 0; lIndex < left.size() && rIndex < right.size(); lIndex++, rIndex++) {
            while ((lMask & (1 << lIndex)) != 0) {
                lIndex++;
            }
            while ((rMask & (1 << rIndex)) != 0) {
                rIndex++;
            }
            if (lIndex < left.size() && rIndex < right.size() && right.get(rIndex) < left.get(lIndex)) {
                return false;
            }
        }
        return true;
    }

    String recoverStr(String str, int lMask, int rMask) {
        StringBuilder sb = new StringBuilder();
        int lIndex = 0;
        int rIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case '(':
                    if ((lMask & (1 << lIndex)) == 0) {
                        sb.append(ch);
                    }
                    lIndex++;
                    break;
                case ')':
                    if ((rMask & (1 << rIndex)) == 0) {
                        sb.append(ch);
                    }
                    rIndex++;
                    break;
                default:
                    sb.append(ch);
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
