package Contest0521.T4;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author IronSid
 * @since 2023-05-21 13:52
 */
public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void modifiedGraphEdges1() {
        int n = 5;
        String edgesS = "[[4,1,-1],[2,0,-1],[0,3,-1],[4,3,-1]]";
        int source = 0;
        int destination = 1;
        int target = 5;
        String es = "[[4,1,1],[2,0,1000000007],[0,3,3],[4,3,1]]";
        int[][] edges = JSON.parseArray(edgesS, int[].class).toArray(new int[0][]);
        int[][] expected = JSON.parseArray(es, int[].class).toArray(new int[0][]);
        int[][] actual = solution.modifiedGraphEdges(n, edges, source, destination, target);
        assertArrayEquals(expected, actual);
    }
}
// 5
//[[4,1,-1],[2,0,-1],[0,3,-1],[4,3,-1]]
//0
//1
//5