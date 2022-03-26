package leetcode.editor.cn;

/**
 * 数青蛙
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-26 10:53:43
 */
public class MinimumNumberOfFrogsCroakingSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] freq = new int[128];
        int max = 0;
        int cnt = 0;
        for (char c : croakOfFrogs.toCharArray()) {
            switch (c) {
                case 'c':
                    freq['c']++;
                    cnt++;
                    break;
                case 'r':
                    if (--freq['c'] < 0) {
                        return -1;
                    }
                    freq['r']++;
                    break;
                case 'o':
                    if (--freq['r'] < 0) {
                        return -1;
                    }
                    freq['o']++;
                    break;
                case 'a':
                    if (--freq['o'] < 0) {
                        return -1;
                    }
                    freq['a']++;
                    break;
                case 'k':
                    if (--freq['a'] < 0) {
                        return -1;
                    }
                    cnt--;
                    break;
                default:
                    return -1;
            }
            max = Math.max(cnt, max);
        }
        if (freq['c'] == 0 && freq['r'] == 0 && freq['o'] == 0 && freq['a'] == 0) {
            return max;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
