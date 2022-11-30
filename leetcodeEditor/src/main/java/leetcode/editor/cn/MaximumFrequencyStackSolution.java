package leetcode.editor.cn;
//设计一个类似堆栈的数据结构，将元素推入堆栈，并从堆栈中弹出出现频率最高的元素。 
//
// 实现 FreqStack 类: 
//
// 
// FreqStack() 构造一个空的堆栈。 
// void push(int val) 将一个整数 val 压入栈顶。 
// int pop() 删除并返回堆栈中出现频率最高的元素。
// 
// 如果出现频率最高的元素不只一个，则移除并返回最接近栈顶的元素。 
// 
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["FreqStack","push","push","push","push","push","push","pop","pop","pop",
//"pop"],
//[[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
//输出：[null,null,null,null,null,null,null,5,7,5,4]
//解释：
//FreqStack = new FreqStack();
//freqStack.push (5);//堆栈为 [5]
//freqStack.push (7);//堆栈是 [5,7]
//freqStack.push (5);//堆栈是 [5,7,5]
//freqStack.push (7);//堆栈是 [5,7,5,7]
//freqStack.push (4);//堆栈是 [5,7,5,7,4]
//freqStack.push (5);//堆栈是 [5,7,5,7,4,5]
//freqStack.pop ();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,5,7,4]。
//freqStack.pop ();//返回 7 ，因为 5 和 7 出现频率最高，但7最接近顶部。堆栈变成 [5,7,5,4]。
//freqStack.pop ();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,4]。
//freqStack.pop ();//返回 4 ，因为 4, 5 和 7 出现频率最高，但 4 是最接近顶部的。堆栈变成 [5,7]。 
//
// 
//
// 提示： 
//
// 
// 0 <= val <= 10⁹ 
// push 和 pop 的操作数不大于 2 * 10⁴。 
// 输入保证在调用 pop 之前堆栈中至少有一个元素。 
// 
// 👍 299 👎 0


import java.util.*;

/**
 * 最大频率栈
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-11-30 11:56:31 
 */
public class MaximumFrequencyStackSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class FreqStack {

    // 存每个数字的 idx
    private final HashMap<Integer, Deque<Integer>> f;
    // 存所有的数字
    private final TreeSet<Integer> set;
    int idx = 0;

    public FreqStack() {
        f = new HashMap<>();
        set = new TreeSet<>((o1, o2) -> {
            Deque<Integer> stack1 = f.get(o1);
            Deque<Integer> stack2 = f.get(o2);
            int s1 = stack1 == null ? 0 : stack1.size();
            int s2 = stack2 == null ? 0 : stack2.size();
            if (s1 == s2) {
                // 根据比较器在下文中被调用的时机，可以断言两个栈不会同时为 null 或空，
                // 也就不存在 s1 = s2 = 0 导致 peek 为 null 的情况
                assert stack1 != null && !stack1.isEmpty();
                return stack2.peek() - stack1.peek();
            } else {
                return s2 - s1;
            }
        });
    }
    
    public void push(int val) {
        set.remove(val);
        if (!f.containsKey(val)) {
            f.put(val, new ArrayDeque<>());
        }
        f.get(val).push(idx++);
        set.add(val);
    }
    
    public int pop() {
        int res = set.first();
        set.remove(res);
        Deque<Integer> stack = f.get(res);
        stack.pop();
        // 若该元素还有剩余，则再次加入 set
        if (stack.size() != 0) {
            set.add(res);
        }
        return res;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
