import java.util.Scanner;

public class ScannerMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = (int) (Math.random() * 10);
        int guess;

        do{
            System.out.println("Please enter 1 to 10 : ");
            guess = scanner.nextInt();
        }while(guess != number);

        System.out.println("Congradulation");
    }
}
