package DP;
import java.util.*;
public class TargetSum {
    public static boolean targetSum(int[] arr, int n){
        boolean[][] dp=new boolean[arr.length+1][n+1];

        for(int i=0; i<dp.length; i++){
            dp[i][0]=true;
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[i].length; j++){
                if(arr[i-1]<=j && dp[i-1][j-arr[i-1]]){
                        dp[i][j]=true;
                }else if(dp[i-1][j]){
                    dp[i][j]=true;
                }
            }
        }

        return dp[arr.length][n];

    }
    public static void main(String[] args) {
        int[] arr={4,2,7,1,3};
        int sum=10;
        System.out.println(targetSum(arr, sum));
    }
}