package T1457;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

// 1457. 杨辉三角形
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(find(n));
    }

    static long find(long n) {
        if (n == 1) return 1;
        // x 行的第 y 个
        int[] f = new int[17];
        f[1] = 1;
        for (int x = 1; x < 50000; x++) {
            for (int y = 16; y >= 1; y--) {
                f[y] += f[y - 1];
                if (f[y] == n) {
                    y = Math.min(y, x + 2 - y);
                    return (long) x * (x + 1) / 2 + y;
                }
            }
        }
        return n * (n + 1) / 2 + 1 + 1;
    }

}
class Main2 {
    // 对拍器
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        long[] arr =new long[44725];
        arr[0]=1;
        long k=1L;
        if (n == 1) {
            System.out.println(1);
            return;
        }
        for (int i = 1;i<44725; i++) {
            for (int j = i; j>=i-16&&j>=1; j--) {
                arr[j] += arr[j - 1];
                if (arr[j] == n) {
                    System.out.println(k + i-j + 1);
                    return;
                }
            }
            k+=(i+1);
        }
        System.out.println(((1 + n) * n / 2) + 2);
    }
}

class Test{
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            System.out.println("i = " + i);
            String s = i + "";
            InputStream is = new ByteArrayInputStream(s.getBytes());
            System.setIn(is);
            Main.main(null);
            is = new ByteArrayInputStream(s.getBytes());
            System.setIn(is);
            Main2.main(null);
        }
    }
}