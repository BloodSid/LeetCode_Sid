import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author IronSid
 * @create 2021-05-12 23:36
 */

public class SolutionTest {
    public static final Solution solution = new Solution();

    @Test
    public void reformatTest1() {
        String actual = solution.reformat("a0b1c2");
        assertEquals(6, actual.length());
        boolean isVaild = true;
        char[] chars = actual.toCharArray();
        if (Character.isDigit(chars[0])) {
            for (int i = 1; i < chars.length; i++) {
                if (i % 2 == 1) {
                    if (!Character.isLetter(chars[i])) {
                        isVaild = false;
                        break;
                    }
                } else {
                    if (!Character.isDigit(chars[i])) {
                        isVaild = false;
                        break;
                    }
                }
            }
        } else {
            for (int i = 1; i < chars.length; i++) {
                if (i % 2 == 1) {
                    if (!Character.isDigit(chars[i])) {
                        isVaild = false;
                        break;
                    }
                } else {
                    if (!Character.isLetter(chars[i])) {
                        isVaild = false;
                        break;
                    }
                }
            }

        }
        assertTrue(isVaild);
    }

    @Test
    public void reformatTest2() {
        String actual = solution.reformat("leetcode");
        assertEquals("", actual);
    }

    @Test
    public void reformatTest3() {
        String actual = solution.reformat("1229857369");
        assertEquals("", actual);
    }

}