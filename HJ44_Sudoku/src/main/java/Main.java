import java.util.*;

/**
 * @author IronSid
 * @create 2021-06-07 2:46
 */
public class Main {
    static int[][] s;//Sokudo
    static List<Integer>[][] l;
    static Queue<Integer> queue;
    static List<Integer> lastNums;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            s = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    s[i][j] = in.nextInt();
                }
            }
            //初始化队列矩阵
            Integer[] array1to9 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            l = new ArrayList[9][9];
            queue = new LinkedList<>();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    List<Integer> integerList = new ArrayList<>();
                    if (s[i][j] == 0) {
                        Collections.addAll(integerList, array1to9);
                    } else {
                        integerList.add(s[i][j]);
                        queue.offer(i * 9 + j);
                    }
                    l[i][j] = integerList;
                }
            }
            //通过排除法进行填数
            while (!queue.isEmpty()) {
                Integer block = queue.poll();
                int x = block / 9;
                int y = block % 9;
                writeNum(x, y, l[x][y].get(0));
            }
            //找出排除法无法确定的位置
            lastNums=new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (s[i][j] == 0) {
                        lastNums.add(i * 9 + j);
                    }
                }
            }
            //深度优先搜索
            dfsWrite(0);


            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(s[i][j]);
                    sb.append(' ');
                }
                if (i != 8)
                    sb.append('\n');
            }
            System.out.println(sb);

        }
    }

    //true 表示不会产生矛盾 false 表示会产生矛盾
    //推测法写数字
    static boolean writeNum(int x, int y, int num) {
        s[x][y] = num;
        boolean flag = false;
        for (int i = 0; i < 9; i++) {
            if (i != y) {
                flag = l[x][i].remove((Integer) num);
                if (flag) {
                    if (l[x][i].size() == 1)
                        queue.offer(x * 9 + i);
                    if (l[x][i].size() == 0)
                        return false;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if (i != x) {
                flag = l[i][y].remove((Integer) num);
                if (flag) {
                    if (l[i][y].size() == 1)
                        queue.offer(i * 9 + y);
                    if (l[i][y].size() == 0)
                        return false;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (x % 3 != i || y % 3 != j) {
                    flag = l[x / 3 * 3 + i][y / 3 * 3 + j].remove((Integer) num);
                    if (flag) {
                        if (l[x / 3 * 3 + i][y / 3 * 3 + j].size() == 1)
                            queue.offer((x / 3 * 3 + i) * 9 + (y / 3 * 3 + j));
                        if (l[x / 3 * 3 + i][y / 3 * 3 + j].size() == 0)
                            return false;
                    }
                }
            }
        }
        return true;
    }

    //true 表示不会产生矛盾 false 表示会产生矛盾
    static boolean check(int index) {
        int x = index / 9, y = index % 9;
        for (int i = 0; i < 9; i++) {
            if (i != y && s[x][i] == s[x][y]) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (i != x && s[i][y] == s[x][y]) {
                return false;
            }
        }
        for (int i = x / 3 * 3; i < x / 3 * 3 + 3; i++) {
            for (int j = y / 3 * 3; j < y / 3 * 3 + 3; j++) {
                if (i != x || j != y) {
                    if (s[i][j] == s[x][y]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //dfs写数字
    static boolean dfsWrite(int index) {
        //递归终止标记
        if (index == lastNums.size()) return true;

        int x = lastNums.get(index) / 9, y = lastNums.get(index) % 9;
        //若该格子已填则跳过
        //if (s[x][y] != 0) return dfsWrite(index + 1);

        //若未填则遍历该格子的列表
        List<Integer> list = l[x][y];

        for (Integer num : list) {
            s[x][y] = num;
            if (check(lastNums.get(index)) && dfsWrite(index + 1))
                return true;
            else
                s[x][y] = 0;
        }

        return false;
    }
}