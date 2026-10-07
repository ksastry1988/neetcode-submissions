class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        Arrays.sort(candidates);
        dfs(candidates, target, 0, result, curr, 0);
        return result;
    }

    public void dfs(int[] nums, int target, int total, List<List<Integer>> result, List<Integer> curr, int index){
        if(total == target){
            result.add(new ArrayList(curr));
        }

        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i-1]) continue;

            if(total + nums[i] > target) return;
            curr.add(nums[i]);
            dfs(nums, target, total + nums[i], result, curr, i+1);
            curr.remove(curr.size() - 1);
        }
    }
}
