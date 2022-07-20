import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class FileManager {



    private Map<Integer, List<String>> mapOfWords = new HashMap<>();

    public Map<Integer, List<String>> getMapOfWords() {
        return mapOfWords;
    }

    public void importPasswords(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        int i = 0;
        while (sc.hasNextLine()) {
            mapOfWords.put(i, Arrays.asList((sc.nextLine().split(", "))));
            i++;

        }

    }
    public void exportPassword(List<String> listOfPasswords) {
        try {

            PrintWriter out = new PrintWriter("finalPassword.txt");
            out.println("Your passwords generated with using of random words is: ");
            for(String password : listOfPasswords) {
                out.println(password);
            }
            out.println("don't show it to anyone ;)))) ");
            out.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

}
