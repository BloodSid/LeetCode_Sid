package leetcode.editor.cn;

import java.util.*;

/**
 * 推多米诺
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-21 20:22:12
 */
public class PushDominoesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] arr = dominoes.toCharArray();
        char pre = 'L';
        int i0 = -1;
        for (int i1 = 0; i1 < n; i1++) {
            char cur = arr[i1];
            if (cur != '.') {
                if (cur == pre) {
                    for (int j = i0 + 1; j < i1; j++) {
                        arr[j] = cur;
                    }
                } else if (cur == 'L') {
                    for (int j = i0 + 1, k = i1 - 1; j < k; j++, k--) {
                        arr[j] = 'R';
                        arr[k] = 'L';
                    }
                }
                pre = cur;
                i0 = i1;
            }
        }
        if (pre == 'R') {
            for (int i = i0 + 1; i < n; i++) {
                arr[i] = 'R';
            }
        }
        return new String(arr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
