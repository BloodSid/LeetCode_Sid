package Contest0422.T2;

import java.util.HashSet;

/**
 * @author IronSid
 * @since 2023-04-22 14:59
 */
public class Solution {
    public int adventureCamp(String[] expeditions) {
        int max = 0;
        int idx = -1;
        HashSet<String> set = new HashSet<>();
        for (String s : expeditions[0].split("->")) {
            if (s.length() == 0) continue;
            set.add(s);
        }
        for (int i = 1; i < expeditions.length; i++) {
            int cnt = 0;
            for (String s : expeditions[i].split("->")) {
                if (s.length() == 0) continue;
                if (set.add(s)) cnt++;
            }
            if (cnt > max) {
                max = cnt;
                idx = i;
            }
        }
        return idx;
    }
}
