package leetcode.editor.cn;
//给定一个由不同正整数的组成的非空数组 nums ，考虑下面的图： 
//
// 
// 有 nums.length 个节点，按从 nums[0] 到 nums[nums.length - 1] 标记； 
// 只有当 nums[i] 和 nums[j] 共用一个大于 1 的公因数时，nums[i] 和 nums[j]之间才有一条边。 
// 
//
// 返回 图中最大连通组件的大小 。 
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
//输入：nums = [4,6,15,35]
//输出：4
// 
//
// 示例 2： 
//
// 
//
// 
//输入：nums = [20,50,9,63]
//输出：2
// 
//
// 示例 3： 
//
// 
//
// 
//输入：nums = [2,3,6,7,4,12,21,39]
//输出：8
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 1 <= nums[i] <= 10⁵ 
// nums 中所有值都 不同 
// 
// 👍 78 👎 0


import java.util.Arrays;
import java.util.HashMap;

/**
 * 按公因数计算最大组件大小
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-07-30 00:38:09 
 */
public class LargestComponentSizeByCommonFactorSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int MAX = (int) 1e5;
    // 缓存所有数最小的质因子
    int[] factor = new int[MAX + 1];
    // static
    HashMap<Integer, Integer> pMap = new HashMap<>();
    // static
    int size = 0;

    // static
    {
        loop:
        for (int i = 2; i <= MAX; i++) {
            int R = (int) Math.sqrt(i);
            for (int j = 2; j <= R; j++) {
                if (i % j == 0) {
                    factor[i] = j;
                    continue loop;
                }
            }
            factor[i] = i;
            pMap.put(i, size++);
        }
    }

    int[] p;
    int[] weight;
    int maxWeight = 0;

    public int largestComponentSize(int[] nums) {
        int n = nums.length;
        // [0, n) 对应 nums 中的数，节点权重为 1, [n, n + size) 对应 prime 中的数， 节点权重为 0
        p = new int[n + size];
        weight = new int[n + size];
        // 初始化
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        Arrays.fill(weight, 0, n, 1);
        // 对每个数，将它和它的质因子 union
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (num != 1) {
                union(i, n + pMap.get(factor[num]));
                num /= factor[num];
            }
        }
        return maxWeight;
    }

    int find(int a) {
        if (p[a] != a) {
            p[a] = find(p[a]);
        }
        return p[a];
    }

    void union(int a, int b) {
        int rootA = find(a), rootB = find(b);
        if (rootA != rootB) {
            // 按节点序号合并
            int mx = Math.max(rootA, rootB), mn = Math.min(rootA, rootB);
            p[mn] = mx;
            weight[mx] += weight[mn];
            maxWeight = Math.max(maxWeight, weight[mx]);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
