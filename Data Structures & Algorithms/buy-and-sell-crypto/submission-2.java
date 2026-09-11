class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;

        int maxProfit = 0;

        int start = 1, end = prices.length - 1;

        int buy = prices[0];

        for(int i = 1; i<= end; i++){
            int diff = prices[i] - buy;
            maxProfit = Math.max(maxProfit, diff);
            buy = Math.min(buy, prices[i]);
        } 
        return maxProfit;
    }
}
