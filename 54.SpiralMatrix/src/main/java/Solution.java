import java.util.ArrayList;
import java.util.List;

/**
 * @author IronSid
 * @create 2021-06-16 17:12
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int xMin = 0, yMin = 0;
        int xMax = matrix.length - 1, yMax = matrix[0].length - 1;
        List<Integer> list = new ArrayList<>(matrix[0].length * matrix.length);
        while (true) {
            for (int i = yMin; i <= yMax; i++) {
                list.add(matrix[xMin][i]);
            }
            xMin++;
            if(xMax<xMin) break;

            for (int i = xMin; i <= xMax; i++) {
                list.add(matrix[i][yMax]);
            }
            yMax--;
            if(yMax<yMin) break;

            for (int i = yMax; i >= yMin; i--) {
                list.add(matrix[xMax][i]);
            }
            xMax--;
            if(xMax<xMin) break;

            for (int i = xMax; i >= xMin; i--) {
                list.add(matrix[i][yMin]);
            }
            yMin++;
            if(yMax<yMin) break;

        }

        return list;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        List l =s.spiralOrder(s.generateMatrix(4));
//        System.out.println(l.size());
//        System.out.println(l);

        int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List l =s.spiralOrder(a);
        System.out.println(l.size());
        System.out.println(l);
    }
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int xMin=0,yMin=0;
        int xMax=result[0].length-1,yMax=result.length-1;
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


}