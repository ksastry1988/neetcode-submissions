class Solution {
    // public List<List<String>> groupAnagrams(String[] strs) {
    //     if(strs.length == 0) return null;

    //     List<List<String>> result = new ArrayList<>();

    //     Map<String, List<String>> map = new HashMap<>();

    //     for(String s: strs){
    //         char[] temp = s.toCharArray();
    //         Arrays.sort(temp);

    //         String key = String.valueOf(temp);

    //         List<String> currentList;
    //         if(!map.containsKey(key)){
    //             currentList = new ArrayList<>();
    //             currentList.add(s);
    //         }
    //         else{
    //             currentList = map.get(key);
    //             currentList.add(s);
    //         }
    //         map.put(key, currentList);
    //     }

    //     for(Map.Entry<String, List<String>> entry : map.entrySet()){
    //         result.add(entry.getValue());
    //     }

    //     return result;
    // }

    public static List<List<String>> groupAnagrams(String[] strs){

        if (strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> result = new HashMap<>();

        int[] count = new int[26];

        for (String str : strs){
            Arrays.fill(count, 0);
            for (char c: str.toCharArray()){
                int index = c - 'a';
                count[index]++;
            }

            StringBuilder delimiterString = new StringBuilder();
            for (int i = 0; i < 26; i++){
                delimiterString.append("#");
                delimiterString.append(count[i]);
            }

            String key = delimiterString.toString();
            if (!result.containsKey(key)){
                result.put(key, new ArrayList<>());
            }

            result.get(key).add(str);
        }

        return new ArrayList<>(result.values());
    }

}
