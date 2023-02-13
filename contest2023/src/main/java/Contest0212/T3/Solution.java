package Contest0212.T3;

import java.util.HashMap;

/**
 * @author IronSid
 * @since 2023-02-12 10:29
 */
public class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        // 每一个二进制值第一次出现的坐标
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            for (int j = i + 1; j <= n && j - i <= 31; j++) {
                String sub = s.substring(i, j);
                map.put(Integer.parseInt(sub, 2), i);
            }
        }
        // 特殊处理 0 的位置
        int first0 = s.indexOf('0');
        if (first0 != -1) map.put(0, first0);
        // 找到 val = first ^ second
        int[][] ans = new int[queries.length][];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int val = query[0] ^ query[1];
            String t = Integer.toBinaryString(val);
            int left = map.getOrDefault(val, -1);
            if (left != -1) {
                ans[i] = new int[]{left, left + t.length() - 1};
            } else {
                ans[i] = new int[]{-1, -1};
            }
        }
        return ans;
    }
}
