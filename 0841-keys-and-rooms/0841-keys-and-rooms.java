class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean visted[] = new boolean[n];
        dfs(0, rooms,visted);
        
        for(int i = 0; i<visted.length; i++){
            if(!visted[i]){
                return false;
            }
        }
        return true;
        
    }
    public void dfs(int node, List<List<Integer>> adjlist, boolean visted[]){
        visted[node] = true;
        for(int i = 0; i<adjlist.get(node).size(); i++){
            int neighbour = adjlist.get(node).get(i);
            if(!visted[neighbour]){
                visted[neighbour] = true;
                dfs(neighbour, adjlist, visted);
            }
        }
    }
}