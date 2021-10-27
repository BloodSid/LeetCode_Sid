package leetcode.editor.cn;

import java.util.*;

/**
 * 重新排序得到 2 的幂
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-28 02:28:46
 */
public class ReorderedPowerOf2Solution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean reorderedPowerOf2(int n) {
        String[] powers = {"0112344778", "011237", "0122579", "012356789", "0124", "0134449", "0145678",
                "01466788", "0248", "0368888", "0469", "1", "112234778", "11266777", "122446", "1234446788",
                "125", "128", "1289", "13468", "16", "2", "2244667999", "224588", "23", "23334455", "234455668",
                "2345588999", "23678", "256", "35566", "4", "46", "8"};
        char[] input = Integer.toString(n).toCharArray();
        Arrays.sort(input);
        return Arrays.binarySearch(powers, new String(input)) >= 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
