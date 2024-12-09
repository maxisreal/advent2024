import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class runner {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/inputtest.txt");
        System.out.println(fileData);
        int sum = 0;
        //forward & backward check
        for (int a = 0; a<fileData.size(); a++){
            String test = fileData.get(a).toLowerCase();
            while (test.contains("xmas") || test.contains("samx")) {
                sum++;
                System.out.println(test);
                if (test.contains("samx")) {
                    test = test.substring(test.indexOf("samx") + 4);
                }
                if (test.contains("xmas")) {
                    test = test.substring(test.indexOf("xmas") + 4);
                }
                System.out.println(test);
            }
        }
        System.out.println("FIRST CHECK");
        System.out.println(sum);
        //up & down check
        
        System.out.println("SECOND CHECK");
        System.out.println(sum);
        //diagonals

        System.out.println("THIRD CHECK");
        //https://stackoverflow.com/questions/10713327/extracting-a-list-of-all-diagonals-from-a-matrix-in-a-specific-direction
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
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}