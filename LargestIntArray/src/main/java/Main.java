/**
 * @author IronSid
 * @create 2021-06-24 19:02
 */
public class Main {
    //java数组最多能造多大：和堆内存大小有关 -Xmx512m ->352875684  约占340m
    //当堆内存设置的足够大时，最大的数组约占用该内存的66%
    public static void main(String[] args) {
        int start = 0, end = 2048/4*1024*1024;//堆内存大小
        while (start <= end) {
            int mid = (start + end) >>> 1;
            boolean flag = true;
            try {
                int[] a = new int[mid];
            } catch (Error e) {
                flag = false;
            }
            if (flag) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }


        }
        System.out.println(end);
    }

}
