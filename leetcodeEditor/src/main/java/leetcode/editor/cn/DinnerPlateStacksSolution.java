package leetcode.editor.cn;
//我们把无限数量 ∞ 的栈排成一行，按从左到右的次序从 0 开始编号。每个栈的的最大容量 capacity 都相同。 
//
// 实现一个叫「餐盘」的类 DinnerPlates： 
//
// 
// DinnerPlates(int capacity) - 给出栈的最大容量 capacity。 
// void push(int val) - 将给出的正整数 val 推入 从左往右第一个 没有满的栈。 
// int pop() - 返回 从右往左第一个 非空栈顶部的值，并将其从栈中删除；如果所有的栈都是空的，请返回 -1。 
// int popAtStack(int index) - 返回编号 index 的栈顶部的值，并将其从栈中删除；如果编号 index 的栈是空的，请返回 -
//1。 
// 
//
// 
//
// 示例： 
//
// 输入： 
//["DinnerPlates","push","push","push","push","push","popAtStack","push","push",
//"popAtStack","popAtStack","pop","pop","pop","pop","pop"]
//[[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]
//输出：
//[null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]
//
//解释：
//DinnerPlates D = DinnerPlates(2);  // 初始化，栈最大容量 capacity = 2
//D.push(1);
//D.push(2);
//D.push(3);
//D.push(4);
//D.push(5);         // 栈的现状为：    2  4
//                                    1  3  5
//                                    ﹈ ﹈ ﹈
//D.popAtStack(0);   // 返回 2。栈的现状为：      4
//                                          1  3  5
//                                          ﹈ ﹈ ﹈
//D.push(20);        // 栈的现状为：  20  4
//                                   1  3  5
//                                   ﹈ ﹈ ﹈
//D.push(21);        // 栈的现状为：  20  4 21
//                                   1  3  5
//                                   ﹈ ﹈ ﹈
//D.popAtStack(0);   // 返回 20。栈的现状为：       4 21
//                                            1  3  5
//                                            ﹈ ﹈ ﹈
//D.popAtStack(2);   // 返回 21。栈的现状为：       4
//                                            1  3  5
//                                            ﹈ ﹈ ﹈ 
//D.pop()            // 返回 5。栈的现状为：        4
//                                            1  3 
//                                            ﹈ ﹈  
//D.pop()            // 返回 4。栈的现状为：    1  3 
//                                           ﹈ ﹈   
//D.pop()            // 返回 3。栈的现状为：    1 
//                                           ﹈   
//D.pop()            // 返回 1。现在没有栈。
//D.pop()            // 返回 -1。仍然没有栈。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 20000 
// 1 <= val <= 20000 
// 0 <= index <= 100000 
// 最多会对 push，pop，和 popAtStack 进行 200000 次调用。 
// 
//
// 👍 91 👎 0


import java.util.*;

/**
 * 餐盘栈
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-04-28 23:20:21 
 */
public class DinnerPlateStacksSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class DinnerPlates {
    int cap;
    // 所有栈
    List<Deque<Integer>> stacks = new ArrayList<>();
    // 未满栈的下标
    PriorityQueue<Integer> unfull = new PriorityQueue<>();

    public DinnerPlates(int capacity) {
        this.cap = capacity;
    }
    
    public void push(int val) {
        // 堆中都是越界下标，直接清空
        if (!unfull.isEmpty() && stacks.size() <= unfull.peek()) {
            unfull.clear();
        }
        if (!unfull.isEmpty()) {
            // 有未满的栈
            Integer id = unfull.peek();
            stacks.get(id).push(val);
            if (stacks.get(id).size() == cap) {
                // 栈满了则从堆中去掉
                unfull.poll();
            }
        } else {
            // 所有栈都是满的
            Deque<Integer> newStack = new LinkedList<>();
            newStack.push(val);
            // 增加新栈
            stacks.add(newStack);
            if (newStack.size() < cap) {
                // 新栈不满则入堆
                unfull.offer(stacks.size() - 1);
            }
        }
    }
    
    public int pop() {
        // 等价于pop列表中的最后一个栈
        return stacks.isEmpty() ? -1 : popAtStack(stacks.size() - 1);
    }
    
    public int popAtStack(int index) {
        if (index >= stacks.size()) return -1;
        Deque<Integer> stack = stacks.get(index);
        // 满栈变成了非满，加入堆中
        if (stack.size() == cap) unfull.offer(index);
        // 空栈返回-1
        int res = stack.isEmpty() ? -1 : stack.pop();
        // 去掉末尾的空栈（懒删除：堆中下标在 push 时处理）
        while (!stacks.isEmpty() && stacks.get(stacks.size() - 1).isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        return res;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
