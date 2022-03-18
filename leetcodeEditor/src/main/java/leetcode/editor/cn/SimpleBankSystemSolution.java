package leetcode.editor.cn;

/**
 * 简易银行系统
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-18 00:03:49
 */
public class SimpleBankSystemSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Bank {

    private long[] balance;
    private final int n;

    public Bank(long[] balance) {
        this.balance = balance;
        n = balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 < 1 || account1 > n || account2 < 1 || account2 > n) {
            return false;
        }
        if (!withdraw(account1, money)) {
            return false;
        }
        deposit(account2, money);
        return true;
    }

    public boolean deposit(int account, long money) {
        if (account < 1 || account > n) {
            return false;
        }
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account < 1 || account > n) {
            return false;
        }
        if (balance[account - 1] < money) {
            return false;
        }
        balance[account - 1] -= money;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
