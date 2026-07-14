class Solution {
    int t[][][];
    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        t = new int[n+1][200+1][200+1];
        for(int i = 0; i<t.length; i++){
            for(int j = 0; j<t[0].length; j++){
                Arrays.fill(t[i][j], -1);
            }
        }
        return solve(nums,0,0,0);


    }
    public int solve(int arr[], int i, int g1, int g2){
        if(i==arr.length){
            if(g1!=0 && g2!=0 && g1==g2){
                return 1;
            }
            return 0;

        }
        if(t[i][g1][g2]!=-1){
            return t[i][g1][g2];
        }
        int nottake = solve(arr,i+1, g1, g2);
        int takeseq1 = solve(arr, i+1,gcd(g1, arr[i]), g2);
        int takeseq2 = solve(arr, i+1,g1, gcd(g2, arr[i]));
        long count = ((long)nottake + takeseq1 + takeseq2) % 1000000007;
        return t[i][g1][g2] =  (int)count;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }
}