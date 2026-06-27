class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build adjacency list
        List<int[]>[] graph = new ArrayList[n+1];

        for(int i =1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : times){
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[] {0, k});
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int time = curr[0];
            int node = curr[1];
            if(time>dist[node])
                continue;
            
            for(int[] neighbor: graph[node]){
                int next = neighbor[0];
                int weight = neighbor[1];
                if(dist[next]> time + weight){
                    dist[next] = time + weight;
                    pq.offer(new int[]{dist[next], next});
                }
              }
            }

        int ans =0;
        for(int i =1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE)
                return -1;

            ans = Math.max(ans, dist[i]);
        }     
        return ans;   
    
    }

}

