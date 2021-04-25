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
            for (String aWord : uniWords) {
                //检查B[i]是不是aword的子集
                for (int j = 0; j < B[i].length(); j++) {
                    char[] charOfaWord = aWord.toCharArray();
                    boolean isb_jINa = false;
                    for (char chr :
                            charOfaWord) {
                        if (chr == B[i].charAt(j)) {
                            chr = '0';
                            isb_jINa = true;
                            break;
                        }
                    }
                    if(isb_jINa=false){
                        uniWords.remove(aWord);
                    }
                }
            }
        }
        return uniWords;
    }

    public static void main(String[] args) {


    }

}
