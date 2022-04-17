package Contest0417;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author IronSid
 * @since 2022-04-17 10:10
 */
public class Solution {
    // T1
    public String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        while (true) {
            if (sb.length() <= k) return sb.toString();
            char[] ch = sb.toString().toCharArray();
            sb.setLength(0);
            for (int i = 0, sum = 0; i < ch.length; ) {
                int j = 0;
                for (; j < k && i + j < ch.length; j++) {
                    sum += ch[i + j] & 15;
                }
                i += k;
                sb.append(sum);
                sum = 0;
            }
        }
    }

    @Test
    public void T1test() {
        String s = "11111222223";
        int k = 3;
        Solution solution = new Solution();
        System.out.println(solution.digitSum(s, k));
        s = "00000000";
        System.out.println(solution.digitSum(s, k));
    }

    // T2
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }
        int round = 0;
        for (Integer val : freq.keySet()) {
            int f = freq.get(val);
            if (f == 1) return -1;
            switch (f % 3) {
                case 0:
                    round += f / 3;
                    break;
                case 1:
                    round += 2 + (f - 4) / 3;
                    break;
                case 2:
                    round += 1 + (f - 2) / 3;
                    break;
            }
        }
        return round;
    }
}

// T3
class Solution2 {

    static final int up = 0, down = 1, left = 2, right = 3;
    static final int two = 0, five = 1;
    static final int[][] dirs = {{up, left}, {up, right}, {down, left}, {down, right}};

    public int maxTrailingZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] cnt2 = new int[m][n];
        int[][] cnt5 = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                cnt2[i][j] = count2(num);
                cnt5[i][j] = count5(num);
            }
        }
        int[][][][] pres = new int[4][m][n][2];
        int[][][] pre = pres[left];
        for (int i = 0; i < m; i++) {
            int twoSum = 0, fiveSum = 0;
            for (int j = 0; j < n; j++) {
                pre[i][j][two] = twoSum;
                pre[i][j][five] = fiveSum;
                twoSum += cnt2[i][j];
                fiveSum += cnt5[i][j];
            }
        }
        pre = pres[right];
        for (int i = 0; i < m; i++) {
            int twoSum = 0, fiveSum = 0;
            for (int j = n - 1; j >= 0; j--) {
                pre[i][j][two] = twoSum;
                pre[i][j][five] = fiveSum;
                twoSum += cnt2[i][j];
                fiveSum += cnt5[i][j];
            }
        }
        pre = pres[up];
        for (int j = 0; j < n; j++) {
            int twoSum = 0, fiveSum = 0;
            for (int i = 0; i < m; i++) {
                pre[i][j][two] = twoSum;
                pre[i][j][five] = fiveSum;
                twoSum += cnt2[i][j];
                fiveSum += cnt5[i][j];
            }
        }
        pre = pres[down];
        for (int j = 0; j < n; j++) {
            int twoSum = 0, fiveSum = 0;
            for (int i = m - 1; i >= 0; i--) {
                pre[i][j][two] = twoSum;
                pre[i][j][five] = fiveSum;
                twoSum += cnt2[i][j];
                fiveSum += cnt5[i][j];
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] dir : dirs) {
                    int d1 = dir[0], d2 = dir[1];
                    int fiveSum = cnt5[i][j] + pres[d1][i][j][five] + pres[d2][i][j][five];
                    int twoSum = cnt2[i][j] + pres[d1][i][j][two] + pres[d2][i][j][two];
                    max = Math.max(max, Math.min(fiveSum, twoSum));
                }
            }
        }
        return max;
    }

    int count2(int num) {
        if (num == 0) return 0;
        return Integer.numberOfTrailingZeros(num);
    }

    int count5(int num) {
        int cnt = 0;
        while (num > 0 && num % 5 == 0) {
            cnt++;
            num /= 5;
        }
        return cnt;
    }
}

// T4

class Solution1 {

    private HashMap<Integer, List<Integer>> map;
    private char[] val;
    private int max;

    public int longestPath(int[] parent, String s) {
        map = new HashMap<>();
        int n = parent.length;
        for (int i = 1; i < n; i++) {
            add(parent[i], i);
        }
        val = s.toCharArray();
        max = 1;
        dfs(0);
        return max;
    }

    void add(int x, int y) {
        if (!map.containsKey(x)) {
            map.put(x, new ArrayList<>());
        }
        map.get(x).add(y);
    }

    int dfs(int node) {
        // 叶子节点
        if (!map.containsKey(node)) {
            return 1;
        }
        int max1 = 0, max2 = 0;
        for (Integer child : map.get(node)) {
            int length = dfs(child);
            if (val[node] != val[child]) {
                if (length > max1) {
                    max2 = max1;
                    max1 = length;
                } else if (length > max2) {
                    max2 = length;
                }
            }
        }
        max = Math.max(max, 1 + max1 + max2);
        return max1 + 1;
    }

    public static void main(String[] args) {
        int[] parent = {-1, 0, 1};
        String s = "aab";
        Solution1 solution1 = new Solution1();
        System.out.println("solution1.longestPath(parent, s) = " + solution1.longestPath(parent, s));
    }
}
