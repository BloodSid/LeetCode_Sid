package leetcode.editor.cn;

/**
 * 文件的最长绝对路径
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-20 22:22:49
 */
public class LongestAbsoluteFilePathSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int[] len = new int[20];

    public int lengthLongestPath(String s) {
        String[] items = s.split("\\n", -1);
        int max = 0;
        for (String item : items) {
            if (item.length() == 0) continue;
            char[] ch = item.toCharArray();
            int n = ch.length;
            int i = 0;
            for (; i < n; i++) {
                if (ch[i] != '\t') break;
            }
            if (item.contains(".")) {
                int cur = n - i;
                for (int j = 0; j < i; j++) {
                    cur += len[j];
                }
                max = Math.max(max, cur + i);
            } else {
                len[i] = n - i;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
