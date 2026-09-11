class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a,b)-> a.getValue() - b.getValue());

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            queue.offer(entry);
            if(queue.size() > k){
                queue.poll();
            }
        }

        int count = 0;
        int[] result = new int[k];
        while(!queue.isEmpty()){
            result[count] = queue.poll().getKey();
            count++;
        }
        return result;
    }
}
