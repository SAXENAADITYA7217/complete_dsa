class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return pow(x,N);

        
    }
    public double pow(double x, long n){
        if(n<0){
            return 1.0/pow(x,-n);
        }
        if(n==0){
            return 1;
        }
        if(n==1){
            return x;
        }
        double half = pow(x,n/2);
        if(n%2==0){
            return half* half;
        }
        return x*half*half;
    }
}