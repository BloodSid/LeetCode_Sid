/**
 * @author IronSid
 * @create 2021-04-24 14:50
 */
public class Solution {
    public int searchInsert(int[] nums, int target){
        for (int index = 0; index < nums.length-1; index++) {
            if(nums[index]>target){
                index++;
            }else if(nums[index]==target){
                return index;
            }else return index--;
        }
        return nums.length;
    }
}
