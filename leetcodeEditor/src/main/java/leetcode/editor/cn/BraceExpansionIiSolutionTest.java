package leetcode.editor.cn;

import com.alibaba.fastjson.JSON;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * BraceExpansionIiSolution Tester.
 *
 * @author IronSid
 * @since 03/07/2023
 * @version 1.0
 */
public class BraceExpansionIiSolutionTest {
    BraceExpansionIiSolution.Solution solution = new BraceExpansionIiSolution.Solution();
    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: braceExpansionII(String exp)
    */
    @Test
    public void testBraceExpansionII1() throws Exception {
        String exp = "{a,b}{c,{d,e}}";
        String es = "[\"ac\",\"ad\",\"ae\",\"bc\",\"bd\",\"be\"]";
        String[] expected = JSON.parseArray(es, String.class).toArray(new String[0]);
        String[] actual = solution.braceExpansionII(exp).toArray(new String[0]);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testBraceExpansionII2() throws Exception {
        String exp = "{{a,z},a{b,c},{ab,z}}";
        String es = "[\"a\",\"ab\",\"ac\",\"z\"]";
        String[] expected = JSON.parseArray(es, String.class).toArray(new String[0]);
        String[] actual = solution.braceExpansionII(exp).toArray(new String[0]);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testBraceExpansionII3() throws Exception {
        String exp = "n{{c,g},{h,j},l}a{{a,{x,ia,o},w},er,a{x,ia,o}w}n";
        String es = "[\"ncaaiawn\",\"ncaan\",\"ncaaown\",\"ncaaxwn\",\"ncaern\",\"ncaian\",\"ncaon\",\"ncawn\",\"ncaxn\",\"ngaaiawn\",\"ngaan\",\"ngaaown\",\"ngaaxwn\",\"ngaern\",\"ngaian\",\"ngaon\",\"ngawn\",\"ngaxn\",\"nhaaiawn\",\"nhaan\",\"nhaaown\",\"nhaaxwn\",\"nhaern\",\"nhaian\",\"nhaon\",\"nhawn\",\"nhaxn\",\"njaaiawn\",\"njaan\",\"njaaown\",\"njaaxwn\",\"njaern\",\"njaian\",\"njaon\",\"njawn\",\"njaxn\",\"nlaaiawn\",\"nlaan\",\"nlaaown\",\"nlaaxwn\",\"nlaern\",\"nlaian\",\"nlaon\",\"nlawn\",\"nlaxn\"]";
        String[] expected = JSON.parseArray(es, String.class).toArray(new String[0]);
        String[] actual = solution.braceExpansionII(exp).toArray(new String[0]);
        assertArrayEquals(expected, actual);
    }


}
