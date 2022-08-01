package leetcode.editor.cn;
//给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。 
//
// 整数 a 比整数 b 更接近 x 需要满足： 
//
// 
// |a - x| < |b - x| 或者 
// |a - x| == |b - x| 且 a < b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = 3
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = -1
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= arr.length 
// 1 <= arr.length <= 10⁴ 
// arr 按 升序 排列 
// -10⁴ <= arr[i], x <= 10⁴ 
// 
// 👍 343 👎 0


import java.util.*;

/**
 * 找到 K 个最接近的元素
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-08-01 11:24:19 
 */
public class FindKClosestElementsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
// import java.util.*;
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(arr[i] - x);
        }
        // 前缀和
        int[] preSum = new int[n + 1];
        for (int i = 1, t = 0; i <= n; i++) {
            t += diff[i - 1];
            preSum[i] = t;
        }
        int idx = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i <= n - k; i++) {
            int t = preSum[i + k] - preSum[i];
            if (t < min) {
                min = t;
                idx = i;
            }
        }
        int start = idx;
        // 提交时需导包
        return new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                return arr[start + index];
            }

            @Override
            public int size() {
                return k;
            }
        };
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}