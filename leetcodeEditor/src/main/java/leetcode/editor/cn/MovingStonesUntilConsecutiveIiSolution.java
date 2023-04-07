package leetcode.editor.cn;
//在一个长度 无限 的数轴上，第 i 颗石子的位置为 stones[i]。如果一颗石子的位置最小/最大，那么该石子被称作 端点石子 。 
//
// 每个回合，你可以将一颗端点石子拿起并移动到一个未占用的位置，使得该石子不再是一颗端点石子。 
//
// 值得注意的是，如果石子像 stones = [1,2,5] 这样，你将 无法 移动位于位置 5 的端点石子，因为无论将它移动到任何位置（例如 0 或 3）
//，该石子都仍然会是端点石子。 
//
// 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。 
//
// 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, 
//maximum_moves] 。 
//
// 
//
// 示例 1： 
//
// 
//输入：[7,4,9]
//输出：[1,2]
//解释：
//我们可以移动一次，4 -> 8，游戏结束。
//或者，我们可以移动两次 9 -> 5，4 -> 6，游戏结束。
// 
//
// 示例 2： 
//
// 
//输入：[6,5,4,3,10]
//输出：[2,3]
//解释：
//我们可以移动 3 -> 8，接着是 10 -> 7，游戏结束。
//或者，我们可以移动 3 -> 7, 4 -> 8, 5 -> 9，游戏结束。
//注意，我们无法进行 10 -> 2 这样的移动来结束游戏，因为这是不合要求的移动。
// 
//
// 示例 3： 
//
// 
//输入：[100,101,104,102,103]
//输出：[0,0] 
//
// 
//
// 提示： 
//
// 
// 3 <= stones.length <= 10^4 
// 1 <= stones[i] <= 10^9 
// stones[i] 的值各不相同。 
// 
//
// 
//
// 👍 130 👎 0


import java.util.*;

/**
 * 移动石子直到连续 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-04-07 10:09:57
 */
public class MovingStonesUntilConsecutiveIiSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;
        // 可选位置
        int s1 = stones[n - 1] - stones[0] + 1 - n;
        // 第一次移动后减少的可选位置
        int s2 = Math.min(stones[n - 1] - stones[n - 2] - 1, stones[1] - stones[0] - 1);
        // 最大值策略：每轮左右端点的差值只减一
        int max = s1 - s2;
        int min = Integer.MAX_VALUE;
        // 双指针
        for (int i = 0, j = 0; ; i++) {
            while (j < n && stones[j] <= stones[i] + n - 1) {
                j++;
            }
            int gap = n - (j - i);
            // 特判 2 3 4 5 8 的情况， gap 为一但是必须需要两步
            if (gap == 1 && stones[j - 1] - stones[i] == n - 2) {
                min = Math.min(min, 2);
            } else {
                min = Math.min(min, gap);
            }
            if (j == n) break;
        }
        return new int[]{min, max};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
