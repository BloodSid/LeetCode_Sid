package leetcode.editor.cn;

/**
 * 省份数量
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-09 00:17:12
 */
public class NumberOfProvincesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int province;
    private int[] p;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        province = n;
        p = new int[n];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        return province;
    }

    void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            p[rootB] = rootA;
            province--;
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
