package Round865.A;

import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-04-09 22:52
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    static void solve(){
        int a = sc.nextInt(), b = sc.nextInt();
        if (a == 1 || b == 1) {
            System.out.println(1);
            System.out.println(a + " " + b);
            return;
        }
        System.out.println(2);
        System.out.println((a - 1) + " " + 1);
        System.out.println(a + " " + b);
    }
}
