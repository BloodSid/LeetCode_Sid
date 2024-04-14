package Contest0414.T1;

/**
 * @author IronSid
 * @since 2024-04-14 10:27
 */
public class Solution {
    public String findLatestTime(String s) {
        for (int hh = 11; hh >= 0; hh--) {
            for (int mm = 59; mm >= 0; mm--) {
                String time = String.format("%02d:%02d", hh, mm);
                if (time.matches(s.replace('?', '.'))) {
                    return time;
                }
            }
        }
        return null;
    }
}
