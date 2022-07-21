import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class StartPasswordGenerator {

    public static void main(String[] args) throws FileNotFoundException {
      FileManager fileManager = new FileManager();
        PasswordGenerator genPass = new PasswordGenerator();
        fileManager.importPasswords("C:\\Users\\Admin\\Desktop\\PasswordGenerator\\words.txt");
        List<String> finalOutcome = genPass.generateMultiplePasswords(fileManager.getMapOfWords());
        fileManager.exportPassword(finalOutcome);
    }





}
