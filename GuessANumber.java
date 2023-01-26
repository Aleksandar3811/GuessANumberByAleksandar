import java.util.Random;
import java.util.Scanner;

public class GuessANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random randomNumber = new Random();
        int computerNumber = randomNumber.nextInt(50);
        System.out.println("Do you want to play ");
        String input = scanner.nextLine();
        int num = 50;
        while (!input.equals("No")) {
            for (int levels = 1; levels <= 5; levels++) {
                computerNumber += 50;
                num += 50;
                boolean isGuessed = false;
                int tries = 10;
                int countTries = 0;
                while (!isGuessed) {

                    if (countTries == tries) {
                        System.out.println("You lose the game");
                        break;
                    }
                    System.out.printf("Guess a number from 0 to %d\n", num);

                    System.out.printf("You have %d tries\n", tries - countTries);
                    String playerInput = scanner.nextLine();
                    boolean isValid = true;
                    for (int i = 0; i < playerInput.length(); i++) {
                        if (playerInput.charAt(i) < 48 || playerInput.charAt(i) > 57) {
                            isValid = false;
                            break;
                        }
                    }
                    if (isValid) {
                        int playerNumber = Integer.parseInt(playerInput);
                        countTries += 1;
                        if (computerNumber == playerNumber) {

                            System.out.println("You guessed the number");

                            isGuessed = true;
                        } else if (playerNumber > computerNumber) {
                            System.out.println("Too high");
                        } else {
                            System.out.println("Too low");
                        }
                    } else {
                        System.out.println("Invalid Input");
                    }
                }

                System.out.println("Congratulations!");
                System.out.println("Do you want to play on the next level?");
                String answer2 = scanner.nextLine();
                if (answer2.equals("No")) {
                    System.out.println("Have a great day:)");
                    input = answer2;
                    break;
                }
            }

        }

    }
}