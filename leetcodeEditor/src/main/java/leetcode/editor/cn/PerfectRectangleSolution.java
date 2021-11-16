package leetcode.editor.cn;

import java.util.*;

/**
 * 完美矩形
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-16 00:45:03
 */
public class PerfectRectangleSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        long area = 0;
        HashMap<Point, Integer> map = new HashMap();
        for (int[] rectangle : rectangles) {
            minX = Math.min(minX, rectangle[0]);
            minY = Math.min(minY, rectangle[1]);
            maxX = Math.max(maxX, rectangle[2]);
            maxY = Math.max(maxY, rectangle[3]);
            area += ((long) (rectangle[3] - rectangle[1])) * (rectangle[2] - rectangle[0]);
            Point[] points = new Point[4];
            points[0] = new Point(rectangle[0], rectangle[1]);
            points[1] = new Point(rectangle[2], rectangle[3]);
            points[2] = new Point(rectangle[0], rectangle[3]);
            points[3] = new Point(rectangle[2], rectangle[1]);
            for (Point point : points) {
                int cnt = 1 + map.getOrDefault(point, 0);
                if (cnt > 4) {
                    return false;
                }
                map.put(point, cnt);
            }
        }
        Point[] corners = new Point[4];
        corners[0] = new Point(maxX, maxY);
        corners[1] = new Point(maxX, minY);
        corners[2] = new Point(minX, maxY);
        corners[3] = new Point(minX, minY);
        for (Point corner : corners) {
            int cnt = map.getOrDefault(corner, 0);
            if (cnt != 1) {
                return false;
            }
            map.remove(corner);
        }
        for (Point point : map.keySet()) {
            int cnt = map.get(point);
            if (cnt != 2 && cnt != 4) {
                return false;
            }
        }
        return area == ((long) (maxY - minY)) * (maxX - minX);
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return (x << 16) + y;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}