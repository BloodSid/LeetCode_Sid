package leetcode.editor.cn;

import java.util.*;

/**
 * 适龄的朋友
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-27 22:52:06
 */
public class FriendsOfAppropriateAgesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numFriendRequests(int[] ages) {
        int[] freq = new int[121];
        for (int age : ages) {
            freq[age]++;
        }
        int sum = 0;
        for (int i = 1; i <= 120; i++) {
            // 对满足 x > y > 0.5 * x + 7 的 y 发送, 第三个条件为真时，第二个条件必为真，故可不考虑该情况
            if (freq[i] == 0) {
                continue;
            }
            int recv = 0;
            for (int j = i / 2 + 8; j <= i; j++) {
                recv += freq[j];
            }
            // 不给自己发
            if (recv > 0) {
                recv--;
            }
            sum += recv * freq[i];
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
