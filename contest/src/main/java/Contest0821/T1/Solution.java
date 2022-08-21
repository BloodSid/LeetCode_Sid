package Contest0821.T1;

/**
 * @author IronSid
 * @since 2022-08-21 9:54
 */
public class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int n = energy.length;
        int ex = initialExperience;
        int eg = initialEnergy;
        int cost = 0;
        for (int i = 0; i < n; i++) {
            if (ex <= experience[i]) {
                cost += experience[i] - ex + 1;
                ex = experience[i] + 1;
            }
            if (eg <= energy[i]) {
                cost += energy[i] - eg + 1;
                eg = energy[i] + 1;
            }
            ex += experience[i];
            eg -= energy[i];
        }
        return cost;
    }
}
