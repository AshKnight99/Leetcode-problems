/*
322. Coin Change
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
Example 1:
Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
Example 2:
Input: coins = [2], amount = 3
Output: -1 
*/
class Solution {
    public int coinChange(int[] coins, int amount) {
         if(coins == null || coins.length == 0 || amount == 0) {
            return 0;
        }
        int value[] = new int[amount + 1];
        Arrays.fill(value,Integer.MAX_VALUE);
        int coin_val[] = new int [amount + 1];
        value[0] = 0;
        coin_val[0] = 0;        
        for(int i = 0; i < coins.length;i++){          
            for(int j = 0;j < amount + 1;j++){
                if(j >= coins[i] &&  value[j - coins[i]] != Integer.MAX_VALUE){
                    value[j] = Math.min(value[j],value[j - coins[i]] + 1);
                    coin_val[j] = coins[i];
                }                                       
            }               
        }  
        /*
       int l = amount;        
        while(l > 0 && coin_val[l] > 0){
        System.out.print(coin_val[l] + ",");        
        l -= coin_val[l];
        }   
       */       
        return value[amount]== Integer.MAX_VALUE? -1 : value[amount];           
    }
}