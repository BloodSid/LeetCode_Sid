package leetcode.editor.cn;
//给你一棵树，树上有 n 个节点，按从 0 到 n-1 编号。树以父节点数组的形式给出，其中 parent[i] 是节点 i 的父节点。树的根节点是编号为 0
// 的节点。 
//
// 树节点的第 k 个祖先节点是从该节点到根节点路径上的第 k 个节点。 
//
// 实现 TreeAncestor 类： 
//
// 
// TreeAncestor（int n， int[] parent） 对树和父数组中的节点数初始化对象。 
// getKthAncestor(int node, int k) 返回节点 node 的第 k 个祖先节点。如果不存在这样的祖先节点，返回 -1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：
//["TreeAncestor","getKthAncestor","getKthAncestor","getKthAncestor"]
//[[7,[-1,0,0,1,1,2,2]],[3,1],[5,2],[6,3]]
//
//输出：
//[null,1,0,-1]
//
//解释：
//TreeAncestor treeAncestor = new TreeAncestor(7, [-1, 0, 0, 1, 1, 2, 2]);
//
//treeAncestor.getKthAncestor(3, 1);  // 返回 1 ，它是 3 的父节点
//treeAncestor.getKthAncestor(5, 2);  // 返回 0 ，它是 5 的祖父节点
//treeAncestor.getKthAncestor(6, 3);  // 返回 -1 因为不存在满足要求的祖先节点
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 5 * 10⁴ 
// parent[0] == -1 表示编号为 0 的节点是根节点。 
// 对于所有的 0 < i < n ，0 <= parent[i] < n 总成立 
// 0 <= node < n 
// 至多查询 5 * 10⁴ 次 
// 
//
// 👍 179 👎 0


/**
 * 树节点的第 K 个祖先
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-06-12 22:17:22 
 */
public class KthAncestorOfATreeNodeSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class TreeAncestor {

    private final int N;
    private final int[][] fa;

    public TreeAncestor(int n, int[] parent) {
        // n 的二进制长度
        N = 32 - Integer.numberOfLeadingZeros(n);
        // 倍增数组
        fa = new int[N][n + 1];
        // 初始化
        for (int i = 0; i < n; i++) {
            int cur = i + 1, prt = parent[i] + 1;
            fa[0][cur] = prt;
        }
        for (int i = 1; i < N; i++) {
            // 第 2^i 的祖先节点是第 2^(i-1) 的祖先节点的 第 2^(i-1) 的祖先节点
            for (int cur = 1; cur <= n; cur++) {
                fa[i][cur] = fa[i - 1][fa[i - 1][cur]];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        // 下标对齐
        node++;
        // 利用倍增数组找 node 的第k个祖先
        for (int j = 0; k != 0; j++, k >>= 1) {
            if ((k & 1) == 1) {
                node = fa[j][node];
            }
        }
        // 下标对齐到0；若node为0，则表示没有对应祖先元素，返回-1
        return node - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
