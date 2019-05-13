package fifthWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class workWithSintaxis {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your text or paragraph");
        String text = scanner.nextLine();
        System.out.println("Input your parsing symbol");
        String symbol = scanner.next();

        Text splitedText = new Text();
        String[] spl;

        Pattern pattern = Pattern.compile("((?<=[^A-Za-z]) [.!?]) + (?=[A-Za-z])");
        spl = text.split("\\.");
        for (String s : spl) {
            System.out.println(s);
        }
        splitedText.setText(new Sentense[spl.length]);

        for (int sentense = 0; sentense < spl.length; sentense++) {
            String[] parts = spl[sentense].split(" ");
            Sentense thiseSentence = new Sentense(parts.length);
            for (String part : parts) {
                if (part.length() == 1) {
                    char element = part.charAt(0);
                    int ascii = (int) element;
                    if (ascii <= 64 & (33 <= ascii)) {
                        SectionSign sectionSign = new SectionSign(part);
                        thiseSentence.addToSentense(sectionSign);
                    } else {
                        Word theseWord = new Word();
                        theseWord.addToWord(new Letter(part));
                        thiseSentence.addToSentense(theseWord);
                    }
                } else {
                    String[] word = part.split("");
                    Word theseWord = new Word();
                    for (String letter : word) {
                        theseWord.addToWord(new Letter(letter));
                    }
                    thiseSentence.addToSentense(theseWord);
                }
            }
            splitedText.addElemenet(thiseSentence);
        }

        splitedText.cutSomePartInEachSentence(symbol);
        splitedText.PrintText();
    }
}

class Text {
    private Sentense[] text;
    private int counter;

    public void setText(Sentense[] text) {
        this.text = text;
    }

    boolean addElemenet(Sentense sentense) {
        if (this.counter <= this.text.length) {
            this.text[counter] = sentense;
            this.counter++;
            return true;
        } else {
            return false;
        }
    }

    int[] findFromStart(String symb) {
        int[] lastPosition = new int[3];
        for (int j = 0; j < text.length; j++) {
            int[] sentPosition = this.text[j].firstIn(symb);
            if (sentPosition[0] != -1) {
                lastPosition[0] = j;
                lastPosition[1] = sentPosition[0];
                lastPosition[2] = sentPosition[1];
                return lastPosition;
            }
        }
        lastPosition[0] = -1;
        return lastPosition;
    }

    int[] findFromEnd(String symb) {
        int[] lastPosition = new int[3];
        for (int j = this.text.length - 1; j > 0; j--) {
            int[] sentPosition = this.text[j].lastIn(symb);
            if (sentPosition[0] != -1) {
                lastPosition[0] = j;
                lastPosition[1] = sentPosition[0];
                lastPosition[2] = sentPosition[1];
                return lastPosition;
            }
        }
        lastPosition[0] = -1;
        return lastPosition;
    }

    void cutSomePartInEachSentence(String symbol) {
        for (int i = 0; i < text.length; i++) {
            this.text[i].cutFromDIapOfSymb(symbol);
        }
    }

    void PrintText() {
        for (Sentense sentense : text) {
            sentense.printSentense();
        }
    }

}


class Sentense {
    PartOfSentence[] sentense;
    int counter = 0;

    Sentense(int length) {
        sentense = new PartOfSentence[length];
    }

    public boolean addToSentense(PartOfSentence partOfSentence) {
        if (counter <= sentense.length) {
            sentense[counter] = partOfSentence;
            counter++;
            return true;
        }
        return false;
    }

    int[] firstIn(String symb) {
        int[] res = new int[2];
        int position = -1;
        //printSentense();
        for (int i = 0; i < sentense.length; i++) {
            position = this.sentense[i].findFirst(symb);
            if (position != -1) {
                res[0] = i;
                res[1] = position;
                return res;
            }
        }
        res[1] = position;
        return res;
    }

    int[] lastIn(String symb) {
        int[] res = new int[2];
        for (int i = this.sentense.length - 1; i > 0; i--) {
            int position = this.sentense[i].findLast(symb);
            if (position != -1) {
                res[0] = i;
                res[1] = position;
                return res;
            }
        }
        res[0] = -1;
        return res;
    }

    public void setSentense(PartOfSentence[] sentense) {
        this.sentense = sentense;
    }

