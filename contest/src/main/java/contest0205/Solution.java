package contest0205;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author IronSid
 * @since 2022-02-05 22:40
 */
public class Solution {
    public int minimumSum(int num) {
        int[] digits = new int[4];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = num % 10;
            num /= 10;
        }
        Arrays.sort(digits);
        return 10 * digits[0] + 10 * digits[1] + digits[2] + digits[3];
    }

    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (o1, o2) -> {
            int i1, i2;
            if (nums[o1] < pivot) {
                i1 = -1;
            } else if (nums[o1] > pivot) {
                i1 = 1;
            } else {
                i1 = 0;
            }
            if (nums[o2] < pivot) {
                i2 = -1;
            } else if (nums[o2] > pivot) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i1 == i2) {
                return o1 - o2;
            } else {
                return i1 - i2;
            }
        });
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[idx[i]];
        }
        return res;
    }

    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int min = Integer.MAX_VALUE;
        ArrayList<int[]> list = new ArrayList<>();
        int m = targetSeconds / 60;
        int n = targetSeconds % 60;
        if (m <= 99) {
            String tem = n <= 9 ? "0" + n : "" + n;
            String k = m == 0 ? "" + n : "" + m + tem;
            int[] ints = new int[k.length()];
            for (int i = 0; i < ints.length; i++) {
                ints[i] = k.charAt(i) & 15;
            }
            list.add(ints);
        }
        if (m > 0 && n <= 39) {
            m -= 1;
            n += 60;
            String k = m == 0 ? "" + n : "" + m + n;
            int[] ints = new int[k.length()];
            for (int i = 0; i < ints.length; i++) {
                ints[i] = k.charAt(i) & 15;
            }
            list.add(ints);
        }
        for (int[] keys : list) {
            int p = startAt;
            int cost = 0;
            for (int key : keys) {
                if (key != p) {
                    cost += moveCost;
                    p = key;
                }
                cost += pushCost;
            }
            min = Math.min(min, cost);
        }
        return min;
    }

    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> right = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            left.add(nums[i]);
        }
        int l = n;
        int r = 2 * n - 1;
        for (int i = 0; i < n; i++) {
            right.add(nums[nums.length - 1 - i]);
        }
        while (l <= r) {
            int lmove = nums[l] > left.peek() ? 0 : -left.peek() + nums[l];
            int rmove = nums[r] < right.peek() ? 0 : right.peek() - nums[r];
            if (lmove < rmove) {
                left.offer(nums[l]);
                left.poll();
                l++;
            } else {
                right.offer(nums[r]);
                right.poll();
                r--;
            }
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += left.poll();
            res -= right.poll();
        }
        return res;
    }

    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length;
        Integer[] odd = new Integer[n / 2];
        int p1 = 0;
        Integer[] even = new Integer[n - odd.length];
        int p2 = 0;
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 1) {
                odd[p1++] = i;
            } else {
                even[p2++] = i;
            }
        }
        Arrays.sort(odd, (o1, o2) -> nums[o2] - nums[o1]);
        Arrays.sort(even, ((o1, o2) -> nums[o1] - nums[o2]));
        int[] res = new int[n];
        for (int i = 0; i < odd.length; i++) {
            res[2 * i + 1] = nums[odd[i]];
        }
        for (int i = 0; i < even.length; i++) {
            res[2 * i] = nums[even[i]];
        }
        return res;
    }

    public long smallestNumber(long num) {
        if (num == 0) return 0;
        char[] arr = String.valueOf(num).toCharArray();
        if (arr[0] == '-') {
            Arrays.sort(arr, 1, arr.length);
            for (int l = 1, r = arr.length - 1; l < r; l++, r--) {
                char tem = arr[l];
                arr[l] = arr[r];
                arr[r] = tem;
            }
        } else {
            Arrays.sort(arr);
            if (arr[0] == '0') {
                int i = 0;
                while (arr[i] == '0') {
                    i++;
                }
                arr[0] = arr[i];
                arr[i] = '0';
            }
        }
        return Long.parseLong(new String(arr));
    }

    public int minimumTime(String str) {
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2};
        Solution s = new Solution();
        long res = s.minimumDifference(nums);
        System.out.println(res);
    }
}

class Bitset {
    int size;
    int[] a;
    int tail;

    public Bitset(int size) {
        this.size = size;
        tail = size % 32 == 0 ? 32 : size % 32;
        a = new int[(size - 1) / 32 + 1];
    }

    public void fix(int idx) {
        a[idx / 32] |= 1 << (32 - idx % 32 - 1);
    }

    public void unfix(int idx) {
        int k = a[idx / 32];
        int m = 1 << (32 - idx % 32 - 1);
        if ((k & m) != 0) {
            a[idx / 32] = k - m;
        }
    }

    public void flip() {
        for (int i = 0; i < a.length - 1; i++) {
            a[i] = ~a[i];
        }
        int t = a[a.length - 1];
        t += (1 << (32 - tail)) - 1;
        a[a.length - 1] = ~t;
    }

    public boolean all() {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] != -1) {
                return false;
            }
        }
        return Integer.bitCount(a[a.length - 1]) == tail;
    }

    public boolean one() {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                return true;
            }
        }
        return false;
    }

    public int count() {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += Integer.bitCount(a[i]);
        }
        return sum;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length - 1; i++) {
            String s = Integer.toBinaryString(a[i]);
            for (int i1 = 0; i1 < 32 - s.length(); i1++) {
                sb.append('0');
            }
            sb.append(s);
        }
        String s = Integer.toBinaryString(a[a.length - 1]);
        char[] arr = new char[32 - s.length()];
        Arrays.fill(arr, '0');
        s = new String(arr) + s;
        sb.append(s, 0, tail);
        return sb.toString();
    }
}
