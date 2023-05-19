package T2230;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-05-19 21:05
 */
public class Main {
    private static final int INF = (int) (1e9 + 7);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println(1);
            return;
        }
        // 建图，模n的剩余系做顶点,disti 表示模n为i的所有数中，bitcount 最小值
        int[][] dist = new int[n][2];
        for (int[] ints : dist) {
            Arrays.fill(ints, INF);
        }
        dist[1][1] = 1;
        // i, j, d 分别为模n，模2的余数，距离
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        // 1 mod n 为 1
        pq.offer(new int[]{1, 1, 1});
        // dijkstra 求到顶点0的最短路
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int i = poll[0], j = poll[1], d = poll[2];
            if (i == 0) {
                System.out.println(d);
                return;
            }
            if (d > dist[i][j]) continue;
            // 每个偶数顶点都有 * 2 和 + 1 两条邻边，每个奇数顶点都有 * 2 一条临边，这样足以覆盖所有自然数
            // * 2 则 d 不变
            int ni = 2 * i % n;
            int nj = 0;
            if (d < dist[ni][nj]) {
                dist[ni][nj] = d;
                pq.offer(new int[]{ni, nj, d});
            }
            if (j == 0) {
                // + 1 则 d 也加1
                ni = (i + 1) % n;
                nj = 1;
                if (d + 1 < dist[ni][nj]) {
                    dist[ni][nj] = d + 1;
                    pq.offer(new int[]{ni, nj, d + 1});
                }
            }
        }
        System.out.println(-1);
    }
}
class test{
    public static void main(String[] args) {

    }
}
