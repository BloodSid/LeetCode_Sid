package leetcode.editor.cn;
//给定一个整数 n 和一个 无重复 黑名单整数数组 blacklist 。设计一种算法，从 [0, n - 1] 范围内的任意整数中选取一个 未加入 黑名单 
//blacklist 的整数。任何在上述范围内且不在黑名单 blacklist 中的整数都应该有 同等的可能性 被返回。 
//
// 优化你的算法，使它最小化调用语言 内置 随机函数的次数。 
//
// 实现 Solution 类: 
//
// 
// Solution(int n, int[] blacklist) 初始化整数 n 和被加入黑名单 blacklist 的整数 
// int pick() 返回一个范围为 [0, n - 1] 且不在黑名单 blacklist 中的随机整数 
// 
//
// 
//
// 示例 1： 
//
// 
//输入
//["Solution", "pick", "pick", "pick", "pick", "pick", "pick", "pick"]
//[[7, [2, 3, 5]], [], [], [], [], [], [], []]
//输出
//[null, 0, 4, 1, 6, 1, 0, 4]
//
//解释
//Solution solution = new Solution(7, [2, 3, 5]);
//solution.pick(); // 返回0，任何[0,1,4,6]的整数都可以。注意，对于每一个pick的调用，
//                 // 0、1、4和6的返回概率必须相等(即概率为1/4)。
//solution.pick(); // 返回 4
//solution.pick(); // 返回 1
//solution.pick(); // 返回 6
//solution.pick(); // 返回 1
//solution.pick(); // 返回 0
//solution.pick(); // 返回 4
// 
//
// 
//
// 提示: 
//
//
// 1 <= n <= 10⁹ 
// 0 <= blacklist.length <= min(10⁵, n - 1) 
// 0 <= blacklist[i] < n 
// blacklist 中所有值都 不同 
// pick 最多被调用 2 * 10⁴ 次 
// 
// 👍 129 👎 0


import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * 黑名单中的随机数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-26 10:17:38 
 */
public class RandomPickWithBlacklistSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private final int white;
    private final HashMap<Integer, Integer> map;
    Random random = new Random();

    public Solution(int n, int[] blacklist) {
        int m = blacklist.length;
        white = n - m;
        map = new HashMap<>();
        // 储存黑名单中超过 n - m 的元素
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            if (blacklist[i] >= white) {
                set.add(blacklist[i]);
            }
        }
        for (int i = 0, j = 0; i < m;) {
            if (blacklist[i] >= white) {
                i++;
            } else if (set.contains(n - m + j)) {
                j++;
            } else {
                map.put(blacklist[i], n - m + j);
                i++;
                j++;
            }
        }
    }
    
    public int pick() {
        int rand = random.nextInt(white);
        if (map.containsKey(rand)) rand = map.get(rand);
        return rand;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
