package Contest1001.T1;

import java.util.HashMap;

/**
 * @author IronSid
 * @since 2022-10-01 22:28
 */
public class Solution {
    public boolean equalFrequency(String word) {
        char[] ch = word.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            HashMap<Character, Integer> f = new HashMap<>();
            for (int j = 0; j < ch.length; j++) {
                char c = ch[j];
                if (i == j) continue;
                f.put(c, f.getOrDefault(c, 0) + 1);
            }
            HashMap<Integer, Integer> cnt = new HashMap<>();
            for (Integer value : f.values()) {
                cnt.put(value, cnt.getOrDefault(value, 0) + 1);
            }
            if (cnt.size() == 1) return true;
        }
        return false;
    }

}
