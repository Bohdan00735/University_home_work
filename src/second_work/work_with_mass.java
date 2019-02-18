package second_work;

import java.util.Random;
import java.util.Scanner;

public class work_with_mass {
    int this_matrix[][];

    public static void main(String[] args) {

        System.out.println("press \"1\"if you want to set matrix random \n " +
                "press \'2\' if you want matrix by yourself");
        Scanner scanner = new Scanner(System.in);
        String first_in = scanner.next();
        if (first_in == "1"){
        }
    }

    public void set_random(int row, int column){
        int matrix[][]  = new int[row][column];
        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                matrix[i][j] = random.nextInt();
            }
        }
       this_matrix = matrix;
    }
}
