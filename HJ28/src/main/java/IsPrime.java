import java.util.Scanner;

/**
 * @author IronSid
 * @create 2021-06-02 1:42
 */
public class IsPrime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            if(!isPrime(a)){
                System.out.println("false");
            }else{
                System.out.println("true");
            }
        }
    }
    public static boolean isPrime(int N) {
        if (N < 2) return false;
        int R = (int) Math.sqrt(N);
        for (int d = 2; d <= R; ++d)
            if (N % d == 0) return false;
        return true;
    }


}
