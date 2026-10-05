class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>
        ((a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1]));
        int[][] result = new int[k][2];

        for(int[] point: points){
            queue.offer(point);
            if(queue.size() > k){
                queue.poll();
            }
        }

        int count = 0;

        while(!queue.isEmpty()){
            result[count++] = queue.poll();
        }

        return result;
    
    }
}
