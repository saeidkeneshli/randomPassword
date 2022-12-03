import java.util.Scanner;

public class Generator {

    Alphabet alphabet;
    public static Scanner keyboard;

    public Generator(Scanner scanner) {
        keyboard = scanner;
    }

    public Generator(boolean IncludeUpper, boolean IncludeLower, boolean IncludeNum) {
        alphabet = new Alphabet(IncludeUpper, IncludeLower, IncludeNum);
    }

    public void mainLoop() {
        System.out.println("Welcome! plz choose what you want: ");
        printMenu();

        String userOption = "-1";

        while (!userOption.equals("3")) {

            userOption = keyboard.next();
            switch (userOption) {
                case "1":
                    createPassword();
                case "2":
                    printMenu();
                    break;
                case "3":
                    System.out.println("I hope you enjoy.");
                    break;
                default:
                    System.out.println("plz enter valid number.");
                    break;
            }
        }

    }

    private void printMenu() {
        System.out.println("1. Create a random password.");
        System.out.println("2. menu");
        System.out.println("3. Exit");
    }

    private void createPassword() {
        boolean IncludeUpper = false;
        boolean IncludeLower = false;
        boolean IncludeNum = false;

        System.out.println("Do you want Lowercase letters \"abcd...\" to be used? ");
        String input = keyboard.next();

        if (isInclude(input)) IncludeLower = true;

        System.out.println("Do you want Uppercase letters \"ABCD...\" to be used? ");
        input = keyboard.next();

        if (isInclude(input)) IncludeUpper = true;

        System.out.println("Do you want Numbers \"1234...\" to be used? ");
        input = keyboard.next();

        if (isInclude(input)) IncludeNum = true;

        //No Pool Selected
        if (!IncludeUpper && !IncludeLower && !IncludeNum) {
            System.out.println("You have selected no characters to generate your " +
                    "password at least one of your answers should be Yes");

            return;
        }

        System.out.println("Great! Now enter the length of the password");
        int length = keyboard.nextInt();

        if (length <= 0){
            System.out.println("Invalid Length!");
            return;
        }

        final Generator generator = new Generator(IncludeUpper, IncludeLower, IncludeNum);
        final Password password = generator.GeneratePassword(length);

        System.err.println("Your generated password -> " + password);

    }

    private boolean isInclude(String Input) {
        if (Input.equalsIgnoreCase("yes")) {
            return true;
        } else {
            if (!Input.equalsIgnoreCase("no")) {
                System.out.println("You have entered something incorrect let's go over it again \n");
            }
            return false;
        }
    }

    private Password GeneratePassword(int length) {
        final StringBuilder pass = new StringBuilder("");

        final int alphabetLength = alphabet.getAlphabet().length();

        int max = alphabetLength - 1;
        int min = 0;
        int range = max - min + 1;

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * range) + min;
            pass.append(alphabet.getAlphabet().charAt(index));
        }

        return new Password(pass.toString());
    }
}
