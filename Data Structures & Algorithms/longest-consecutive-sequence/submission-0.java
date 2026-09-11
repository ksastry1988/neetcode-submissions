class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i]))
                set.add(nums[i]);
        }


        int maxLength = 0;
        for(int num: nums){
            if(!set.contains(num - 1)){
                int currNum = num;
                int currentLength = 1;

                while(set.contains(currNum + 1)){
                    currNum = currNum + 1; 
                    currentLength++;
                }
                maxLength = Math.max(currentLength, maxLength);
            }
        }

        return maxLength; 
    }
}
