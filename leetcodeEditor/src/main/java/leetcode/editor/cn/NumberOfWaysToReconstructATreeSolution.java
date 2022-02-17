package leetcode.editor.cn;

import java.util.*;

/**
 * 重构一棵树的方案数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-16 23:35:12
 */
public class NumberOfWaysToReconstructATreeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int checkWays(int[][] pairs) {
        // 每个节点对应一个集合，其中包括它在树中所有的子孙节点和祖先节点
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] pair : pairs) {
            for (int i = 0; i < 2; i++) {
                map.putIfAbsent(pair[i], new HashSet<>());
                Set<Integer> children = map.get(pair[i]);
                children.add(pair[i ^ 1]);
            }
        }
        List<Integer> nodes = new ArrayList<>(map.keySet());
        // 按节点的度顺序排列
        nodes.sort((o1, o2) -> map.get(o1).size() - map.get(o2).size());
        boolean isTwo = false;
        int n = map.size();
        // 检查根节点
        if (map.get(nodes.get(n - 1)).size() < n - 1) {
            return 0;
        }
        for (int i = 0; i < n - 1; i++) {
            int cur = nodes.get(i);
            int j = i + 1;
            int parent = 0;
            for (; j < n; j++) {
                parent = nodes.get(j);
                if (map.get(parent).contains(cur)) {
                    break;
                }
            }
            // 当前节点找不到父节点
            if (j == n) {
                return 0;
            }
            // 子节点和父节点的度相等，说明父节点到子节点的路径伤没有分支，子节点和父节点互换的构筑可以成立，故存在1种以上的构筑
            Set<Integer> parentSet = map.get(parent);
            if (!isTwo && map.get(cur).size() == parentSet.size()) {
                isTwo = true;
            }
            // 子节点的对应的集合(去掉父节点后)，应该是父节点对应的集合的子集
            for (Integer c : map.get(cur)) {
                if (c != parent && !parentSet.contains(c)) {
                    return 0;
                }
            }
        }
        return isTwo ? 2 : 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
