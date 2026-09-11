class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        //Min-heap with capacity k
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) ->
                map.get(a) - map.get(b)
        );

        for(int num: map.keySet()){
            queue.offer(num);
            if(queue.size() > k){
                queue.poll();
            }
        }

        int count = 0;
        int[] result = new int[k];
        while(!queue.isEmpty()){
            result[count] = queue.poll();
            count++;
        }
        return result;
    }
}
