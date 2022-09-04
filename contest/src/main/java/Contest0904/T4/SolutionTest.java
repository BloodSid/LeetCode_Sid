package Contest0904.T4;

import com.alibaba.fastjson.JSON;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static org.junit.Assert.assertEquals;

/**
 * Solution Tester.
 *
 * @author IronSid
 * @since 09/04/2022
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
    * Method: mostBooked(int n, int[][] meetings)
    */
    @Test
    public void testMostBooked1() throws Exception {
        int n = 2;
        int[][] meetings = {{0,10},{1,5},{2,7},{3,4}};
        int expected = 0;
        int actual = solution.mostBooked(n, meetings);
        assertEquals(expected, actual);
    }

    @Test
    public void testMostBooked2() throws Exception {
        File file = new File("src/main/java/Contest0904/T4/Example2.txt");
        System.out.println(file.getAbsolutePath());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] meetings = JSON.parseArray(bufferedReader.readLine(), int[].class).toArray(new int[0][]);
        int expected = 15;
        int actual = solution.mostBooked(n, meetings);
        assertEquals(expected, actual);
    }


}
