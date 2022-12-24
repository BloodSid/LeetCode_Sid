package Contest1224.T2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author IronSid
 * @since 2022-12-24 23:10
 */
public class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] id, int k) {
        HashSet<String> pos = new HashSet<>(), neg = new HashSet<>();
        for (String s : positive_feedback) {
            pos.add(s);
        }
        for (String s : negative_feedback) {
            neg.add(s);
        }
        int n = report.length;
        // 打分
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            String[] s1 = report[i].split(" ");
            for (String s : s1) {
                if (s.length() == 0) continue;
                if (pos.contains(s)) score[i] += 3;
                else if (neg.contains(s)) score[i] -= 1;
            }
        }
        List<Integer> res = new ArrayList<>();
        Integer[] idx = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        Arrays.sort(idx, (o1, o2) -> score[o1] != score[o2] ?  score[o2] - score[o1] : id[o1] - id[o2]);
        for (int i = 0; i < k; i++) {
            res.add(id[idx[i]]);
        }
        return res;
    }
}
