package second_work;

import java.util.Scanner;

public class StartWorkWithMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyFloatMatrix firstMatrix = new MyFloatMatrix();
        MyFloatMatrix secondMatrix = new MyFloatMatrix();

        System.out.println("press \"1\"if you want to set matrix random \n " +
                "press \'2\' if you want matrix by yourself");

        String first_in = scanner.next();
        if (first_in.equals("1")){
            firstMatrix.setRandom(scanner);
            secondMatrix.setRandom(scanner);

        }else if (first_in.equals("2")){
            System.out.println("fill first matrix");
            firstMatrix.setThisMatrix(scanner);
            System.out.println("fill second matrix");
            secondMatrix.setThisMatrix(scanner);

        }else {
            System.out.println("unresolved command");
        }

        MyFloatMatrix resultMatrix = new MyFloatMatrix();
        resultMatrix.setThisMatrix(firstMatrix.multiplicateOfMatrix(secondMatrix), firstMatrix.getRows(), secondMatrix.getColumn());
        resultMatrix.printMatrix();
        System.out.println("sum of min element each row is "+ resultMatrix.calcSumOfLowestElemInRows());
    }
}
