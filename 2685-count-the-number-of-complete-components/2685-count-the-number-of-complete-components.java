class Solution {
    int edge;
    int vertex;

    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adjlist = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjlist.add(new ArrayList<>());
        }
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            adjlist.get(u).add(v);
            adjlist.get(v).add(u);
        }
        int count = 0;
        boolean visted[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visted[i]) {
                edge = 0;
                vertex = 0;

                dfs(i, adjlist, visted);
                if (edge/2 == (vertex * (vertex - 1)) / 2) {
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int node, List<List<Integer>> adjlist, boolean visted[]) {
        visted[node] = true;
         edge += adjlist.get(node).size();
        vertex++;
        
        for (int i = 0; i < adjlist.get(node).size(); i++) {
            int neighbour = adjlist.get(node).get(i);
            if (!visted[neighbour]) {
                dfs(neighbour, adjlist, visted);
            }
        }
       
    }
}