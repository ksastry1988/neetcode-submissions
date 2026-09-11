class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;

        int maxLength = 0;
        int maxFrequency = 0;
        int windowSize = 0;

        int charsToReplace = 0;

        Map<Character, Integer> freq = new HashMap<>();

        for(right = 0; right < s.length() ; right++){
            freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right), 0) + 1);

            maxFrequency = Math.max(maxFrequency, freq.get(s.charAt(right)));

            windowSize = right - left + 1;
            charsToReplace = windowSize - maxFrequency;

            while(charsToReplace > k){
                freq.put(s.charAt(left), freq.get(s.charAt(left)) - 1);
                left ++;
                windowSize = right - left + 1;
                charsToReplace = windowSize - maxFrequency;
            }
            maxLength = Math.max(maxLength, windowSize);
        }
        return maxLength;
    }
}
