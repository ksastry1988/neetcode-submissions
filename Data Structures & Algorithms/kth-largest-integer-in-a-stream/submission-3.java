class KthLargest {
    PriorityQueue<Integer> priorityQueue;
    int kCounter;
    public KthLargest(int k, int[] nums) {
        priorityQueue = new PriorityQueue<>((a, b) -> a - b);
        kCounter = k;

        for(int num : nums){
            priorityQueue.offer(num);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
    }
    
    public int add(int val) {
        priorityQueue.offer(val);
        if(priorityQueue.size() > kCounter){
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }
}
