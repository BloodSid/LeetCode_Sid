package Contest0521.T4;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author IronSid
 * @since 2023-05-21 13:52
 */
public class SolutionTest {
    public static final int INF = (int) (1e9 + 7);
    Solution solution = new Solution();

    @Test
    public void modifiedGraphEdges1() {
        int n = 5;
        String edgesS = "[[4,1,-1],[2,0,-1],[0,3,-1],[4,3,-1]]";
        int source = 0;
        int destination = 1;
        int target = 5;
        String es = "[[4,1,1],[2,0,3],[0,3,3],[4,3,1]]";
        int[][] edges = JSON.parseArray(edgesS, int[].class).toArray(new int[0][]);
        int[][] expected = JSON.parseArray(es, int[].class).toArray(new int[0][]);
        int[][] actual = solution.modifiedGraphEdges(n, edges, source, destination, target);
        assertTrue("actual is " + Arrays.toString(actual), isGraphSame(expected, actual));
        assertEquals(target, dijkstra(n, source, destination, actual));
    }

    @Test
    public void modifiedGraphEdges2() {
        int n = 15;
        String edgesS = "[[0,7,34],[3,12,39],[5,6,45],[10,6,64],[1,7,90],[12,1,60],[4,9,72],[2,4,59],[11,2,54],[13,2,61],[10,2,43],[10,8,53],[8,12,13],[12,14,88],[14,11,74],[4,5,71],[10,3,32],[7,9,43],[3,7,59],[9,12,87],[13,12,35],[3,14,77],[7,5,92],[4,1,45],[8,9,36],[14,2,35],[3,6,-1],[14,10,90],[6,11,35],[0,13,27],[0,11,69],[1,8,90],[10,11,45],[13,10,54],[7,4,32],[3,0,74],[8,0,94],[3,4,21],[5,13,77],[1,14,94],[0,6,-1],[14,0,85],[10,5,26],[14,4,21],[1,2,58],[10,4,81],[9,11,11],[11,13,34],[13,6,26],[4,0,83],[6,7,80],[9,2,51],[8,14,81],[9,0,68],[13,8,10],[14,6,47],[5,12,53],[2,0,43],[10,12,62],[2,7,53],[11,7,81],[5,8,54],[3,8,38],[6,4,39],[8,11,73],[5,3,16],[9,13,44],[11,5,14],[2,3,22],[1,13,53],[13,3,17],[13,7,62],[7,12,21],[11,12,74],[6,8,66],[10,7,39],[1,10,22],[1,5,44],[1,3,-1],[4,12,25],[10,9,85],[12,2,28],[5,2,30],[6,12,78],[0,10,99],[4,8,77],[14,13,32],[7,14,53],[6,9,68],[3,9,90],[1,9,99],[0,5,40],[7,8,45],[5,14,75],[9,5,71],[8,2,42],[1,11,27]]";
        int source = 0;
        int destination = 1;
        int target = 46;
        String es = "[[0,7,34],[3,12,39],[5,6,45],[10,6,64],[1,7,90],[12,1,60],[4,9,72],[2,4,59],[11,2,54],[13,2,61],[10,2,43],[10,8,53],[8,12,13],[12,14,88],[14,11,74],[4,5,71],[10,3,32],[7,9,43],[3,7,59],[9,12,87],[13,12,35],[3,14,77],[7,5,92],[4,1,45],[8,9,36],[14,2,35],[3,6,1],[14,10,90],[6,11,35],[0,13,27],[0,11,69],[1,8,90],[10,11,45],[13,10,54],[7,4,32],[3,0,74],[8,0,94],[3,4,21],[5,13,77],[1,14,94],[0,6,44],[14,0,85],[10,5,26],[14,4,21],[1,2,58],[10,4,81],[9,11,11],[11,13,34],[13,6,26],[4,0,83],[6,7,80],[9,2,51],[8,14,81],[9,0,68],[13,8,10],[14,6,47],[5,12,53],[2,0,43],[10,12,62],[2,7,53],[11,7,81],[5,8,54],[3,8,38],[6,4,39],[8,11,73],[5,3,16],[9,13,44],[11,5,14],[2,3,22],[1,13,53],[13,3,17],[13,7,62],[7,12,21],[11,12,74],[6,8,66],[10,7,39],[1,10,22],[1,5,44],[1,3,2],[4,12,25],[10,9,85],[12,2,28],[5,2,30],[6,12,78],[0,10,99],[4,8,77],[14,13,32],[7,14,53],[6,9,68],[3,9,90],[1,9,99],[0,5,40],[7,8,45],[5,14,75],[9,5,71],[8,2,42],[1,11,27]]";
        int[][] edges = JSON.parseArray(edgesS, int[].class).toArray(new int[0][]);
        int[][] expected = JSON.parseArray(es, int[].class).toArray(new int[0][]);
        int[][] actual = solution.modifiedGraphEdges(n, edges, source, destination, target);
        assertTrue("actual is " + Arrays.toString(actual), isGraphSame(expected, actual));
        assertEquals(target, dijkstra(n, source, destination, actual));
    }

    @Test
    public void modifiedGraphEdges3() {
        int n = 5;
        String edgesS = "[[1,2,1],[0,1,1],[0,4,-1],[4,3,-1],[3,2,-1]]";
        int source = 2;
        int destination = 0;
        int target = 2;
        String es = "[[1,2,1],[0,1,1],[0,4,1000000007],[4,3,1],[3,2,1]]";
        int[][] edges = JSON.parseArray(edgesS, int[].class).toArray(new int[0][]);
        int[][] expected = JSON.parseArray(es, int[].class).toArray(new int[0][]);
        int[][] actual = solution.modifiedGraphEdges(n, edges, source, destination, target);
        assertTrue("actual is " + Arrays.toString(actual), isGraphSame(expected, actual));
        assertEquals(target, dijkstra(n, source, destination, actual));
    }

    private int dijkstra(int n, int source, int dest, int[][] edges) {
        List<int[]>[] map = new List[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0], y = edges[i][1];
            map[x].add(new int[]{y, i});
            map[y].add(new int[]{x, i});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[source] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{source, 0});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int x = p[0], d = p[1];
            if (d > dist[x]) continue;
            dist[x] = d;
            if (x == dest) return dist[x];
            for (int[] e : map[x]) {
                int y = e[0], ei = e[1];
                int nd = d + edges[ei][2];
                if (nd < dist[y]) {
                    dist[y] = nd;
                    pq.offer(new int[]{y, nd});
                }
            }
        }
        return -1;
    }

    // 判断 actual 和是否和 expected 两个图是否相似，即边权不同；且 actual 不能有小于等于0的边
    private boolean isGraphSame(int[][] expected, int[][] actual) {
        if (expected.length != actual.length) return false;
        HashSet<String > set = new HashSet<>();
        for (int[] e : actual) {
            if (e[2] <= 0) return false;
            set.add(Math.min(e[0], e[1]) + " " + Math.max(e[0], e[1]));
        }
        for (int[] e : expected) {
            if (!set.remove(Math.min(e[0], e[1]) + " " + Math.max(e[0], e[1]))) return false;
        }
        return true;
    }
}
