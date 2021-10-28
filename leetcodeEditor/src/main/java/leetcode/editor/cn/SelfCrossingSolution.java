package leetcode.editor.cn;

import java.util.*;

/**
 * 路径交叉
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-28 13:13:41
 */
public class SelfCrossingSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isSelfCrossing(int[] distance) {
        int x = 0;
        int y = 0;
        Map<Integer, List<int[]>> curr = new HashMap<>();
        Map<Integer, List<int[]>> next = new HashMap<>();
        for (int i = 0; i < distance.length; i++) {
            int key = 0;
            int v0 = 0;
            int v1 = 0;
            switch (i % 4) {
                case 0:
                    key = x;
                    v0 = y;
                    y += distance[i];
                    v1 = y;
                    break;
                case 1:
                    key = y;
                    v1 = x;
                    x -= distance[i];
                    v0 = x;
                    break;
                case 2:
                    key = x;
                    v1 = y;
                    y -= distance[i];
                    v0 = y;
                    break;
                case 3:
                    key = y;
                    v0 = x;
                    x += distance[i];
                    v1 = x;
                    break;
            }
            // 同方向的线段有无重合
            List<int[]> list = curr.get(key);
            if (list != null) {
                for (int[] seg : list) {
                    if (v0 <= seg[1] && v1 >= seg[0]) {
                        return true;
                    }
                }
            }
            // 不同方向的线段有无重合
            int from = v0;
            int to = v1;
            if (i % 4 == 0 || i % 4 == 3) {
                from++;
            } else {
                to--;
            }
            for (int j = from; j <= to; j++) {
                list = next.get(j);
                if (list == null) {
                    continue;
                }
                for (int[] seg : list) {
                    if (key >= seg[0] && key <= seg[1]) {
                        return true;
                    }
                }
            }
            int[] value = {v0, v1};
            if (curr.containsKey(key)) {
                curr.get(key).add(value);
            } else {
                List<int[]> valueList = new ArrayList<>();
                valueList.add(value);
                curr.put(key, valueList);
            }
            Map<Integer, List<int[]>> temp = curr;
            curr = next;
            next = temp;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
