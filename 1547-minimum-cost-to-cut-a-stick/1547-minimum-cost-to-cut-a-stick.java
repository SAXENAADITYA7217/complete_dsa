class Solution {
    int t[][];
    public int minCost(int n, int[] cuts) {
        ArrayList<Integer> list = new ArrayList<>();
        int m = cuts.length;
        t = new int[m+1][m+1];
        for(int i = 0; i<t.length; i++){
            Arrays.fill(t[i],-1);
        }
        list.add(0);
        list.add(n);
        for(int i = 0; i<cuts.length; i++){
            list.add(cuts[i]);
        }
        Collections.sort(list);
        return solve(1,cuts.length,list);
        
    }
    public int solve(int i, int j , List<Integer> list){
        if(i>j){
            return 0;
        }
        if(t[i][j]!=-1){
            return t[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k = i; k<=j; k++){
            int cost = list.get(j+1)-list.get(i-1);
            int left = solve(i,k-1,list);
            int right = solve(k+1,j,list);
            min = Math.min(min, cost+left+right);
        }
        return t[i][j] =  min;
    }
}