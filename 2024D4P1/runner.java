import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class runner {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/input.txt");
        ArrayList<String[]> last = new ArrayList<>();
        System.out.println(fileData);
        int sum = 0;
        //forward & backward check
        for (int a = 0; a<fileData.size(); a++){
            String test = fileData.get(a).toLowerCase();
            last.add(test.split(""));
            sum += testxmas(test);
        }
        System.out.println("FIRST CHECK");
        System.out.println(sum);
        //up & down check
        ArrayList<String[]> rotato = new ArrayList<>();
        for (int a = 0; a<fileData.size(); a++){
            String input = "";
            for (String b : fileData){
                input += b.substring(a, a+1);
            }
            rotato.add(input.toLowerCase().split(""));
        }
        for (int a = 0; a<rotato.size(); a++){
            String test = "";
            for (String q : rotato.get(a)){
                test += q;
            }
            sum += testxmas(test);
        }
        System.out.println("SECOND CHECK");
        System.out.println(sum);
        //diagonals
        for (int i = 0; i<rotato.size(); i++) {
            String test = "";
            for (int a = 0; a + i < rotato.size(); a++) {
                test += rotato.get(a + i)[a + i];
            }
            sum += testxmas(test);
        }
        for (int i = 0; i<last.size(); i++) {
            String test = "";
            for (int a = 0; a + i < last.size(); a++) {
                test += last.get(a + i)[a + i];
            }
            sum += testxmas(test);
        }
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
    public static int testxmas(String test){
        int a = 0;
        while (test.contains("xmas") || test.contains("samx")) {
            System.out.println(test);
            if (test.contains("samx")) {
                test = test.substring(test.indexOf("samx") + 3);
                a++;
            }
            if (test.contains("xmas")) {
                test = test.substring(test.indexOf("xmas") + 3);
                a++;
            }
            System.out.println(test);
        }
        return a;
    }
