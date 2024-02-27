package Arrays;
import java.util.*;
public class Subarrays {
    public static int maxSubArraySum(int[] arr){
        int ans=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                int sum=0;
                for(int k=i; k<=j; k++){
                   sum+=arr[k];
                }
                ans=Math.max(ans, sum);
            }
            
        }
        return ans;
    }
    public static int maxSubArraySum2(int[] arr){
        int[] prefixSum=new int[arr.length];
        prefixSum[0]=arr[0];
        for(int i=1; i<arr.length; i++){
            prefixSum[i]=prefixSum[i-1]+arr[i];
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0; i<prefixSum.length; i++){
            for(int j=i; j<prefixSum.length; j++){
                
                ans=Math.max(ans, (i==0)?prefixSum[j]:prefixSum[j]-prefixSum[i-1]);
            }
        }
        return ans;
    }

    public static int KadanesAlgo(int[] arr){
        int ans=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            if(sum<0){
                sum=0;
            }
            ans=Math.max(ans, sum);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={1,-2,6,-1,3};
        System.out.println(maxSubArraySum(arr));
        System.out.println(maxSubArraySum2(arr));
        System.out.println(KadanesAlgo(arr));
    }
}
