package Contest0416_1;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author IronSid
 * @since 2022-04-16 22:02
 */
public class Solution {
    // T1
    public int findClosestNumber(int[] nums) {
        int closet = (int) 1e6;
        for (int num : nums) {
            if (Math.abs(num) < Math.abs(closet)) {
                closet = num;
            } else if (Math.abs(num) == Math.abs(closet)) {
                closet = Math.max(closet, num);
            }
        }
        return closet;
    }
    // T2
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ways = 0;
        for (int i = total / cost1; i >= 0; i--) {
            ways += (total - cost1 * i) / cost2 + 1;
        }
        return ways;
    }

    // T4
    HashMap<Integer, List<int[]>> map = new HashMap<>();
    int max = -1;
    int[] scores;
    int n;

    void add(int x, int y) {
        if (!map.containsKey(x)) {
            map.put(x, new ArrayList<>());
        }
        map.get(x).add(new int[]{y, scores[x] + scores[y]});
    }

    public int maximumScore(int[] scores, int[][] edges) {
        n = scores.length;
        maxValue = new int[n];
        maxNext = new int[n];
        Arrays.fill(maxNext, -1);
        this.scores = scores;
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            add(a, b);
            add(b, a);
        }
        for (int[] edge : edges) {
            int e1 = maxEdge(edge[1], edge[0]);
            int e2 = maxEdge(edge[0], edge[1]);
            System.out.println("edge[0] = " + edge[0]);
            System.out.println("edge[1] = " + edge[1]);
            max = Math.max(max, e1 + e2);
            System.out.println("max = " + max);
        }
        return max;
    }

    int[] maxValue, maxNext;

    int maxEdge(int from, int except) {
        if (maxValue[from] != 0 && maxNext[from] != except) {
            return maxValue[from];
        }
        List<int[]> edges = map.get(from);
        if (maxValue[from] == 0) {
            for (int[] edge : edges) {
                if (edge[1] > maxValue[from]) {
                    maxValue[from] = edge[1];
                    maxNext[from] = edge[0];
                }
            }
        }
        if (maxNext[from] == except) {
            int secendValue = 0;
            for (int[] edge : edges) {
                if (edge[0] != except && edge[1] > secendValue) {
                    secendValue = edge[1];
                }
            }
            return secendValue;
        }
        return maxValue[from];
    }

    @Test
    public void T4test1() {
        Solution solution = new Solution();
        int[] scores = {5,2,9,8,4};
        int[][] edges = {{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}};
        int expected = 24;
        int actual = solution.maximumScore(scores, edges);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void T4test2() {
        Solution solution = new Solution();
        int[] scores = {9,20,6,4,11,12};
        int[][] edges = {{0,3},{5,3},{2,4},{1,3}};
        int expected = -1;
        int actual = solution.maximumScore(scores, edges);
        Assert.assertEquals(expected, actual);
    }

}

// T3
class ATM {
    // 20 50 100 200 500
    long[] cash = new long[5];
    int[] val = {20, 50, 100, 200, 500};

    public ATM() {

    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i++) {
            cash[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        long[] withdraw = new long[5];
        for (int i = val.length - 1; i >= 0; i--) {
            withdraw[i] = Math.min(amount / val[i], cash[i]);
            amount -= val[i] * withdraw[i];
        }
        if (amount != 0) return new int[]{-1};
        for (int i = 0; i < 5; i++) {
            cash[i] -= withdraw[i];
        }
        int[] res = new int[5];
        for (int i = 0; i < 5; i++) {
            res[i] = (int) withdraw[i];
        }
        return res;
    }
}

