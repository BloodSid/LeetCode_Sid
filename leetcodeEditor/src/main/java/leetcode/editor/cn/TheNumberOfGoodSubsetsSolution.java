package leetcode.editor.cn;

import org.junit.*;

import java.util.*;

/**
 * 好子集的数目
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-22 00:06:19
 */
public class TheNumberOfGoodSubsetsSolution {
    @Test
    public void blockTest() {
        Solution solution = new Solution();
        int[] nums = {5,10,1,26,24,21,24,23,11,12,27,4,17,16,2,6,1,1,6,8,13,30,24,20,2,19};
        Assert.assertEquals(5368, solution.numberOfGoodSubsets(nums));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    // 记录每个数的质因数分解，若一个数被分解出相同的质因数，则赋值-1
    int[] factors = new int[31];
    // 记录可能的集合
    List<List<Integer>> setList = new ArrayList<>();

    {
        List<Integer> goodNums = new ArrayList<>();
        for (int i = 2; i <= 30; i++) {
            int num = i;
            int factor = 0;
            for (int j = 0; j < primes.length; j++) {
                if (num % primes[j] == 0) {
                    num /= primes[j];
                    if (num % primes[j] == 0) {
                        factor = -1;
                        break;
                    }
                    factor |= (1 << j);
                    if (num == 1) {
                        break;
                    }
                }
            }
            factors[i] = factor;
            if (factor != -1) {
                goodNums.add(i);
            }
        }
        LinkedList<Integer> buffer = new LinkedList<>();
        dfs(0, goodNums, buffer, 0);
    }

    void dfs(int i, List<Integer> g, LinkedList<Integer> b, int status) {
        if (i == g.size()) {
            if (b.size() > 0) {
                setList.add(new ArrayList<>(b));
            }
            return;
        }
        dfs(i + 1, g, b, status);
        int cur = g.get(i);
        if ((status & factors[cur]) == 0) {
            b.addLast(cur);
            status += factors[cur];
            dfs(i + 1, g, b, status);
            b.removeLast();
        }
    }

    static final int MOD = (int) 1e9 + 7;

    public int numberOfGoodSubsets(int[] nums) {
        int[] freq = new int[31];
        for (int num : nums) {
            freq[num]++;
        }
        long sum = 0;
        for (List<Integer> set : setList) {
            long cnt = 1;
            for (Integer num : set) {
                cnt = cnt * freq[num] % MOD;
            }
            sum = (sum + cnt) % MOD;
        }
        sum = sum * powWithMod(2, freq[1], MOD) % MOD;
        // 若有n个1，这些 1 总共有 2 ^ n 个不同的子集（包括空集），与之前的结果相乘就是最终结果
        return (int) sum;
    }

    private int powWithMod(int base, int pow, int mod) {
        if (pow == 0) return 1;
        long i1 = (pow & 1) == 1 ? base : 1;
        long i2 = powWithMod(base, pow / 2, mod);
        return (int) (i1 * i2 % MOD * i2 % MOD);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
