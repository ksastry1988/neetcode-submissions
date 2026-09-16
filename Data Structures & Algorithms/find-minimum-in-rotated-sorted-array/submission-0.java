class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        int min = Integer.MAX_VALUE;

        while(left <= right){
            int mid = (left + right)/2;

            min = Math.min(nums[mid], min);
            if(nums[left] <= nums[mid]){
                if(nums[right] < nums[mid]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
            else{
                if(nums[left] > nums[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
        }
        return min;
    }
}
