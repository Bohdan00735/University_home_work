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

        int [][] n;

        int [] w = {1,2,3,4,5,6,7};
        int []q = new int[4];
        System.arraycopy(w,0,q,0,3);
        System.arraycopy(w,6,q,3,1);
        System.out.println("ttt");

        for (int i : q){
            System.out.println(i);
        }

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
