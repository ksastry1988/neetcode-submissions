class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false; 

        int[] need = new int[26];
        int[] window = new int[26];
        int s1Len = s1.length();

        for(char ch: s1.toCharArray()){
            need[ch - 'a']++;
        }
        int count = 0;
        int leftIndex = 0; 
        for(char ch: s2.toCharArray()){
            window[ch - 'a']++;
            count++;
            if(count == s1Len){
                if(matches(need, window)){
                    return true;
                }
                else{
                    char leftChar = s2.charAt(leftIndex);
                    window[leftChar - 'a']--;
                    count--;
                    leftIndex++;
                }
            }

        }
        return false;
    }

    public boolean matches(int[] need, int[] window){
        for(int i = 0; i < need.length; i++){
            if(need[i] != window[i]){
                return false;
            }
        }

        return true;
    }
}
