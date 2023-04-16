package leetcode.editor.cn;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author IronSid
 * @since 2023-04-16 12:12
 */
public class OnlineMajorityElementInSubarraySolutionTest {

    @Test
    public void test1() {
        OnlineMajorityElementInSubarraySolution.MajorityChecker a = null;
        String ms = "[\"MajorityChecker\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\"]";
        String as = "[[2,2,1,2,1,3,1,1,1,2,3,3,3,1,1,1,2,2,3,3,2,2,1,1,1,2,1,3,1,1,2,3,1,3,3,1,3,2,2,2,3,2,3,1,2,1,3,3,3,2,2,1,1,2,2,3,2,3,3,3,2,1,2,3,1,3,2,3,1,2,3,3,2,2,2,2,2,2,3,2,3,2,3,3,1,2,3,3,3,3,3,3,3,2,1,1,2,1,2,2],[31,97,34],[17,97,81],[20,48,28],[26,35,9],[27,57,23],[13,74,37],[59,90,27],[27,28,2],[0,57,47],[22,77,35],[38,57,11],[37,80,30],[28,89,40],[36,61,23],[28,70,36],[37,99,33],[29,81,44],[81,81,1],[10,33,23],[22,52,30],[8,22,12],[5,82,43],[85,91,6],[27,75,40],[16,25,6],[27,37,11],[7,95,89],[6,88,67],[34,92,37],[17,86,57],[24,96,69],[47,94,48],[45,68,22],[79,89,6],[78,81,4],[23,85,54],[49,73,15],[36,76,35],[20,50,28],[12,60,27],[8,79,42],[14,94,43],[66,71,4],[33,81,37],[28,84,32],[54,84,18],[29,40,8],[12,63,39],[16,80,62],[14,61,36],[31,65,29],[17,58,31],[51,84,23],[19,95,65],[24,38,10],[7,42,20],[0,73,60],[8,30,20],[14,52,38],[2,50,36],[2,64,51],[1,73,37],[75,87,9],[27,33,6],[70,78,5],[52,98,43],[64,97,23],[44,91,31],[39,44,5],[33,87,48],[24,32,8],[45,70,18],[21,80,31],[32,92,53],[38,85,37],[10,88,72],[22,94,45],[13,15,3],[24,72,37],[24,40,13],[24,80,48],[52,65,9],[23,25,2],[63,74,11],[17,76,59],[12,78,67],[89,89,1],[1,87,86],[13,89,52],[50,60,7],[47,53,6],[66,95,22],[4,86,52],[51,62,10],[40,81,39],[26,42,10],[47,90,36],[60,73,8],[7,57,37],[51,72,16]]";
        String es = "[null,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,-1,-1,-1,-1,3,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,3,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,1,-1,-1,-1,3,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1]";
        String[] methods = JSON.parseArray(ms, String.class).toArray(new String[0]);
        int[][] args = JSON.parseArray(as, int[].class).toArray(new int[0][]);
        Integer[] expected = JSON.parseArray(es, Integer.class).toArray(new Integer[0]);
        for (int i = 0; i < methods.length; i++) {
            switch (methods[i]) {
                case "MajorityChecker":
                    a = new OnlineMajorityElementInSubarraySolution.MajorityChecker(args[i]);
                    break;
                case "query":
                    assertEquals((int) expected[i], a.query(args[i][0], args[i][1], args[i][2]));
                    break;
                default:
                    assertTrue("illegal method name", true);
                    break;
            }
        }
    }
}
