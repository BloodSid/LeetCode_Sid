package Contest0528.T1;

/**
 * @author IronSid
 * @since 2023-05-28 10:29
 */
public class Solution {
    public String removeTrailingZeros(String num) {
        return num.replaceAll("0*$", "");
    }
}
