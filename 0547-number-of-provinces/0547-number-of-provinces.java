class Solution {
    public int findCircleNum(int[][] graph) {

        int n = graph.length;
        boolean visted[] = new boolean[n];
        int count = 0;
        for(int i = 0; i<visted.length; i++){
            if(!visted[i]){
                dfs(i,graph, visted);
                count++;
            }
        }
        return count;
        
    }
    public void dfs(int node, int graph[][], boolean visted[]){
        visted[node] = true;
        for(int i = 0; i<graph[node].length; i++){
            if(graph[node][i]==1 && !visted[i]){
                dfs(i, graph,visted);
            }
        }
    }
}