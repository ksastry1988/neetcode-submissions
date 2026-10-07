class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, result, curr);
        return new ArrayList<>(result);
    }

    public void dfs(int[] nums, int i, Set<List<Integer>> result, List<Integer> curr){
        if(i >= nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        dfs(nums, i+1, result, curr);
        curr.remove(curr.size()-1);
        dfs(nums, i+1, result, curr);
    }
}
