import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class runner {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/inputtest.txt");
        System.out.println(fileData);
        int sum = 0;
        //forward & backward check
        for (int a = 0; a < fileData.size(); a++) {
            String test = fileData.get(a).toLowerCase();
            sum += testxmas(test);
        }
        System.out.println("FIRST CHECK");
        System.out.println(sum);
        //rows to columns conversion
        ArrayList<String[]> rotato = new ArrayList<>();
        for (int a = 0; a < fileData.size(); a++) {
            String input = "";
            for (String b : fileData) {
                input += b.substring(a, a + 1);
            }
            rotato.add(input.toLowerCase().split(""));
        }
        //flipping it vertically, to finish rotation
        for (int a = 0; a < rotato.size(); a++) {
            for (int i = 0; i<rotato.get(a).length/2; i++){
                String temp = rotato.get(a)[i];
                rotato.get(a)[i] = rotato.get(a)[rotato.get(a).length - 1 - i];
                rotato.get(a)[rotato.get(a).length - 1 - i] = temp;
            }
        }
        //up & down check
        for (int a = 0; a < rotato.size(); a++) {
            String test = "";
            for (String q : rotato.get(a)) {
                test += q;
            }
            sum += testxmas(test);
        }
        System.out.println("SECOND CHECK");
        System.out.println(sum);
        //diagonals
        //test print out of rotated array
        for (int i = 0; i < rotato.size(); i++) {
            for (String a : rotato.get(i)){
                System.out.print(a.toUpperCase() + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < rotato.size(); i++) {
            //goes through ⬕ (white half)
            String test = "";
            for (int a = 0; a + i < rotato.size(); a++) {
                test += rotato.get(a + i)[a];
            }
            sum += testxmas(test);
        }
        for (int i = 0; i < fileData.size(); i++) {
            String input = "";
            for (int a = 0; a + i < fileData.size(); a++) {
                input += fileData.get(a + i).substring(a, a+1);
            }
            sum += testxmas(input);
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
        } catch (FileNotFoundException e) {
            return fileData;
        }
    }

    public static int testxmas(String test) {
        int a = 0;
        while (test.contains("xmas") || test.contains("samx")) {
            System.out.println(test);
            if (test.indexOf("xmas") < test.indexOf("samx")) {
                if (test.contains("xmas")) {
                    test = test.substring(test.indexOf("xmas") + 3);
                    a++;
                }
                if (test.contains("samx")) {
                    test = test.substring(test.indexOf("samx") + 3);
                    a++;
                }
            } else {
                if (test.contains("samx")) {
                    test = test.substring(test.indexOf("samx") + 3);
                    a++;
                }
                if (test.contains("xmas")) {
                    test = test.substring(test.indexOf("xmas") + 3);
                    a++;
                }
            }
            System.out.println(test);
        }
        return a;
    }
}
