package Contest1023.T1;

/**
 * @author IronSid
 * @since 2022-10-23 10:52
 */
public class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        return event1[1].compareTo(event2[0]) >= 0 && event2[1].compareTo(event1[0]) >= 0;
    }
}
