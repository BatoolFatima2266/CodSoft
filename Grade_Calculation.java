import java.util.Scanner;
public class Grade_Calculation {
    static float avg=0.0f;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of subjects");
        int ts=sc.nextInt();
        int arr[]=new int[ts];
        System.out.println("Please enter the number you get:");
        for (int i=0;i<ts;i++){
            arr[i]= sc.nextInt();
        }
        float sum=0.0f;
        for (int i=0;i<ts;i++){
            sum+= arr[i];
        }
        avg=((sum)/(ts*100))*100;
        System.out.println("The total numbers are: "+sum);
        System.out.println("The average percentage is: "+avg);
        grade();

    }
    static void grade(){
        if(avg>=90 && avg <= 100){
            System.out.println("Grade is A+.");
        }
        else if(avg>=80 && avg < 90){
            System.out.println("Grade is A.");
        }
        else if(avg>=70 && avg < 8){
            System.out.println("Grade is B.");
        }
        else if(avg>=60 && avg < 70){
            System.out.println("Grade is C.");
        }
        else if(avg>=50 && avg < 60){
            System.out.println("Grade is D.");
        }
        else {
            System.out.println("Grade is F.");
        }
    }
}
