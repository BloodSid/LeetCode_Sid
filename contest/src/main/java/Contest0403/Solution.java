package Contest0403;

import java.util.*;

/**
 * @author IronSid
 * @since 2022-04-03 10:30
 */
public class Solution {
    //T1
    public int convertTime(String current, String correct) {
        int h1 = Integer.parseInt(current.substring(0, 2));
        int m1 = Integer.parseInt(current.substring(3));
        int h2 = Integer.parseInt(correct.substring(0, 2));
        int m2 = Integer.parseInt(correct.substring(3));
        // 1 5 15 60
        if (m1 > m2) {
            m1 -= 60;
            h1++;
        }
        int ops = 0;
        int diff = m2 - m1;
        ops += diff / 15; diff %= 15;
        ops += diff / 5; diff %= 5;
        ops += diff;
        if (h1 > h2) {
            ops += h2 - h1 + 24;
        } else {
            ops += h2 - h1;
        }
        return ops;
    }

    //T2
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] match : matches) {
            int w = match[0], l = match[1];
            map.put(w, map.getOrDefault(w, 0));
            map.put(l, map.getOrDefault(l, 0) + 1);
        }
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < 2; i++) {
            res.add(new ArrayList<>());
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() <= 1) {
                res.get(entry.getValue()).add(entry.getKey());
            }
        }
        for (int i = 0; i < 2; i++) {
            res.get(i).sort(Comparator.naturalOrder());
        }
        return res;
    }

    //T3
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        int l = 1, r = sum / k >= Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) (sum / k);
        while (l <= r) {
            int mid = l + (r - l >> 1);
            long cnt = 0;
            for (int candy : candies) {
                cnt += candy / mid;
            }
            if (cnt >= k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

}
