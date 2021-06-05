import java.util.*;

/**
 * @author IronSid
 * @create 2021-06-03 1:46
 */
public class Main {
    static int [][] isBro;
    static int [] result; //用来记录偶数匹配到的奇数
    static boolean[] state;
    public static void main(String[] args) {
        //把4-60000的素数放入hashset
        //占用空间太大，但是提升效率有限，若做是不是素数的次数非常多，才有这么做的价值
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

        Set<Integer> set = new HashSet<>(7000);
        for (int j = 4; j < num.length; j++) {
            if(num[j]==0){
                set.add(j);
            }
        }

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] odd= new int[n];//偶数奇数分开记录
            int[] even=new int[n];
            int oddIndex=0,evenIndex=0;
            for (int i = 0; i < n; i++) {
                int m = in.nextInt();
                if(m%2==0){
                    even[evenIndex]=m;
                    evenIndex++;
                }else{
                    odd[oddIndex]=m;
                    oddIndex++;
                }
            }
            if(oddIndex==0||evenIndex==0){
                System.out.println(0);
                break;
            }//若奇数或偶数为零个，则组不成素数

            isBro = new int[oddIndex][evenIndex];
            //用来记录a[i]和a[j]之和是否为素数

            for (int i = 0; i < oddIndex; i++) {
                for (int j = 0; j < evenIndex; j++) {
                    if(set.contains(odd[i]+even[j])){
                        isBro[i][j]=1;
                    }
                }
            }
            //匈牙利算法
            result = new int[evenIndex];//用来记录偶数匹配到的奇数的index,若为-1则未匹配
            Arrays.fill(result,-1);
            int anwser = 0;
            for (int i = 0; i < oddIndex; i++) {
                state = new boolean[isBro[0].length];

                if(find(i)){
                    anwser++;
                }

            }


            System.out.println(anwser);

        }
    }
    static boolean find(int a){

        for (int j = 0; j < isBro[0].length; j++) {//即遍历evenIndex
            if(isBro[a][j]==1&& !state[j]) {
                state[j] = true;
                if (result[j] == -1 || find(result[j])) {
                    result[j] = a;
                    return true;
                }

            }
        }
        return false;
    }
}