package contest2024.H;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author IronSid
 * @since 2024-04-14 20:35
 */
public class Main2 {
    private static int[] wt;
    private static List<Integer>[] map;
    static long res = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Kattio io = new Kattio(2);
        int n = io.nextInt();
        int s = io.nextInt();
        map = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            map[i] = new ArrayList<>();
        }
        wt = new int[n+1];
        int[] wtMap = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wt[i] = io.nextInt();
            wtMap[wt[i]] = i;
        }
        for (int i = 0; i < n - 1; i++) {
            int u = io.nextInt(), v = io.nextInt();
            map[u].add(v);
            map[v].add(u);
        }
        Deque<Integer> q = new ArrayDeque<>();
        dfs(s, 0, q);
        io.println(res);
        io.close();
    }

    private static void dfs(int cur, int prt, Deque<Integer> stack) {
        int w = wt[cur];
        for (Integer p : stack) {
            if (p % w != 0) {
                res++;
            }
        }
        stack.push(wt[cur]);
        for (Integer nxt : map[cur]) {
            if (nxt == prt) continue;
            dfs(nxt, cur, stack);
        }
        stack.pop();
    }
}
