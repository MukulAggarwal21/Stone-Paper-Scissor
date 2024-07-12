import java.util.Scanner;

public class main1 {
    private static int gamesPlayed = 0;
    private static int gamesWon = 0;
    private static int gamesLost = 0;
    private static int gamesDrawn = 0;
    private static int userStoneCount = 0;
    private static int userPaperCount = 0;
    private static int userScissorsCount = 0;
    private static int computerStoneCount = 0;
    private static int computerPaperCount = 0;
    private static int computerScissorsCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        
        while (true) {
            System.out.println("\nEnter your choice:");
            System.out.println("1. Play Stone-Paper-Scissors");
            System.out.println("2. View Game Statistics");
            System.out.println("3. Reset Statistics");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");

            int mainChoice;

            try {
                mainChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 to 4.");
                continue;
            }

            switch (mainChoice) {
                case 1:
                    playGame(scanner, userName);
                    break;
                case 2:
                    displayGameStatistics(userName);
                    break;
                case 3:
                    resetStatistics();
                    break;
                case 4:
                    System.out.println("Exiting the game...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 to 4.");
            }
        }
    }

    private static void playGame(Scanner scanner, String userName) {
        System.out.println("\nEnter your choice: \n1. Stone\n2. Paper\n3. Scissors");
        System.out.print("Your choice: ");
        int userChoice;

        try {
            userChoice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a number between 1 to 3.");
            return;
        }

        if (userChoice < 1 || userChoice > 3) {
            System.out.println("Invalid choice! Please enter a number between 1 to 3.");
            return;
        }

        String userChoiceStr = getUserChoiceString(userChoice);
        String computerChoiceStr = generateComputerChoice();

        updateChoiceCounts(userChoiceStr, computerChoiceStr);

        System.out.println(userName + "'s choice: " + userChoiceStr);
        System.out.println("Computer's choice: " + computerChoiceStr);

        String result = determineWinner(userChoiceStr, computerChoiceStr);
        System.out.println(result);

        updateGameStatistics(result);
    }

    private static String getUserChoiceString(int choice) {
        switch (choice) {
            case 1:
                return "Stone";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            default:
                return "";
        }
    }

    private static String generateComputerChoice() {
        int randomNum = (int) (Math.random() * 3) + 1;
        return getUserChoiceString(randomNum);
    }

    private static void updateChoiceCounts(String userChoice, String computerChoice) {
        switch (userChoice) {
            case "Stone":
                userStoneCount++;
                break;
            case "Paper":
                userPaperCount++;
                break;
            case "Scissors":
                userScissorsCount++;
                break;
        }
        switch (computerChoice) {
            case "Stone":
                computerStoneCount++;
                break;
            case "Paper":
                computerPaperCount++;
                break;
            case "Scissors":
                computerScissorsCount++;
                break;
        }
    }

    private static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "It's a draw!";
        } else if ((userChoice.equals("Stone") && computerChoice.equals("Scissors")) ||
                   (userChoice.equals("Paper") && computerChoice.equals("Stone")) ||
                   (userChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }

    private static void updateGameStatistics(String result) {
        gamesPlayed++;
        if (result.contains("win")) {
            gamesWon++;
        } else if (result.contains("draw")) {
            gamesDrawn++;
        } else {
            gamesLost++;
        }
    }

    private static void displayGameStatistics(String userName) {
        System.out.println("\nGame Statistics:");
        System.out.println("Total games played: " + gamesPlayed);
        System.out.println("Games won: " + gamesWon);
        System.out.println("Games lost: " + gamesLost);
        System.out.println("Games drawn: " + gamesDrawn);
        System.out.println(userName + "'s choices:");
        System.out.println("Stone: " + userStoneCount);
        System.out.println("Paper: " + userPaperCount);
        System.out.println("Scissors: " + userScissorsCount);
        System.out.println("Computer's choices:");
        System.out.println("Stone: " + computerStoneCount);
        System.out.println("Paper: " + computerPaperCount);
        System.out.println("Scissors: " + computerScissorsCount);
    }

    private static void resetStatistics() {
        gamesPlayed = 0;
       gamesWon=0;
        gamesLost=0;
       gamesDrawn=0;
       userPaperCount=0;
       userScissorsCount=0;
       userStoneCount=0;
        computerStoneCount=0;
        computerScissorsCount=0;
        computerPaperCount=0;
        System.out.println("statitics has been reset");
    }
}
