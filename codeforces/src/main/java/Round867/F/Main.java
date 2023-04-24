package Round867.F;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-04-25 0:05
 */
public class Main {
    static Scanner sc;
    private static List<Integer>[] map;
    private static boolean[] vis;
    private static int[] h, d, heavy;
    private static long maxProfit;
    private static long k;
    private static long c;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
;
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt();
        k = sc.nextInt();
        c = sc.nextInt();
        map = new List[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
            map[u].add(v);
            map[v].add(u);
        }
        // 0 是根
        vis = new boolean[n];
        h = new int[n];
        d = new int[n];
        heavy = new int[n];
        // 计算每个节点的高度
        dfs0(0, 0);
        // 计算每个节点作为根的收益
        maxProfit = Long.MIN_VALUE;
        vis = new boolean[n];
        dfs1(0, 0);
        System.out.println(maxProfit);
    }

    // other 表示在当前子树之外，到达父节点的最大路径长度
    private static void dfs1(int i, int other) {
        vis[i] = true;
        // 轻儿子中的最大值高度
        int maxH = 0;
        for (Integer next : map[i]) {
            if (vis[next]) continue;
            if (next == heavy[i]) continue;
            maxH = Math.max(maxH, h[next]);
        }
        for (Integer next : map[i]) {
            if (vis[next]) continue;
            if (next == heavy[i]) {
                dfs1(next, Math.max(other, maxH) + 1);
            } else {
                dfs1(next, Math.max(other, h[heavy[i]]) + 1);
            }
        }
        long max = Math.max(h[i], other + 1);
        long p = (max - 1L) * k - d[i] * c;
        maxProfit = Math.max(maxProfit, p);
    }

    private static int dfs0(int i, int depth) {
        vis[i] = true;
        d[i] = depth;
        int max = 0;
        for (Integer next : map[i]) {
            if (!vis[next]) {
                int res = dfs0(next, depth + 1);
                if (res > max) {
                    max = res;
                    heavy[i] = next;
                }
            }
        }
        h[i] = max + 1;
        return max + 1;
    }


}
