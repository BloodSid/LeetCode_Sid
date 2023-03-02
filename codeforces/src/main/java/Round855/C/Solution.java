package Round855.C;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-03-02 23:31
 */
public class Solution {
    // 每个 0 可以获得前面的一个不是零的数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int cases = 0; cases < n; cases++) {
            int len = Integer.parseInt(sc.nextLine());
            int[] data = new int[len];
            for (int i = 0; i < len; i++) {
                data[i] = sc.nextInt();
            }
            sc.nextLine();

            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
            long res = 0;
            for (int i = 0; i < data.length; i++) {
                if (data[i] == 0) {
                    if (!pq.isEmpty()) res += pq.poll();
                } else {
                    pq.offer(data[i]);
                }
            }
            System.out.println(res);
        }
    }

}
