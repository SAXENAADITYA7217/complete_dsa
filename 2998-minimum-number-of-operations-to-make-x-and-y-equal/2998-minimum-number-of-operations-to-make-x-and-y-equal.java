class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        if(x==y){
            return 0;
        }
        if(x<y){
            return y-x;
        }
        int limit = 2* Math.max(x,y)+30;
        boolean visted[]  = new boolean[limit];
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        int count = 0;

        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i<size; i++){
                int curr = q.poll();
                if(curr==y){
                    return count;
                }

                if(curr-1>=0 && !visted[curr-1]){
                    q.add(curr-1);
                    visted[curr-1] = true;
                }
                if(curr+1<limit && !visted[curr+1]){
                    q.add(curr+1);
                    visted[curr+1]  = true;
                }
                if(curr%5==0 && !visted[curr/5]){
                    q.add(curr/5);
                    visted[curr/5] = true;
                }
                if(curr%11==0 && !visted[curr/11]){
                    q.add(curr/11);
                    visted[curr/11] = true;
                }

            }
            count++;
        }
        return count;
        
    }
}