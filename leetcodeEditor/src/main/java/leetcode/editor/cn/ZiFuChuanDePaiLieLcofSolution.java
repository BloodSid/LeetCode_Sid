package leetcode.editor.cn;

import java.util.*;

/**
 * 字符串的排列
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-23 13:43:14
 */
public class ZiFuChuanDePaiLieLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Set<String> set;

    public String[] permutation(String s) {
        set = new HashSet<>();
        char[] arr = s.toCharArray();
        dfs(arr, 0);
        return set.toArray(new String[0]);
    }

    void dfs(char[] arr, int index) {
        if (index == arr.length) {
            set.add(new String(arr));
            return;
        }
        char temp = arr[index];
        for (int i = index; i < arr.length; i++) {
            if (i != index && arr[i] == temp) {
                continue;
            }
            arr[index] = arr[i];
            arr[i] = temp;
            dfs(arr, index + 1);
            arr[i] = arr[index];
        }
        arr[index] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
