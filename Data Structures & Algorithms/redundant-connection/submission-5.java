class Solution {
    public int[] findRedundantConnection(int[][] edges) {
    int n = edges.length;
    UnionFind uf = new UnionFind(n+1);
    for( int [] edge: edges){
        int u = edge[0];
        int v = edge[1];
        if(uf.find(u) == uf.find(v)){
         return edge;
        }
        uf.union(u, v);
    }
    return new int[0];
}
}

class UnionFind{
        int[] parent;
        int[] rank;
        UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i =1; i<n ;i++)
                parent[i] = i;
        }
        int find(int x){
            if(parent[x]!=x){
                parent[x] = find(parent[x]);
            }
         return parent[x];
        }
        void union(int x, int y){
            int px= find(x);
            int py = find(y);

            if(px==py)
                return;
            
            if(rank[px]<rank[py]){
                parent[px] =py;
            } else if(rank[py]< rank[px]){
                parent[py] =px;
            } else{
                parent[px] =py;
                rank[py]++;
            }
        }
    }


