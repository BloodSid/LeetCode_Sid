package Contest0416.T3;

import java.util.regex.Pattern;
/**
 * @author IronSid
 * @since 2023-04-16 10:30
 */
public class Solution {
    public int addMinimum(String word) {
        Pattern p = Pattern.compile("a?b?c?");
        int cnt = p.matcher(word).replaceAll("d").length();
        return (cnt - 1) * 3 - word.length();
    }
}