class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int [] indegree = new int[numCourses];
        for(int i =0; i<numCourses; i++){
            graph.add(new ArrayList<>(i));
        }
        int[] ans = new int[numCourses];
        int counter=0;
        Queue <Integer> queue = new LinkedList<>();
        for(int []pre: prerequisites){
            int a = pre[0];
            int b = pre[1];
            graph.get(b).add(a);
            indegree[a]++;
        }
        for(int i =0; i< numCourses; i++){
            if(indegree[i]== 0){
                queue.offer(i);
            }
        }
        int completed = 0;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            ans[counter++] = curr;
            completed++;

            for (int next : graph.get(curr)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        if (completed != numCourses) {
            return new int[0];
        }
        return ans;
    }
}
