class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for(Character c:s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(Character c: t.toCharArray()){
            if(map.containsKey(c)){
                int newVal = map.get(c) - 1;
                if(newVal > 0){
                    map.put(c, newVal);
                }
                else{
                    map.remove(c);
                }
            }
            else{
                return false;
            }
        }

        if(map.size() > 0) return false;

        return true;
    }
}
