import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author IronSid
 * @create 2021-04-24 16:00
 */

public class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        if (A == null||B == null) return new ArrayList<String>();
        if(A.length==0) return new ArrayList<String>();
        if(B.length==0) return Arrays.asList(A);

        List<String> uniWords = new ArrayList<>(Arrays.asList(A));
        //用每一个b去遍历检查A中的所有a
        for (int i = 0; i < B.length; i++) {
            if(uniWords.isEmpty()) return uniWords;
            int indexOfA = 0;
            while(!uniWords.isEmpty()&&indexOfA<uniWords.size()){
                //检查B[i]是不是aword的子集
                String aWord = uniWords.get(indexOfA);
                char[] charOfaWord = aWord.toCharArray();
                for (int j = 0; j < B[i].length(); j++) {
                    boolean isb_jINa = false;
                    for (int k = 0; k < charOfaWord.length; k++) {
                        if (charOfaWord[k] == B[i].charAt(j)) {
                            charOfaWord[k] = '0';
                            isb_jINa = true;
                            break;
                        }
                    }
                    if(!isb_jINa){
                        uniWords.remove(aWord);
                        break;
                    }else if (j == B[i].length() - 1) {
                        indexOfA++;
                    }
                }
            }
        }
        return uniWords;
    }

    public static void main(String[] args) {
        String a = new String("Str");
        String b = new String("Str");
        System.out.println(a==b);
        System.out.println(a.equals(b));

    }

}
