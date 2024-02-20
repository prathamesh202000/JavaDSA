package DP;
public class StairCase{
    public static int nWays(int n){
        if(n==0 || n==1){
            return 1;
        }

        return nWays(n-1)+nWays(n-2);
    }

    public static int nWaysMemo(int n, int[] dp){
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        return dp[n]=nWays(n-1)+nWays(n-2);
    }

    public static int nWaysTab(int n){
        
        int[] dp=new int[n+1];
        dp[0]=dp[1]=1;

        for(int i=2; i<dp.length; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }

    
    public static void main(String[] args) {
        System.out.println(nWays(5)); //5 221 122 212 2111 1211 1121 1112
        int[] dp=new int[6];
        System.out.println(nWaysMemo(5, dp));
        System.out.println(nWaysTab(5));
    }
}