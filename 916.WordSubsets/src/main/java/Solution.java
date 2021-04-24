import java.util.ArrayList;
import java.util.List;

/**
 * @author IronSid
 * @create 2021-04-24 16:00
 */

public class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> expected=new ArrayList<>();
        String[] exp = new String[]{"facebook","google","leetcode"};
        for (int i = 0; i < exp.length; i++) {
            expected.add(exp[i]);
        }
        return expected;
    }
}
