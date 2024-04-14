package contest2024.G;

import java.io.*;
import java.util.*;

/**
 * 第十五届蓝桥杯省赛Java研究生组G题。大致题意为，从树上找两个不相邻的点，这两个点异或的最大值
 * @author IronSid
 * @since 2024-04-14 16:26
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        PrintWriter pr  = new PrintWriter("lanqiao/src/main/java/contest2024/G/in.txt");
//        int maxn = (int) 1e5;
//        pr.println(maxn);
//        Random r = new Random();
//        for (int i = 0; i < maxn; i++) {
//            pr.print(Math.abs(r.nextInt((int) 1e9)));
//            pr.print(' ');
//        }
//        pr.print(-1);
//        for (int i = 1; i < maxn; i++) {
//            pr.print(' ');
//            pr.print(0);
//        }
//        pr.close();
        long start = System.currentTimeMillis();
        Kattio io = new Kattio();
//        Kattio io = new Kattio("5\n" +
//                "-1 0 1 0 1\n" +
//                "1 0 5 3 4");
        int n = io.nextInt();
        int[] x = new int[n];
        int[] p = new int[n];
        for (int i = 0; i < n; i++) x[i] = io.nextInt();
        for (int i = 0; i < n; i++) p[i] = io.nextInt();
        List<Integer>[] map = new List[n];
        for (int i = 0; i < n; i++) map[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int j = p[i];
            if (j == -1) continue;
            map[i].add(j);
            map[j].add(i);
        }
        // 31个bit 分3 级， 11-10-10
        HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>> f = new HashMap<>();
        for (int t : x) {
            add(f, t);
        }
        int mx = 0;
        for (int i = 0; i < n; i++) {
            // 将相邻的节点去掉
            if (map[i] != null) {
                for (Integer j : map[i]) {
                    remove(f, x[j]);
                }
            }
            // 求最大的异或值
            int ma = 0, mb = 0, mc = 0;
            int a = ba(x[i]), b = bb(x[i]), c = bc(x[i]);
            for (Integer sa : f.keySet()) if ((sa ^ a) > ma) ma = sa ^ a;
            for (Integer sb : f.get(ma ^ a).keySet()) if ((sb ^ b) > mb) mb = sb ^ b;
            for (Integer sc : f.get(ma ^ a).get(mb ^ b).keySet()) if ((sc ^ c) > mc) mc = sc ^ c;
            int res = ma << 20 | mb << 10 | mc;
            mx = Math.max(mx, res);
            // 将相邻的节点加回来
            if (map[i] != null) {
                for (Integer j : map[i]) {
                    add(f, x[j]);
                }
            }
        }
        io.println(mx);
        System.out.println("System.currentTimeMillis() - start = " + (System.currentTimeMillis() - start));
        io.close();
    }

    private static void add(HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>> f, int t) {
        f.computeIfAbsent(ba(t), k -> new HashMap<>())
        .computeIfAbsent(bb(t), k -> new HashMap<>())
        .merge(bc(t), 1, Integer::sum);
    }

    private static void remove(HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>> f, int s) {
        HashMap<Integer, HashMap<Integer, Integer>> f1 = f.get(ba(s));
        HashMap<Integer, Integer> f2 = f1.get(bb(s));
        f2.merge(bc(s), -1, (a, b) -> a + b != 0 ? a + b : null);
        if (f2.size() == 0) {
            f1.remove(bb(s));
        }
        if (f1.size() == 0) {
            f.remove(ba(s));
        }
    }

    static int ba(int x) {return x >> 20;}
    static int bb(int x) {return x << 12 >>> 22;}
    static int bc(int x) {return x << 22 >>> 22;}
}

class Kattio extends PrintWriter {
    StringTokenizer st;
    BufferedReader br;
    Kattio() throws FileNotFoundException {
        super("lanqiao/src/main/java/contest2024/G/out.txt");
        br = new BufferedReader(new FileReader("lanqiao/src/main/java/contest2024/G/in.txt"));
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