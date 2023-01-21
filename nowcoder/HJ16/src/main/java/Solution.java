/**
 * @author IronSid
 * @create 2021-05-26 0:33
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            ArrayList<Good> list = new ArrayList<>();
            int total = in.nextInt()/10;
            int num = in.nextInt();//物品件数
            int[] v = new int[num];
            int[] p = new int[num];
            int[] q = new int[num];
            int[][] dp = new int[num][total+1];//dp[i-1][j]剩下j元，买i件物品的最大product之和
            for (int i = 0; i < num; i++) {
                v[i] = in.nextInt()/10;
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
            for(int i = 0; i < num; i++){
                Good g = list.get(i);
                if(i==0){//最后一个物品的判断
                    if (g.q == 0 ){
                        //只考虑主件
                        for (int value = 1; value <= total; value++) {
                            if(g.value<=value){//剩余钱够买g
                                int sum = g.product;
                                //有附件1且能买
                                if (g.v1 > 0 && g.v1 + g.value <= value) {
                                    sum = g.product + g.p1;
                                }
                                //有附件2且能买
                                if (g.v2 > 0 && g.v2 + g.value <= value) {
                                    sum = Math.max(sum,g.product + g.p2);
                                }
                                //有两个附件且能都买
                                if (g.v2 > 0 && g.v1 + g.v2 + g.value <= value) {
                                    sum = g.product+g.p1+g.p2;
                                }
                                dp[i][value]=sum;
                            }
                        }
                    }else{//附件不考虑
                        //dp[i][value]==0;
                    }
                }else{//其他物品的判断
                    for (int value = 0; value <= total; value++) {
                        if(g.q!=0){//附件跳过
                            dp[i][value]=dp[i-1][value];
                        }else{
                            if(g.value>value){//买不起则跳过
                                dp[i][value]=dp[i-1][value];
                            }else{//买的起则求以下情形的最大
                                int temp = 0;
                                //有两个附件且能都买
                                if (g.v2 > 0 && g.v1 + g.v2 + g.value <= value){
                                    temp = dp[i-1][value-g.value-g.v1-g.v2]+g.product+g.p1+g.p2;
                                }
                                //有附件1且能买
                                if (g.v1 > 0 && g.v1 + g.value <= value){
                                    temp = Math.max(temp,dp[i-1][value-g.value-g.v1]+g.product+g.p1);
                                }
                                //有附件2且能买
                                if (g.v2 > 0 && g.v2 + g.value <= value){
                                    temp = Math.max(temp,dp[i-1][value-g.value-g.v2]+g.product+g.p2);
                                }
                                //不买附件,只买主件
                                temp = Math.max(temp,dp[i-1][value-g.value]+g.product);
                                //不买主件
                                temp = Math.max(temp,dp[i-1][value]);
                                dp[i][value]=temp;
                            }
                        }
                    }
                }
            }

            System.out.println(dp[num-1][total]*10);
            list.clear();
        }
    }




    static class Good {
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
}
