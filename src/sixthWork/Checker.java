package sixthWork;

import java.util.Scanner;

public class Checker {
    private static int checkForInt(String name_of_varible, Scanner scanner){
        System.out.printf("please input %s type: int", name_of_varible);
        while(true){
            if(scanner.hasNextInt()){
                return scanner.nextInt();
            }else {
                System.out.println("please input only int");
            }
        }
    }

    int[] checkForBound(Scanner scanner){
        System.out.println("\n");
        int firstBound = checkForInt("first Bound", scanner);
        int secondBound = checkForInt("Second Bound", scanner);
        int[] result = new int[2];
        while (true){
            if (firstBound <= secondBound){
                result[0] = firstBound;
                result[1] = secondBound;
                return result;
            }else {
                System.out.println("First bound shoud be lower than second");
                firstBound = checkForInt("first Bound", scanner);
                secondBound = checkForInt("Second Bound", scanner);
            }
        }
    }
}
