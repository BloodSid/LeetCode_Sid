package Contest1001.T2;

/**
 * @author IronSid
 * @since 2022-10-01 22:39
 */
public class LUPrefix {

    private final boolean[] load;
    private int idx = 0;

    public LUPrefix(int n) {
        load = new boolean[n];
    }

    public void upload(int video) {
        load[video - 1] = true;
    }

    public int longest() {
        while (idx < load.length && load[idx]) idx++;
        return idx;
    }

}
