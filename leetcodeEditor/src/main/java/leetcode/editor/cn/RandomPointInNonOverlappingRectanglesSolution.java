package leetcode.editor.cn;
//给定一个由非重叠的轴对齐矩形的数组 rects ，其中 rects[i] = [ai, bi, xi, yi] 表示 (ai, bi) 是第 i 个矩形的左
//下角点，(xi, yi) 是第 i 个矩形的右上角角点。设计一个算法来随机挑选一个被某一矩形覆盖的整数点。矩形周长上的点也算做是被矩形覆盖。所有满足要求的点必须
//等概率被返回。 
//
// 在一个给定的矩形覆盖的空间内任何整数点都有可能被返回。 
//
// 请注意 ，整数点是具有整数坐标的点。 
//
// 实现 Solution 类: 
//
// 
// Solution(int[][] rects) 用给定的矩形数组 rects 初始化对象。 
// int[] pick() 返回一个随机的整数点 [u, v] 在给定的矩形所覆盖的空间内。 
// 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: 
//["Solution","pick","pick","pick","pick","pick"]
//[[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
//输出: 
//[null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]
//
//解释：
//Solution solution = new Solution([[-2, -2, 1, 1], [2, 2, 4, 6]]);
//solution.pick(); // 返回 [1, -2]
//solution.pick(); // 返回 [1, -1]
//solution.pick(); // 返回 [-1, -2]
//solution.pick(); // 返回 [-2, -2]
//solution.pick(); // 返回 [0, 0] 
//
// 
//
// 提示： 
//
// 
// 1 <= rects.length <= 100 
// rects[i].length == 4 
// -10⁹ <= ai < xi <= 10⁹ 
// -10⁹ <= bi < yi <= 10⁹ 
// xi - ai <= 2000 
// yi - bi <= 2000 
// 所有的矩形不重叠。 
// pick 最多被调用 10⁴ 次。 
// 
// 👍 59 👎 0


import java.util.*;

/**
 * 非重叠矩形中的随机点
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-09 00:11:54
 */
public class RandomPointInNonOverlappingRectanglesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    TreeMap<Integer, Integer> map = new TreeMap<>();
    private int[][] rects;
    private int total;
    private Random random = new Random();

    public Solution(int[][] rects) {
        this.rects = rects;
        int temp = 0;
        for (int i = 0; i < rects.length; i++) {
            int area = (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            map.put(temp, i);
            temp += area;
        }
        total = temp;
    }

    public int[] pick() {
        int r = random.nextInt(total);
        Map.Entry<Integer, Integer> entry = map.floorEntry(r);
        int idx = entry.getValue();
        r -= entry.getKey();
        int a = rects[idx][2] - rects[idx][0] + 1;
        return new int[]{rects[idx][0] + r % a, rects[idx][1] + r / a};
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
