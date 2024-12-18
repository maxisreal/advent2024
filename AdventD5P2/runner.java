import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

public class runner {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/input.txt");
        ArrayList<String[]> rules = new ArrayList<>();
        ArrayList<ArrayList<String>> pages = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i<fileData.size(); i++){
            if (Pattern.matches("\\d+\\|\\d+", fileData.get(i))){
                rules.add(fileData.remove(i).split("\\|"));
                i--;
            }
        }
        for (int i = 0; i<fileData.size(); i++){
            String[] temp = fileData.get(i).split(",");
            ArrayList<String> temp2 = new ArrayList<>();
            for (String b : temp){
                temp2.add(b);
            }
            pages.add(temp2);
        }
        //test printout
        for (String[] a : rules){
            for (String b : a){
                System.out.print(b + " ");
            }
            System.out.println();
        }
        //test printout
        for (ArrayList<String> a : pages){
            System.out.println(a);
            System.out.println(a.size());
            System.out.println(a.size()/2);
            System.out.println(a.get(a.size()/2));
        }
        for (int i = 0; i<pages.size(); i++){
            boolean valid = false;
            ArrayList<String> arr = pages.get(i);
            for (int a = 0; a<rules.size(); a++){
                String[] rule = rules.get(a);
                if (arr.contains(rule[0]) && arr.contains(rule[1])) {
                    if (arr.indexOf(rule[0]) > arr.indexOf(rule[1])) {
                        valid = true;
                    }
                }
            }
            if (!valid){
                pages.remove(i);
                i--;
            }
        }
        System.out.println("FILES REMOVED");
        //FIXING THE INCORRECTLY ORDERED 4 PART 2
        //test printout
        for (ArrayList<String> a : pages){
            System.out.println(a);
            System.out.println(a.size());
        }
        for (int i = 0; i<pages.size(); i++) {
            ArrayList<String> arr = pages.get(i);
            for (int a = 0; a < rules.size(); a++) {
                String[] rule = rules.get(a);
                if (arr.contains(rule[0]) && arr.contains(rule[1])) {
                    System.out.println(arr);
                    if (arr.indexOf(rule[0]) > arr.indexOf(rule[1])) {
                        Collections.swap(arr, arr.indexOf(rule[0]), arr.indexOf(rule[1]));
                    }
                    System.out.println(arr);
                }
            }
            pages.set(i, arr);
        }
        for (ArrayList<String> a : pages){
            sum += Integer.parseInt(a.get(a.size()/2));
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
}