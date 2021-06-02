import java.util.*;

/**
 * @author IronSid
 * @create 2021-06-03 1:46
 */
public class Main {
    public static void main(String[] args) {
        //把4-60000的素数放入hashset
        int max = 60000;
        int [] num = new int[max+1];
        num[0] = 2; num[1] = 2; //0表示素数 1表示和数
        int i1=2;
        while(i1<=max/2){
            if(num[i1]==0){
                for (int j = 2; j <= max/i1; j++) {
                    num[i1*j]++;
                }
            }
            i1++;
        }

        Set<Integer> set = new HashSet<>(8080);
        for (int j = 4; j < num.length; j++) {
            if(num[j]==0){
                set.add(j);
            }
        }

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] a= new int[n];
            for (int i = 0; i < a.length; i++) {
                a[i]=in.nextInt();
            }


            System.out.println(set.size());
            System.out.println(set);

        }
    }
}