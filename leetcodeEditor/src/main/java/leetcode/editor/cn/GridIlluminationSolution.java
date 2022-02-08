package leetcode.editor.cn;

import java.util.*;

/**
 * 网格照明
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-08 14:30:56
 */
public class GridIlluminationSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        HashMap<Integer, Integer> colToCnt = new HashMap<>();
        HashMap<Integer, Integer> lineToCnt = new HashMap<>();
        HashMap<Integer, Integer> diagToCnt = new HashMap<>();
        HashMap<Integer, Integer> revDToCnt = new HashMap<>();
        BlockSet blocks = new BlockSet();
        for (int[] lamp : lamps) {
            int x = lamp[0], y = lamp[1];
            // 重复打开的灯不额外计数
            if (blocks.contains(x, y)) {
                continue;
            }
            colToCnt.put(x, 1 + colToCnt.getOrDefault(x, 0));
            lineToCnt.put(y, 1 + lineToCnt.getOrDefault(y, 0));
            diagToCnt.put(x + y, 1 + diagToCnt.getOrDefault(x + y, 0));
            revDToCnt.put(x - y, 1 + revDToCnt.getOrDefault(x - y, 0));
            blocks.add(x, y);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];
            if (colToCnt.containsKey(x) || lineToCnt.containsKey(y)
                    || diagToCnt.containsKey(x + y) || revDToCnt.containsKey(x - y)) {
                res[i] = 1;
            }
            for (int c = -1; c <= 1; c++) {
                for (int l = -1; l <= 1; l++) {
                    int nx = x + c, ny = y + l;
                    if (blocks.contains(nx, ny)) {
                        blocks.remove(nx, ny);
                        minusOne(nx, colToCnt);
                        minusOne(ny, lineToCnt);
                        minusOne(nx + ny, diagToCnt);
                        minusOne(nx - ny, revDToCnt);
                    }
                }
            }
        }
        return res;
    }

    void minusOne(int key, HashMap<Integer, Integer> map) {
        int val = map.get(key);
        if (val <= 1) {
            map.remove(key);
        } else {
            map.put(key, val - 1);
        }
    }
}

class BlockSet {
    HashSet<Long> blocks = new HashSet<>();

    void add(int col, int line) {
        blocks.add(((long) col << 32) + line);
    }

    boolean contains(int col, int line) {
        return blocks.contains(((long) col << 32) + line);
    }

    void remove(int col, int line) {
        blocks.remove(((long) col << 32) + line);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
