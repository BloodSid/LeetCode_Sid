package Contest0320;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author IronSid
 * @since 2022-03-20 10:40
 */
public class Solution {
    public int countHillValley(int[] nums) {
        int cnt = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : nums) {
            if (list.isEmpty() || list.getLast() != num) {
                list.add(num);
            }
        }
        int n = list.size();
        for (int i = 1; i < n - 1; i++) {
            if ((list.get(i - 1) - list.get(i)) * (list.get(i + 1) - list.get(i)) > 0) {
                cnt++;
            }
        }
        return cnt;
    }

    public int countCollisions(String directions) {
        char[] a = directions.toCharArray();
        int l = 0;
        while (l < a.length && a[l] == 'L') l++;
        int r = a.length - 1;
        while (r >= 0 && a[r] == 'R') r--;
        int cnt = 0;
        for (int i = l; i <= r; i++) {
            if (a[i] != 'S') {
                cnt++;
            }
        }
        return cnt;
    }

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int max = 0, maxStatus = 0;
        for (int i = 0; i < 1 << 12; i++) {
            int point = 0;
            int numB = 0;
            for (int j = 1; j < 12; j++) {
                if (((i >> j) & 1) == 1) {
                    point += j;
                    numB += aliceArrows[j] + 1;
                }
            }
            if (point <= max || numB > numArrows) {
                continue;
            }
            max = point;
            maxStatus = i;
        }
        int[] bob = new int[12];
        int numB = numArrows;
        for (int i = 0; i < 11; i++) {
            if (((maxStatus >> i) & 1) == 1) {
                bob[i] = aliceArrows[i] + 1;
                numB -= bob[i];
            }
        }
        bob[11] = numB;
        return bob;
    }

    // T4
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.start - o.end));
        List<Node> list = new LinkedList<>();
        int l = 0, r = -1;
        while (l < s.length()) {
            while (r < s.length() - 1 && s.charAt(l) == s.charAt(r + 1)) {
                r++;
            }
            Node cur = new Node(l, r, s.charAt(l));
            list.add(cur);
            pq.offer(cur);
            l = r + 1;
        }
        char[] a = s.toCharArray();
        int k = queryIndices.length;
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            a[queryIndices[i]] = queryCharacters.charAt(i);
            Node peek = pq.peek();
            res[i] = peek.end - peek.start + 1;
        }
        return res;
    }

    class Node {
        int start;
        int end;
        char c;

        public Node(int start, int end, char c) {
            this.start = start;
            this.end = end;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return start == node.start && end == node.end;
        }
    }

}
