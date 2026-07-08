class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adjlist) {
        
        boolean visted[] = new boolean[adjlist.size()];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<visted.length; i++){
            if(!visted[i]){
                dfs(i, list, adjlist,visted);
            }
            
        }
        return list;
        
    }
    public void dfs(int node, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> adjlist, boolean visted[]){
        visted[node] = true;
        list.add(node);
        for(int i = 0; i<adjlist.get(node).size(); i++){
            int neighbour = adjlist.get(node).get(i);
            if(!visted[neighbour]){
                dfs(neighbour, list, adjlist, visted);
            }
        }
    }
}