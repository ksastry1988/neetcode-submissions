class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;

        int maxLength = nums[0];
        int currLength = nums[0];

        for(int i = 1;  i < nums.length; i++){
            currLength = Math.max(nums[i], currLength + nums[i]);

            maxLength = Math.max(currLength, maxLength);
        }

        return maxLength;


    }
}
