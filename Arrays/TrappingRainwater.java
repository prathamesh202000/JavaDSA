package Arrays;
import java.util.*;
public class TrappingRainwater {
    public static int trappingRainwater(int[] height){
        int[] maxLeft=new int[height.length];
        maxLeft[0]=height[0];
        int[] maxRight=new int[height.length];
        maxRight[height.length-1]=height[height.length-1];
        for(int i=1; i<height.length; i++){
            maxLeft[i]=Math.max(maxLeft[i-1], height[i]);
        }
        for(int i=height.length-2; i>=0; i--){
            maxRight[i]=Math.max(maxRight[i+1], height[i]);
        }

        int water=0;
        for(int i=0; i<height.length; i++){
            water+=(Math.min(maxLeft[i], maxRight[i])-height[i]);
        }
        return water;
    }
    public static void main(String[] args) {
        int height[]={4,2,0,6,3,2,5};
        System.err.println(trappingRainwater(height));    
        
    }
}
