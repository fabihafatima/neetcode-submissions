class Solution {
    public int countComponents(int n, int[][] edges) {
            int connected =0;
            List<List<Integer>> graph = new ArrayList<>();
            for(int i =0; i<n; i++){
                graph.add(new ArrayList<>());
            }
            for(int edge[]: edges){
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }
            boolean[] visited = new boolean[n];        
            for(int i =0; i<n; i++){
                if(!visited[i]){
                    connected++;
                    dfs(i, visited,graph);
                }
            }
            return connected;
    }
    private void dfs(int node, boolean[] visited, List<List<Integer>> graph){
        visited[node] = true;
        for(int neighbor: graph.get(node)){
            if(!visited[neighbor]){
             dfs(neighbor, visited,graph);
            }
        }

    }
}
