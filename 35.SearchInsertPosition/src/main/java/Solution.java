/**
 * @author IronSid
 * @create 2021-04-24 14:50
 */
public class Solution {
    public int searchInsert(int[] nums, int target){
        for (int index = 0; index < nums.length; index++) {
            if(target>nums[index]){

            }else
                return index;
        }
        return nums.length;
    }
}
