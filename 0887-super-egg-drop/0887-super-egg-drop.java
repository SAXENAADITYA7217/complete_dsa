class Solution {
    int t[][];
    public int superEggDrop(int k, int n) {
        t = new int[n+1][k+1];
        for(int i = 0; i<t.length; i++){
            for(int j = 0; j<t[0].length; j++){
            Arrays.fill(t[i],-1);
            }
        }
        return solve(n,k);
        
    }
    public int solve(int f, int e){
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

            int left = solve(mid-1, e-1);
            int right = solve(f-mid, e);
            int temp = 1+ Math.max(left, right);
            min = Math.min(min, temp);
            if(left<right){
                low = mid+1;
            }
            else{
                high = mid-1;
            }

        }
        return t[f][e] =  min;
        
    }
}