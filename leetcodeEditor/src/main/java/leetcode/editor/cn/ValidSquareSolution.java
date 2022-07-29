package leetcode.editor.cn;
//给定2D空间中四个点的坐标 p1, p2, p3 和 p4，如果这四个点构成一个正方形，则返回 true 。 
//
// 点的坐标 pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的。 
//
// 一个 有效的正方形 有四条等边和四个等角(90度角)。 
//
// 
//
// 示例 1: 
//
// 
//输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
//输出: True
// 
//
// 示例 2: 
//
// 
//输入：p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
//输出：false
// 
//
// 示例 3: 
//
// 
//输入：p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
//输出：true
// 
//
// 
//
// 提示: 
//
// 
// p1.length == p2.length == p3.length == p4.length == 2 
// -10⁴ <= xi, yi <= 10⁴ 
// 
// 👍 125 👎 0


import java.util.Arrays;

/**
 * 有效的正方形
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-07-29 10:26:35 
 */
public class ValidSquareSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p = {p1, p2, p3, p4};
        int n = p.length;
        int[] list = new int[n * (n - 1) / 2];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                list[k++] = dis(p[i], p[j]);
            }
        }
        Arrays.sort(list);
        if (list[0] == 0) return false;
        return list[1] == list[0] && list[2] == list[0] && list[3] == list[0] &&
                list[4] == 2 * list[0] && list[5] == 2 * list[0];
    }

    int dis(int[] x, int[] y) {
        int[] v = {x[0] - y[0], x[1] - y[1]};
        return v[0] * v[0] + v[1] * v[1];
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
