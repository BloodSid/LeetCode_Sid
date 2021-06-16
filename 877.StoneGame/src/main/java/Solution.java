/**
 * @author IronSid
 * @create 2021-06-16 17:58
 */
public class Solution {
    public boolean stoneGame(int[] piles) {
        return stoneGame(piles,0,piles.length-1,0,0);
    }
    boolean stoneGame(int[] piles, int start, int end,int aSum, int bSum){//a先拿 b后拿
        //1.只剩最后两个
        if(start+1==end){
            if(aSum+piles[start]>bSum+piles[end]||aSum+piles[end]>bSum+piles[start])
                return true;
            else
                return false;
        }
        int aNewSum;
        //2.1 a从头拿
        boolean aStart =
                //b从头拿
                stoneGame(piles, start+2, end, aSum+piles[start], bSum+piles[start+1]) &&
                //b从尾拿
                stoneGame(piles, start+1, end-1, aSum+piles[start], bSum+piles[end]);


        //2.2 a从尾拿
        boolean aEnd =
                //b从头拿
                stoneGame(piles, start+1, end-1, aSum+piles[end], bSum+piles[start]) &&
                //b从尾拿
                stoneGame(piles, start, end-2, aSum+piles[end], bSum+piles[end-1]);
        return aStart||aEnd;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int [] a = {5,3,4,5};
        System.out.println(s.stoneGame(a));
    }
}
