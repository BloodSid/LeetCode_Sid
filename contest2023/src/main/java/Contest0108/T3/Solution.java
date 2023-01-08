package Contest0108.T3;

import java.util.HashMap;

/**
 * @author IronSid
 * @since 2023-01-08 10:29
 */
public class Solution {
    public boolean isItPossible(String word1, String word2) {
        HashMap<Character, Integer> f1 = new HashMap<>();
        HashMap<Character, Integer> f2 = new HashMap<>();
        for (char c : word1.toCharArray()) {
            f1.put(c, f1.getOrDefault(c, 0) + 1);
        }
        for (char c : word2.toCharArray()) {
            f2.put(c, f2.getOrDefault(c, 0) + 1);
        }
        for (char i = 'a'; i <= 'z'; i++) {
            if (!f1.containsKey(i)) continue;
            for (char j = 'a'; j <= 'z'; j++) {
                if (!f2.containsKey(j)) continue;
                Object clone1 = f1.clone();
                Object clone2 = f2.clone();
                Integer val1 = f1.get(i);
                if (val1 == 1) f1.remove(i);
                else f1.put(i, val1 - 1);
                Integer val2 = f2.get(j);
                if (val2 == 1) f2.remove(j);
                else f2.put(j, val2 - 1);
                f1.put(j, f1.getOrDefault(j, 0) + 1);
                f2.put(i, f2.getOrDefault(i, 0) + 1);
                if (f1.size() == f2.size()) return true;
                f1 = (HashMap<Character, Integer>) clone1;
                f2 = (HashMap<Character, Integer>) clone2;
            }
        }
        return false;
    }
}
