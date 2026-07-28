class Solution {
    static class pair{
        int node;
        int wt;
        public pair(int node, int wt){
            this.node = node;
            this.wt = wt;
        }
    }
    static class pair2 implements Comparable<pair2>{
        int node;
        int distance;
        public pair2(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
        
        @Override
        public int compareTo(pair2 p2){
            return this.distance-p2.distance;
        }
    }
    public int shortestPath(int V, int src, int dest, int[][] edges) {
        // code here
        List<List<pair>> adjlist = new ArrayList<>();
        for(int i= 0; i<V; i++){
            adjlist.add(new ArrayList<>());
            
        }
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adjlist.get(u).add(new pair(v,wt));
            adjlist.get(v).add(new pair(u,wt));
            
        }
        
        
        PriorityQueue<pair2> q = new PriorityQueue<>();
        int dist[] = new int[V+1];
        Arrays.fill(dist,(int)1e8);
        q.add(new pair2(src, 0));
        dist[src] = 0;
        while(!q.isEmpty()){
            pair2 p = q.poll();
            int node = p.node;
            int distance = p.distance;
            for(int i = 0; i<adjlist.get(node).size(); i++){
                pair p2 = adjlist.get(node).get(i);
                int neighbour = p2.node;
                int wt = p2.wt;
                if(distance+wt<dist[neighbour]){
                    dist[neighbour] = distance+wt;
                    q.add(new pair2(neighbour, dist[neighbour]));
                }
                
            }
            
        }
        return dist[dest]==(int)1e8 ? -1 : dist[dest];
    }
    
}