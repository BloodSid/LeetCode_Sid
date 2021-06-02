import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author IronSid
 * @create 2021-06-03 2:04
 */
public class test {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(8080);
        Integer[] integers ={};
        Collections.addAll(set,integers );
        System.out.println(set);
    }
}
