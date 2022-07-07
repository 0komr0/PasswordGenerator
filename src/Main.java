import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Main {
    static List<String> listOfWords = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        readFile("C:\\Users\\Admin\\Desktop\\PasswordGenerator\\words.txt");
        String password = generatePassword();
        exportPassword(password);

    }

    private static void readFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        sc.useDelimiter(", ");
        while (sc.hasNext()) {
            listOfWords.add(sc.next());
        }
    }

    private static String generatePassword() {
        Collections.shuffle(listOfWords);
         int size = listOfWords.size();
        String password = "";
        for (int i = 0; i < size; i++) {
            String caps = listOfWords.get(i);

            password += pickAChar(caps);
        }

        return password;
    }


    private static String pickAChar(String caps){
        Random random = new Random();

        int randomInt = random.nextInt(caps.length());
        Character randomChar = caps.charAt(randomInt);
        String randomCharString = String.valueOf(randomChar);

        if (randomInt % 2 == 0) {
            randomCharString.toUpperCase();
        }
        return (randomCharString);
    }
    private static void exportPassword(String password) {
        try {
            PrintWriter out = new PrintWriter("finalPassword.txt");
            out.println("Your password generated with using of random words is: ");
            out.println(password);
            out.println("don't show it to anyone ;)))) ");
            out.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
