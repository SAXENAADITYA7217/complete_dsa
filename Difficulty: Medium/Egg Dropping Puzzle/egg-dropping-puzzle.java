class Solution {
   static int t[][];
    static int eggDrop(int n, int k) {
        // code here
        t = new int[k+1][n+1];
        for(int i = 0; i<t.length; i++){
            Arrays.fill(t[i],-1);
        }
        return solve(k,n);
        
    }
    static int solve(int f, int e){
        if(f==0 || f==1 || e==1){
            return f;
        }
        if(t[f][e]!=-1){
            return t[f][e];
        }
        int min = Integer.MAX_VALUE;
        int low = 1;
        int high = f;
        while(low<=high){
            int mid = low+(high-low)/2;
            int breaks = solve(mid-1, e-1);
            int notbreak = solve(f-mid, e);
            int temp = 1+ Math.max(breaks, notbreak);
            min = Math.min(min , temp);
            if(breaks<notbreak){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
            
        }
        
        return t[f][e] =  min;
    }
}