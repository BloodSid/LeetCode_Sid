package T2211;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-05-21 0:59
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger two = BigInteger.valueOf(2);
        BigInteger res = sumOfGS(100, 100, n).subtract(two.multiply(sumOfGS(10, 10, n)))
                .add(BigInteger.valueOf(n)).multiply(BigInteger.valueOf(4)).divide(BigInteger.valueOf(9));
        System.out.println(res);
    }

    // sum of geometric series 等差数列求和
    static BigInteger sumOfGS(int a0, int q, int n) {
        BigInteger a0b = BigInteger.valueOf(a0);
        BigInteger qb = BigInteger.valueOf(q);
        BigInteger one = BigInteger.ONE;
        return a0b.multiply(one.subtract(qb.pow(n))).divide(one.subtract(qb));
    }
}
