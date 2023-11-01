package leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author IronSid
 * @since 2023-11-01 16:47
 */
public class MaximumEmployeesToBeInvitedToAMeetingSolutionTest {
    MaximumEmployeesToBeInvitedToAMeetingSolution.Solution solution = new MaximumEmployeesToBeInvitedToAMeetingSolution.Solution();

    /**
     * Method: maximumInvitations(int[] favorite)
     */
    @Test
    public void testMaximumInvitations1() throws Exception {
        int[] favorite = {1, 0, 3, 2, 5, 6, 7, 4, 9, 8, 11, 10, 11, 12, 10};
        int expected = 11;
        int actual = solution.maximumInvitations(favorite);
        assertEquals(expected, actual);
    }
}