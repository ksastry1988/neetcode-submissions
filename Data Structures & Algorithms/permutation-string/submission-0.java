class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false; 

        Map<Character, Integer> map = new HashMap<>();

        for(char ch: s1.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int left = 0;
        for(int right = 0; right < s2.length(); right++){
            int diff = right - left + 1;
            if(diff == s1.length()){
                if(isPermutation(map, s2.substring(left, right+1))) return true;
                else{
                    left++;
                }
            }
        }
        return false;
    }

    public boolean isPermutation(Map<Character, Integer> map, String subStrS2){
        Map<Character, Integer> map2 = new HashMap<>(); 
        for(char ch: subStrS2.toCharArray()){
            map2.put(ch, map2.getOrDefault(ch, 0)+1);
        }

        return map.equals(map2);
    }
}
