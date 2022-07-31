package Contest0731.T3;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2022-07-31 10:35
 */
public class Solution {

    public static final int INF = Integer.MAX_VALUE;

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dis1 = new int[n];
        int[] dis2 = new int[n];
        Arrays.fill(dis1, INF);
        Arrays.fill(dis2, INF);
        int cur = node1;
        int step = 0;
        while (cur != -1 && dis1[cur] == INF) {
            dis1[cur] = step++;
            cur = edges[cur];
        }
        cur = node2;
        step = 0;
        while (cur != -1 && dis2[cur] == INF) {
            dis2[cur] = step++;
            cur = edges[cur];
        }
        int res = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dis1[i] != INF && dis2[i] != INF) {
                int d = Math.max(dis1[i], dis2[i]);
                if (d < min) {
                    min = d;
                    res = i;
                }
            }
        }
        return res;
    }
}
