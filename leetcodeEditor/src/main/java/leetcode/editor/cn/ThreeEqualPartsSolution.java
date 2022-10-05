package leetcode.editor.cn;
//给定一个由 0 和 1 组成的数组 arr ，将数组分成 3 个非空的部分 ，使得所有这些部分表示相同的二进制值。 
//
// 如果可以做到，请返回任何 [i, j]，其中 i+1 < j，这样一来： 
//
// 
// arr[0], arr[1], ..., arr[i] 为第一部分； 
// arr[i + 1], arr[i + 2], ..., arr[j - 1] 为第二部分； 
// arr[j], arr[j + 1], ..., arr[arr.length - 1] 为第三部分。 
// 这三个部分所表示的二进制值相等。 
// 
//
// 如果无法做到，就返回 [-1, -1]。 
//
// 注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，[1,1,0] 表示十进制中的 6，而不会是 3。此外，前导零也是被允许的，所以 [0,
//1,1] 和 [1,1] 表示相同的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,0,1,0,1]
//输出：[0,3]
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,1,0,1,1]
//输出：[-1,-1] 
//
// 示例 3: 
//
// 
//输入：arr = [1,1,0,0,1]
//输出：[0,2]
// 
//
// 
//
// 提示： 
// 
//
// 
// 3 <= arr.length <= 3 * 10⁴ 
// arr[i] 是 0 或 1 
// 
// 👍 73 👎 0


/**
 * 三等分
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-10-06 00:02:50 
 */
public class ThreeEqualPartsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private final int[] notPossible = new int[]{-1, -1};

    public int[] threeEqualParts(int[] arr) {
        int n = arr.length;
        // lcp 表示 a[i:] 和 a[j:] 的最长公共前缀
        int bit = 0;
        for (int i : arr) {
            bit += i;
        }
        if (bit % 3 != 0) return notPossible;
        if (bit == 0) return new int[]{0, 2};
        int p0 = -1, p1 = -1, p2 = -1, cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += arr[i];
            if (cnt == 1 && p0 == -1) p0 = i;
            else if (cnt == bit / 3 + 1 && p1 == -1) p1 = i;
            else if (cnt == bit / 3 * 2 + 1 && p2 == -1) p2 = i;
        }
        while (p2 < n) {
            if (arr[p0] != arr[p1] || arr[p1] != arr[p2]) return notPossible;
            p0++;
            p1++;
            p2++;
        }
        return new int[]{p0 - 1, p1};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
