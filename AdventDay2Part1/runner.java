import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import java.util.concurrent.Callable;

public class runner {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/input.txt");
        ArrayList<int[]> nums = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i<fileData.size(); i++){
            String[] split = fileData.get(i).split("\\s+");
            int[] list = new int[split.length];
            for (int j = 0; j<list.length; j++){
                list[j] = Integer.parseInt(split[j]);
            }
            nums.add(list);
        }
        for (int i = 0; i<nums.size(); i++){
            int prev = nums.get(i)[0];
            System.out.println("LIST: " + Arrays.toString(nums.get(i)));
            boolean inc = false;
            boolean dec = false;
            boolean valid = false;
            for (int a = 1; a<nums.get(i).length; a++){
                int result = prev - nums.get(i)[a];
                if (result < 0){
                    inc = true;
                } else if (result > 0){
                    dec = true;
                } else {
                    valid = false;
                    break;
                }
                result = Math.abs(result);
                System.out.println(prev +" - " + nums.get(i)[a]);
                System.out.println("RESULT: " + result);
                //System.out.println("INCREASING: " + inc);
                //System.out.println("DECREASING: " + dec);
                if (result == 1) {
                    valid = true;
                } else if (result == 2){
                    valid = true;
                } else if (result == 3) {
                    valid = true;
                } else {
                    valid = false;
                    break;
                }
                prev = nums.get(i)[a];
            }
            if (valid){
                if (inc && !dec){
                    sum++;
                }
                else if (!inc && dec){
                    sum++;
                } else {
                    valid = false;
                }
            }
            System.out.println("VALID: " + valid);
            System.out.println("TOTAL SAFE: " +sum);
        }
        System.out.println(sum);
        // you now have an ArrayList of Strings for each number in the file
        // do Advent 2020 day 1!
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
