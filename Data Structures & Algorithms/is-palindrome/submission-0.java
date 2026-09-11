class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;

        char[] chars = s.toCharArray();

        int start = 0, end = s.length()-1;

        while(start < end){
            char left = chars[start];
            char right = chars[end];

            if(Character.isLetterOrDigit(left) && Character.isLetterOrDigit(right)){
                if(Character.toLowerCase(left) == Character.toLowerCase(right)){
                    start++; 
                    end--; 
                }
                else{
                    return false;
                }
            }
            if(!Character.isLetterOrDigit(left)){
                start++;
            }
            if(!Character.isLetterOrDigit(right)){
                end--;
            }
        }
        return true;
    }
}
