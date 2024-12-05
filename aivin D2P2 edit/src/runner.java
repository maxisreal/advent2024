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
            boolean inc = false;
            boolean dec = false;
            boolean valid = false;

            for (int a = 1; a < nums.get(i).length; a++){
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
                if (result > 0 && result <= 3) {
                    valid = true;
                } else {
                    valid = false;
                    break;
                }
                prev = nums.get(i)[a];
            }
            System.out.println("VALID 1st time: " + valid);
            if (!valid) {
                for (int q = 0; q < nums.get(i).length; q++) {
                    int[] arr2 = remove(nums.get(i), q);
                    for (int a = 1; a < arr2.length; a++) {
                        int result = arr2[a - 1] - arr2[a];
                        if (result < 0) {
                            inc = true;
                        } else if (result > 0) {
                            dec = true;
                        } else {
                            break;
                        }
                        result = Math.abs(result);
                        if (result > 0 && result <= 3) {
                            valid = true;
                        } else {
                            valid = false;
                            break;
                        }
                    }
                    if (inc != dec){
                        valid = true;
                    } else {
                        break;
                    }
                    
                }
                System.out.println("VALID 2nd time: " + valid);
            }

            if (valid) {
                if (inc != dec) {
                    sum++;
                }
            }
            System.out.println("TOTAL SAFE: " + sum);
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
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
    public static int[] remove(int[] arr, int in) {

        if (arr == null || in < 0 || in >= arr.length) {
            return arr;
        }

        int[] arr2 = new int[arr.length - 1];

        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == in)
                continue;

            arr2[k++] = arr[i];
        }

        return arr2;
    }
}
