class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < stones.length; i++){
            queue.offer(stones[i]);
        }

        while(!queue.isEmpty() && queue.size()>1){
            int first = queue.poll();
            int second = queue.poll();

            if(first > second){
                int diff = Math.abs(first - second);
                queue.offer(diff);
            }
        }
        return !queue.isEmpty() ? queue.poll() : 0;
    }
}
