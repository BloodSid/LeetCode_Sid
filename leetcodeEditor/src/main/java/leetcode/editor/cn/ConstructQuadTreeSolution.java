package leetcode.editor.cn;

/**
 * 建立四叉树
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-29 23:18:01
 */
public class ConstructQuadTreeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[][] grid;

    public Node construct(int[][] grid) {
        this.grid = grid;
        int n = grid.length;
        return construct(0, 0, n - 1, n - 1);
    }

    // 左上和右下的坐标
    public Node construct(int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            return new Node(grid[x1][y1] == 1, true);
        }
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (grid[i][j] != grid[x1][y1]) {
                    int x3 = x1 + x2 >> 1, y3 = y1 + y2 >> 1;
                    // 注意子节点的顺序
                    return new Node(true, false, construct(x1, y1, x3, y3), construct(x1, y3 + 1, x3, y2),
                            construct(x3 + 1, y1, x2, y3), construct(x3 + 1, y3 + 1, x2, y2));
                }
            }
        }
        return new Node(grid[x1][y1] == 1, true);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

}
