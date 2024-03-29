package leetcode.editor.cn;
//给你一个下标从 0 开始的整数数组 players ，其中 players[i] 表示第 i 名运动员的 能力 值，同时给你一个下标从 0 开始的整数数组 
//trainers ，其中 trainers[j] 表示第 j 名训练师的 训练能力值 。 
//
// 如果第 i 名运动员的能力值 小于等于 第 j 名训练师的能力值，那么第 i 名运动员可以 匹配 第 j 名训练师。除此以外，每名运动员至多可以匹配一位训
//练师，每位训练师最多可以匹配一位运动员。 
//
// 请你返回满足上述要求 players 和 trainers 的 最大 匹配数。 
//
// 
//
// 示例 1： 
//
// 输入：players = [4,7,9], trainers = [8,2,5,8]
//输出：2
//解释：
//得到两个匹配的一种方案是：
//- players[0] 与 trainers[0] 匹配，因为 4 <= 8 。
//- players[1] 与 trainers[3] 匹配，因为 7 <= 8 。
//可以证明 2 是可以形成的最大匹配数。
// 
//
// 示例 2： 
//
// 输入：players = [1,1,1], trainers = [10]
//输出：1
//解释：
//训练师可以匹配所有 3 个运动员
//每个运动员至多只能匹配一个训练师，所以最大答案是 1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= players.length, trainers.length <= 10⁵ 
// 1 <= players[i], trainers[j] <= 10⁹ 
// 
// 👍 4 👎 0


import java.util.*;

/**
 * 运动员和训练师的最大匹配数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-09-24 22:54:02 
 */
public class MaximumMatchingOfPlayersWithTrainersSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i = players.length - 1;
        int j = trainers.length - 1;
        int cnt = 0;
        while (i >= 0 && j >= 0) {
            if (players[i] <= trainers[j]) {
                i--;
                j--;
                cnt++;
            } else {
                i--;
            }
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
