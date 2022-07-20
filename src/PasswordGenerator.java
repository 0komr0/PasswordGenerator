import java.util.*;

public class PasswordGenerator {

    public List generateMultiplePasswords(Map<Integer, List<String>> mapOfWords){

     List<String> listOfPasswords = new ArrayList<>();

        for(Map.Entry listOfWords : mapOfWords.entrySet()){
           listOfPasswords.add(generatePassword((List<String>) listOfWords.getValue()));

        }
        return listOfPasswords;
    }

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
