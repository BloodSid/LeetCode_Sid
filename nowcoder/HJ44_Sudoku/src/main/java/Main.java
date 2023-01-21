import java.util.*;

/**
 * @author IronSid
 * @create 2021-06-07 2:46
 */
public class Main {
    static int[][] s;//Sokudo

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            s = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    s[i][j] = in.nextInt();
                }
            }
            //深度优先搜索
            dfsWrite(0);

            //输出拼接
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
        if (index == 81) return true;
        int x = index / 9, y = index % 9;

        //若该格子已填则跳过
        if (s[x][y] != 0) return dfsWrite(index + 1);

        //若未填则遍历该格子的列表
        for (int num = 1; num <= 9; num++) {
            s[x][y] = num;
            if (check(index) && dfsWrite(index + 1))
                return true;
            else
                s[x][y] = 0;
        }
        //遍历之后，没有成功填数则返回false
        return false;
    }
}