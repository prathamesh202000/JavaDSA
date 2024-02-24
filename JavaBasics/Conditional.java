package JavaBasics;
import java.util.*;
public class Conditional {
    public static void max(int a, int b){
        if(a>b){
            System.out.println("Max: "+a);

        }else{
            System.out.println("Max: "+b);
        }
    }

    public static void isEven(int a){
        if(a%2==0){
            System.out.println("Even");
        }else{
            System.out.println("Odd");
        }
    }
    
    public static double calc(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1st Number: ");
        int n1=sc.nextInt();
        System.out.println("Enter 2nd Number: ");
        int n2=sc.nextInt();
        System.out.println("Enter the operation +, -, *, /");
        String op=sc.next();
        double ans=0;
        switch(op){
            case "+":ans=(n1+n2);
                        break;
            case "-":ans=(n1-n2);
                        break;
            case "*":ans=(n1*n2);
                        break;
            case "/":ans=(n1/n2);
                        break;
            default:System.out.println("Please enter Valid Opertion");

        }
        return ans;
    }

    public static void Day(int n){
        String[] days={"Sunday","Monday","Tuesday","Wednesday","Thirsday","Friday","Saturday"};
        System.out.println(days[n-1]);
    }
    
    public static void main(String[] args) {
        max(2, 7);
        isEven(4);

       
        // int income=sc.nextInt();
        // int tax=0;
        // if(income<500000){
        //     tax=0;
        // }else if(income>=500000 && income<1000000){
        //     tax=(int)(0.2*income);
        // }else{
        //     tax=(int)(0.3*income);
        // }
        // System.out.println(tax);
        //System.out.println(calc());
            Day(1);
    }
}
