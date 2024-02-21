package DP;
import java.util.*;
public class Rod {
    
    public static int MaxCost(int[] cost,int[] part, int length){
        int[][] dp=new int[cost.length+1][length+1];
        for(int i=0; i<dp.length; i++){
            dp[i][0]=0;
        }
        for(int i=0; i<dp[0].length; i++){
            dp[0][i]=0;
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1;j<dp[i].length; j++){
                if(part[i-1]<=j){
                    dp[i][j]=Math.max(cost[i-1]+dp[i][j-part[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[cost.length][length];
    }
    public static void main(String[] args) {
        int[] cost={1,5,8,9,10,17,17,20};
        int[] part={1,2,3,4,5,6,7,8};
        int length=8;
        System.out.println(MaxCost(cost, part, length));        
    }
}
