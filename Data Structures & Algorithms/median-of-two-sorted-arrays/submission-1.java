class Solution {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int num: nums1){
            insert(num);
        }
        for(int num: nums2){
            insert(num);
        }

        return getMedian();

    }

    public void insert(int num){
        if(maxHeap.isEmpty() || num <= maxHeap.peek())
        {
            maxHeap.offer(num);
        }
        else{
            minHeap.offer(num);
        }

        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.offer(maxHeap.poll());
        }
        else if(minHeap.size() > maxHeap.size()){
            
            maxHeap.offer(minHeap.poll());
        }
    }

    public double getMedian(){
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }
        else 
            return (double)maxHeap.peek();
    }
}
