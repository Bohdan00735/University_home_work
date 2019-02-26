package first_work;

import java.util.Scanner;

public class LetsDoIt {
    public static void main(String[] args) {
        int first_oper = 8119%2;
        int constant= 8119%3;
        int second_operation = 8119%5;
        int type_of_index = 8119%7;

        System.out.println("First_operator: -, because c2 = " + first_oper);
        System.out.println("First_operator: -, because c5 = " + second_operation);
        System.out.println("type of index is double , because c7 = " + type_of_index);
        System.out.println("const = " + constant);

        Scanner scanner = new Scanner(System.in);

        double i = 0;
        double j = 0;
        double n = 0;
        double m = 0;

        while (true){
            i = check_for_input("i", scanner);
            j = check_for_input("j", scanner);
            n = check_for_input("n", scanner);
            m = check_for_input("m", scanner);
            if (i <= n && j <= m){
                break;
            }else {
                System.out.println("i and j must be lower than n,m");
            }
        }

        double result = calculation(i,j,m,n,constant);
        System.out.println("result = " + result);
    }

    private static double check_for_input(String name_of_varible, Scanner scanner){
        System.out.printf("please input %s type: double", name_of_varible);
        while(true){
            if(scanner.hasNextDouble() ){
                return scanner.nextDouble();
            }else {
                System.out.println("please input only double ");
            }
        }


    }

    private static double calculation(double i, double j, double m, double n, int constant ){
        double result = 0;
        if(i <= constant && n >= constant) {
            System.out.println("there will be / by zero");
            System.exit(1);
        }else{
            for (i = i; i <= n;i++){
                for (j = j;j <= m;j++){
                    result += (i-j)/(i-constant);

                }
            }
        }
        return result;
    }
}
