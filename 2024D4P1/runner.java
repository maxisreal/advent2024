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
            for (int i = 0; i < rotato.get(a).length / 2; i++) {
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
        //diagonals: FROM THIS POINT FORTH GOD HATES ME
        //test print out of starter array
        for (String a : fileData) {
            String[] arr = a.split("");
            for (String b : arr){
                System.out.print(b + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < fileData.size(); i++) {
            //goes through ⬕ (white half on darkmode, black half normally)
            String test = "";
            for (int a = 0; a + i < fileData.size(); a++) {
                test += fileData.get(a + i).substring(a, a+1);
            }
            System.out.println(test);
            sum += testxmas(test.toLowerCase());
        }
        //test print out of rotated array
        for (int i = 0; i < rotato.size(); i++) {
            for (String a : rotato.get(i)){
                System.out.print(a.toUpperCase() + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < rotato.size(); i++) {
            //goes through ⬕ (white half on darkmode, black half normally)
            String test = "";
            for (int a = 0; a + i < rotato.size(); a++) {
                test += rotato.get(a + i)[a];
            }
            System.out.println(test);
            sum += testxmas(test);
        }
        for (int i = 0; i < rotato.size(); i++) {
            //goes through ◪ (white half on darkmode, black half normally)
            String test = "";
            for (int a = 0; a + i < rotato.size(); a++) {
                test += rotato.get(a+i)[rotato.size()-a-1];
            }
            System.out.println(test);
            sum += testxmas(test);
        }
        //TODO: ADD SOME SHIT HERE
        //https://www.geeksforgeeks.org/rotate-matrix-by-45-degrees/
        //https://stackoverflow.com/questions/21212402/java-diagonal-checking
        //https://stackoverflow.com/questions/10713327/extracting-a-list-of-all-diagonals-from-a-matrix-in-a-specific-direction
        System.out.println("THIRD CHECK");
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

    public static int finddiag(ArrayList<String[]> rotato){
        int b = 0;
        for (int i = 0; i < rotato.size(); i++) {
            //goes through ⬕ (white half)
            String test = "";
            for (int a = 0; a + i < rotato.size(); a++) {
                test += rotato.get(a + i)[a];
            }
            System.out.println(test);
            b += testxmas(test);
        }
        return b;
    }

    public static int testxmas(String test) {
        int a = 0;
        System.out.println(test);
        while (test.contains("xmas") || test.contains("samx")) {
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
