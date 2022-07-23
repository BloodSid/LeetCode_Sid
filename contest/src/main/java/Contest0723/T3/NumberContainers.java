package Contest0723.T3;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * @author IronSid
 * @since 2022-07-23 22:30
 */
public class NumberContainers {

    HashMap<Integer, Integer> hash = new HashMap<>();
    HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();

    public NumberContainers() {}

    public void change(int index, int number) {
        Integer pre = hash.put(index, number);
        if (!map.containsKey(number)) map.put(number, new TreeSet<>());
        map.get(number).add(index);
        if (pre != null && pre != number) {
            map.get(pre).remove(index);
        }
    }

    public int find(int number) {
        if (!map.containsKey(number)) return -1;
        TreeSet<Integer> idx = map.get(number);
        if (idx.isEmpty()) return -1;
        return idx.first();
    }
}
