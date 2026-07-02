class Solution {
    public boolean findSafeWalk(List<List<Integer>> graph, int health) {

        int n = graph.size();
        int m = graph.get(0).size();
        int dist[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int) 1e8);
        }
        if (graph.get(0).get(0) == 1) {
            dist[0][0] = 1;
        } else {
            dist[0][0] = 0;
        }
        Deque<int[]> q = new ArrayDeque<>();

        q.add(new int[] { 0, 0 });

        while (!q.isEmpty()) {
            int pair[] = q.poll();
            int row = pair[0];
            int col = pair[1];

            int adjlist[][] = { { row + 1, col }, { row - 1, col }, { row, col + 1 }, { row, col - 1 } };
            for (int neighbour[] : adjlist) {
                int newrow = neighbour[0];
                int newcol = neighbour[1];
                if (newrow < 0 || newcol < 0 || newrow >= n || newcol >= m) {
                    continue;
                }
                int newdist = dist[row][col] + graph.get(newrow).get(newcol);
                if (newdist < dist[newrow][newcol]) {
                    dist[newrow][newcol] = newdist;

                    if (graph.get(newrow).get(newcol) == 0) {
                        q.addFirst(new int[] { newrow, newcol });
                    } else {
                        q.addLast(new int[] { newrow, newcol });
                    }
                }

            }
        }

        return (dist[n-1][m-1]<health) ?  true : false;

    }
}