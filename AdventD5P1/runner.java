import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class runner {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/input.txt");
        ArrayList<String> rules = new ArrayList<>();
        ArrayList<String[]> pages = new ArrayList<>();
        for (int i = 0; i<fileData.size(); i++){
            if (Pattern.matches("\\d+\\|\\d+", fileData.get(i))){
                rules.add(fileData.remove(i));
                i--;
            }
        }
        for (int i = 0; i<fileData.size(); i++){
            pages.add(fileData.get(i).split(","));
        }
        int sum = 0;
        System.out.println(rules);
        System.out.println(fileData);

    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
