class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List <List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int [] pre: prerequisites){
           int a = pre[0];
           int b = pre[1];
           graph.get(b).add(a);
           indegree[a]++;
        }
        int completed = 0;
        Queue <Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
         }
         while(!queue.isEmpty()){
                int curr = queue.poll();
                completed++;
                for (int next : graph.get(curr)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
                }
            }
        return completed == numCourses;
    }
}
