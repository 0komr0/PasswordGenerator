import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.function.BooleanSupplier;

public class FileManager {


    private static Map<Integer, List<String>> mapOfWords = new HashMap<>();

    public Map<Integer, List<String>> getMapOfWords() {
        return mapOfWords;
    }

    public void importPasswords(String path) throws FileNotFoundException {
        String delimiter = userRegexInput();
        File file = new File(path);
        Scanner sc = new Scanner(file);
        List<String> lines = new ArrayList<>();
        while (sc.hasNextLine()) {
            lines.add((sc.nextLine()));
        }
        boolean check = isDelimiterPresent(delimiter, lines);
        if(check == true){
            addWordsToMap(delimiter, lines);
        } else{
            System.out.println("Sorry! Your delimiter isn't there :/ ");
            importPasswords(path);
        }
    }

    public void exportPassword(List<String> listOfPasswords) {
        try {

            PrintWriter out = new PrintWriter("finalPassword.txt");
            out.println("Your passwords generated with using of random words is: ");
            for (String password : listOfPasswords) {
                out.println(password);
            }
            out.println("don't show it to anyone ;)))) ");
            out.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Boolean isDelimiterPresent(String delimiter, List<String> lines) {
        for (String line : lines) {
            if (!line.contains(delimiter)) {
                return false;
            }
        }
        return true;
    }
    public static void addWordsToMap(String delimiter, List<String> lines){
        for(int i = 0; i<lines.size(); i++){
            mapOfWords.put(i, Arrays.asList(lines.get(i).split(delimiter)));
        }
    }
    public static String userRegexInput(){
        System.out.println("Input delimiter used in file: ");
        String regex = "";
        try {
            Scanner regexInput = new Scanner(System.in);
            regex = regexInput.nextLine();
            regexInput.close();

        }catch (NoSuchElementException ex){
            System.out.println(ex);
        }
        return regex;
    }
}
