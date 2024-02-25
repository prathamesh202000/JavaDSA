package JavaBasics;
import java.util.*;
public class Functions {
    public static int product(int a, int b){
        return a*b;
    }
    public static int factorial(int n){
        int ans=1;
        while(n>0){
            ans*=n;
            n--;
        }
        return ans;
    }

    public static int binCoeff(int n, int r){
        int n_fact=factorial(n);
        int r_fact=factorial(r);
        int n_r_fact=factorial(n-r);

        return n_fact/(r_fact*n_r_fact);
    }
    public static boolean isPrime(int n){
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void primesInRange(int a, int b){
        for(int i=a; i<=b; i++){
            if(isPrime(i)){
                System.out.print(i+" ");
            }
        }
    }

    public static int binToDec(int bin){
        int pow=0;
        int dec=0;
        while(bin>0){
            int digit=bin%10;
            dec+=(digit*Math.pow(2, pow));
            pow++;
            bin/=10;
        }
        return dec;
    }

    public static int decToBin(int dec){
        int pow=0;
        int bin=0;
        while(dec>0){
            int bit=dec%2;
            bin+=(bit*Math.pow(10, pow));
            pow++;
            dec/=2;
        }
        return bin;
    }

    public static int Average(int a, int b, int c){
        return (a+b+c)/3;
    }

    public static boolean isEven(int n){
        if(n%2==0){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean isPalindrome(int n){
        int n1=n;
        int n2=0;
        while(n>0){
            int digit=n%10;
            n2=n2*10+(digit);
            n/=10;
        }

        return n1==n2;
    }

    public static int sumOfDigits(int n){
        int ans=0;
        while(n>0){
            int digit=n%10;
            ans+=digit;
            n/=10;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(product(3, 4));
        System.out.println(factorial(5));
        System.out.println(binCoeff(5, 2));
        System.out.println(isPrime(4));
        primesInRange(2, 100);
        System.out.println();
        System.out.println(binToDec(110));
        System.out.println(decToBin(7));
        System.out.println(Average(4, 5, 6));
        System.out.println(isEven(5));
        System.out.println(isPalindrome(12321));
        System.out.println(sumOfDigits(1234));
    }

}
