import java.util.Arrays;


/**
 * @author IronSid
 * @create 2021-06-16 16:20
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int xMin=0,yMin=0;
        int xMax=result.length-1,yMax=result[0].length-1;
        int tem = 1;
        while(xMax>=xMin){
            for (int i = yMin; i <= yMax; i++) {
                result[xMin][i]=tem;
                tem++;
            }
            xMin++;


            for (int i = xMin; i <= xMax; i++) {
                result[i][yMax]=tem;
                tem++;
            }
            yMax--;


            for (int i = yMax; i >= yMin; i--) {
                result[xMax][i]= tem;
                tem++;
            }
            xMax--;


            for (int i = xMax; i >= xMin; i--) {
                result[i][yMin]=tem;
                tem++;
            }
            yMin++;


        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] r = solution.generateMatrix(4);
        for (int[] ints : r) {
            System.out.println(Arrays.toString(ints));
        }
    }
}