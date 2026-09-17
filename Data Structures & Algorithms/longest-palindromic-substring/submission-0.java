class Solution {
    public String longestPalindrome(String s) {

        int[] res = {0, 0};
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        char[] chars = s.toCharArray();

        // Base case 1 - single character
        for(int i=0; i< len; i++){
            dp[i][i] = true;
        }
        // Base case 2 - substring of length 2
        for(int i=0; i< len-1; i++){
            // check if the character are equal
            dp[i][i+1] = chars[i] == chars[i+1];
            if(dp[i][i+1]){
                res = new int[]{i, i+1};
            }
        }

        // Case 3 - substring greater than equal to length 3
        for(int n = 3; n<=len; n++){
            int i = 0;
            for(int j = n - 1; j < len; j++){
                dp[i][j] = dp[i+1][j-1] && (chars[i] == chars[j]);
                if(dp[i][j]){
                    res = new int[]{i, j};
                }
                i++;
            }
        }
        return s.substring(res[0], res[1]+1);
    }
}
