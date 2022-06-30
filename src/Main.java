import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    static List<String> listOfWords = new ArrayList<String>();
    public static void main(String[] args) throws FileNotFoundException {
        readFile("C:\\Users\\Admin\\Desktop\\PasswordGenerator\\words.txt");

    }

    static void readFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        sc.useDelimiter(", ");
        while (sc.hasNext()) {
                listOfWords.add(sc.next());
        }
        System.out.println(listOfWords);

    }
}
