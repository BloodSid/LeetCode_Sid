package leetcode.editor.cn;
//给出基数为 -2 的两个数 arr1 和 arr2，返回两数相加的结果。 
//
// 数字以 数组形式 给出：数组由若干 0 和 1 组成，按最高有效位到最低有效位的顺序排列。例如，arr = [1,1,0,1] 表示数字 (-2)^3 +
// (-2)^2 + (-2)^0 = -3。数组形式 中的数字 arr 也同样不含前导零：即 arr == [0] 或 arr[0] == 1。 
//
// 返回相同表示形式的 arr1 和 arr2 相加的结果。两数的表示形式为：不含前导零、由若干 0 和 1 组成的数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr1 = [1,1,1,1,1], arr2 = [1,0,1]
//输出：[1,0,0,0,0]
//解释：arr1 表示 11，arr2 表示 5，输出表示 16 。
// 
//
// 
// 
//
// 示例 2： 
//
// 
//输入：arr1 = [0], arr2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：arr1 = [0], arr2 = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
// 
//
// 
// 1 <= arr1.length, arr2.length <= 1000 
// arr1[i] 和 arr2[i] 都是 0 或 1 
// arr1 和 arr2 都没有前导0 
// 
//
// 👍 52 👎 0


/**
 * 负二进制数相加
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-05-18 01:43:38 
 */
public class AddingTwoNegabinaryNumbersSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        int n = Math.max(n1, n2);
        int[] res = new int[n];
        for (int i = 0; i < n1; i++) {
            res[n - 1 - i] += arr1[n1 - 1 - i];
        }
        for (int i = 0; i < n2; i++) {
            res[n - 1 - i] += arr2[n2 - 1 - i];
        }
        for (int i = n - 1; i > 0; i--) {
            if (res[i] >= 2) {
                // 对于 2 和 3，前一位减一
                res[i - 1]--;
                res[i] -= 2;
            } else if (res[i] == -1) {
                // 对于 -1 前一位加一
                res[i - 1]++;
                res[i] += 2;
            }
        }
        if (res[0] == -1) {
            res[0] += 2;
            // 在前面补 “1”
            int[] copy = new int[n + 1];
            copy[0] = 1;
            System.arraycopy(res, 0, copy, 1, n);
        } else if (res[0] >= 2) {
            res[0] -= 2;
            // 在前面补 “11”
            int[] copy = new int[n + 2];
            copy[0] = copy[1] = 1;
            System.arraycopy(res, 0, copy, 2, n);
            return copy;
        } else if (res[0] == 0) {
            // 去除前导零
            int offset = 0;
            while (offset < n - 1 && res[offset] == 0) offset++;
            int[] copy = new int[n - offset];
            System.arraycopy(res, offset, copy, 0, n - offset);
            return copy;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
