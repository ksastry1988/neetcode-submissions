class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0) return List.of(new ArrayList<>());

        List<List<Integer>> perms = permute(Arrays.copyOfRange(nums, 1, nums.length));

        List<List<Integer>> result = new ArrayList<>();
    
        
        for(List<Integer> perm : perms){
            for(int i = 0 ; i <= perm.size(); i++){
                List<Integer> perm_copy = new ArrayList<>(perm);
                perm_copy.add(i, nums[0]);
                result.add(perm_copy);
            }
        }
        return result;
    }
}
