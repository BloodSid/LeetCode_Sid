package Contest1029.T2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IronSid
 * @since 2022-10-29 22:27
 */
public class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> list = new ArrayList<>();
        for (String query : queries) {
            for (String d : dictionary) {
                if (editDis(query, d) <= 2) {
                    list.add(query);
                    break;
                }
            }
        }
        return list;
    }

    // s1 s2 长度相等，编辑只能换字母
    int editDis(String s1, String s2) {
        int res = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                res++;
            }
        }
        return res;
    }
}
