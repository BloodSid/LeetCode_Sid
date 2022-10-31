package Contest1030.T2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author IronSid
 * @since 2022-10-30 10:29
 */
public class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        int n = creators.length;
        HashMap<String, Long> sum = new HashMap<>();
        HashMap<String, String> id = new HashMap<>();
        HashMap<String, Integer> maxV = new HashMap<>();
        long maxSum = 0;
        for (int i = 0; i < n; i++) {
            String cur = creators[i];
            if (sum.containsKey(cur)) {
                sum.put(cur, sum.get(cur) + views[i]);
                if (maxV.get(cur) < views[i] || maxV.get(cur) == views[i] && id.get(cur).compareTo(ids[i]) > 0) {
                    maxV.put(cur, views[i]);
                    id.put(cur, ids[i]);
                }
            } else {
                sum.put(cur, (long) views[i]);
                id.put(cur, ids[i]);
                maxV.put(cur, views[i]);
            }
            maxSum = Math.max(maxSum, sum.get(cur));
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, Long> entry : sum.entrySet()) {
            if (entry.getValue() == maxSum) {
                List<String> list = new ArrayList<>();
                list.add(entry.getKey());
                list.add(id.get(entry.getKey()));
                res.add(list);
            }
        }
        return res;
    }
}
