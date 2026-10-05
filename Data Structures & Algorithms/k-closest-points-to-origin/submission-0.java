class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        int[][] result = new int[k][2];

        for(int[] point : points){
            int distance = Math.abs(
                point[0] * point[0] + point[1] * point[1]);
            queue.offer(new int[]{distance, point[0], point[1]});
        }

        for(int i = 0 ; i < k; i++){
            int[] point = queue.poll();
            result[i] = new int[]{point[1], point[2]};
        }
        return result;
    
    }
}
