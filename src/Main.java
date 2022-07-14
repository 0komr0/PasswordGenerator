import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        FileManager fileManager = new FileManager();
        PasswordGenerator genPass = new PasswordGenerator();
        fileManager.importPasswords("C:\\Users\\Admin\\Desktop\\PasswordGenerator\\words.txt");
     /* String password = genPass.generatePassword(FileManager.listOfWords);
        fileManager.exportPassword(password); */
    }

}
