class Solution {
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        // minDist[i] stores the minimum cost required
        // to connect point i to the current MST.
        int[] minDist = new int[n];

        // Keeps track of whether a point has already
        // been included in the MST.
        boolean[] inMST = new boolean[n];

        // Initialize all distances as infinity.
        Arrays.fill(minDist, Integer.MAX_VALUE);

        // Start building the MST from point 0.
        minDist[0] = 0;

        int totalCost = 0;

        // We need to add exactly n points to the MST.
        for (int i = 0; i < n; i++) {

            int u = -1;

            // Find the unvisited point with the
            // smallest connection cost.
            for (int j = 0; j < n; j++) {
                if (!inMST[j] &&
                   (u == -1 || minDist[j] < minDist[u])) {
                    u = j;
                }
            }

            // Include this point in the MST.
            inMST[u] = true;

            // Add its connection cost.
            totalCost += minDist[u];

            // Update the minimum distance of all
            // remaining points.
            for (int v = 0; v < n; v++) {

                if (!inMST[v]) {

                    // Manhattan distance between u and v.
                    int distance =
                        Math.abs(points[u][0] - points[v][0]) +
                        Math.abs(points[u][1] - points[v][1]);

                    // If connecting through u is cheaper,
                    // update the minimum cost.
                    if (distance < minDist[v]) {
                        minDist[v] = distance;
                    }
                }
            }
        }

        return totalCost;
    }
}