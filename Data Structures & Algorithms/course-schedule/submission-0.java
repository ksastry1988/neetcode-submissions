class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for(int[] pre: prerequisites){
            preMap.computeIfAbsent(pre[0], v->new ArrayList<>()).add(pre[1]);
        }

        for(int i = 0; i< numCourses; i++){
            if(!dfs(i, preMap, visited)) return false;
        }

        return true;
    }

    public boolean dfs(int course, Map<Integer, List<Integer>> map, Set<Integer> visited){
        if(visited.contains(course)) return false; 

        if(!map.containsKey(course) || map.get(course).isEmpty())
        {
            return true;
        }

        visited.add(course);
        List<Integer> currPreReq = map.get(course);

        for(Integer pre: currPreReq){
            if(!dfs(pre, map, visited)) {
                return false;
            }
        }
        visited.remove(course);
        map.put(course, new ArrayList());

        return true;
    }

}
