import java.util.Arrays;
import java.util.Scanner;

/**
 * @author IronSid
 * @create 2021-06-07 2:53
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                String name = in.next();
                char[] chars = name.toUpperCase().toCharArray();
                int[] count  = new int[26];
                for (char c : chars) {
                    count[c-'A']++;
                }
                Arrays.sort(count);
                int sum=0;
                for (int i1 = count.length - 1; i1 >= 0; i1--) {
                    if(count[i1]==0) break;
                    sum+=count[i1]*(i1+1);
                }
                System.out.println(sum);
            }
        }
    }
}