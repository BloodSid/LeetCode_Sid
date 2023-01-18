package leetcode.editor.cn;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static org.junit.Assert.*;

/**
 * FindingMkAverageSolution Tester.
 *
 * @author IronSid
 * @since 01/18/2023
 * @version 1.0
 */
public class FindingMkAverageSolutionTest {
    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: addElement(int num)
    */
    @Test
    public void test1() throws Exception {
        FindingMkAverageSolution.MKAverage a = null;
        String ms = "[\"MKAverage\",\"addElement\",\"addElement\",\"calculateMKAverage\",\"addElement\",\"calculateMKAverage\",\"addElement\",\"addElement\",\"addElement\",\"calculateMKAverage\"]";
        String as = "[[3,1],[3],[1],[],[10],[],[5],[5],[5],[]]";
        String es = "[null,null,null,-1,null,3,null,null,null,5]";
        String[] methods = JSON.parseArray(ms, String.class).toArray(new String[0]);
        int[][] args = JSON.parseArray(as, int[].class).toArray(new int[0][]);
        Integer[] expected = JSON.parseArray(es, Integer.class).toArray(new Integer[0]);
        for (int i = 0; i < methods.length; i++) {
            switch (methods[i]) {
                case "MKAverage":
                    a = new FindingMkAverageSolution.MKAverage(args[i][0], args[i][1]);
                    break;
                case "addElement":
                    a.addElement(args[i][0]);
                    break;
                case "calculateMKAverage":
                    assertEquals((int) expected[i], a.calculateMKAverage());
                    break;
                default:
                    fail("illegal method name");
                    break;
            }
        }

    }

    @Test
    public void test2() throws Exception {
        FindingMkAverageSolution.MKAverage a = null;
        File file = new File("src/main/java/leetcode/editor/cn/FindingMkAverageSolutionTestcase.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String ms = bufferedReader.readLine();
        String as = bufferedReader.readLine();
        String es = bufferedReader.readLine();
        String[] methods = JSON.parseArray(ms, String.class).toArray(new String[0]);
        int[][] args = JSON.parseArray(as, int[].class).toArray(new int[0][]);
        Integer[] expected = JSON.parseArray(es, Integer.class).toArray(new Integer[0]);
        for (int i = 0; i < methods.length; i++) {
            switch (methods[i]) {
                case "MKAverage":
                    int m = args[i][0];
                    int k = args[i][1];
                    a = new FindingMkAverageSolution.MKAverage(m, k);
                    System.out.println("m = " + m);
                    System.out.println("k = " + k);
                    break;
                case "addElement":
                    a.addElement(args[i][0]);
                    break;
                case "calculateMKAverage":
                    assertEquals("i = " +  i,(int) expected[i], a.calculateMKAverage());
                    break;
                default:
                    fail("illegal method name");
                    break;
            }
        }

    }

}