    void cutFromDIapOfSymb(String symbol) {
        int[] start = firstIn(symbol);
        int[] end = lastIn(symbol);
        if (start[0] == end[0] & start[1] == end[1]) {
            sentense[start[0]].deleteOneLetter(start[1]);
        } else if (start[0] == end[0]) {
            sentense[start[0]].deleteFromDiapason(start[1], end[1]);

        } else if (start[1] == -1 || end[1] == -1) {

        } else {
            PartOfSentence[] newSentance = new PartOfSentence[start[0] + sentense.length - end[0] + 1];
            System.arraycopy(this.sentense, 0, newSentance, 0, start[0]);
            Word firstPart = new Word();
            firstPart.setWord(sentense[start[0]].returnToPoint(start[1]));
            newSentance[start[0]] = firstPart;

            Word lastPart = new Word();
            lastPart.setWord(sentense[end[0]].returnfromPointToEnd(end[1]));
            newSentance[start[0] + 1] = lastPart;

            System.arraycopy(this.sentense, end[0], newSentance, start[0] + 1, sentense.length - end[0]);

            this.sentense = newSentance;
        }
    }

    void printSentense() {
        for (PartOfSentence part : this.sentense) {
            part.printThis();
        }
    }

}

class Word implements PartOfSentence {
    List<Letter> word = new ArrayList<Letter>();
    int counter = 0;

    public void setWord(List<Letter> word) {
        this.word = word;
    }

    void addToWord(Letter letter) {
        word.add(letter);
    }

    public List<Letter> getWord() {
        return word;
    }

    @Override
    public char returnSymb() {
        return 0;
    }

    public int findFirst(String symb) {
        for (int i = 0; i < word.size(); i++) {
            if (word.get(i).compare(symb)) {
                return i;
            }
        }
        return -1;
    }


    public int findLast(String symb) {
        for (int i = word.size() - 1; i > 0; i--) {
            if (word.get(i).compare(symb)) {
                return i;
            }
        }
        return -1;
    }

    public void deleteOneLetter(int index) {
        word.remove(index);
    }

    public void deleteFromDiapason(int start, int end) {
        List<Letter> newWord = new ArrayList<Letter>();

        for (int i = 0; i < start - 1; i++) {
            newWord.add(i, word.get(i));
        }

        for (int j = end; j < word.size(); j++) {
            newWord.add(word.get(j));
        }
        word = newWord;
    }

    public List<Letter> returnToPoint(int point) {
        List<Letter> newWord = new ArrayList<>();
        for (int i = 0; i < point; i++) {
            newWord.add(i, word.get(i));
        }
        return newWord;
    }

    public List<Letter> returnfromPointToEnd(int point) {
        List<Letter> newWord = new ArrayList<>();
        for (int i = point; i < this.word.size(); i++) {
            newWord.add(word.get(i));
        }
        word = newWord;
        return newWord;
    }

    @Override
    public void printThis() {
        System.out.print(" ");
        for (Letter letter : this.word) {
            letter.printLetter();
        }
    }
}

class Letter {
    String marking;
    String transcription;

    Letter(String mark) {
        this.marking = mark;
    }

    void printLetter() {
        System.out.print(marking);
    }

    boolean compare(String symbol) {
        return symbol.equals(marking);
    }

}

interface PartOfSentence {
    char returnSymb();

    int findFirst(String symb);

    int findLast(String symb);

    void deleteFromDiapason(int start, int end);

    List<Letter> returnToPoint(int point);

    List<Letter> returnfromPointToEnd(int point);

    void printThis();

    void deleteOneLetter(int index);
}

class SectionSign implements PartOfSentence {
    String symb;

    SectionSign(String mean) {
        this.symb = mean;
    }

    public List<Letter> returnfromPointToEnd(int point) {
        List<Letter> returnable = new ArrayList<Letter>();
        returnable.add(new Letter(" "));
        return returnable;
    }

    public void deleteOneLetter(int index) {
    }

    @Override
    public void printThis() {
        System.out.print(symb);
    }

    public List<Letter> returnToPoint(int point) {
        List<Letter> returnable = new ArrayList<Letter>();
        returnable.add(new Letter(""));
        return returnable;
    }

    public void deleteFromDiapason(int start, int end) {
    }

    @Override
    public char returnSymb() {
        return 0;
    }

    @Override
    public int findFirst(String symb) {
        if (this.symb.equals(symb)) {
            return 0;
        }
        return -1;
    }

    @Override
    public int findLast(String symb) {
        if (this.symb.equals(symb)) {
            return 0;
        }
        return -1;
    }
}