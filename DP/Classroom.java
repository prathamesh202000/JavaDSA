package DP;
import java.util.*;
public class Classroom {
    public static int fibo(int n){
        if(n==0 || n==1){
            return n;
        }

        return fibo(n-1)+fibo(n-2);
    }

    public static int fiboMemo(int n, int[] dp){
        if(n==0 || n==1){
            return n;
        }

        if(dp[n]!=0){
            return dp[n];
        }

        return dp[n]=fiboMemo(n-1 ,dp)+fiboMemo(n-2, dp);
    }

    public static int fiboTab(int n){
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;

        for(int i=2; i<dp.length; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(fibo(5));
        int[] dp=new int[6];
        System.out.println(fiboMemo(5, dp));
        System.out.println(fiboTab(5));
    }
}
