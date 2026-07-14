class Solution {
    public int findGCD(int[] nums) {
        int ans = 0;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            low = Math.min(low, nums[i]);
            high = Math.max(high, nums[i]);
        }
        return gcd(low, high);
        
    }
    public int gcd(int a, int b){
        while(b!=0){
            int rem  = a%b;
            a = b;
            b = rem;
        }
        return a;
    }


}