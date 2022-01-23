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
    List<String> list;

    public String[] permutation(String s) {
        list = new LinkedList<>();
        char[] arr = s.toCharArray();
        dfs(arr, 0);
        return list.toArray(new String[0]);
    }

    void dfs(char[] arr, int index) {
        if (index == arr.length) {
            list.add(new String(arr));
            return;
        }
        char temp = arr[index];
        boolean[] visited = new boolean[26];
        for (int i = index; i < arr.length; i++) {
            if (visited[arr[i] - 'a']) {
                continue;
            }
            visited[arr[i] - 'a'] = true;
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
