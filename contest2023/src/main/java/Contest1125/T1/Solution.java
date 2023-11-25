package Contest1125.T1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IronSid
 * @since 2023-10-28 22:33
 */
public class Solution {

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) >= 0) res.add(i);
        }
        return res;
    }
}
