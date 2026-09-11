class Solution {
    public int maxArea(int[] heights) {
        
        int maxArea = 0;

        int start = 0, end = heights.length - 1;

        while(start <= end){
            int width = end - start;

            maxArea = Math.max(maxArea, Math.min(heights[start], heights[end]) * width);

            if (heights[end] < heights[start]){
                end--;
            }
            else{
                start++;
            }
        }
        return maxArea;
    }
}
