import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class getPrime {

    public static void main(String[] args) {
        int max = 60000;
        int [] num = new int[max+1];
        num[0] = 2; num[1] = 2; //0表示素数 1表示和数
        int i=2;
        while(i<=max/2){
            if(num[i]==0){
                for (int j = 2; j <= max/i; j++) {
                    num[i*j]=1;
                }
            }
            i++;
        }
        int count = 0;
        List<Integer> s = new ArrayList<>(8080);
        for (int j = 0; j < num.length; j++) {
            if(num[j]==0){
                count++;
                s.add(j);
            }
        }
        System.out.println(s);
        int pnum = 0;
        for (Integer p : s) {
            if(!IsPrime.isPrime(p)){
                System.out.println(i+" is not prime");
            }else{
                pnum++;
            }
        }
        System.out.println(pnum);


    }

}