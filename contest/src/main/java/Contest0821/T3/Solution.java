package Contest0821.T3;

import binaryTree.TreeNode;

import java.util.*;

/**
 * @author IronSid
 * @since 2022-08-21 9:54
 */
public class Solution {

    private HashMap<Integer, List<Integer>> map;

    public int amountOfTime(TreeNode root, int start) {
        map = new HashMap<>();
        //  先建图
        dfs(root);
        // 广度优先搜索
        int depth = 0;
        Deque<Integer> q = new LinkedList<>();
        HashSet<Integer> vis = new HashSet<>();
        q.offer(start);
        vis.add(start);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                List<Integer> list = map.get(cur);
                if (list == null) continue;
                for (Integer next : list) {
                    if (!vis.contains(next)) {
                        q.offer(next);
                        vis.add(next);
                    }
                }
            }
            depth++;
        }
        return depth - 1;
    }

    void dfs(TreeNode node) {
        if (node == null) return;
        if (node.left != null) {
            addEdge(node.val, node.left.val);
            addEdge(node.left.val, node.val);
        }
        if (node.right != null) {
            addEdge(node.val, node.right.val);
            addEdge(node.right.val, node.val);
        }
        dfs(node.left);
        dfs(node.right);
    }

    void addEdge(int from, int to) {
        if (!map.containsKey(from)) map.put(from, new ArrayList<>());
        map.get(from).add(to);
    }
}
