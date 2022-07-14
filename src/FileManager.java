import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class FileManager {



    Map<Integer, List<String>> mapOfWords = new HashMap<>();

    public void importPasswords(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        int i = 0;
        while (sc.hasNextLine()) {
            mapOfWords.put(i, Arrays.asList((sc.nextLine().split(", "))));
            i++;

        }
        System.out.println(mapOfWords);
    }
    public void exportPassword(String password) {
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
