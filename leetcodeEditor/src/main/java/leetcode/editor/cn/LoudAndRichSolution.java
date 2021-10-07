package leetcode.editor.cn;
//在一组 N 个人（编号为 0, 1, 2, ..., N-1）中，每个人都有不同数目的钱，以及不同程度的安静（quietness）。 
//
// 为了方便起见，我们将编号为 x 的人简称为 "person x "。 
//
// 如果能够肯定 person x 比 person y 更有钱的话，我们会说 richer[i] = [x, y] 。注意 richer 可能只是有效观察的
//一个子集。 
//
// 另外，如果 person x 的安静程度为 q ，我们会说 quiet[x] = q 。 
//
// 现在，返回答案 answer ，其中 answer[x] = y 的前提是，在所有拥有的钱不少于 person x 的人中，person y 是最安静的人
//（也就是安静值 quiet[y] 最小的人）。 
//
// 示例： 
//
// 输入：richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1
//,7,0]
//输出：[5,5,2,5,4,5,6,7]
//解释： 
//answer[0] = 5，
//person 5 比 person 3 有更多的钱，person 3 比 person 1 有更多的钱，person 1 比 person 0 有更多的钱。
//
//唯一较为安静（有较低的安静值 quiet[x]）的人是 person 7，
//但是目前还不清楚他是否比 person 0 更有钱。
//
//answer[7] = 7，
//在所有拥有的钱肯定不少于 person 7 的人中(这可能包括 person 3，4，5，6 以及 7)，
//最安静(有较低安静值 quiet[x])的人是 person 7。
//
//其他的答案也可以用类似的推理来解释。
// 
//
// 提示： 
//
// 
// 1 <= quiet.length = N <= 500 
// 0 <= quiet[i] < N，所有 quiet[i] 都不相同。 
// 0 <= richer.length <= N * (N-1) / 2 
// 0 <= richer[i][j] < N 
// richer[i][0] != richer[i][1] 
// richer[i] 都是不同的。 
// 对 richer 的观察在逻辑上是一致的。 
// 
// Related Topics 深度优先搜索 图 拓扑排序 数组 
// 👍 58 👎 0


import java.util.*;

/**
 * 喧闹和富有
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-04 22:53:39
 */
public class LoudAndRichSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer>[] map;
    int[] ans;
    int[] quiet;

    public int[] loudAndRich(int[][] richers, int[] quiet) {
        int N = quiet.length;
        ans = new int[N];
        Arrays.fill(ans, -1);
        this.quiet = quiet;
        // 一个人到直接比他富的人的映射
        this.map = new List[N];
        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<Integer>();
        }
        for (int[] richer : richers) {
            map[richer[1]].add(richer[0]);
        }
        for (int i = 0; i < N; i++) {
            dfs(i);
        }
        return ans;
    }

    int dfs(int node) {
        // 如果没访问过才dfs
        if (ans[node] == -1) {
            ans[node] = node;
            for (Integer son : map[node]) {
                int temp = dfs(son);
                if (quiet[temp] < quiet[ans[node]]) {
                    ans[node] = temp;
                }
            }
        }
        return ans[node];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
