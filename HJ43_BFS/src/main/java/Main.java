
import java.util.*;

/**
 * @author IronSid
 * @create 2021-06-07 1:07
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int x = in.nextInt();
            int y = in.nextInt();
            int[][] map = new int[x][y];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    int n = in.nextInt();
                    map[i][j] = n == 1 ? -1 : 0;//
                }
            }
            Queue<Node> q = new LinkedList<>();
            q.offer(new Node(null, 0, 0, 1));
            map[0][0]=1;
            Node curr = null;
            out:
            while (!q.isEmpty()) {
                curr = q.poll();
                List<Node> l = curr.getNext(map);
                if (!l.isEmpty()) {
                    for (Node node : l) {
                        q.offer(node);
                        if (node.x == x - 1 && node.y == y - 1) {//若到出口则停止BFS
                            curr = node;
                            break out;
                        }

                    }
                }
            }
            if (q.isEmpty()) {
                System.out.println("NO PATH");
                continue;
            }
            Stack<Node> path = new Stack<>();

            while (curr != null) {
                path.push(curr);
                curr = curr.pre;
            }
            while (!path.isEmpty()) {
                curr = path.pop();
                System.out.println("(" + curr.x + "," + curr.y + ")");
            }

        }
    }
}

class Node {
    Node pre;
    int x;
    int y;
    int dis;

    public Node(Node pre, int x, int y, int dis) {
        this.pre = pre;
        this.x = x;
        this.y = y;
        this.dis = dis;
    }

    public List<Node> getNext(int[][] map) {
        List<Node> next = new ArrayList<>();
        int x1 = 0, y1 = 0;
        for (int i = 0; i < 4; i++) {
            switch (i) {//右 上 左 下
                case 0:
                    x1 = x + 1;
                    y1 = y ;
                    break;
                case 1:
                    x1 = x ;
                    y1 = y - 1;
                    break;
                case 2:
                    x1 = x - 1;
                    y1 = y ;
                    break;
                case 3:
                    x1 = x ;
                    y1 = y + 1;
                    break;
            }
            if (x1 >= 0 && x1 < map.length && y1 >= 0 && y1 < map[0].length) {
                if (map[x1][y1] == 0) {
                    map[x1][y1] = dis + 1;
                    next.add(new Node(this, x1, y1, dis + 1));
                }
            }
        }
        return next;
    }
}
