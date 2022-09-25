package Contest0925.T1;

import java.util.*;

/**
 * @author IronSid
 * @since 2022-09-25 11:23
 */
public class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = names.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.put(i, heights[i]);
            list.add(i);
        }
        list.sort(Comparator.comparingInt(k -> map.get(k)).reversed());
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = names[list.get(i)];
        }
        return res;
    }
}
