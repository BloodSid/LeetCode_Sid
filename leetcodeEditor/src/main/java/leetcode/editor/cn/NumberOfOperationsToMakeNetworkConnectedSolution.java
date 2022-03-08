package leetcode.editor.cn;

/**
 * 连通网络的操作次数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-09 00:11:33
 */
public class NumberOfOperationsToMakeNetworkConnectedSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 连通分量( Connected Component)
    private int comp;
    private int[] p;

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        comp = n;
        p = new int[n];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        // 对相连节点进行合并
        for (int[] connection : connections) {
            union(connection[0], connection[1]);
        }
        return comp - 1;
    }

    void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            p[rootB] = rootA;
            comp--;
        }
    }

    int find(int a) {
        if (p[a] != a) {
            p[a] = find(p[a]);
        }
        return p[a];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
