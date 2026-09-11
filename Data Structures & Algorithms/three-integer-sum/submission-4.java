class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        if(nums.length == 0) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        if(nums[0] > 0) return new ArrayList<>();

        for(int i = 0; i< nums.length - 2; i++){

            if(i > 0 && nums[i] == nums[i-1]) continue; 

            if(nums[i] > 0) break;

            int first = nums[i];

            int start = i + 1;
            int end = nums.length - 1;

            while(start < end){
                int target = nums[i] + nums[start] + nums[end];

                if(target == 0){
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));

                    while(start<end && nums[start] == nums[start+1]) start++;
                    while(start<end && nums[end] == nums[end-1]) end--;
                    start++;
                    end--;
                }
                else if(target > 0){
                    end--;
                }
                else{
                    start++;
                }
            }
        }
        return result;
    }
}
