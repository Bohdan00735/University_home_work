package sixthWork;

import java.util.Arrays;
import java.util.Scanner;

public class Train {
    int numOfWagons;
    Carriage [] wagons;
    Tractor tractor;
    String director;
    int nummberOfTrain;
    String route;
    int spaceForWagon = 0;

    public Train(int numOfWagons, Tractor tractor, String director, int nummberOfTrain, String route) {
        this.numOfWagons = numOfWagons;
        this.wagons = new Carriage[numOfWagons];
        this.tractor = tractor;
        this.director = director;
        this.nummberOfTrain = nummberOfTrain;
        this.route = route;
    }

    boolean addInTheEndWagon(Carriage truck){
        if (spaceForWagon <= numOfWagons){
            wagons[spaceForWagon] = truck;
            spaceForWagon++;
            return true;
        }return false;
    }

    boolean addInTheSpace(int space, Carriage truck){
        if (space >= numOfWagons) {
            return false;
        }wagons[space] = truck;
        return true;
    }

    int calculateNumOfPassengers(){
        int result = 0;
        for (Truck truck: wagons){
            result+=truck.calculateNumOfPassanger();
        }return result;
    }

    int calculateNumOfLuggage(){
        int result = 0;
        for (Truck truck: wagons){
            result+=truck.calculateNuOfLuggage();
        }return result;
    }

    void sortByComfort(){
        Arrays.sort(wagons, new SortByComfortable());
        System.out.println("\n Wagons was sorted by comfortable");
    }

    void showInRowByNum(){
        System.out.println("\n");
        for (Carriage carriage:wagons){
            System.out.printf("%d(%d), ",carriage.nummber, carriage.comfortable);
        }
    }

    void findWagonInDiap(){
        Scanner scanner = new Scanner(System.in);
        Checker checker = new Checker();
        int [] bounds = checker.checkForBound(scanner);
        int calc = 0;
        for (Carriage carriage: wagons){
            int numOfPassenger = carriage.calculateNumOfPassanger();
            if (numOfPassenger <=bounds[1] && numOfPassenger>= bounds[0]){
                System.out.printf("\n %d Passengers(%d), ", carriage.nummber, numOfPassenger);
                calc++;
            }
        }
        if (calc == 0){
            System.out.println("there is no wagon with passengers from set diapason");
        }
    }
}
