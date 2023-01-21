import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author IronSid
 * @create 2021-04-24 15:21
 */
public class SolutionTest {
    public static Solution solution = new Solution();
    @Test
    public void searchInsert1() {
        assertEquals(2,solution.searchInsert(new int[]{1,3,5,6},5));
    }
    @Test
    public void searchInsert2() {
        assertEquals(1,solution.searchInsert(new int[]{1,3,5,6},2));
    }
    @Test
    public void searchInsert3() {
        assertEquals(4,solution.searchInsert(new int[]{1,3,5,6},7));
    }
    @Test
    public void searchInsert4() {
        assertEquals(0,solution.searchInsert(new int[]{1,3,5,6},0));
    }
    @Test
    public void searchInsert5() {
        assertEquals(0,solution.searchInsert(new int[]{1},0));
    }
}