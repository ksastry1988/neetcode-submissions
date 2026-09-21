class Solution {
    List<List<Integer>> result; 
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        
        List<Integer> curr = new ArrayList<>();

        backtrack(nums, target, 0, curr, 0);
        return result;
    }

    public void backtrack(int[] nums, int target, int total, List<Integer> curr, int index){
        if(target == total){
            result.add(new ArrayList<>(curr));
            
        }

        for(int i = index; i<nums.length; i++){
            if(total + nums[i] > target) return;
            curr.add(nums[i]);
            backtrack(nums, target, total+nums[i], curr, i);
            curr.remove(curr.size() - 1);
        }
    }
}
