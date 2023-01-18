package leetcode.editor.cn;
//给你两个整数 m 和 k ，以及数据流形式的若干整数。你需要实现一个数据结构，计算这个数据流的 MK 平均值 。 
//
// MK 平均值 按照如下步骤计算： 
//
// 
// 如果数据流中的整数少于 m 个，MK 平均值 为 -1 ，否则将数据流中最后 m 个元素拷贝到一个独立的容器中。 
// 从这个容器中删除最小的 k 个数和最大的 k 个数。 
// 计算剩余元素的平均值，并 向下取整到最近的整数 。 
// 
//
// 请你实现 MKAverage 类： 
//
// 
// MKAverage(int m, int k) 用一个空的数据流和两个整数 m 和 k 初始化 MKAverage 对象。 
// void addElement(int num) 往数据流中插入一个新的元素 num 。 
// int calculateMKAverage() 对当前的数据流计算并返回 MK 平均数 ，结果需 向下取整到最近的整数 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["MKAverage", "addElement", "addElement", "calculateMKAverage", "addElement", 
//"calculateMKAverage", "addElement", "addElement", "addElement", 
//"calculateMKAverage"]
//[[3, 1], [3], [1], [], [10], [], [5], [5], [5], []]
//输出：
//[null, null, null, -1, null, 3, null, null, null, 5]
//
//解释：
//MKAverage obj = new MKAverage(3, 1); 
//obj.addElement(3);        // 当前元素为 [3]
//obj.addElement(1);        // 当前元素为 [3,1]
//obj.calculateMKAverage(); // 返回 -1 ，因为 m = 3 ，但数据流中只有 2 个元素
//obj.addElement(10);       // 当前元素为 [3,1,10]
//obj.calculateMKAverage(); // 最后 3 个元素为 [3,1,10]
//                          // 删除最小以及最大的 1 个元素后，容器为 [3]
//                          // [3] 的平均值等于 3/1 = 3 ，故返回 3
//obj.addElement(5);        // 当前元素为 [3,1,10,5]
//obj.addElement(5);        // 当前元素为 [3,1,10,5,5]
//obj.addElement(5);        // 当前元素为 [3,1,10,5,5,5]
//obj.calculateMKAverage(); // 最后 3 个元素为 [5,5,5]
//                          // 删除最小以及最大的 1 个元素后，容器为 [5]
//                          // [5] 的平均值等于 5/1 = 5 ，故返回 5
// 
//
// 
//
// 提示： 
//
// 
// 3 <= m <= 10⁵ 
// 1 <= k*2 < m 
// 1 <= num <= 10⁵ 
// addElement 与 calculateMKAverage 总操作次数不超过 10⁵ 次。 
// 
// 👍 50 👎 0


import java.util.*;

/**
 * 求出 MK 平均值
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-01-18 11:10:54 
 */
public class FindingMkAverageSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class MKAverage {

    private int idx = 0;
    private int m;
    private int k;
    // {element, idx} idx 用于区分相等的元素
    TreeSet<int[]> s1, s2, s3;
    Deque<int[]> q;
    long sum2 = 0;

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        s1 = new TreeSet<>((o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        s2 = new TreeSet<>(s1.comparator());
        s3 = new TreeSet<>(s1.comparator());
        q = new ArrayDeque<>();
    }
    
    public void addElement(int num) {
        int[] cur = {num, idx++};
        q.offer(cur);
        if (q.size() <= m) {
            // 未满 m 个，只加入
            s2.add(cur);
            sum2 += num;
            if (q.size() == m) {
                // 若加满m个，把最大和最小的k个数放进s1, s3
                for (int i = 0; i < k; i++) {
                    int[] f = s2.pollFirst();
                    sum2 -= f[0];
                    s1.add(f);
                    int[] l = s2.pollLast();
                    sum2 -= l[0];
                    s3.add(l);
                }
            }
        } else {
            // 满 m 个，则根据大小加入
            if (num < s1.last()[0]) {
                s1.add(cur);
            } else if (num > s3.first()[0]) {
                s3.add(cur);
            } else {
                s2.add(cur);
                sum2 += num;
            }
            // 同时把最早的元素删除
            int[] poll = q.poll();
            s1.remove(poll);
            if (s2.remove(poll)) {
                sum2 -= poll[0];
            }
            s3.remove(poll);
            // 保证s1大小是k
            if (s1.size() == k + 1) {
                int[] p = s1.pollLast();
                s2.add(p);
                sum2 += p[0];
            } else if (s1.size() == k - 1) {
                int[] p = s2.pollFirst();
                s1.add(p);
                sum2 -= p[0];
            }
            // 保证s3大小是k,此时s2大小必为m-2k
            if (s3.size() == k + 1) {
                int[] p = s3.pollFirst();
                s2.add(p);
                sum2 += p[0];
            } else if (s3.size() == k - 1) {
                int[] p = s2.pollLast();
                sum2 -= p[0];
                s3.add(p);
            }
        }
    }
    
    public int calculateMKAverage() {
        if (q.size() < m) return -1;
        return (int) (sum2 / (m - 2 * k));
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
