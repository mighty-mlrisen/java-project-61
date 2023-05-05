package hexlet.code;

import java.util.Scanner;

class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n" + "2 - Even\n" + "0 - Exit");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your choice: ");
        int number = scanner.nextInt();
        switch (number) {
            case 0:
                break;
            case 1:
                Cli.greeting();
                break;
            case 2:
                Even.startingGame();
                break;
        }
    }
}
