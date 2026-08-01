class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visted[] = new boolean[rooms.size()];
        int count = 0;
        for(int i = 0; i<visted.length; i++){
            if(!visted[i]){
                dfs(i, rooms, visted);
                count++;
            }
        }
     
        return count==1;
    
        
    }
    public void dfs(int node, List<List<Integer>> adjlist , boolean visted[]){
        visted[node] = true;
        for(int i = 0; i<adjlist.get(node).size(); i++){
            int neighbour = adjlist.get(node).get(i);
            if(!visted[neighbour]){
                dfs(neighbour, adjlist, visted);
            }
        }
    }
}