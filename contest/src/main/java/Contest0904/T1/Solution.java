package Contest0904.T1;

/**
 * @author IronSid
 * @since 2022-09-04 10:27
 */
public class Solution {
    public boolean checkDistances(String s, int[] distance) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (c == 0) continue;
            c -= 'a';
            if (i + 1 + distance[c] >= ch.length || ch[i + 1 + distance[c]] != ch[i]) return false;
            ch[i + 1 + distance[c]] = 0;
        }
        return true;
    }
}
