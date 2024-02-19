import java.util.*;
public class Welcome{

    public static void main(String[] args) {
        System.out.println("Hello World");
        Scanner sc=new Scanner(System.in);

        //Sum of 2 numbers
        // System.out.println("Enter 1st Number");
        // int n1=sc.nextInt();
        // System.out.println("Enter 2st Number");
        // int n2=sc.nextInt();
        //int sum=n1+n2;
        // System.out.println("Sum of two numbers: "+(sum));

        //Simple Interest
        // System.out.println("Enter Principal Amount: ");
        // int p=sc.nextInt();
        // System.out.println("Enter Rate of Interest: ");
        // int r=sc.nextInt();
        // System.out.println("Enter Time period: ");
        // int t=sc.nextInt();
        // int si=(p*r*t)/100;
        // System.out.println("Simple Interest: "+si);


        //Largest of 3 Numbers
        // System.out.println("Enter 1st Number: ");
        // int n1=sc.nextInt();

        // System.out.println("Enter 2nd Number: ");
        // int n2=sc.nextInt();

        // System.out.println("Enter 3rd Number: ");
        // int n3=sc.nextInt();

        // if(n1>n2){
        //     if(n1>n3){
        //         System.out.println("Largest Number: "+n1);
        //     }else{
        //         System.out.println("Largest Number: "+n3);
        //     }
        // }else{
        //     if(n2>n3){
        //         System.out.println("Largest Number: "+n2);
        //     }else{
        //         System.out.println("Largest Number: "+n3);
        //     }
        // }
        
        //prime or not
        // System.out.println("Enter a Number");
        // int n=sc.nextInt();
        //     boolean isPrime=true;
        // for(int i=2; i<n; i++){
        //     if(n%i==0){
        //         isPrime=false;
        //         break;
        //     }
        // }
        // if(isPrime){
        //     System.out.println("It is a prime number");
        // }else{
        //     System.out.println("It is not a prime number");
        // }

        //sum of first N natural Number
        System.out.println("Enter a Number");
        int n=sc.nextInt();
        int sum=0;
        while(n>0){
            sum+=n;
            n--;
        }
        System.out.println("Sum of first "+n+" Natural numbers: "+ sum);
    }
}