package second_work;

import java.util.Random;
import java.util.Scanner;

public class MyFloatMatrix {
    private float [][] thisMatrix;
    private int thisRows;
    private int thisColumn;

    public float[][] getThisMatrix() {
        return thisMatrix;
    }

    public int getColumn() {
        return thisColumn;
    }

    public int getRows() {
        return thisRows;
    }

    float getElem(int x, int y){
        return thisMatrix[x][y];
    }

    void setRandom(Scanner scanner){

        thisRows = checkForInput("row", scanner);
        thisColumn = checkForInput("column", scanner);

        thisMatrix  = new float[thisRows][thisColumn];

        int min = checkForInput("min of diapason", scanner);
        int max = checkForInput("max of diapason", scanner);
        int dimmension = max-min;

        Random random = new Random();

        for (int i = 0; i < thisRows; i++){
            for (int j = 0; j < thisColumn; j++){
                thisMatrix[i][j] = min + (float)random.nextInt(dimmension +1);
            }
        }
    }

    void setThisMatrix(Scanner scanner){
        thisRows = checkForInput("row", scanner);
        thisColumn = checkForInput("column", scanner);
        thisMatrix = new float[thisRows][thisColumn];

        for (int i = 0; i < thisRows; i ++ ){
            for (int j = 0; j < thisColumn; j++){
                thisMatrix[i][j] = checkForInput(String.format("position %d : %d", thisRows+1, thisColumn+1), scanner);
            }
        }
    }

    void setThisMatrix(float[][]matrix, int column, int row){
        thisMatrix = matrix;
        thisRows = row;
        thisColumn = column;
    }

    private static int checkForInput(String name_of_varible, Scanner scanner){
        System.out.printf("please input %s type: int", name_of_varible);
        while(true){
            if(scanner.hasNextInt() ){
                return scanner.nextInt();
            }else {
                System.out.println("please input only int");
            }
        }
    }

    float[][] multiplicateOfMatrix(MyFloatMatrix anotherMatrix){
        float [][] newMatrix = new float[thisRows][thisColumn];
        if (thisRows != anotherMatrix.getColumn()){
            System.out.println("rows of first should be == column of second");
            System.exit(1);
        }else {
            for (int i = 0; i < thisRows; i++){
                for (int j = 0; j < thisColumn; j ++){
                    for (int k = 0; k < thisRows; k++){
                        newMatrix[i][j]+=thisMatrix[i][k]*anotherMatrix.getElem(j,k);
                    }
                }
            }
        }return newMatrix;
    }

    void printMatrix(){
        for (int i = 0; i < thisRows; i++){
            for (int j = 0; j < thisColumn; j ++ ){
                System.out.print(thisMatrix[i][j]);
            }
            System.out.println(" ");
        }
    }

    float calcSumOfLowestElemInRows(){
        float sum = 0;
        for (int i = 0; i < thisRows; i ++ ){
            float min = thisMatrix[i][0];
            for (int j = 0; j < thisColumn; j ++){
                if (thisMatrix[i][j]< min){
                    min = thisMatrix[i][j];
                }
            }
            sum+=min;
        }
        return sum;
    }
}
