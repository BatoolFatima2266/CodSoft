import java.util.Random;
import java.util.Scanner;
public class NumberGame {
    static Scanner sc=new Scanner(System.in);
    static int rand=0;
    static int Usernumber=0;
    public static void main(String[] args){
        Random random=new Random();
        rand=random.nextInt(4);
        for (int limit=1;limit<=5;limit++){
            guessNumber();
            if(Usernumber==rand){
                System.out.println("You find number in "+limit+ " attempt.");
                break;
            }
        }
    }
    static void guessNumber(){
        System.out.println("Please enter the number");
        Usernumber=sc.nextInt();
        if(Usernumber==rand){
            System.out.println("Win");
        }
        else if(Usernumber<rand){
            System.out.println("too low");
        }
        else {
            System.out.println("too high");
        }
    }
}
