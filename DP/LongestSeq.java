package DP;
import java.util.*;
public class LongestSeq {
    public static int lcsRec(String s1, String s2, int n, int m){
        if(n==0 || m==0){
            return 0;
        }

        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return lcsRec(s1, s2, n-1, m-1)+1;
        }else{
            return Math.max(lcsRec(s1, s2, n-1, m), lcsRec(s1, s2, n, m-1));
        }

    }

    public static int lcsMemo(String s1, String s2, int n, int m, int[][] dp){
        if(n==0 || m==0){
            return 0;
        }

        if(dp[n][m]!=0){
            return dp[n][m];
        }

        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return dp[n][m]=lcsRec(s1, s2, n-1, m-1)+1;
        }else{
            return dp[n][m]=Math.max(lcsRec(s1, s2, n-1, m), lcsRec(s1, s2, n, m-1));
        }

    }

    public static int lcsTab(String s1, String s2){
        int[][] dp=new int[s1.length()+1][s2.length()+1];

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[i].length; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
        }
        
    }

    return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1="abcdge";
        String s2="abedg";
        System.out.println(lcsRec(s1, s2, s1.length(), s2.length()));
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        System.out.println(lcsMemo(s1, s2, s1.length(), s2.length(), dp));
        System.out.println(lcsTab(s1, s2));
    }
    
}
