package Contest0430.T3;

import java.util.*;

/**
 * @author IronSid
 * @since 2023-04-30 10:34
 */
public class Solution {

    public static final long N = (long) 1e5 + 1;

    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        HashMap<Long, Integer> map = new HashMap<>();
        List<int[]> v = new ArrayList<>();
        v.add(start);
        v.add(target);
        for (int[] s : specialRoads) {
            v.add(new int[]{s[0], s[1]});
            v.add(new int[]{s[2], s[3]});
        }
        int pi = 0;
        for (int[] vi : v) {
            long k = (long) vi[0] * N + vi[1];
            if (!map.containsKey(k)) {
                map.put(k, pi++);
            }
        }
        int size = map.size();
        int[][] g = new int[size][size];
        Map.Entry[] entries = map.entrySet().toArray(new Map.Entry[0]);
        for (int i = 0; i < entries.length; i++) {
            int x = (int) entries[i].getValue();
            for (int j = 0; j < entries.length; j++) {
                int d = dis(pos((Long) entries[i].getKey()), pos((Long) entries[j].getKey()));
                int y = (int) entries[j].getValue();
                g[x][y] = d;
                g[y][x] = d;
            }
        }
        for (int[] s : specialRoads) {
            int x = map.get(s[0] * N + s[1]);
            int y = map.get(s[2] * N + s[3]);
            g[x][y] = Math.min(g[x][y], s[4]);
        }
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
        return g[map.get(start[0] * N + start[1])][map.get(target[0] * N + target[1])];
    }

    int dis(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    int[] pos(long a) {
        return new int[]{(int) (a / N), (int) (a % N)};
    }
}