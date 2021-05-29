import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author IronSid
 * @create 2021-05-29 8:33
 */
public class SolutionTest {
    static Solution solution = new Solution();

    @Test
    public void superEggDropTest1() {
        int actual = solution.superEggDrop(1,2);
        int expected = 2;
        assertEquals(expected,actual);
    }
    @Test
    public void superEggDropTest2() {
        int actual = solution.superEggDrop(2,6);
        int expected = 3;
        assertEquals(expected,actual);

    }
    @Test
    public void superEggDropTest3() {
        int actual = solution.superEggDrop(3,14);
        int expected =4;
        assertEquals(expected,actual);

    }
    @Test
    public void superEggDropTest4() {
        int actual = solution.superEggDrop(2,100);
        int expected =14;
        assertEquals(expected,actual);

    }
    @Test
    public void superEggDropTest5() {
        int actual = solution.superEggDrop(3,4);
        int expected =3;
        assertEquals(expected,actual);

    }
    @Test
    public void superEggDropTest6() {
        int actual = solution.superEggDrop(4,100);
        int expected =8;
        assertEquals(expected,actual);

    }
    @Test
    public void superEggDropTest7() {
        int actual = solution.superEggDrop(11, 8178);
        int expected =14;
        assertEquals(expected,actual);

    }



}