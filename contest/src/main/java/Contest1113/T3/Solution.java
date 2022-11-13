package Contest1113.T3;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author IronSid
 * @since 2022-11-13 10:30
 */
public class Solution {

    private List<List<Integer>> lines;

    public int minimumOperations(TreeNode root) {
        lines = new ArrayList<>();
        dfs(root, 0);
        int res = 0;
        for (List<Integer> line : lines) {
            int[] arr = line.stream().mapToInt(o -> o).toArray();
            int[] sort = Arrays.copyOf(arr, arr.length);
            Arrays.sort(sort);
            HashMap<Integer, Integer> rank = new HashMap<>();
            for (int i = 0; i < sort.length; i++) {
                rank.put(sort[i], i);
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i] = rank.get(arr[i]);
            }
            // 转换成 [0,1,2,..., n-1]
            int ops = 0;
            for (int i = 0; i < arr.length; i++) {
                while (arr[i] != i) {
                    // 交换 arr[i] 和 i 上的值
                    swap(arr[i], i, arr);
                    ops++;
                }
            }
            res += ops;
        }
        return res;
    }

    void dfs(TreeNode o, int level) {
        if (o == null) return;
        if (lines.size() == level) {
            lines.add(new ArrayList<>());
        }
        lines.get(level).add(o.val);
        dfs(o.left, level + 1);
        dfs(o.right, level + 1);
    }

    void swap(int a, int b, int[] arr) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
