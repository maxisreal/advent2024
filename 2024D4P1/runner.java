import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class runner {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/input.txt");
        int sum = 0;
        //forward & backward check
        String[][] last = new String[fileData.size()][fileData.size()];
        for (int a = 0; a<last.length; a++){
            last[a] = fileData.get(a).split("");
        }
        for (String[] a : last){
            String test = Arrays.toString(a);
            //System.out.println(Arrays.toString(a));
            //System.out.println(test);
            while (test.contains("xmas") || test.contains("samx")) {
                sum++;
                if (test.contains("xmas")) {
                    test = test.substring(test.indexOf("xmas") + 3);
                }
                if (test.contains("smax")) {
                    test = test.substring(test.indexOf("smax") + 3);
                }
            }
            System.out.println(test);
        }
        System.out.println("FIRST CHECK");
        //up & down check
        for (int a = 0; a<last.length; a++){
            String test = "";
            for (int i = 0; i<last.length; i++){
                test += last[i][a];
            }
            System.out.println("FIRST CHECK");
            while (test.contains("xmas") || test.contains("samx")) {
                    sum++;
                if (test.contains("xmas")) {
                    test = test.substring(test.indexOf("xmas") + 4);
                }
                if (test.contains("smax")) {
                    test = test.substring(test.indexOf("smax") + 4);
                }
                System.out.println(test);
                //test = test.substring(1);
            }
        }
        System.out.println("SECOND CHECK");
        //diagonals
        int num = 0;
        for (int a = 0; a<140; a++){
            String test = "";
            for (int i = 0; i<last.length; i++){
                test += last[num][i];
                num++;
            }
            while (test.contains("xmas") || test.contains("samx")) {
                sum++;
                if (test.contains("xmas")) {
                    test = test.substring(test.indexOf("xmas") + 3);
                }
                if (test.contains("smax")) {
                    test = test.substring(test.indexOf("smax") + 3);
                }
            }
            num -= num;
            test = "";
            for (int i = last.length; i>0; i--){
                test += last[i-1-num][i];
                num++;
            }
            while (test.contains("xmas") || test.contains("samx")) {
                sum++;
                if (test.contains("xmas")) {
                    test = test.substring(test.indexOf("xmas") + 3);
                }
                if (test.contains("smax")) {
                    test = test.substring(test.indexOf("smax") + 3);
                }
            }
            num++;
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
                String line = s.nextLine().toLowerCase();
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
