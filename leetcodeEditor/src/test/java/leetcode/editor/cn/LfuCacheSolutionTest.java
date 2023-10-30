package leetcode.editor.cn;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author IronSid
 * @since 2023-10-30 21:10
 */
public class LfuCacheSolutionTest {


    @Test
    public void test1() throws Exception {
        LfuCacheSolution.LFUCache lc = null;
        String ms = "[\"LFUCache\",\"put\",\"put\",\"get\",\"put\",\"get\",\"get\",\"put\",\"get\",\"get\",\"get\"]";
        String as = "[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]";
        String es = "[null,null,null,1,null,-1,3,null,-1,3,4]";
        String[] methods = JSON.parseArray(ms, String.class).toArray(new String[0]);
        int[][] args = JSON.parseArray(as, int[].class).toArray(new int[0][]);
        Integer[] expected = JSON.parseArray(es, Integer.class).toArray(new Integer[0]);
        for (int i = 0; i < methods.length; i++) {
            switch (methods[i]) {
                case "LFUCache":
                    lc = new LfuCacheSolution.LFUCache(args[i][0]);
                    break;
                case "put":
                    lc.put(args[i][0], args[i][1]);
                    break;
                case "get":
                    assertEquals((int) expected[i], lc.get(args[i][0]));
                    break;
                default:
                    assertTrue("illegal method name", true);
                    break;
            }
        }
    }
}