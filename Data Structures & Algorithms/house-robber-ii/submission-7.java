class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 0) return 0;
        if(n==1) return nums[0];

        int excludeFirstHouse = robRange(nums, 1, n-1);
        int excludeLastHouse = robRange(nums, 0, n-2);

        return Math.max(excludeFirstHouse, excludeLastHouse);
    }

    public int robRange(int[] nums, int start, int end){
        int length = end - start +1;

        int[] lookupTable = new int[length+1];

        lookupTable[0] = 0;
        lookupTable[1] = nums[start];

        for (int i = 2; i <= length; i++) {
            int currentHouse = nums[start + i - 1];
            lookupTable[i] = Math.max(lookupTable[i - 1], currentHouse + lookupTable[i - 2]);
        }

        return lookupTable[length];
    }
}
