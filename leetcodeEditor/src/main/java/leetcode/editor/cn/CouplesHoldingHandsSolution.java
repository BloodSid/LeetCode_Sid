package leetcode.editor.cn;
//n 对情侣坐在连续排列的 2n 个座位上，想要牵到对方的手。 
//
// 人和座位由一个整数数组 row 表示，其中 row[i] 是坐在第 i 个座位上的人的 ID。情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 
//3)，以此类推，最后一对是 (2n-2, 2n-1)。 
//
// 返回 最少交换座位的次数，以便每对情侣可以并肩坐在一起。 每次交换可选择任意两人，让他们站起来交换座位。 
//
// 
//
// 示例 1: 
//
// 
//输入: row = [0,2,1,3]
//输出: 1
//解释: 只需要交换row[1]和row[2]的位置即可。
// 
//
// 示例 2: 
//
// 
//输入: row = [3,2,0,1]
//输出: 0
//解释: 无需交换座位，所有的情侣都已经可以手牵手了。
// 
//
// 
//
// 提示: 
//
// 
// 2n == row.length 
// 2 <= n <= 30 
// n 是偶数 
// 0 <= row[i] < 2n 
// row 中所有元素均无重复 
// 
//
// 👍 478 👎 0


/**
 * 情侣牵手
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-11-11 14:17:45 
 */
public class CouplesHoldingHandsSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int[] p;
    private int cnt;

    public int minSwapsCouples(int[] row) {
        int n = row.length;
        // 联通分量个数
        cnt = n / 2;
        p = new int[n / 2];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        // 2个相邻下标为1组位置，如果两个人在1组位置上，那么对应的情侣组建边
        for (int i = 0; i < n; i += 2) {
            union(row[i] / 2, row[i + 1] / 2);
        }
        // 若k对情侣构成一个环，那么需要换k-1次，即每组连通分量都使交换次数减一
        return n / 2 - cnt;
    }

    void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (rx != ry) {
            p[ry] = rx;
            cnt--;
        }
    }

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
