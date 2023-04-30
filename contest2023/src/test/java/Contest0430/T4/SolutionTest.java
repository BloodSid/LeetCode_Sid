package Contest0430.T4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author IronSid
 * @since 2023-04-30 14:32
 */
public class SolutionTest {

    @Test
    public void smallestBeautifulString1() {
        Solution solution = new Solution();
        String actual = solution.smallestBeautifulString("abcz", 26);
        String expeted = "abda";
        assertEquals(expeted, actual);
    }

}