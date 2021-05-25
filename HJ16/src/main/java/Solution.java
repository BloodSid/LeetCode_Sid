/**
 * @author IronSid
 * @create 2021-05-26 0:33
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static ArrayList<Good> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int total = in.nextInt();
            int num = in.nextInt();//物品件数
            int[] v = new int[num];
            int[] p = new int[num];
            int[] q = new int[num];
            for (int i = 0; i < num; i++) {
                v[i] = in.nextInt();
                p[i] = in.nextInt();
                q[i] = in.nextInt();
                list.add(new Good(v[i], p[i], q[i]));
            }
            for (int i = 0; i < num; i++) {//给主件添加附件
                if (q[i] != 0) {
                    Good g = list.get(q[i] - 1);
                    if (g.p1 == 0) {
                        g.set1(v[i], p[i]);
                    } else {
                        g.set2(v[i], p[i]);
                    }
                }
            }
            System.out.println(dp(list.size() - 1, total));
            list.clear();
        }
    }

    static int dp(int index, int total) {

        Good g = list.get(index);
        if (index == 0) {//最后一个
            if (g.q != 0) return 0;//若是附件则不算
            if (g.value > total) return 0;
            int max = 0;
            int temp = 0;
            //不买附件只买主件
            if (g.v1 == 0) {
                return g.product;
            }

            //有两个附件且能都买
            if (g.v2 > 0 && g.v1 + g.v2 + g.value <= total) {
                return g.product + g.p1 + g.p2;
            }
            //有附件1且能买
            if (g.v1 > 0 && g.v1 + g.value <= total) {
                max = g.product + g.p1;

            }

            //有附件2且能买
            if (g.v2 > 0 && g.v2 + g.value <= total) {
                temp = g.product + g.p2;
                if (temp > max) max = temp;
            }

            return max;
        }
        if (g.q != 0 || g.value > total) return dp(index - 1, total);//如果是附件,或买不起则跳过

        int max = 0;
        int temp = 0;
        //有两个附件且能都买
        if (g.v2 > 0 && g.v1 + g.v2 + g.value <= total) {

            max = dp(index - 1, total - g.value - g.v1 - g.v2) + g.product + g.p1 + g.p2;
        }
        //有附件1且能买
        if (g.v1 > 0 && g.v1 + g.value <= total) {
            temp = dp(index - 1, total - g.value - g.v1) + g.product + g.p1;
            if (temp > max) max = temp;

        }

        //有附件2且能买
        if (g.v2 > 0 && g.v2 + g.value <= total) {
            temp = dp(index - 1, total - g.value - g.v2) + g.product + g.p2;
            if (temp > max) max = temp;
        }
        //不买附件,只买主件

        temp = dp(index - 1, total - g.value) + g.product;
        if (temp > max) max = temp;
        //不买主件

        temp = dp(index - 1, total);
        if (temp > max) max = temp;

        return max;
    }

}


class Good {
    int value;
    int product;
    int v1;
    int p1;
    int v2;
    int p2;
    int q;

    Good(int v, int p, int q) {
        value = v;
        product = p * v;
        v1 = 0;
        p1 = 0;
        v2 = 0;
        p2 = 0;
        this.q = q;
    }

    void set1(int v, int p) {
        v1 = v;
        p1 = v * p;
    }

    void set2(int v, int p) {
        v2 = v;
        p2 = v * p;
    }


}

