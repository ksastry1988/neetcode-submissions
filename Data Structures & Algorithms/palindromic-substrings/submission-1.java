class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        if(len == 0) return 0;

        boolean[][] dp = new boolean[len][len];

        for(int i = 0; i < len; i++){
            dp[i][i] = true;
        }

        for(int i = 0; i< len-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
            }
        }

        for(int n = 3; n<= len; n++){
            for(int i = 0; i<= len-n;i++){
                int j = n+i - 1;
                if(dp[i+1][j-1] && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                }
            }
        }

        int countSubstrings = 0; 
        for(int i = 0; i< dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(dp[i][j]){
                    countSubstrings++;
                }
            }
        }
        return countSubstrings;
    }
}
