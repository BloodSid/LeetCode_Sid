package leetcode.editor.cn;

import java.util.*;

/**
 * 图像渲染
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-18 18:17:13
 */
public class FloodFillSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int[][] image;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.image = image;
        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }
        image[sr][sc] = newColor;
        dfs(sr, sc, oldColor, newColor);
        return image;
    }

    void dfs(int x, int y, int oldColor, int newColor) {
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < image.length && nx >= 0 && ny < image[0].length && ny >= 0 && image[nx][ny] == oldColor) {
                image[nx][ny] = newColor;
                dfs(nx, ny, oldColor, newColor);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
