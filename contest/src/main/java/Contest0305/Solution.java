package Contest0305;

import org.junit.Test;

import java.util.*;

/**
 * @author IronSid
 * @since 2022-03-05 22:27
 */
public class Solution {
    static Solution solution = new Solution();

    public int mostFrequent(int[] nums, int key) {
        int[] freq = new int[1001];
        int maxFreq = 0;
        int mostFreq = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                int target = nums[i + 1];
                freq[target]++;
                maxFreq = Math.max(maxFreq, freq[target]);
                if (freq[target] == maxFreq) mostFreq = target;
            }
        }
        return mostFreq;
    }
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        long[] mapTo = new long[n];
        for (int i = 0; i < nums.length; i++) {
            long origin = nums[i];
            if (origin == 0) {
                mapTo[i] = mapping[0];
                continue;
            }
            long result = 0;
            for (long base = 1; origin > 0; base *= 10, origin /= 10) {
                result += base * mapping[(int) (origin % 10)];
            }
            mapTo[i] = result;
        }
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (o1, o2) -> {
            if (mapTo[o1] > mapTo[o2]) {
                return 1;
            } else if (mapTo[o1] < mapTo[o2]) {
                return -1;
            } else {
                return o1.compareTo(o2);
            }
        });
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = nums[idx[i]];
        }
        return ret;
    }

    @Test
    public void test1() {
        int[] mapping = {9,8,7,6,5,4,3,2,1,0};
        int[] nums = {0,1,2,3,4,5,6,7,8,9};
        solution.sortJumbled(mapping, nums);
    }

    Map<Integer, Set<Integer>> map = new HashMap<>();
    List<List<Integer>> list = new ArrayList<>();
    boolean[] visited;

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        for (int[] edge : edges) {
            int f = edge[0], t = edge[1];
            if (!map.containsKey(f)) map.put(f, new HashSet<>());
            map.get(f).add(t);
        }
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            dfs(i, i);
        }
        return list;
    }

    void dfs(int cur, int root) {
        visited[cur] = true;
        if (root != cur) {
            list.get(cur).add(root);
        }
        if (map.containsKey(cur)) {
            for (Integer child : map.get(cur)) {
                if (!visited[child]) dfs(child, root);
            }
        }

    }



    public int minMovesToMakePalindrome(String s) {
        return 0;
    }
}
