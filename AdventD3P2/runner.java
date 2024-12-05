import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class runner {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/input.txt");
        int sum = 0;
        for (String a : fileData){
            String search = "mul(";
            String test = a;
            boolean toggle = false;
            String dont = "don't()";
            String dew = "do()";
            while (test.contains(search)){
                if (test.contains(dont) && test.indexOf(dont)<test.indexOf(search)){
                    toggle = true;
                }
                if (test.contains(dew) && test.indexOf(dew)>test.indexOf(search)){
                    toggle = false;
                }
                if (!toggle) {
                    test = test.substring(test.indexOf(search));
                    String input = test.substring(test.indexOf(search), test.indexOf(")"));
                    input = input.substring(4);
                    if (Pattern.matches("\\d+,\\d+", input)) {
                        String[] list = input.split(",");
                        System.out.println(Arrays.toString(list));
                        sum += Integer.parseInt(list[0]) * Integer.parseInt(list[1]);
                    }
                }
                test = test.substring(test.indexOf(search) + search.length());

            }
        }
        System.out.println(sum);
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
        } catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
