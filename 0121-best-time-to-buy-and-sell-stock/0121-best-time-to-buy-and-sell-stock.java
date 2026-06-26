class Solution {
    public int maxProfit(int[] price) {
        int buyprice = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0; i<price.length; i++){
            if(price[i]>buyprice){
                ans = Math.max(ans, price[i]-buyprice);
            }
            else{
                buyprice = price[i];
            }
        }
        return ans;

        
    }
}