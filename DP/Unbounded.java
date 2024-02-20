package DP;
import java.util.*;
public class Unbounded {
    public static int unboundedKnapsack(int[] val, int wt[], int W){
        int[][] dp=new int[val.length+1][W+1];

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[i].length; j++){
                if(wt[i-1]<=j){
                    dp[i][j]=Math.max(val[i-1]+dp[i][j-wt[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[val.length][W];
    }
    public static void main(String[] args) {
        int[] val={15,14,10,45,30};
        int[] wt={2,5,1,3,4};
        System.out.println(unboundedKnapsack(val, wt, 7));
    }
}
