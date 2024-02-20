package DP;
import java.util.*;
public class Knapsack {
    public static int zeroOneKnapsack(int[] val, int[] wt, int W, int i){
        if(i==val.length){
            return 0;
        }
        if(wt[i]<=W){
            return Math.max(zeroOneKnapsack(val, wt, W-wt[i], i+1)+val[i], zeroOneKnapsack(val, wt, W, i+1));
        }else{
            return zeroOneKnapsack(val, wt, W, i+1);
        }
    }

    public static int zeroOneKnapsackMemo(int[] val, int[] wt, int W, int n, int[][] dp){
        if(n==0 || W==0){
            return 0;
        }
        if(wt[n-1]<=W){
            return dp[n][W]=Math.max(zeroOneKnapsackMemo(val, wt, W-wt[n-1], n-1, dp)+val[n-1], zeroOneKnapsackMemo(val, wt, W, n-1, dp));
        }else{
            return dp[n][W]=zeroOneKnapsackMemo(val, wt, W, n-1,dp);
        }

    }

    public static int zerOneKnapsackTab(int[] val, int[] wt, int W ){
        int[][] dp=new int[val.length+1][W+1];

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[i].length; j++){
                if(wt[i-1]<=j){
                    dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
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

    System.out.println(zeroOneKnapsack(val, wt, 7, 0));
        int[][] dp=new int[val.length+1][8];
        System.out.println(zeroOneKnapsackMemo(val, wt, 7, val.length, dp));
        System.out.println(zerOneKnapsackTab(val, wt, 7));
    }
}
