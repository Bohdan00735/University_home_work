package different_tets;
import java.util.Scanner;

public class help_with_home_work {
    public static void main(String[] args) {
        double s=0.0;
        int m=5;
        int n=5;
        int c=1;
        for (int i =1; i <= n;i++){
            for(int j=1; j<=m; j++) {
                s+=((double) (i/j)/(i+c));
            }
        }
        System.out.println(s);
    }
}




class Main {
    private static int Translator(){
        int number, counter, flag;
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        while (true) {
            flag=0;
            counter = 0;
            if (s.charAt(0) == '-') {
                number = -1;
                counter++;
                if (s.charAt(1) <= '9' && s.charAt(1) >= '0') {
                    number *= s.charAt(1) - '0';
                    counter++;
                }

                for (int i = 2; i < s.length(); i++) {
                    if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                        number *= 10;
                        number -= s.charAt(i) - '0';
                        counter++;
                    }
                }

                flag=1;
            } else {
                number = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                        number *= 10;
                        number += s.charAt(i) - '0';
                        counter++;
                    }
                }
            }
            if (counter == s.length() && flag==0) {
                break;
            } else  if (flag == 1){
                System.out.println("Enter number > 0");
                s = scan.nextLine();
            } else {
                System.out.println("Enter number, please, or I will kill your family");
                s = scan.nextLine();
            }
        }
        return number;
    }

    public static void main(String[] args) {
        int n,m;
        double Sum=0;
        n=Translator();
        m=Translator();
        for (int i=1;i<=n;i++){
            for (int j=1;j<=m;j++){
                Sum+=(double)(i%j)/(i+1);
                //System.out.println(Sum);
            }
        }
        System.out.println("Sum = " + Sum);
    }
}
