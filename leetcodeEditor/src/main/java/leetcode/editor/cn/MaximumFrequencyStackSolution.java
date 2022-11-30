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
    private final HashMap<Integer, Integer> f;
    // 存所有频率对应的栈序列
    private final HashMap<Integer, Deque<Integer>> s;
    // 维护频率的最大值
    int maxF = 0;

    public FreqStack() {
        f = new HashMap<>();
        s = new HashMap<>();
    }
    
    public void push(int val) {
        int freq = f.getOrDefault(val, 0) + 1;
        f.put(val, freq);
        if (!s.containsKey(freq)) {
            s.put(freq, new ArrayDeque<>());
        }
        maxF = Math.max(maxF, freq);
        // 此时在 s[1:freq] 中都有一个 val 元素
        s.get(freq).push(val);
    }
    
    public int pop() {
        Deque<Integer> stack = s.get(maxF);
        // 从频率最大的栈序列出栈
        int res = stack.pop();
        f.put(res, maxF - 1);
        // 若元素出栈后栈为空，则最大频率自减一
        if (stack.size() == 0) {
            maxF--;
        }
        return res;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
