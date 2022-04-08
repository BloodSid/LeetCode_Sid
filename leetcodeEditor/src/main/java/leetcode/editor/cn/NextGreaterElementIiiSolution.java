package leetcode.editor.cn;

/**
 * 下一个更大元素 III
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-08 13:57:13
 */
public class NextGreaterElementIiiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int i = arr.length - 1;
        for (; i > 0; i--) {
            if (arr[i] > arr[i - 1]) break;
        }
        if (i == 0) return -1;
        int j = arr.length - 1;
        for (; j > i; j--) {
            if (arr[j] > arr[i - 1]) break;
        }
        swap(arr, j, i - 1);
        reverse(arr, i, arr.length - 1);
        try {
            return Integer.parseInt(new String(arr));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    void swap(char[] arr, int a, int b) {
        char t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    void reverse(char[] arr, int a, int b) {
        for (; a < b; a++, b--) {
            swap(arr, a, b);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
