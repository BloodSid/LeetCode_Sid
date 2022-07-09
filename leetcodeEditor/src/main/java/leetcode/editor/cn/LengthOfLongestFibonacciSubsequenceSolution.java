package leetcode.editor.cn;
//如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的： 
//
// 
// n >= 3 
// 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2} 
// 
//
// 给定一个严格递增的正整数数组形成序列 arr ，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回 0 。 
//
// （回想一下，子序列是从原序列 arr 中派生出来的，它从 arr 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如， [3, 5, 8] 
//是 [3, 4, 5, 6, 7, 8] 的一个子序列） 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入: arr = [1,2,3,4,5,6,7,8]
//输出: 5
//解释: 最长的斐波那契式子序列为 [1,2,3,5,8] 。
// 
//
// 示例 2： 
//
// 
//输入: arr = [1,3,7,11,12,14,18]
//输出: 3
//解释: 最长的斐波那契式子序列有 [1,11,12]、[3,11,14] 以及 [7,11,18] 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= arr.length <= 1000 
// 
// 1 <= arr[i] < arr[i + 1] <= 10^9 
// 
// 
// 👍 285 👎 0


/**
 * 最长的斐波那契子序列的长度
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-07-09 13:09:06 
 */
public class LengthOfLongestFibonacciSubsequenceSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int max = 0;
        int n = arr.length;
        int[][] f = new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int l = 0, r = i - 1;
                int target = arr[j] - arr[i];
                while (l < r) {
                    int mid = l + r >> 1;
                    if (arr[mid] < target) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                if (arr[l] == target) {
                    f[i][j] = f[l][i] + 1;
                    max = Math.max(max, f[i][j]);
                }
            }
        }
        return max == 0 ? 0 : max + 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
