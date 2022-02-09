package leetcode.editor.cn;

import java.util.*;

/**
 * 最简分数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-10 00:24:24
 */
public class SimplifiedFractionsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> simplifiedFractions(int n) {
        List list = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (gcd(j, i) == 1) {
                    sb.setLength(0);
                    sb.append(j).append('/').append(i);
                    list.add(sb.toString());
                }
            }
        }
        return list;
    }

    int gcd(int a, int b) {
        // gcd(a,b) = gcd(b,a mod b)
        while (b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
