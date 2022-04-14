package leetcode.editor.cn;

/**
 * 设计循环队列
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-14 00:41:24
 */
public class DesignCircularQueueSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class MyCircularQueue {

    private int rear;
    private int front;
    private int k;
    private int size;
    private final int[] val;

    public MyCircularQueue(int k) {
        this.k = k;
        val = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        val[rear++] = value;
        if (rear == k) rear = 0;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        front++;
        if (front == k) front = 0;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return val[front];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return val[rear == 0 ? k - 1 : rear - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
