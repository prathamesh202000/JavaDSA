package Arrays;
import java.util.*;
public class Assignments {
    public static boolean containsDuplicates(int arr[]){
        HashSet<Integer> set=new HashSet<>();
        for(int i=0; i<arr.length; i++){
            if(set.contains(arr[i])){
                return true;
            }else{
                set.add(arr[i]);
            }
        }
        return false;
    }
    public static int binarySerarchMod(int[] arr, int key){
        int minIdx=findMin(arr);
        if(arr[0]<=key && key<=arr[minIdx-1]){
           return binarSearch(arr, key, 0, minIdx-1);
        }else{
            return binarSearch(arr, key, minIdx, arr.length-1);
        }
    }

    public static int findMin(int[] arr){
        int si=0;
        int ei=arr.length-1;

        while(si<ei){
            int mid=si+(ei-si)/2;
            if(mid>0 && arr[mid-1]>arr[mid]){
                return mid;
            }else if(arr[si]<=arr[mid] && arr[mid]>arr[ei]){
                si=mid+1;
            }else{
                ei=mid-1;
            }
        }
        return si;
    }

    public static int binarSearch(int[] arr, int key, int si, int ei){
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(arr[mid]==key){
                return mid;
            }else if(arr[mid]<key){
                si=mid+1;
            }else{
                ei=mid-1;
            }
        }
        return -1;
    }
    public static int trappingRainwaterMod(int[] height){
        int l=0;
        int r=height.length-1;
        int maxL=height[0];
        int maxR=height[height.length-1];
        int water=0;
        while(l<r){
            if(maxL<maxR){
                l++;
                maxL=Math.max(maxL, height[l]);
                water+=(maxL-height[l]);
            }else{
                r--;
                maxR=Math.max(maxR, height[r]);
                water+=(maxR-height[r]);
            }
        }
        return water;
    }

    public static List<List<Integer>> triplets(int[] arr){
        ArrayList<List<Integer>> result=new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                for(int k=j+1; k<arr.length; k++){
                    if(arr[i]+arr[j]+arr[k]==0){
                        ArrayList<Integer> triplet=new ArrayList<>();
                        triplet.add(arr[i]);
                        triplet.add(arr[j]);
                        triplet.add(arr[k]);
                        Collections.sort(triplet);
                        result.add(triplet);
                    }
                }
            }
        }
       // System.out.println(result);
        result=new ArrayList<List<Integer>>(new HashSet<List<Integer>>(result));
        return result;
    }
    public static void main(String[] args) {
        int[] arr1={1,2,3,1};
        int[] arr2={1,2,3,4};
        int[] ro={4,5,6,7,0,1,2};
        int key=0;
        System.out.println(containsDuplicates(arr1));
        System.out.println(containsDuplicates(arr2));
        System.out.println(binarySerarchMod(ro, key));
        int height[]={4,2,0,6,3,2,5};
        System.out.println(trappingRainwaterMod(height));
        int[] nums={-1,0,1,2,-1,-4};
        System.out.println(triplets(nums));
    }
}
