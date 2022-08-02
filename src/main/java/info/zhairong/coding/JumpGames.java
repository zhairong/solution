package info.zhairong.coding;

/**
 * You are given an integer array nums. You are initially positioned at the
 * array's first index, and each element in the array represents your maximum
 * jump length at that position.
 * 
 * Return true if you can reach the last index, or false otherwise. Example 1:
 * 
 * Input: nums = [2,3,1,1,4] Output: true Explanation: Jump 1 step from index 0
 * to 1, then 3 steps to the last index.
 * 
 * Example 2:
 * 
 * Input: nums = [3,2,1,0,4] Output: false Explanation: You will always arrive
 * at index 3 no matter what. Its maximum jump length is 0, which makes it
 * impossible to reach the last index.
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 104 0 <= nums[i] <= 105
 * 
 * 
 * @author zhairong
 *
 */
public class JumpGames {
	
	public boolean canJumpSolutionOptimizer(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            } else { // if i>rightmost, the rest can be ignored.
                break;
            }
        }
        return false;
	}
	public boolean canJumpSolution(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

	// begin from big one, but this is not a right thinking. 
	public boolean canJump(int[] nums) {
        if(nums.length==1) {
            return true;
        }
		return canJump(0, nums);
	}
	
	private boolean canJump(int index, int[] nums) {
        if(nums[index]==0) {
            return false;
        }
		for(int i=nums[index]; i>0;i--) {
            if(i+index>=nums.length-1) {
                return true;
            }
            
			if(canJump(i+index, nums)){
				return true;
			}	
		}
		return false;
	}
}
