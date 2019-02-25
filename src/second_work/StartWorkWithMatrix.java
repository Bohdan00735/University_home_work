package second_work;

import java.util.Scanner;

public class StartWorkWithMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dimension = checkForInput("dimension", scanner);

        MyFloatMatrix firstMatrix = new MyFloatMatrix(dimension);
        MyFloatMatrix secondMatrix = new MyFloatMatrix(dimension);

        System.out.println("press \"1\"if you want to set matrix random \n " +
                "press \'2\' if you want matrix by yourself");

        String first_in = scanner.next();
        if (first_in.equals("1")){
            firstMatrix.setRandom();
            secondMatrix.setRandom();

        }else if (first_in.equals("2")){
            System.out.println("fill first matrix");
            firstMatrix.setThisMatrix(scanner);
            System.out.println("fill second matrix");
            secondMatrix.setThisMatrix(scanner);

        }else {
            System.out.println("unresolved command");
        }

        MyFloatMatrix resultMatrix = new MyFloatMatrix(dimension);
        resultMatrix.setThisMatrix(firstMatrix.multiplicateOfMatrix(secondMatrix));
        resultMatrix.printMatrix();
        System.out.println("sum of min element each row is "+ resultMatrix.calcSumOfLowestElemInRows());
    }

    private static int checkForInput(String name_of_varible, Scanner scanner){
        System.out.printf("please input %s type: int", name_of_varible);
        while(true){
            if(scanner.hasNextInt() ){
                return scanner.nextInt();
            }else {
                System.out.println("please input only int ");
            }
        }
    }
}
