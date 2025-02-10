package leetcode.editor.cn;

import java.util.*;

/**
 * 猫和老鼠
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-04 20:14:10
 * 2025年2月11日用例更新
 */
public class CatAndMouseSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    static final int DRAW = 0;
    static final int MOUSE_WIN = 1;
    static final int CAT_WIN = 2;
    int[][] graph;
    int N;
    int[][][] dp;
    private int T;

    public int catMouseGame(int[][] graph) {
        this.graph = graph;
        this.N = graph.length;
        T = 4 * N + 10;
        this.dp = new int[N][N][T];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return getResult(1, 2, 0);
    }

    int getResult(int mouse, int cat, int turns) {
        if (turns == T) {
            return DRAW;
        }
        if (dp[mouse][cat][turns] == -1) {
            if (mouse == 0) {
                dp[mouse][cat][turns] = MOUSE_WIN;
            } else if (cat == mouse) {
                dp[mouse][cat][turns] = CAT_WIN;
            } else {
                getNextResult(mouse, cat, turns);
            }
        }
        return dp[mouse][cat][turns];
    }

    void getNextResult(int mouse, int cat, int turns) {
        int curMove = turns % 2 == 0 ? mouse : cat;
        // 默认为输
        int defaultResult = curMove == mouse ? CAT_WIN : MOUSE_WIN;
        int result = defaultResult;
        for (int next : graph[curMove]) {
            // 猫不能移动到0
            if (next == 0 && curMove == cat) {
                continue;
            }
            int nextCat = cat;
            int nextMouse = mouse;
            if (curMove == mouse) {
                nextMouse = next;
            } else {
                nextCat = next;
            }
            int nextResult = getResult(nextMouse, nextCat, turns + 1);
            // 遇赢为赢并停止，遇平为平继续搜，全输则为输
            if (nextResult != defaultResult) {
                result = nextResult;
                if (nextResult != DRAW) {
                    break;
                }
            }
        }
        dp[mouse][cat][turns] = result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
