class Solution {
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int n = nums.length;

        int[] lookupTable = new int[n];

        lookupTable[0] = nums[0];
        lookupTable[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            lookupTable[i] = Math.max(lookupTable[i - 1], nums[i] + lookupTable[i - 2]);
        }

        return lookupTable[n - 1];
    }
}
