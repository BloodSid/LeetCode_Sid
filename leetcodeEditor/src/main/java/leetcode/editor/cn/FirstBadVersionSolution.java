package leetcode.editor.cn;

/**
 * 第一个错误的版本
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-19 09:27:06 
 */
public class FirstBadVersionSolution {
    class VersionControl {
        boolean isBadVersion(int version) {
            return false;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l <= r) {
            int mid = l + (r - l >> 1);
            if (isBadVersion(mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
