package JavaBasics;
import java.util.*;
public class AdvancedPatters {
    public static void hollowRect(int a, int b){
        for(int i=0; i<a; i++){
            for(int j=0; j<b; j++){
                if(i==0 || j==0 || i==a-1 || j==b-1){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void inv_Rot_HalfPyramid (int n){
        for(int i=1; i<=n ;i++){
            for(int j=1; j<=n-i; j++){
                System.out.print("  ");
            }
            for(int j=1; j<=i ; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void inv_HalfPyramid(int n){
        for(int i=0; i<n ;i++){
            for(int j=1; j<=n-i; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public static void floydTraingle(int n){
        int dig=1;
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                System.out.print((dig++)+" ");
            }
            System.out.println();
        }
    }

    public static void zeroOneTriangle(int n){
        for(int i=0; i<n; i++){
            for(int j=0 ;j<=i; j++){
                if((i+j)%2==0){
                    System.out.print(1+" ");
                }else{
                    System.out.print(0+" ");
                }
                
            }
            System.out.println();
        }
    }
    public static void butterflyPatter(int n){
        for(int i=0; i<n ; i++){
            for(int j=0; j<=i; j++){
                System.out.print("* ");
            }
            for(int j=0; j<2*(n-i-1); j++){
                System.out.print("  ");
            }
            for(int j=0; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }

        for(int i=0; i<n ; i++){
            for(int j=0; j<n-i; j++){
                System.out.print("* ");
            }
            for(int j=0; j<2*(i); j++){
                System.out.print("  ");
            }
            for(int j=0; j<n-i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        
    }

    public static void hollowRhombus(int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n-i-1; j++){
                System.out.print("  ");
            }
            for(int j=0; j<n; j++){
                if(i==0 || j==0 || i==n-1 || j==n-1){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }

            }
            System.out.println();
        }
    }

    public static void solidRhombus(int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n-i-1; j++){
                System.out.print("  ");
            }
            for(int j=0; j<n; j++){
                
                    System.out.print("* ");
                

            }
            System.out.println();
        }
    }

    public static void diamond(int n){
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                System.out.print("  ");
            }
            for(int j=0; j<(2*i)+1; j++){
                System.out.print("* ");
            }
            System.out.println();
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                System.out.print("  ");
            }
            for(int j=0; j<(2*(n-i-1)+1); j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void numberPyramid(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print("  ");
            }
            for(int j=1; j<=i; j++){
                System.out.print(i+" ");
                System.out.print("  ");
            }
            System.out.println();
        }
    }
    public static void palindromicPyramid(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print("  ");
            }
            for(int j=1; j<=i; j++){
                System.out.print(i-j+1+" ");
            }
            for(int j=2; j<=i; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        hollowRect(4, 5);
        inv_Rot_HalfPyramid(5);
        inv_HalfPyramid(5);
        floydTraingle(5);
        zeroOneTriangle(5);
        butterflyPatter(5);
        solidRhombus(5);
        hollowRhombus(5);
        diamond(5);
        numberPyramid(5);
        palindromicPyramid(5);
    }
}
