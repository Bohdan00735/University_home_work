package thirdWork;

import java.util.Scanner;

public class WorkWithLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder line = new StringBuilder();
        System.out.println("INPUT your line");
        line.append(scanner.nextLine());
        int startSymb = -1;
        int lastSymbol = -1;
        String symbol="";
        int localLast;
        String localSymb;

        for (int i = 0; i < line.length()/2; i++){
            if (line.length()- i < lastSymbol-startSymb ){
                break;
            }else {
                localSymb = String.valueOf(line.charAt(i));
                localLast = line.lastIndexOf(localSymb);

                if (localLast-i > lastSymbol-startSymb){
                    lastSymbol= localLast;
                    startSymb = i;
                    symbol = localSymb;
                }
            }
        }
        if(startSymb == -1){
            System.out.println("there is no repeating symbols");
        }else {
            line.delete(startSymb,lastSymbol+1);
            System.out.printf("new line is %s symbol was: %s, length of subline was: %d",
                    line.toString(),symbol, lastSymbol-startSymb+1);
        }

    }
}
