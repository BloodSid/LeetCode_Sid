package Contest1030.T2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author IronSid
 * @since 2022-10-30 10:29
 */
public class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<Integer>> hotIdx = new HashMap<>();
        HashMap<String, Long> v = new HashMap<>();
        long n = creators.length;
        long hotest = 0;
        for (int i = 0; i < n; i++) {
            long view = v.getOrDefault(creators[i], 0L) + views[i];
            hotest = Math.max(hotest, view);
            v.put(creators[i], view);
        }
        for (int i = 0; i < n; i++) {
            if (v.get(creators[i]) == hotest) {
                if (hotIdx.get(creators[i]) == null) {
                    hotIdx.put(creators[i], new ArrayList<>());
                }
                hotIdx.get(creators[i]).add(i);
            }
        }
        for (String s : hotIdx.keySet()) {
            List<String> t = new ArrayList<>();
            t.add(s);
            int max = -1;
            String maxVideo = null;
            for (Integer idx : hotIdx.get(s)) {
                if (views[idx] > max) {
                    max = views[idx];
                    maxVideo = ids[idx];
                } else if (views[idx] == max) {
                    if (ids[idx].compareTo(maxVideo) < 0) {
                        maxVideo = ids[idx];
                    }
                }
            }
            t.add(maxVideo);
            res.add(t);
        }
        return res;
    }
}
