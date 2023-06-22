package leetcode.editor.cn;
//你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指
//相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。 
// 示例： 
// 输入：
//[
//  [0,2,1,0],
//  [0,1,0,1],
//  [1,1,0,1],
//  [0,1,0,1]
//]
//输出： [1,2,4]
// 
// 提示： 
// 
// 0 < len(land) <= 1000 
// 0 < len(land[i]) <= 1000 
// 
//
// 👍 135 👎 0


import java.util.*;

/**
 * 水域大小
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-06-22 21:08:15 
 */
public class PondSizesLcciSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int[][] DIRS = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    private int m;
    private int n;
    private int[][] land;

    public int[] pondSizes(int[][] land) {
        m = land.length;
        n = land[0].length;
        this.land = land;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0) list.add(dfs(i, j));
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        return res;
    }

    private int dfs(int i, int j) {
        int sum = 0;
        land[i][j] = 1;
        for (int[] dir : DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || y < 0 || x >= m || y >= n) continue;
            if (land[x][y] != 0) continue;
            sum += dfs(x, y);
        }
        return 1 + sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
