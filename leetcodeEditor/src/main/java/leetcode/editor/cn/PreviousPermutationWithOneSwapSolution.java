package leetcode.editor.cn;
//给你一个正整数数组 arr（可能存在重复的元素），请你返回可在 一次交换（交换两数字 arr[i] 和 arr[j] 的位置）后得到的、按字典序排列小于 
//arr 的最大排列。 
//
// 如果无法这么操作，就请返回原数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,2,1]
//输出：[3,1,2]
//解释：交换 2 和 1
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,1,5]
//输出：[1,1,5]
//解释：已经是最小排列
// 
//
// 示例 3： 
//
// 
//输入：arr = [1,9,4,6,7]
//输出：[1,7,4,6,9]
//解释：交换 9 和 7
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10⁴ 
// 1 <= arr[i] <= 10⁴ 
// 
//
// 👍 49 👎 0


import java.util.*;

/**
 * 交换一次的先前排列
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-04-03 00:07:58 
 */
public class PreviousPermutationWithOneSwapSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        // 最大值的下标
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                // arr[i+1:] 单调增，找其中最后一个小于arr[i]的元素交换
                int l = i + 1, r = n - 1;
                while (l <= r) {
                    int mid = l + r >> 1;
                    if (arr[mid] < arr[i]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                // 若该元素有多个，则找第一个进行交换
                int e = arr[r];
                l = i + 1;
                while (l <= r) {
                    int mid = l + r >> 1;
                    if (arr[mid] < e) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                int t = arr[l];
                arr[l] = arr[i];
                arr[i] = t;
                break;
            }
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
