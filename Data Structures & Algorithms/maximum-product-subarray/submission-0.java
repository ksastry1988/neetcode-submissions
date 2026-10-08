class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int result = Integer.MIN_VALUE;

        int currMax = 1; int currMin = 1;

        for(int n : nums){

            int tempMax = currMax * n;
            int tempMin = currMin * n;
            currMax = Math.max(Math.max(tempMax, tempMin), n);
            currMin = Math.min(Math.min(tempMax, tempMin), n);

            result = Math.max(currMax, result);

        }
        return result;
    }
}
