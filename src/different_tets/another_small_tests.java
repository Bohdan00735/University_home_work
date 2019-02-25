package different_tets;

import java.util.Random;
import java.util.Scanner;

public class another_small_tests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input smth");
        System.out.println(scanner.hasNextInt());

        Smth thesis = new Smth();
        thesis.start();
        int dd = thesis.change;
        dd = thesis.calc(25);
    }


}

class Smth{
    int change;
    void start(){
        Random rand = new Random();
        System.out.println(calc(rand.nextInt()));
    }

    int calc(int var){
        change = var*10;
        return var*var;
    }
}
