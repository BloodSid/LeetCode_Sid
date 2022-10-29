package Contest1029.T1;

/**
 * @author IronSid
 * @since 2022-10-29 22:27
 */
public class Solution {
    public String oddString(String[] words) {
        int n = words.length;
        char[][] w = new char[n][];
        for (int i = 0; i < n; i++) {
            w[i] = words[i].toCharArray();
        }
        if (isDiff(w[0], w[1])) {
            if (isDiff(w[0], w[2])) return words[0];
            else return words[1];
        }
        for (int i = 2; i < n; i++) {
            if (isDiff(w[i], w[1])) return words[i];
        }
        return "";
    }

    boolean isDiff(char[] c1, char[] c2) {
        for (int i = 1; i < c1.length; i++) {
            if (c1[i] - c1[0] != c2[i] - c2[0]) return true;
        }
        return false;
    }
}
