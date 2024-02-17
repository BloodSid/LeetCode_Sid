package Contest0217.T4;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2024-02-17 22:03
 */
public class Solution {

    public static final int L = (int) 1e6;
    public static final int[] f = new int[L + 2];

    public int maxSelectedElements(int[] nums) {
        int max = 0;
        Arrays.fill(f, 0);
        for (int num : nums) {
            f[num]++;
            max = Math.max(max, num);
        }
        int res = 0;
        // dp0(i) 表示i不增加时，最多可以选出的数目；dp1(i) 表示元素i增加时，最多可以选出的数目。
        // 对于i有多个的情况，对其中的1个或多个增加都不会影响结果，故只增加1个
        int[] dp0 = new int[max + 1], dp1 = new int[max + 1];
        Arrays.fill(dp1, -1);
        for (int i = 1; i <= max + 1; i++) {
            // 表示对元素i-1进行增加了的结果
            int add = dp1[i - 1] != -1 ? dp1[i - 1] + 1 : 0;
            int pre = Math.max(dp0[i - 1], dp1[i - 1]) + 1;
            if (f[i] == 0) {
                // 元素i不能增加
                dp0[i] = add;
            } else if (f[i] == 1) {
                // 元素i一旦增加，就不存在更多i
                dp0[i] = pre;
                dp1[i] = add;
            } else {
                // i频次大于等于2，可以增加其中的一个，就还存在i
                dp0[i] = dp1[i] = pre;
            }
            res = Math.max(res, dp0[i]);
            res = Math.max(res, dp1[i]);
        }
        return res;
    }
}
