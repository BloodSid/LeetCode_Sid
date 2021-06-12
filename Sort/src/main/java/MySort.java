import java.util.Arrays;

/**
 * @author IronSid
 * @create 2021-06-02 23:04
 */
public class MySort {

    //插入排序
    public static void insertionSort(int[] a) {
        insertionSort(a, 0, a.length - 1);
//        int j;
//        for (int p = 1; p < a.length; p++) {
//            int tmp = a[p];
//            for (j = p; j > 0 && tmp < a[j - 1]; j--)
//                a[j] = a[j - 1];
//            a[j] = tmp;
//        }
    }

    private static void insertionSort(int[] a, int left, int right) {
        int j;
        for (int p = left + 1; p <= right; p++) {
            int tmp = a[p];
            for (j = p; j > left && tmp < a[j - 1]; j--)
                a[j] = a[j - 1];
            a[j] = tmp;
        }
    }
    //希尔排序

    //堆排序

    //归并排序

    //快速排序1
    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    //快速排序1, 三数中值分割法
    private static int median3(int[] a, int left, int right) {
        int center = (left + right) / 2;
        if (a[center] < a[left])
            swapReferences(a, left, center);
        if (a[right] < a[left])
            swapReferences(a, left, right);
        if (a[right] < a[center])
            swapReferences(a, center, right);
        //Place pivot at position right - 1
        swapReferences(a, center, right - 1);
        return a[right - 1];
    }

    private static void swapReferences(int[] a, int i1, int i2) {
        int temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }


    private static void quickSort(int[] a, int left, int right) {

        final int CUTOFF = 2;//最小为2，此时子数组长度为3，median3不会出错
        if (left + CUTOFF <= right) {//如果数组长度较小，可以不递归进行快排，而直接插入排序
            //数组较长，则快排
            //不使用cutoff 则要注意递归的出口
            int pivot = median3(a, left, right);

            // Begin partitioning
            int i = left, j = right - 1;
            for (; ; ) {
                while (a[++i] < pivot) {
                }
                while (a[--j] > pivot) {
                }
                if (i < j)
                    swapReferences(a, i, j);
                else
                    break;
            }

            swapReferences(a, i, right - 1); // Restore pivot
            quickSort(a, left, i - 1);// Sort small elements
            quickSort(a, i + 1, right);// Sort large elements

        } else // Do an insertion sort on the subarray
            insertionSort(a, left, right);
    }

    //快速排序2 from:《冲刺篇》
    public static void quickSort2(int[] a, int low, int high) {
        //1.找到递归算法的入口
        if (low > high)
            return;
        //2.存
        int i = low, j = high;
        //3.key
        int key = a[low];
        //完成一趟排序
        while (i < j) {
            //4.1 从右往左找到第一个小于key的数
            while (i < j && a[j] >= key) {
                j--;
            }
            //4.2 从左往右找到第一个大于key的数
            while (i < j && a[i] < key) {
                i++;
            }
            //4.3交换
            if (i < j) {
                int p = a[i];
                a[i] = a[j];
                a[j] = p;

            }
        }
        //4.4 调整key的位置
        int p = a[i];
        a[i] = a[low];
        a[low] = p;
        //5 对key左边的数快排
        quickSort2(a, low, i - 1);
        //6 对key右边的数快排
        quickSort2(a, i + 1, high);
    }


    //简单的递归排序
    //计数排序
    public static void countingSort(int[] a){
        int min=a[0],max=a[0];
        for (int i = 1; i < a.length; i++) {
            min=Math.min(min,a[i]);
            max=Math.max(max,a[i]);
        }
        int[] count=new int[max-min+1];
        for (int n : a) {
            count[n-min]++;//count 数组统计数字出现频率
        }
        int num=0;//count 数组的指针
        for (int i = 0; i < a.length; i++) {
            while(count[num]==0) num++;
            a[i]=min+num;
            count[num]--;
        }

    }
    //基数排序


    public static void main(String[] args) {
        int n = 1000;

        int[] a = new int[n];
//        n=a.length;
        for (int i = 0; i < a.length; i++) {
            a[i] = --n;
        }
        int[] b = Arrays.copyOf(a, a.length);
        Arrays.sort(b);
        System.out.println(Arrays.toString(b));


//        quickSort2(a,0,a.length-1);

        System.out.println(Arrays.toString(a));
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                System.out.println("i=" + i + " a[i]=" + a[i] + " b[i]=" + b[i]);
            }
        }
        System.out.println(Arrays.equals(a, b));

    }
}