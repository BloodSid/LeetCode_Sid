package leetcode.editor.cn;

import java.util.*;

/**
 * 钥匙和房间
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-22 14:34:15
 */
public class KeysAndRoomsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean[] visited;
    // adjacency list
    List<List<Integer>> list;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        list = rooms;
        dfs(0);
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    void dfs(int i) {
        visited[i] = true;
        List<Integer> children = list.get(i);
        for (Integer child : children) {
            if (!visited[child]) {
                dfs(child);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
