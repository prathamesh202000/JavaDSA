package Arrays;
import java.util.*;
public class Search {
    public static int linearSearch(int[] arr, int n){
        for(int  i=0; i<arr.length; i++){
            if(arr[i]==n){
                return i;
            }
        }
        return -1;
    }

    public static int largest(int[] arr){
        int max=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            max=Math.max(max, arr[i]);
        }
        return max;
    }

    public static int smallest(int[] arr){
        int min=Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            min=Math.min(min, arr[i]);
        }
        return min;
    }

    public static int binarySearch(int[] arr, int n){
        int si=0;
        int ei=arr.length-1;

        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(arr[mid]==n){
                return mid;
            }else if(arr[mid]<n){
                si=mid+1;
            }else{
                ei=mid-1;
            }
        }
        return -1;
    }

    public static void reverse(int[] arr){
        for(int i=0;i<arr.length/2; i++){
            int temp=arr[i];
            arr[i]=arr[arr.length-i-1];
            arr[arr.length-i-1]=temp;
        }
    }
    public static void printArr(int[] arr){
        for(int  i=0;i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void pairs(int[] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                System.out.print("("+arr[i]+","+arr[j]+")");
            }
            System.out.println();    
        }
    }

    public static void subArr(int[] arr){
        for(int i=0;i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                System.out.print("(");
                for(int k=i; k<=j; k++){
                    if(k==j){
                        System.out.print(arr[k]);    
                    }else{
                        System.out.print(arr[k]+",");
                    }
                   
                }
                if(j==arr.length-1){
                    System.out.print(")");
                }else{
                    System.out.print(")"+", ");
                }
                
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] arr={2,4,6,8,10,12,14,16};
        System.out.println(linearSearch(arr, 10));
        System.err.println(largest(arr));
        System.out.println(smallest(arr));
        System.out.println(binarySearch(arr, 10));
        printArr(arr);
        reverse(arr);
        printArr(arr);
        pairs(arr);
        subArr(arr);
    }
}