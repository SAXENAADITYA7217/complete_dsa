class Solution {
    int t[][];
    public int maxCoins(int[] nums) {
         t = new int[nums.length][nums.length];
         for(int i = 0; i<t.length; i++){
            Arrays.fill(t[i],-1);
         }

       return solve(nums, 0, nums.length-1);
        
    }
    int solve(int arr[], int i, int j){
        if(i>j){
            return 0;
        }
        if(t[i][j]!=-1){
            return t[i][j];
        }
        int ans = 0;
        for(int k= i; k<=j; k++){
            int left = solve(arr, i, k-1);
            int right = solve(arr, k+1, j);
            int coins = 0;
            if(i==0 && j== arr.length-1){
                coins = arr[k];
            }
            else if(i==0){
                coins = arr[k] * arr[j+1];
            }
            else if(j==arr.length-1){
                coins = arr[i-1]*arr[k];
                
            }
            else{
                coins = arr[i-1]*arr[k]*arr[j+1];
            }
            ans = Math.max(ans, left+ coins+right);

            
        }
        return t[i][j] =  ans;
    }
}