package Contest0422.T4;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import static org.junit.Assert.*;
/**
@author IronSid
@since 2023-04-22 17:36
*/

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void challengeOfTheKeeper1() {
        String sm = "[\".....\",\"##S..\",\"...#.\",\"T.#..\",\"###..\"]";
        String[] maze = JSON.parseArray(sm, String.class).toArray(new String[0]);
        int actual = solution.challengeOfTheKeeper(maze);
        int expected = 7;
        assertEquals(actual, expected);
    }

    @Test
    public void challengeOfTheKeeper2() {
        String sm = "[\".#..\",\"..##\",\".#S.\",\".#.T\"]";
        String[] maze = JSON.parseArray(sm, String.class).toArray(new String[0]);
        int actual = solution.challengeOfTheKeeper(maze);
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void challengeOfTheKeeper3() {
        String sm = "[\"S###.\",\"..###\",\"#..##\",\"##..#\",\"###.T\"]";
        String[] maze = JSON.parseArray(sm, String.class).toArray(new String[0]);
        int actual = solution.challengeOfTheKeeper(maze);
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void challengeOfTheKeeper4() {
        String sm = "[\".....#..\",\"...T....\",\"S.#.#..#\",\"........\",\"..#.....\",\"#.##...#\",\"....#.##\",\".#....#.\"]";
        String[] maze = JSON.parseArray(sm, String.class).toArray(new String[0]);
        int actual = solution.challengeOfTheKeeper(maze);
        int expected = 6;
        assertEquals(expected, actual);
    }
}