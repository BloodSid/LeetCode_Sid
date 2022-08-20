package Contest0820.T3;

/**
 * @author IronSid
 * @since 2022-08-20 22:30
 */
public class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[] diff = new int[n + 1];
        for (int[] shift : shifts) {
            int start = shift[0], end = shift[1];
            int op = shift[2] == 1 ? 1 : -1;
            diff[start] += op;
            diff[end + 1] -= op;
        }
        int[] ops = new int[n];
        for (int i = 0, t = 0; i < n; i++) {
            t += diff[i];
            ops[i] = t;
        }
        for (int i = 0; i < ch.length; i++) {
            ch[i] -= 'a';
            ch[i] = (char) (((ch[i] + ops[i]) % 26 + 26) % 26);
            ch[i] += 'a';
        }
        return new String(ch);
    }
}
