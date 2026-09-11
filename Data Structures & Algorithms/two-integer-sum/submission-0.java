class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> set = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];

            if(set.containsKey(diff)){
                int val = set.get(diff);
                return new int[]{val, i};
            }
            set.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
}
