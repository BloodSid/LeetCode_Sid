package leetcode.editor.cn;

import java.util.*;

/**
 * 1～n 整数中 1 出现的次数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-26 13:43:30 
 */
public class OneNzhengShuZhong1chuXianDeCiShuLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countDigitOne(int n) {
        int sum = 0;
        int product = 1;
        for (int i = 0; i < 10 && product <= n; i++) {
            int high = n / product;
            int higher = high / 10;
            int curr = high % 10;
            int temp = higher * product;
            if (curr == 1) {
                temp += n % product + 1;
            } else if (curr > 1) {
                temp += product;
            }
            sum += temp;
            product *= 10;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
