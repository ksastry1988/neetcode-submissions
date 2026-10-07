class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, result, curr);
        return result;
    }

    public void dfs(int[] nums, int i, List<List<Integer>> result, List<Integer> curr){
        result.add(new ArrayList(curr));

        for(int j = i; j < nums.length; j++){
            if(j > i && nums[j] == nums[j-1]) continue;
            curr.add(nums[j]);
            dfs(nums, j+1, result, curr);
            curr.remove(curr.size()-1);
        }
    }
}
