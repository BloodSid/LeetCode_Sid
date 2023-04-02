package Contest0402.T4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;

public class Solution {
    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ans[p] = 0;
        if (k == 1) return ans;
        HashSet<Integer> b = new HashSet<>();
        for (int i : banned) {
            b.add(i);
        }
        Deque<Integer>[] q = new Deque[2];
        q[0] = new ArrayDeque<>();
        q[1] = new ArrayDeque<>();
        for (int i = p, j = p; j < n; ) {
            // 对于k，一次反转可到达的位置有 k-1, k-3...
            if (j - i == k) {
                for (int i1 = 0; i1 < 2; i1++) {
                    if (!q[i1].isEmpty() && q[i1].peek() == i) q[i1].poll();
                }
                i++;
            } else {
                if (!b.contains(j)) {
                    Deque<Integer> cur = q[((k - 1) ^ j) & 1];
                    // left + right = j + peek; right - left = k - 1
                    //  right = (j + peek + k - 1) /2 <= n - 1
                    while (!cur.isEmpty() && (j + cur.peekLast() + k - 1) / 2 <= n - 1) {
                        System.out.println("i = " + i);
                        System.out.println("j = " + j);
                        System.out.println(cur);
                        cur.pollLast();
                    }
                    if (!cur.isEmpty()) {
                        ans[j] = ans[cur.peek()] + 1;
                    }
                }
                if (ans[j] != -1) q[j & 1].offer(j);
                j++;
            }
        }
        q[0] = new ArrayDeque<>();
        q[1] = new ArrayDeque<>();
        for (int i = p, j = p; j >= 0; ) {
            if (i - j == k) {
                for (int i1 = 0; i1 < 2; i1++) {
                    if (!q[i1].isEmpty() && q[i1].peek() == i) q[i1].poll();
                }
                i--;
            } else {
                if (!b.contains(j)) {
                    Deque<Integer> cur = q[((k - 1) ^ j) & 1];
                    if (!cur.isEmpty()) {
                        ans[j] = ans[cur.peek()] + 1;
                    }
                }
                if (ans[j] != -1) q[j & 1].offer(j);
                j--;
            }
        }
        return ans;
    }
}
