import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Problem statement: https://adventofcode.com/2018/day/1
 */
public class Day01 {
    
    /**
     * To solve part 1, run with no arguments
     * 
     * To solve part 2, run with the argument 2
     */
    public static void main(String[] args) {
        
         
        
        File f = new File("day01_input.txt");
        
        if(args.length == 1 && args[0].equals("2")) {
            partTwo(f);
        } else {
            partOne(f);
        }

    }
    
    public static void partOne(File f) {
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
    
    public static void partTwo(File f) {
        
        HashMap<Integer, Boolean> frequencies = new HashMap<>();
        ArrayList<Integer> deltas = new ArrayList<>();
        int sum = 0;
        
        try(Scanner s = new Scanner(f)) {
            while(s.hasNext()) {
                
                String temp = s.nextLine();
                int change = Integer.parseInt(temp.substring(1));
                               
                if(temp.charAt(0) == '+') {
                    sum += change;
                    deltas.add(change);
                } else if(temp.charAt(0) == '-') {
                    sum -= change;
                    deltas.add(-1 * change);
                }
                frequencies.put(sum, true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("input file not properly formed.");
        }
        
        int i = 0;
        while(true) {
            
            sum += deltas.get(i % deltas.size());
            
            if(frequencies.get(sum) != null) {
                System.out.print(sum);
                break;
            }
            i++;
        }
    }
}