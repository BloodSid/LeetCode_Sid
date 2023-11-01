package leetcode.editor.cn;
//一个公司准备组织一场会议，邀请名单上有 n 位员工。公司准备了一张 圆形 的桌子，可以坐下 任意数目 的员工。 
//
// 员工编号为 0 到 n - 1 。每位员工都有一位 喜欢 的员工，每位员工 当且仅当 他被安排在喜欢员工的旁边，他才会参加会议。每位员工喜欢的员工 不会 
//是他自己。 
//
// 给你一个下标从 0 开始的整数数组 favorite ，其中 favorite[i] 表示第 i 位员工喜欢的员工。请你返回参加会议的 最多员工数目 。 
//
//
// 
//
// 示例 1： 
//
// 
//
// 输入：favorite = [2,2,1,2]
//输出：3
//解释：
//上图展示了公司邀请员工 0，1 和 2 参加会议以及他们在圆桌上的座位。
//没办法邀请所有员工参与会议，因为员工 2 没办法同时坐在 0，1 和 3 员工的旁边。
//注意，公司也可以邀请员工 1，2 和 3 参加会议。
//所以最多参加会议的员工数目为 3 。
// 
//
// 示例 2： 
//
// 输入：favorite = [1,2,0]
//输出：3
//解释：
//每个员工都至少是另一个员工喜欢的员工。所以公司邀请他们所有人参加会议的前提是所有人都参加了会议。
//座位安排同图 1 所示：
//- 员工 0 坐在员工 2 和 1 之间。
//- 员工 1 坐在员工 0 和 2 之间。
//- 员工 2 坐在员工 1 和 0 之间。
//参与会议的最多员工数目为 3 。
// 
//
// 示例 3： 
//
// 
//
// 输入：favorite = [3,0,1,4,1]
//输出：4
//解释：
//上图展示了公司可以邀请员工 0，1，3 和 4 参加会议以及他们在圆桌上的座位。
//员工 2 无法参加，因为他喜欢的员工 0 旁边的座位已经被占领了。
//所以公司只能不邀请员工 2 。
//参加会议的最多员工数目为 4 。
// 
//
// 
//
// 提示： 
//
// 
// n == favorite.length 
// 2 <= n <= 10⁵ 
// 0 <= favorite[i] <= n - 1 
// favorite[i] != i 
// 
//
// 👍 152 👎 0


import java.util.*;

/**
 * 参加会议的最多员工数
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-11-01 15:21:13 
 */
public class MaximumEmployeesToBeInvitedToAMeetingSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumInvitations(int[] favorite) {
        // 建图
        int n = favorite.length;
        // 入度
        int[] deg = new int[n];
        for (int i = 0; i < favorite.length; i++) {
            deg[favorite[i]]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) q.offer(i);
        }
        int[] chain = new int[n];
        // 拓扑排序，同时计算出非环链的长度
        for (int len = 1; !q.isEmpty(); len++) {
            for (int size = q.size(); size > 0; size--) {
                int p = q.poll();
                chain[p] = len;
                if (--deg[favorite[p]] == 0) q.offer(favorite[p]);
            }
        }

        // 存环的长度，最开始是个空节点
        int[] loop = new int[n];
        // 存到该点的链最大长度
        int[] maxChain = new int[n];
        List<Integer> looplen = new ArrayList<>();
        looplen.add(-1);
        // 遍历数出环的长度
        for (int i = 0; i < n; i++) {
            if (chain[i] != 0) {
                maxChain[favorite[i]] = Math.max(maxChain[favorite[i]], chain[i]);
                continue;
            }
            // 环的起点
            int cnt = 1;
            int li = looplen.size();
            chain[i] = -1;
            loop[i] = li;
            for (int cur = favorite[i]; cur != i; cur = favorite[cur]) {
                chain[cur] = -1;
                loop[cur] = li;
                cnt++;
            }
            looplen.add(cnt);
        }
        int res = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            // 合法结果中必然有一部分是环
            if (chain[i] == -1) {
                int len = looplen.get(loop[i]);
                // 结果集中只有一个环
                res = Math.max(res, len);
                // 环的长度为2，则环上两个点可以各连接一个链，这样形成的子图可以在结果集中存在多个
                if (len == 2) {
                    sum += 2 + maxChain[i] + maxChain[favorite[i]];
                }
            }
        }
        return Math.max(res, sum / 2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
