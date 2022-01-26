package leetcode.editor.cn;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * 检测正方形
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-26 14:53:57
 */
public class DetectSquaresSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class DetectSquares {
    int LIMIT = 1001;
    HashMap<Integer, HashMap<Integer, Integer>> lines;

    public DetectSquares() {
        lines = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0], y = point[1];
        lines.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> line = lines.get(x);
        line.put(y, line.getOrDefault(y, 0) + 1);
    }

    int getDuplications(int... point) {
        int x = point[0], y = point[1];
        if (!lines.containsKey(x)) {
            return 0;
        }
        Map<Integer, Integer> line = lines.get(x);
        if (!line.containsKey(y)) {
            return 0;
        }
        return line.get(y);
    }

    public int count(int[] point) {
        int x = point[0], y = point[1], count = 0;
        if (!lines.containsKey(x)) {
            return 0;
        }
        Map<Integer, Integer> line = lines.get(x);
        for (Integer y1 : line.keySet()) {
            if (y1 != y) {
                int side = Math.abs(y1 - y);
                count += getDuplications(x, y1) * getDuplications(x + side, y1)
                        * getDuplications(x + side, y);
                count += getDuplications(x, y1) * getDuplications(x - side, y1)
                        * getDuplications(x - side, y);
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
