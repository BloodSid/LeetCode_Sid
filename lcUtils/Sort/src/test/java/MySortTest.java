import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author IronSid
 * @create 2021-06-26 22:26
 */
public class MySortTest {

    @Test
    public void bubbleSortTest1() {
        int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        for (int i = 0; i < 10000; i++) {
            int[] a = generateRandomArray(20);
            System.out.println(Arrays.toString(a));
            MySort.bubbleSort(a);
            assertArrayEquals(expected, a);
        }

    }

    /**
     * 生成一个数组，包括0到n的全部整数，顺序随机
     *
     * @param n 数组元素的最大值，必须是自然数
     * @return 生成的随机数组
     */
    static int[] generateRandomArray(int n) {
        int[] a = new int[n + 1];
        label:
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * (n + 1));
            for (int j = 0; j < i; j++) {
                if (a[i] == a[j]) {
                    i--;
                    continue label;
                }
            }
        }
        return a;
    }
}