package sixthWork;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(8119%13);
        RandomSetter randomSetter = new RandomSetter();
        Train train = randomSetter.makeNewPassengerTrain();
        System.out.printf("there is %d passengers in the train",train.calculateNumOfPassengers());
        System.out.printf("\n there is %d luggage in the train",train.calculateNumOfLuggage());

        train.showInRowByNum();
        train.sortByComfort();
        train.showInRowByNum();
        train.findWagonInDiap();
    }
}
