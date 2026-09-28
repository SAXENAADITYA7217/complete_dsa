class Solution {
    int t[];
    public int fib(int n) {
        t = new int[n+1];
       Arrays.fill(t,-1);
       return fibo(n);
        
    }
    public int fibo(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(t[n]!=-1){
            return t[n];
        }
        return t[n] = fibo(n-1)+fibo(n-2);
        
    }
}