package fifthWork;

import java.util.Scanner;

public class workWithSintaxis {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your text or paragraph");
        String text;
        text = scanner.nextLine();
        System.out.println("Input your parsing symbol");
        String symbol = scanner.next();

        Text splitedText = new Text();
        String [] spl;

        spl = text.split("(?i)(?<=[.?!]\\S\\+(?=[a-z]))");
        for (String i: spl ){

            System.out.println(i);
        }
    }
}

class Text{
    private Sentense [] text;

    public void setText(Sentense[] text) {
        this.text = text;
    }
}


class Sentense {
    PartOfSentence [] sentense;

    int[] firstIn(String symb){
        int [] res = new int[2];
        for (int i = 0; i < sentense.length; i++){
            int position = sentense[i].findFirst(symb);
            if (position != -1){
                res[0] = i;
                res[1] = position;
                return res;
            }
        }
        return res;
    }

    int [] lastIn(String symb){
        int [] res = new int[2];
        for (int i = sentense.length; i > 0; i--){
            int position = sentense[i].findLast(symb);
            if (position != -1){
                res[0] = i;
                res[1] = position;
                return res;
            }
        }
        return res;
    }
}

class Word implements PartOfSentence{
    Letter [] word;

    @Override
    public char returnSymb() {
        return 0;
    }

    public int findFirst(String symb){
        for (int i = 0; i < word.length; i++){
            if(word[i].compare(symb)){
                return i;
            }
        }
        return -1;
    }


    public int findLast(String symb){
        for (int i = word.length; i > 0; i--){
            if(word[i].compare(symb)){
                return i;
            }
        }
        return -1;
    }
}

class Letter{
    String marking;
    String transcription;

    Letter(String mark){
        this.marking = mark;
    }

    boolean compare(String symbol){
        return symbol.equals(marking);
    }

}

interface PartOfSentence{
    char returnSymb();
    int findFirst(String symb);
    int findLast(String symb);
}

class SectionSign implements PartOfSentence{
    @Override
    public char returnSymb() {
        return 0;
    }

    @Override
    public int findFirst(String symb) {
        return 0;
    }

    @Override
    public int findLast(String symb) {
        return 0;
    }
}