package contest2024.H;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author IronSid
 * @since 2024-04-14 16:26
 */
public class Main {

    private static int[] wt;
    private static List<Integer>[] map;
    private static int[][] p;
    private static int[] d;
    static long res = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Kattio io = new Kattio();

        int n = io.nextInt();
        int s = io.nextInt();
        map = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            map[i] = new ArrayList<>();
        }
        wt = new int[n+1];
        int M = 32 - Integer.numberOfLeadingZeros(n);
        p = new int[n+1][M];
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
        res = 0;
        d = new int[n + 1];
        dfs(s, 0, 1);
        for (int j = 1; j < M; j++) {
            for (int i = 1; i <= n; i++) {
                p[i][j] = p[p[i][j-1]][j-1];
            }
        }
        for (int i = 1; i <= n; i++) {
            int w = wt[i];
            // 找被它整除的节点，看是不是它的祖先
            for (int j = 2 * w; j <= n; j += w) {
                int k = wtMap[j], h = i, dd;
                if ((dd = d[i] - d[k]) > 0) {
                    for (int t = 0; dd > 0; dd >>= 1, t++) {
                        if ((dd & 1) == 1) {
                            h = p[h][t];
                        }
                    }
                    if (h == k) res--;
                }
            }
        }
        io.println(res);
        io.close();
    }

    private static int dfs(int cur, int prt, int depth) {
        int size = 0;
        p[cur][0] = prt;
        d[cur] = depth;
        if (map[cur] != null)
            for (Integer nxt : map[cur]) {
                if (prt == nxt) continue;
                size += dfs(nxt, cur, depth + 1);
            }
        res += size;
        return size + 1;
    }
}

class Kattio extends PrintWriter {
    StringTokenizer st;
    BufferedReader br;
    Kattio() throws FileNotFoundException {
        super(System.out);
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    Kattio(int i) throws FileNotFoundException {
        super(String.format("contest2024/H/out%d.txt", i));
        br = new BufferedReader(new FileReader("contest2024/H/in.txt"));
    }
    Kattio(String s) {
        super(System.out);
        br = new BufferedReader(new StringReader(s));
    }
    String next() {
        try {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return st.nextToken();
    }
    int nextInt() {return Integer.parseInt(next());}
}