package Contest0507.T2;

import java.util.HashMap;

/**
 * @author IronSid
 * @since 2023-05-07 10:39
 */
public class FrequencyTracker {
    private final HashMap<Integer, Integer> f;
    private final HashMap<Integer, Integer> ff;

    public FrequencyTracker() {
        f = new HashMap<>();
        ff = new HashMap<>();
    }

    public void add(int number) {
        f.merge(number, 1, Integer::sum);
        int freq = f.get(number);
        if (freq > 1) ff.merge(freq - 1, -1, Integer::sum);
        ff.merge(freq, 1, Integer::sum);
    }

    public void deleteOne(int number) {
        if (f.getOrDefault(number, 0) > 0) {
            f.merge(number, -1, Integer::sum);
            int freq = f.get(number);
            ff.merge(freq + 1, -1, Integer::sum);
            if (freq > 0) ff.merge(freq, 1, Integer::sum);
        }
    }

    public boolean hasFrequency(int frequency) {
        return ff.getOrDefault(frequency, 0) > 0;
    }
}
