import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author IronSid
 * @since 2022-01-24 22:12
 */
public class NextPermutation {
    public static void main(String[] args) {
    }

    public static int nextBitsPermutation(int n, int size) {
        int trailZero = Integer.numberOfTrailingZeros(n);
        int bit = Integer.bitCount(n);
        // 所有的1都在0之前，则下一个排列是所有的0都在1之前
        if (trailZero + bit == size) return (-1 >>> 32 - bit);
        for (int i = 0; i < size; i++) {
            if (((n >>> i) & 3) == 1) {
                n += 1 << trailZero;
                n += i - trailZero == 32 ? -1 : (1 << i - trailZero) - 1;
                break;
            }
        }
        return n;
    }

    public static <T extends Comparable<? super T>> void nextPermutation(List<T> list) {
        // TODO 下一个排列
        return;
    }

    // 输出 start 的二进制表示在后 size 位上的所有排列。（start的二进制里的所有1必须在后size位之内）
    @Test
    public void nextBitsPermutationTest() {
        char[] zeros = new char[32];
        Arrays.fill(zeros, '0');
        // start 有两个 1
        int start = Integer.parseInt("1000010000", 2);
        int size = 10;
        int cnt = 0;
        for (int i = start; ;) {
            String s = Integer.toBinaryString(i);
            s = new String(zeros, 0, size - s.length()) + s;
            System.out.println("i = " + i);
            System.out.println(s);
            cnt++;
            i = nextBitsPermutation(i, size);
            if (i == start) break;
        }
        //  C(10, 2) = 45
        System.out.println("cnt = " + cnt);
    }
}
