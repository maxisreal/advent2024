import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.concurrent.Callable;

public class runner {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/input.txt");
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Integer> numz = new ArrayList<>();
        int sum = 0;
        //System.out.println(fileData);
        for (int a = 0; a<fileData.size(); a++){
            String[] splitstr = fileData.get(a).split("\\s+");
            nums.add(Integer.valueOf(splitstr[0]));
            numz.add(Integer.valueOf(splitstr[1]));
        }
        Collections.sort(nums);
        Collections.sort(numz);
            for (int i = 0; i<nums.size(); i++){
                int a = 0;
                int b = nums.get(i);
                for (int j = 0; j<numz.size(); j++){
                    if (b == numz.get(j)) {
                        a++;
                    }
                }
                sum += (nums.get(i) * a);
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
