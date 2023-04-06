package eRound146.C;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s1 = sc.nextInt();
            int s2 = sc.nextInt();
            int[] r = new int[n];
            for (int i1 = 0; i1 < r.length; i1++) {
                r[i1] = sc.nextInt();
            }
            List<Integer>[] solve = solve(s1, s2, r);
            print(solve[0]);
            print(solve[1]);
        }
    }

    static void print(List<Integer> a) {
        StringBuffer sb = new StringBuffer();
        sb.append(a.size()).append(' ');
        for (int i : a) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);
    }

    static List<Integer>[] solve(int s1, int s2, int[] r) {
        List<Integer> a = new ArrayList<>(), b = new ArrayList<>();
        int n = r.length;
        Integer[] idx = IntStream.range(1, n + 1).boxed().toArray(Integer[]::new);
        Arrays.sort(idx, (o1, o2) -> r[o2 - 1] - r[o1 - 1]);
        for (int i = 0, j = 0, k = 0; k < r.length; k++) {
            if (i + s1 <= j + s2) {
                a.add(idx[k]);
                i += s1;
            } else {
                b.add(idx[k]);
                j += s2;
            }
        }
        return new List[]{a, b};
    }
}
