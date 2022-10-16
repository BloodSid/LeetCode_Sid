package Contest1016.T3;

/**
 * @author IronSid
 * @since 2022-10-16 11:12
 */
public class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= num; i++) {
            sb.setLength(0);
            sb.append(i);
            sb.reverse();
            int rev = Integer.parseInt(sb.toString());
            if (i + rev == num) {
                return true;
            }
        }
        return false;
    }
}
