package first_work;


import java.util.Scanner;

public class LetsDoIt {
    public static void main(String[] args) {
        int firstOper = 8119%2;
        double constant= 8119%3;
        int secondOperation = 8119%5;
        int typeOfIndex = 8119%7;
        double result = 0;
        int countDevByZero = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input n");
        double n = scanner.nextDouble();
        System.out.println("Input m");
        double m = scanner.nextDouble();

        System.out.println("First_operator: -, because c2 = " + firstOper);
        System.out.println("First_operator: -, because c5 = " + secondOperation);
        System.out.println("type of index is double , because c7 = " + typeOfIndex);
        System.out.println("const = " + constant);

        for (double i =1; i < n;i++){
            for (double j = 1;j < m;j++){
                if (i - constant == 0.0){
                    countDevByZero++;
                }else {
                    result += (i-j)/(i-constant);
                }
            }
        }
        System.out.println("result = " + result);
        System.out.println("/ by zero has happened : " + countDevByZero + " times");
    }
}
