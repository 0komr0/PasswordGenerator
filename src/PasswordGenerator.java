import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PasswordGenerator {
    public String generatePassword(List<String> listOfWords) {
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
}
