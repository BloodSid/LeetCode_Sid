package Contest0924.T2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author IronSid
 * @since 2022-09-24 17:19
 */
public class Solution {
    public int transportationHub(int[][] path) {
        HashMap<Integer, Integer> in = new HashMap<>();
        HashMap<Integer, Integer> out = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int[] p : path) {
            int from = p[0], to = p[1];
            out.put(from, out.getOrDefault(from, 0) + 1);
            in.put(to, in.getOrDefault(to, 0) + 1);
            set.add(from);
            set.add(to);
        }
        int n = set.size();
        for (Map.Entry<Integer, Integer> entry : in.entrySet()) {
            int node = entry.getKey();
            int inCnt = entry.getValue();
            if (inCnt == n - 1 && !out.containsKey(node)) return node;
        }
        return -1;
    }
}
