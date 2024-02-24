package JavaBasics;
import java.util.*;
public class StarPatterns {
    public static void IncStars(int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void DecStars(int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n-i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void HalfPyramid(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public static void CharHalfPyramid(int n){
        char ch='A';
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(ch+" ");
                ch=(char)(ch+1);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        IncStars(5);
        DecStars(5);
        HalfPyramid(5);
        CharHalfPyramid(5);
    }
}
