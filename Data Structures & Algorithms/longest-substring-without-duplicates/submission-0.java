class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;

        int maxLength = 0;

        int currLength = 0;

        char[] chars = s.toCharArray();

        Map<Character, Integer> tempStore = new HashMap<>();

        int start = 0;

        for(int i = 0 ; i < chars.length; i++){
            char currChar = chars[i];

            if(tempStore.containsKey(currChar)){
                start = Math.max(start, tempStore.get(currChar) + 1);
            }

            tempStore.put(currChar, i);
            currLength = i - start + 1;
            maxLength = Math.max(currLength, maxLength);
        }
        return maxLength;
    }
}
