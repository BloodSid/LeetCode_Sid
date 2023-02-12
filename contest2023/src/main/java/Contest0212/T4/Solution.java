package Contest0212.T4;

/**
 * @author IronSid
 * @since 2023-02-12 10:29
 */
public class Solution {
    public int minimumScore(String s, String t) {
        if (isSubsequent(s, t)) {
            return 0;
        }
        int l = 1, r = t.length();
        while (l <= r) {
            boolean hasValid = false;
            int mid = l + r >> 1;
            for (int i = 0; i + mid <= t.length(); i++) {
                if (isSubsequent(s, t.substring(0, i) + t.substring(i + mid))) {
                    hasValid = true;
                    break;
                }
            }
            if (hasValid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    boolean isSubsequent(String s, String sub) {
        int j = 0;
        for (int i = 0; i < sub.length(); i++) {
            char c = sub.charAt(i);
            for (; j < s.length(); j++) {
                if (s.charAt(j) == c) break;
            }
            if (j == s.length()) return false;
            j++;
        }
        return true;
    }
}
