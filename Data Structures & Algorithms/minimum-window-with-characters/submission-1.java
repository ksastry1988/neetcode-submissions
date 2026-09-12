class Solution {
    public static String minWindow(String s, String t) {

        Map<Character, Integer> hm = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            hm.put(t.charAt(i), hm.getOrDefault(t.charAt(i), 0) + 1);
        }

        int i = 0;
        int j = 0;

        int found = 0;
        int minLen = Integer.MAX_VALUE;

        String res = "";

        while(j < s.length()){
            if(hm.containsKey(s.charAt(j))){
                if(hm.get(s.charAt(j)) > 0){
                    found++;
                }
                hm.put(s.charAt(j), hm.get(s.charAt(j)) - 1);
            }

            while(found == t.length()){
                if(j - i + 1 < minLen){
                    minLen = j - i + 1;
                    res = s.substring(i, j+1);
                }

                char left = s.charAt(i);

                if(hm.containsKey(left)){
                    hm.put(left, hm.get(left) + 1);
                    if(hm.get(left) > 0){
                        found --;
                    }
                }
                i++;
            }
            j++;
        }
        return res;

    }
}
