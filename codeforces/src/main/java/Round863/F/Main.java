package Round863.F;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt();
        int m = sc.nextInt();
        // 度
        int[] d = new int[n];
        List<Integer>[] map = new List[n];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
            d[u]++;
            d[v]++;
            addEdge(u, v, map);
            addEdge(v, u, map);
        }
        boolean flag = true;
        // 检查点数和边数是否符合
        int k = (int) Math.sqrt(n);
        flag = k * k == n && k * k + k == m;
        // 检查是否有 k 个点度数为 4， k(k-1) 个点度数为2
        int start = 0;
        if (flag) {
            int d4 = 0, d2 = 0;
            for (int i = 0; i < d.length; i++) {
                int di = d[i];
                if (di == 2) {
                    d2++;
                } else if (di == 4) {
                    d4++;
                    start = i;
                } else {
                    break;
                }
            }
            flag = d4 == k && d2 == k * k - k;
        }

        // 检查所有的环的长度
        boolean[] vis = new boolean[n];
        vis[start] = true;
        if (flag) {
            int cur = start;
            int coreLen = 0;
            while (true) {
                // 判断副环
                int subLen = 0;
                for (int sub = cur; ; ) {
                    int t = sub;
                    List<Integer> list = map[sub];
                    for (Integer next : list) {
                        if (vis[next] || d[next] != 2) continue;
                        sub = next;
                        vis[sub] = true;
                        subLen++;
                        break;
                    }
                    if (t == sub) {
                        break;
                    }
                }
                flag = flag && subLen == k - 1;
                // 找主环上的下一个
                int t = cur;
                List<Integer> list = map[cur];
                for (Integer next : list) {
                    if (vis[next] || d[next] != 4) continue;
                    cur = next;
                    vis[cur] = true;
                    coreLen++;
                    break;
                }
                // 未找到下一个
                if (t == cur) {
                    break;
                }
            }
            flag = flag && coreLen == k - 1;
        }

        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void addEdge(int v, int u, List<Integer>[] map) {
        if (map[v] == null) map[v] = new ArrayList<>();
        map[v].add(u);
    }
}
