class Solution {

    static final long mod = 1000000007;
    
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = n/2;
        long evenpos = pow(5,even);
        long oddpos = pow(4,odd);
        long ans = (evenpos*oddpos)%mod;
        return (int)ans;

        
    }
    public long pow(int x, long n){
        
        if(n==0){
            return 1;
        }
        if(n==1){
            return x;
        }
        long half = pow(x,n/2);
        if(n%2==0){
            return (half*half)%mod;
        }
        return (x * half*half)%mod;

    }
}