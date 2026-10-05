class Solution {
    // For a graph to be Tree
    // Can't have loops
    // Every node is connected
    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n - 1) return false;

        if(edges.length == 0 || n == 0) return true;


        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i< n ; i ++){
            adj.add(new ArrayList<>());
        }
        Set<Integer> visited = new HashSet<>();

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        if(!dfs(0, -1, adj, visited))
            return false;

        return visited.size() == n;
    }

    public boolean dfs(int node, int parent, List<List<Integer>> adj, Set<Integer> visited){
        if(visited.contains(node)){
            return false;
        }

        visited.add(node);
        for(int neig: adj.get(node)){
            if(neig == parent) continue;

            if(!dfs(neig, node, adj, visited)){
                return false;
            }
        }
        return true;
    }
}
