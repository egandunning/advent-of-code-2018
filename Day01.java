import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Day01 {
    
    public static void main(String[] args) {
        File f = new File("day01_input.txt");
        
        int sum = 0;
        
        try(Scanner s = new Scanner(f)) {
            while(s.hasNext()) {
                String temp = s.nextLine();
                if(temp.charAt(0) == '+') {
                    sum += Integer.parseInt(temp.substring(1));
                } else if(temp.charAt(0) == '-') {
                    sum -= Integer.parseInt(temp.substring(1));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("input file not properly formed.");
        }
        
        System.out.println(sum);
    }
}