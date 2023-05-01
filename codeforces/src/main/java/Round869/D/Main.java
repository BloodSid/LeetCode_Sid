package Round869.D;

import java.io.*;
import java.util.*;

/**
 * @author IronSid
 * @since 2023-05-02 0:19
 */
public class Main {
    static Kattio sc;
    private static boolean[] notLoop;
    private static List<Integer>[] map;

    public static void main(String[] args) {
        sc = new Kattio();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            solve();
        }
        sc.flush();
    }

    private static void solve() {
        int n = sc.nextInt();
        int m = sc.nextInt();
        map = new List[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        int[] cnt = new int[n];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
            map[u].add(v);
            map[v].add(u);
            cnt[u]++;
            cnt[v]++;
        }
        HashMap<Integer, Integer> f = new HashMap<>();
        for (int i = 0; i < n; i++) {
            f.merge(cnt[i], 1, Integer::sum);
        }
        notLoop = new boolean[n];
        List<Integer> list = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (cnt[i] == 1) {
                q.offer(i);
                notLoop[i] = true;
            }
        }
        // 拓扑排序去掉必不在环上的点
        while (!q.isEmpty()) {
            int poll = q.poll();
            list.add(poll);
            for (Integer next : map[poll]) {
                if (notLoop[next]) continue;
                cnt[next]--;
                if (cnt[next] == 1) {
                    q.offer(next);
                    notLoop[next] = true;
                }
            }
        }
        // 题目的要求可以转化成找到一个环，上面有一个节点的度大于等于4
        int res = 0;
        for (; res < n; res++) {
            if (!notLoop[res] && map[res].size() >= 4) {
                break;
            }
        }
        if (res == n) {
            sc.println("NO");
            return;
        }
        List<Integer> path = new ArrayList<>();
        // 找到环
        for (Integer to : map[res]) {
            boolean[] vis = new boolean[n];
            if (dfs(res, to, res, path, vis)) {
                break;
            }
        }
        if (path.isEmpty()) {
            sc.println("NO");
            return;
        }
        sc.println("YES");
        // 利用题意缩小环
        List<Integer> extra = map[res].subList(0, 4);
        int[] idx = new int[4];
        int minLoop = path.size();
        for (int ei = 0; ei < 4; ei++) {
            int i = path.indexOf(extra.get(ei));
            idx[ei] = i;
            if (i >= 2) minLoop = Math.min(minLoop, i + 1);
        }
        path = path.subList(0, minLoop);

        // 缩环后，至少有两个边不在环上
        List<Integer> extra1 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if (idx[i] >= minLoop || idx[i] == -1) {
                extra1.add(extra.get(i));
            }
        }

        sc.println(path.size() + 2);
        // 输出环和“鱼鳍”
        int pre = path.get(path.size() - 1);
        for (Integer i : path) {
            out(pre, i);
            pre = i;
        }
        out(res, extra1.get(0));
        out(res, extra1.get(1));
    }

    // // find path from u to v, without edge (u,v)
    private static boolean dfs(int u, int v, int at, List<Integer> p, boolean[] vis) {
        p.add(at);
        vis[at] = true;
        if (at == v) {
            return true;
        }
        for (Integer to : map[at]) {
            if (vis[to] || notLoop[to]) continue;
            if (at == u && to == v) continue;
            if (dfs(u, v, to, p, vis)) return true;
        }
        p.remove(p.size() - 1);
        return false;
    }

    static void out(int a, int b) {
        sc.println((a + 1) + " " + (b + 1));
    }


    public static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // 标准 IO
        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // 文件 IO
        public Kattio(String intput, String output) throws IOException {
            super(output);
            r = new BufferedReader(new FileReader(intput));
        }

        // 在没有其他输入时返回 null
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
