package Contest1007.T4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution Tester.
 *
 * @author IronSid
 * @since 10/07/2022
 * @version 1.0
 */
public class SolutionTest {
    Solution solution = new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: Leetcode(String[] words)
     */
    @Test
    public void testLeetcode1() throws Exception {
        String[] words = {"hold","engineer","cost","level"};
        int expected = 5;
        int actual = solution.Leetcode(words);
        assertEquals(expected, actual);
    }

    @Test
    public void testLeetcode2() throws Exception {
        String[] words = {"axer","qsuec","rg","cod","lauefxbv","oexyzjr","yefttp","gbnpaccl","lj","kineyykk","esecokfl", "qlf","wuxahozg","z","py","ohqpea","nwrtt","ixmvpbsw","jixygsly","cqiudy"};
        int expected = 2;
        int actual = solution.Leetcode(words);
        assertEquals(expected, actual);
    }

    @Test
    public void testLeetcode3() throws Exception {
        String[] words = {"edot","leuj","ceq","hobqmib","vyfdkres","tkfetc","th","slqlclla","hhyljfst"};
        int expected = 12;
        int actual = solution.Leetcode(words);
        assertEquals(expected, actual);
    }

    @Test
    public void testLeetcode4() throws Exception {
        String[] words = {"whlesuln"};
        int expected = -1;
        int actual = solution.Leetcode(words);
        assertEquals(expected, actual);
    }

    @Test
    public void testLeetcode5() throws Exception {
        String[] words = {"dllthtdc", "tloottoe", "lllehedc", "colldcho", "teootedl", "ecdlhdcd", "techdctd", "ocddoctt", "lchheede", "deteotcd", "oecdohhl", "hcothtod", "ttltddtl", "eethtodd", "ddhodhoh", "tcoeclhd", "cldchthc", "ohhceode", "dddcldoe", "tecclele", "leooceeh", "dccdhttl", "lohoothl", "dtoocdho"};
        int expected = 0;
        int actual = solution.Leetcode(words);
        assertEquals(expected, actual);
    }

    @Test
    public void testLeetcode6() throws Exception {
        String[] words = {"kqurbprs", "tkppyyen", "dxdfgneh", "pyghtcwq", "rluwvfcf", "exiuzzcz", "pgcilhsh", "sixcxehl", "jeerbmzp", "qsfnqqmn", "cqdrcjzi", "qkkxpdyw", "fyhffxif", "ilfssmja", "qjksbhib", "qsuayfmz", "lvsydcwh", "zwyjdoxx", "wmbbgdvr", "iodhkfmb", "cimuvgwd", "tgujznfq", "rthyjela", "lzwpaowv"};
        int expected = 24;
        int actual = solution.Leetcode(words);
        assertEquals(expected, actual);
    }

    @Test
    public void minCost1() throws Exception {
        String word = "engineer";
        String cards = "ee";
        int expected = 5;
        int actual = solution.minCost(word, cards);
        assertEquals(expected, actual);
    }

    @Test
    public void minCost2() throws Exception {
        String word = "hold";
        String cards = "dhlo";
        int expected = 0;
        int actual = solution.minCost(word, cards);
        assertEquals(expected, actual);
    }

    @Test
    public void minCost3() throws Exception {
        String word = "cost";
        String cards = "cot";
        int expected = 0;
        int actual = solution.minCost(word, cards);
        assertEquals(expected, actual);
    }

    @Test
    public void minCost4() throws Exception {
        String word = "level";
        String cards = "eell";
        int expected = 0;
        int actual = solution.minCost(word, cards);
        assertEquals(expected, actual);
    }

    @Test
    public void minCost5() throws Exception {
        String word = "slqlclla";
        String cards = "ll";
        int expected = 11;
        int actual = solution.minCost(word, cards);
        assertEquals(expected, actual);
    }

    @Test
    public void minCost6() throws Exception {
        String word = "tkfetc";
        String cards = "cet";
        int expected = 0;
        int actual = solution.minCost(word, cards);
        assertEquals(expected, actual);
    }

}