class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return null;

        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs){
            char[] temp = s.toCharArray();
            Arrays.sort(temp);

            String key = String.valueOf(temp);

            List<String> currentList;
            if(!map.containsKey(key)){
                currentList = new ArrayList<>();
                currentList.add(s);
            }
            else{
                currentList = map.get(key);
                currentList.add(s);
            }
            map.put(key, currentList);
        }

        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            result.add(entry.getValue());
        }

        return result;
    }

}
