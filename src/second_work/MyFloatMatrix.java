package second_work;

import java.util.Random;
import java.util.Scanner;

public class MyFloatMatrix {
    private float [][] thisMatrix;
    private int thisDimension;

    MyFloatMatrix(int dimension){
        thisDimension = dimension;
    }

    public float[][] getThisMatrix() {
        return thisMatrix;
    }

    float getElem(int x, int y){
        return thisMatrix[x][y];
    }

    void setRandom(){

        thisMatrix  = new float[thisDimension][thisDimension];

        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < thisDimension; i++){
            for (int j = 0; j < thisDimension; j++){
                thisMatrix[i][j] = random.nextFloat();
            }
        }
    }

    void setThisMatrix(Scanner scanner){
        thisMatrix = new float[thisDimension][thisDimension];

        for (int i = 0; i < thisDimension; i ++ ){
            for (int j = 0; j < thisDimension; j++){
                thisMatrix[i][j] = checkForInput(String.format("position %d : %d", thisDimension+1, thisDimension+1), scanner);
            }
        }
    }

    void setThisMatrix(float[][]matrix){
        thisMatrix = matrix;
        thisDimension = matrix.length;
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

    float[][] multiplicateOfMatrix(MyFloatMatrix anotherMatrix){
        float [][] newMatrix = new float[thisDimension][thisDimension];
        for (int i = 0; i < thisDimension; i++){
            for (int j = 0; j < thisDimension; j ++){
                for (int k = 0; k < thisDimension; k++){
                    newMatrix[i][j]+=thisMatrix[i][k]*anotherMatrix.getElem(j,k);
                }
            }
        }
        return newMatrix;
    }

    void printMatrix(){
        for (int i = 0; i < thisDimension; i++){
            for (int j = 0; j < thisDimension; j ++ ){
                System.out.print(thisMatrix[i][j]);
            }
            System.out.println(" ");
        }
    }

    float calcSumOfLowestElemInRows(){
        float sum = 0;
        for (int i = 0; i < thisDimension; i ++ ){
            float min = 10000;
            for (int j = 0; j < thisDimension; j ++){
                if (thisMatrix[i][j]< min){
                    min = thisMatrix[i][j];
                }
            }
            sum+=min;
        }return sum;
    }
}
