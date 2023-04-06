package eRound146.A;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            if (solve(sc.nextLong(), sc.nextLong())) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static boolean solve(long n, long k) {
        if (n % 2 == 0) return true;
        return n - k >= 0 && (n - k) % 2 == 0;
    }
}
