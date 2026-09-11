class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        if(nums.length == 0) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        if(nums[0] > 0) return new ArrayList<>();

        for(int i = 0; i< nums.length; i++){

            int first = nums[i];

            int start = i + 1;
            int end = nums.length - 1;

            while(start < end){
                int target = nums[i] + nums[start] + nums[end];

                if(target == 0){
                    List<Integer> curr = new ArrayList<>();
                    curr.add(nums[i]);
                    curr.add(nums[start]);
                    curr.add(nums[end]);
                    if(!result.contains(curr))
                        result.add(curr);
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
