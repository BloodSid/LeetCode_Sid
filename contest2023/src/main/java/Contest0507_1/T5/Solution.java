package Contest0507_1.T5;

import com.alibaba.fastjson.JSON;

import java.util.Random;

/**
 * @author IronSid
 * @since 2023-05-07 16:12
 */
public class Solution {
    public static void main(String[] args) {
        Random r = new Random();
        Solution s = new Solution();
        int mask = (1 << 5) - 1;
        int[] arr = {27,31,31,15,15,27,27,11,15};
        int[][] ops = JSON.parseArray("[[1,10,1],[0,5,4],[0,0,12],[0,7,28],[1,10,4],[0,8,29],[1,8,7],[0,1,4],[0,2,24],[1,10,13]]", int[].class).toArray(new int[0][]);
        for (int[] op : ops) {
            int type = op[0], x = op[1], y = op[2];
            if (type == 0) {
                arr[x] = y;
            } else {
                System.out.println("c1 = " + (s.calc(arr, y, x) & mask));
                System.out.println("c2 = " + (s.calc1(arr, y, x) & mask));
            }
        }

    }

    public int getNandResult(int k, int[] arr, int[][] operations) {
        int res = 0;
        for (int[] op : operations) {
            int type = op[0], x = op[1], y = op[2];
            if (type == 0) {
                arr[x] = y;
            } else {
                res ^= calc(arr, y, x);
            }
        }
        res &= (1 << k) - 1;
        return res;
    }

    // 优化：分奇偶计算
    private int calc(int[] arr, int y, int x) {
        for (int i = 0; i < (x + 1) % 2 + 1; i++) {
            for (int j : arr) {
                y = ~(y & j);
            }
        }
        return y;
    }

    // 暴力
    private int calc1(int[] arr, int y, int x) {
        for (int i = 0; i < x; i++) {
            for (int j : arr) {
                y = ~(y & j);
            }
        }
        return y;
    }

}
