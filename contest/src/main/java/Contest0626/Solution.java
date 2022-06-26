package Contest0626;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IronSid
 * @since 2022-06-26 10:31
 */
public class Solution {
    // T1
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1) {
                    if (grid[i][j] == 0) return false;
                } else {
                    if (grid[i][j] != 0) return false;
                }
            }
        }
        return true;
    }

    // T2
    public int countHousePlacements(int n) {
        int MOD = (int) 1e9 + 7;
        long[] dp0 = new long[n];
        long[] dp1 = new long[n];
        dp0[0] = dp1[0] = 1;
        for (int i = 1; i < n; i++) {
            dp0[i] = (dp1[i - 1] + dp0[i - 1]) % MOD;
            dp1[i] = dp0[i - 1];
        }
        long sum = (dp0[n - 1] + dp1[n - 1]) % MOD;
        return (int) (sum * sum % MOD);
    }

    // T3
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(getMax(nums1, nums2), getMax(nums2, nums1));
    }

    public int getMax(int[] nums1, int[] nums2) {
        int res = 0;
        int n = nums1.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            res += nums1[i];
            diff[i] = nums2[i] - nums1[i];
        }
        res += maxSubArray(diff);
        return res;
    }

    int maxSubArray(int[] nums) {
        int dp = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            dp = Math.max(num, dp + num);
            max = Math.max(max, dp);
        }
        return max;
    }

    // T4
    private List[] map;
    private int[] parent;
    private int[] xorSum;
    private boolean[] visited;
    private int[] nums;

    public int minimumScore(int[] nums, int[][] edges) {
        this.nums = nums;
        int n = nums.length;
        map = new List[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            map[edge[1]].add(edge[0]);
            map[edge[0]].add(edge[1]);
        }
        // 以0为根节点，建树
        parent = new int[n];
        xorSum = new int[n];
        visited = new boolean[n];
        dfs(0);
        int min = Integer.MAX_VALUE;
        // 枚举删除两条边
        for (int i = 0; i < edges.length; i++) {
            int root1 = parent[edges[i][0]] == edges[i][1] ? edges[i][0] : edges[i][1];
            for (int j = i + 1; j < edges.length; j++) {
                int root2 = parent[edges[j][0]] == edges[j][1] ? edges[j][0] : edges[j][1];
                int x1 = 0, x2 = 0, x3 = 0;
                // root1 是 root2 的 sub
                if (isSub(root1, root2)) {
                    x1 = xorSum[root1]; x2 = xorSum[root2] ^ xorSum[root1]; x3 = xorSum[0] ^ xorSum[root2];
                } else if (isSub(root2, root1)) {
                    // root2 是 root1 的 sub
                    x1 = xorSum[root2]; x2 = xorSum[root1] ^ xorSum[root2]; x3 = xorSum[0] ^ xorSum[root1];
                } else {
                    x1 = xorSum[root1]; x2 = xorSum[root2]; x3 = xorSum[0] ^ x1 ^ x2;
                }
                min = Math.min(min, getScore(x1, x2, x3));
            }
        }
        return min;
    }

    private void dfs(int node) {
        visited[node] = true;
        int xor = nums[node];
        for (Object o : map[node]) {
            Integer chlid = (Integer) o;
            if (visited[chlid]) continue;
            parent[chlid] = node;
            dfs(chlid);
            xor ^= xorSum[chlid];
        }
        xorSum[node] = xor;
    }

    // node1 是否 node2 的 sub
    boolean isSub(int node1, int node2) {
        // 根节点不是任何节点的子树
        if (node1 == 0) return false;
        if (parent[node1] == node2) return true;
        return isSub(parent[node1], node2);
    }

    int getScore(int ... v) {
        int max = v[0], min = v[0];
        for (int i = 1; i < v.length; i++) {
            max = Math.max(max, v[i]);
            min = Math.min(min, v[i]);
        }
        return max - min;
    }

}
