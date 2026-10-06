class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        dfs(nums, 0, curr, res);
        return res;
    }

    public void dfs(int[] nums, int i, List<Integer> curr, List<List<Integer>> res){
        if(i >= nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        dfs(nums, i + 1, curr, res);
        curr.remove(curr.size() - 1);
        dfs(nums, i + 1, curr, res);

    }
}
