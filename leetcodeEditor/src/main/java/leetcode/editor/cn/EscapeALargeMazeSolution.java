package leetcode.editor.cn;

import java.util.*;

/**
 * 逃离大迷宫
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-11 22:22:40
 */
public class EscapeALargeMazeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length == 0) {
            return true;
        }
        int MAX_POS = 1_000_000;
        int perimeter = blocked.length;
        int maxArea = perimeter * (perimeter - 1) / 2;
        Group blockedPoints = new Group();
        for (int[] pos : blocked) {
            blockedPoints.add(pos);
        }
        int[][] sources = {source, target};
        for (int[] pos : sources) {
            Group visited = new Group();
            visited.add(pos);
            Deque<int[]> queue = new LinkedList<>();
            queue.offer(pos);
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                if (visited.count > maxArea) {
                    break;
                }
                for (int[] dir : dirs) {
                    int[] next = new int[2];
                    for (int i = 0; i < 2; i++) {
                        next[i] = cur[i] + dir[i];
                    }
                    if (next[0] < 0 || next[1] < 0 || next[0] >= MAX_POS || next[1] >= MAX_POS) {
                        continue;
                    }
                    if (!visited.contains(next) && !blockedPoints.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
            // 可达的点不够多，说明被挡住了
            if (visited.count <= maxArea) {
                if (pos == source && visited.contains(target)) {
                    return true;
                }
                return false;
            }
        }
        // 起点和终点都没被挡住
        return true;
    }
}

class Group {
    int count;
    Map<Integer, Set<Integer>> group;

    public Group() {
        group = new HashMap<>();
        count = 0;
    }

    boolean contains(int[] pos) {
        return contains(pos[0], pos[1]);
    }

    boolean contains(int x, int y) {
        Set<Integer> line = group.get(x);
        if (line == null) {
            return false;
        }
        return line.contains(y);
    }

    boolean add(int[] pos) {
        return add(pos[0], pos[1]);
    }

    boolean add(int x, int y) {
        count++;
        if (!group.containsKey(x)) {
            group.put(x, new HashSet<>());
        }
        return group.get(x).add(y);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
