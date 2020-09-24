import java.util.Scanner;

public class Vigenere {
    public static String encryptVigenere(String message, String key) {
        String result = "";
        int change = 0;
        int realKey = 0;
        int place = 0;
        for (int i = 0; i < message.length(); i++) {
            change = (place + key.length()) % key.length();
            if (key.charAt(change) >= 65 && key.charAt(change) <= 90)
                realKey = key.charAt(change) - 65;
            else
                realKey = key.charAt(change) - 97;
            if (message.charAt(i) >= 65 && message.charAt(i) <= 90) {
                if (message.charAt(i) + realKey > 90)
                    result += (char) (message.charAt(i) + realKey - 26);
                else
                    result += (char) (message.charAt(i) + realKey);
                place++;
            }
            else if (message.charAt(i) >= 97 && message.charAt(i) <= 122) {
                if (message.charAt(i) + realKey > 122)
                    result += (char) (message.charAt(i) + realKey - 26);
                else
                    result += (char) (message.charAt(i) + realKey);
                place++;
            }
            else 
                result += (char) (message.charAt(i));
        }
        return result;
    }

    public static String decryptVigenere(String message, String key) {
        String result = "";
        int change = 0;
        int realKey = 0;
        int place = 0;
        for (int i = 0; i < message.length(); i++) {
            change = (place + key.length()) % key.length();
            if (key.charAt(change) >= 65 && key.charAt(change) <= 90)
                realKey = key.charAt(change) - 65;
            else
                realKey = key.charAt(change) - 97;
            if (message.charAt(i) >= 65 && message.charAt(i) <= 90) {
                if (message.charAt(i) - realKey < 65)
                    result += (char) (message.charAt(i) - realKey + 26);
                else
                    result += (char) (message.charAt(i) - realKey);
                place++;
            }
            else if (message.charAt(i) >= 97 && message.charAt(i) <= 122) {
                if (message.charAt(i) - realKey < 97)
                    result += (char) (message.charAt(i) - realKey + 26);
                else
                    result += (char) (message.charAt(i) - realKey);
                place++;
            }
            else 
                result += (char) (message.charAt(i));
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
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
