import org.junit.Test;


import static org.junit.Assert.*;

/**
 * @author IronSid
 * @create 2021-06-28 17:13
 */
public class SolutionTest {
    static Solution solution = new Solution();

    @Test
    public void reorganizeStringTest1() {
        String input = "aaab";
        String actual = solution.reorganizeString(input);
        String expected = "";
        assertEquals(actual, expected);
    }

    @Test
    public void reorganizeStringTest2() {
        String input = "aab";
        String actual = solution.reorganizeString(input);
        assertEquals(input.length(), actual.length());
        boolean flag = true;
        //判断有没有相同的相邻字母
        for (int i = 0; i < actual.length() - 1; i++) {
            flag &= !(actual.charAt(i) == actual.charAt(i + 1));
        }
        assertTrue(flag);
        assertArrayEquals(countLetter(input), countLetter(actual));
    }

    @Test
    public void reorganizeStringTest3() {
        String input = "vvvlo";
        String actual = solution.reorganizeString(input);
        assertEquals(input.length(), actual.length());
        boolean flag = true;
        //判断有没有相同的相邻字母
        for (int i = 0; i < actual.length() - 1; i++) {
            flag &= !(actual.charAt(i) == actual.charAt(i + 1));
        }
        assertTrue(flag);
        System.out.println("input: " + input);
        System.out.println("output: " + actual);
        assertArrayEquals(countLetter(input), countLetter(actual));
    }

    static int[] countLetter(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        return count;
    }
}