class Solution {

    // Complexity - O(m*n)
    // Space - O(Min(m, n))
    public int longestCommonSubsequence(String text1, String text2) {

        int[] dp = new int[text2.length()+1];
        
        for(int i = text1.length() - 1; i >=0; i--){
            int prev = 0;
            for(int j = text2.length() - 1; j >=0; j--){
                int temp = dp[j];
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[j] = prev + 1;
                }
                else{
                    dp[j] = Math.max(dp[j], dp[j+1]);
                }
                prev = temp;
            }
        }
        return dp[0];
    }
}
