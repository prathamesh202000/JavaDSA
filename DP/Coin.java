package DP;
import java.util.*;
public class Coin {
    public static int coinChangeWays(int[] coins, int cost){
        int[][] dp=new int[coins.length+1][cost+1];
        for(int i=0; i<dp.length; i++){
            dp[i][0]=1;
        }
        for(int i=0; i<dp[0].length; i++){
            dp[0][i]=0;
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1;j<dp[i].length; j++){
                if(coins[i-1]<=j){
                    dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[coins.length][cost];
    }
    public static void main(String[] args) {
        int[] coins={2,5,3,6};
        int cost=10;
        System.out.println(coinChangeWays(coins, cost));        
    }
}
