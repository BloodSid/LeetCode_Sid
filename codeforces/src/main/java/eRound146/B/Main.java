package eRound146.B;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println(solve(sc.nextInt(), sc.nextInt()));
        }
    }

    static int solve(int a, int b) {
        // leg 长的最小值大概在 sqrt(a + b) 附近
        int min = Integer.MAX_VALUE;
        int s = (int) Math.sqrt(a + b);
        for (int i = Math.max(1, s - 10); i < s + 10; i++) {
            min = Math.min(min, f(a, b, i));
        }
        return min;
    }

    static int f(int a, int b, long leg) {
        return (int) (leg - 1 + (a + leg - 1) / leg + (b + leg - 1) / leg);
    }

}
