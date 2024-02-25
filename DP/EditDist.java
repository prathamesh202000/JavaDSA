package DP;
import java.util.*;
public class EditDist {
    public static int transform(String s1, String s2){
        int n=s1.length();
        int m=s2.length();

        int dp[][]=new int[n+1][m+1];

        for(int i=0;i<dp.length; i++){
            dp[i][0]=i;
        }
        for(int i=0;i<dp[0].length; i++){
            dp[0][i]=i;
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[i].length; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
                }
            }
        }
        return dp[n][m];
    }

    public static int stringConversion(String s1, String s2){
        int[][] dp=new int[s1.length()+1][s2.length()+1];

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[i].length; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
                }

            }
        }

        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[i].length;j++){
        //         System.err.print(dp[i][j]);
        //     }
        //     System.err.println();
        // }
        return s1.length()+s2.length()-(2*dp[dp.length-1][dp[0].length-1]);
    }
    public static void main(String[] args) {
    String s1="intention";
    String s2="execution";
    System.out.println(transform(s1, s2));        
        System.out.println(stringConversion(s1, s2));
}
}
