package Contest0918.T4;

/**
 * @author IronSid
 * @since 2022-09-18 10:28
 */
public class Solution {
    public int[] sumPrefixScores(String[] words) {
        int[] res = new int[words.length];
        char[][] ws = new char[words.length][];
        for (int i = 0; i < words.length; i++) {
            res[i] = words[i].length();
            ws[i] = words[i].toCharArray();
        }
        for (int i = 0; i < words.length; i++) {
            char[] w1 = ws[i];
            for (int j = i + 1; j < words.length; j++) {
                char[] w2 = ws[j];
                int k = 0;
                for (; k < Math.min(w1.length, w2.length); k++) {
                    if (w1[k] != w2[k]) break;
                }
                res[i] += k;
                res[j] += k;
            }
        }
        return res;
    }
}
