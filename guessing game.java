import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        boolean playAgain = true;
        
        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1; // Random number between 1-100
            int attempts = 0;
            int maxAttempts = 10; // Limit attempts
            boolean guessedCorrectly = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have chosen a number between 1 and 100. Try to guess it!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all attempts. The correct number was: " + targetNumber);
            }

            // Ask if user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thanks for playing! Goodbye.");
        scanner.close();
    }
}
