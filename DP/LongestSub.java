package DP;
import java.util.*;
public class LongestSub {
    public static int LCString(String s1, String s2){
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        int ans=0;
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[i].length; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    ans=Math.max(ans, dp[i][j]);
                }else{
                    dp[i][j]=0;
                }
            }
        }
        // for(int i=0; i<dp.length; i++){
        //     for(int j=0; j<dp[i].length; j++){
        //         System.out.print(dp[i][j]);
        //     }
        //     System.err.println();
        // }
        return ans;
    }

    public static int lis(int[] nums){
        HashSet<Integer> set=new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        int[] sort=new int[set.size()];
        int i=0;
        for(int n: set){
            sort[i]=n;
            i++;
        }
        Arrays.sort(sort);
        return lcs(nums, sort);
    }

    public static int lcs(int[] n1, int[] n2){
        int[][] dp=new int[n1.length+1][n2.length+1];

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[i].length; j++){
                if(n1[i-1]==n2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n1.length][n2.length];
    }
    public static void main(String[] args) {
        String s1="abcde";
        String s2="abdge";
        System.err.println(LCString(s1, s2));;
        int[] nums={50,3,10,7,40,80};
        System.out.println(lis(nums));

    }
}
