class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxValue = 0; 

        for(int pile: piles){
            maxValue = Math.max(maxValue, pile);
        }

        int left = 1; 
        int right = maxValue;

        while (left < right){
            int mid = (left + right)/2;
            int hours = 0;
            for(int pile: piles){
                hours += (pile + mid - 1)/mid; // Ceiling
            }

            if(hours <= h){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
}
