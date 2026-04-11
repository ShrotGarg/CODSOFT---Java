import java.util.Scanner;
public class Task1{
    public static void main(String[] args){
        boolean flag = true;
        int guess = 0;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter range (min to max): ");
        int min = sc.nextInt();
        int max = sc.nextInt();

        do{
            int num = (int)(Math.random() * (max - min + 1)) + min;
            int ans = -1;

            while(num != ans){
                guess++;

                System.out.print("Enter guess: ");
                ans = sc.nextInt();

                if(ans > num)
                    System.out.println("Think lower");
                else if(ans < num)
                    System.out.println("Think higher");
                else{
                    System.out.println("Nice Guess!");
                    System.out.printf("it toook you %d num of guesses \n", guess);
                    sc.nextLine();
                    System.gc();

                    System.out.println("Would you like to play again? (yes or no): ");

                    if(sc.nextLine().equalsIgnoreCase("yes"))
                        flag = true;
                    else
                        flag = false;
                }
            }
        } while(flag);

        sc.close();

    }
}