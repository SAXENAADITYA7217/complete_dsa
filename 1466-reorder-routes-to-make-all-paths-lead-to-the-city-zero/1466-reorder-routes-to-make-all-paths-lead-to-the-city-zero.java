class Solution {
    int count = 0;

    static class pair {
        int neigh;
        int direction;

        public pair(int neigh, int direction) {
            this.neigh = neigh;
            this.direction = direction;
        }
    }

    public int minReorder(int n, int[][] connections) {
        List<List<pair>> adjlist = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjlist.add(new ArrayList<>());
        }
        for (int edge[] : connections) {
            int u = edge[0];
            int v = edge[1];
            adjlist.get(u).add(new pair(v, 1));
            adjlist.get(v).add(new pair(u, 0));
        }

        boolean visted[] = new boolean[n];
        dfs(0, adjlist, visted);
        return count;

    }

    public void dfs(int node, List<List<pair>> adjlist, boolean visted[]) {
        visted[node] = true;
        for (int i = 0; i < adjlist.get(node).size(); i++) {
            pair p2 = adjlist.get(node).get(i);
            int neighbour = p2.neigh;
            int direction = p2.direction;

            if (!visted[neighbour]) {
                if (direction == 1) {
                    count++;

                }
                dfs(neighbour, adjlist, visted);
            }
        }
    }
}