package thirdWork;

import java.util.Scanner;

public class anotherVar10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input your text");
        StringBuilder text = new StringBuilder(scanner.nextLine());
        System.out.println("input your symb");
        String symb = scanner.next();

        String [] sentenses = String.valueOf(text).split("\\.");
        StringBuilder splitedText = new StringBuilder();

        for (String i:sentenses){
            int prevLenght = splitedText.length();
            int start = i.indexOf(symb);
            int last = i.lastIndexOf(symb);
            splitedText.append(i);
            splitedText.append(".");
            splitedText.delete(start + prevLenght, last + prevLenght+1);
        }

        System.out.println("new line is : \n" + splitedText.toString());

    }
}
