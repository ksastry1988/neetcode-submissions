class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Use monotonic decreasing Queue
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>(); // storing indices
        int[] result = new int[n - k + 1];
        int l = 0; int r = 0;

        while(r < n){
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[r])
            {
                deque.removeLast();
            }
            deque.addLast(r);

            // remove the lst value from window
            if(l > deque.getFirst()){
                deque.removeFirst();
            }

            if(r + 1 >= k){
                result[l] = nums[deque.getFirst()];
                l++;
            }
            r++;
        }
        return result;
    }
}
