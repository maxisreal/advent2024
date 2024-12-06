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
        for (int a = 0; a<fileData.size(); a++){
            String z = fileData.get(a);
            while (z.contains("xmas") || z.contains("samx")){
                sum++;
                if (z.contains("xmas")) {
                    z = z.substring(z.indexOf("xmas") + 3);
                }
                if (z.contains("samx")) {
                    z = z.substring(z.indexOf("xmas") + 3);
                }
            }
        }

        //up & down check (basically im rotating the board 90 deg)
        String[] list = new String[fileData.get(0).length()-2];

        for (int a = 0; a<list.length; a++) {
            String input = "";
            for (int b = 0; b < fileData.size(); b++) {
                input += fileData.get(b).substring(a, a + 1);
            }
            list[a] = input;
        }


        //forward & backward check...but for up & down (crazy)
        for (String a : list){
            String z = a;
            while (z.contains("xmas") || z.contains("samx")){
                sum++;
                if (z.contains("xmas")) {
                    z = z.substring(z.indexOf("xmas") + 3);
                }
                if (z.contains("samx")) {
                    z = z.substring(z.indexOf("xmas") + 3);
                }
            }
        }
        //diagonals check
        String[][] last = new String[list[0].length()][list.length];
        for (int a = 0; a<list.length; a++){
            last[a] = list[a].split("");
        }
        for (String[] a : last){
            System.out.println(Arrays.toString(a));
        }
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
