import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author IronSid
 * @create 2021-04-24 16:11
 */
public class SolutionTest {
    public static Solution solution=new Solution();

    @Test
    public void wordSubsetsTest1() {
        List<String> list = solution.wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"},new String[]{"e","o"});
        List<String> expected=new ArrayList<>();
        String[] exp = new String[]{"facebook","google","leetcode"};
        for (int i = 0; i < exp.length; i++) {
            expected.add(exp[i]);
        }
        assertEquals(true,expected.equals(list));

    }

}