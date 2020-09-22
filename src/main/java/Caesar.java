import java.util.Scanner;

public class Caesar {
    public static String encryptCaesar(String message) {
        String result = "";
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) >= 65 && message.charAt(i) <= 90)
                if (message.charAt(i) + 3 > 90 )
                    result += (char) (message.charAt(i) + 3 - 26);
                else
                    result += (char) (message.charAt(i) + 3);
            else if (message.charAt(i) >= 97 && message.charAt(i) <= 122)
                if (message.charAt(i) + 3 > 122 )
                    result += (char) (message.charAt(i) + 3 - 26);
                else
                    result += (char) (message.charAt(i) + 3);
            else
                result += message.charAt(i);
        }
        return result;
        // REPLACE THIS WITH YOUR CODE
    }

    public static String decryptCaesar(String message) {
        String result = "";
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) >= 65 && message.charAt(i) <= 90)
                if (message.charAt(i) - 3 < 65 )
                    result += (char) (message.charAt(i) - 3 + 26);
                else
                    result += (char) (message.charAt(i) - 3);
             else if (message.charAt(i) >= 97 && message.charAt(i) <= 122)
                if (message.charAt(i) - 3 < 97 )
                    result += (char) (message.charAt(i) - 3 + 26);
                else
                    result += (char) (message.charAt(i) - 3);
            else
                result += message.charAt(i);
        }
        return result;
    }

    public static String encryptCaesarKey(String message, int key) {
        String result = "";
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) >= 65 && message.charAt(i) <= 90)
                if (message.charAt(i) + (key % 26) > 90 )
                    result += (char) (message.charAt(i) + (key % 26) - 26);
                else
                    result += (char) (message.charAt(i) + (key % 26));
            else if (message.charAt(i) >= 97 && message.charAt(i) <= 122)
                if (message.charAt(i) + (key % 26) > 122 )
                    result += (char) (message.charAt(i) + (key % 26) - 26);
                else
                    result += (char) (message.charAt(i) + (key % 26));
            else
                result += message.charAt(i);
        }
        return result;
    }

    public static String decryptCaesarKey(String message, int key) {
        String result = "";
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) >= 65 && message.charAt(i) <= 90)
                if (message.charAt(i) - (key % 26) < 65 )
                    result += (char) (message.charAt(i) - (key % 26) + 26);
                else
                    result += (char) (message.charAt(i) - (key % 26));
             else if (message.charAt(i) >= 97 && message.charAt(i) <= 122)
                if (message.charAt(i) - (key % 26) < 97 )
                    result += (char) (message.charAt(i) - (key % 26) + 26);
                else
                    result += (char) (message.charAt(i) - (key % 26));
            else
                result += message.charAt(i);
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Would you like to pick your own key? \"yes\" or \"no\" ");
            String keyDecision = scan.nextLine();
            if (keyDecision.equals("no")) {
                System.out.println("Here is your encrypted message: ");
                System.out.println(encryptCaesar(message)); }
            else if (keyDecision.equals("yes")) {
                System.out.println("What will be your key?");
                int key = scan.nextInt();
                scan.nextLine();
                System.out.println("Here is your encrypted message: ");
                System.out.println(encryptCaesarKey(message, key));
            }
            else 
                System.out.println("Unknown command; please type \"yes\" or \"no\"");
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Would you like to pick your own key? \"yes\" or \"no\" ");
            String keyDecision = scan.nextLine();
            if (keyDecision.equals("no")) {
                System.out.println("Here is your decrypted message: ");
                System.out.println(decryptCaesar(message)); }
            else if (keyDecision.equals("yes")) {
                System.out.println("What will be your key?");
                int key = scan.nextInt();
                scan.nextLine();
                System.out.println("Here is your decrypted message: ");
                System.out.println(decryptCaesarKey(message, key));
            }
            else 
                System.out.println("Unknown command; please type \"yes\" or \"no\"");
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
