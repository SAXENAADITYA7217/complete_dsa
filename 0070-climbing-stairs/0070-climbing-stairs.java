class Solution {
    int t[];
    public int climbStairs(int n) {
        t = new int[n+1];
        Arrays.fill(t,-1);
        return climb(n);
        
    }
    public int climb(int n){
        if(n==0 || n==1){
            return 1;
        }
        if(t[n]!=-1){
            return t[n];
        }
        int oneway = climb(n-1);
        int twoway = climb(n-2);
        return t[n]  =  oneway+twoway;
    }
}