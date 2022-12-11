package Contest1211.T3;

import com.alibaba.fastjson.JSON;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Allocator Tester.
 *
 * @author IronSid
 * @since 12/11/2022
 * @version 1.0
 */
public class AllocatorTest {
    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void test1() throws Exception {
        Allocator a = null;
        String ms = "[\"Allocator\",\"allocate\",\"allocate\",\"allocate\",\"free\"," +
                "\"allocate\",\"allocate\",\"allocate\",\"free\",\"allocate\",\"free\"]";
        String as = "[[10],[1,1],[1,2],[1,3],[2],[3,4],[1,1],[1,1],[1],[10,2],[7]]";
        String es = "[null,0,1,2,1,3,1,6,3,-1,0]";
        String[] methods = JSON.parseArray(ms, String.class).toArray(new String[0]);
        int[][] args = JSON.parseArray(as, int[].class).toArray(new int[0][]);
        Integer[] expected = JSON.parseArray(es, Integer.class).toArray(new Integer[0]);
        for (int i = 0; i < methods.length; i++) {
            switch (methods[i]) {
                case "Allocator":
                    a = new Allocator(args[i][0]);
                    break;
                case "allocate":
                    assertEquals((int) expected[i], a.allocate(args[i][0], args[i][1]));
                    break;
                case "free":
                    assertEquals((int) expected[i], a.free(args[i][0]));
                    break;
                default:
                    assertTrue("illegal method name", true);
                    break;
            }
        }
    }
//
//
    @Test
    public void test2() throws Exception {
        Allocator a = null;
        String ms = "[\"Allocator\",\"allocate\",\"allocate\",\"free\",\"free\"]";
        String as = "[[7],[3,1],[5,2],[1],[3]]";
        String es = "[null,0,-1,3,0]";
        String[] methods = JSON.parseArray(ms, String.class).toArray(new String[0]);
        int[][] args = JSON.parseArray(as, int[].class).toArray(new int[0][]);
        Integer[] expected = JSON.parseArray(es, Integer.class).toArray(new Integer[0]);
        for (int i = 0; i < methods.length; i++) {
            switch (methods[i]) {
                case "Allocator":
                    a = new Allocator(args[i][0]);
                    break;
                case "allocate":
                    assertEquals((int) expected[i], a.allocate(args[i][0], args[i][1]));
                    break;
                case "free":
                    assertEquals((int) expected[i], a.free(args[i][0]));
                    break;
                default:
                    assertTrue("illegal method name", true);
                    break;
            }
        }
    }

}
