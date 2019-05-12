package sixthWork;

public class Train {
    int numOfWagons;
    Truck [] wagons;
    Tractor tractor;
    String director;
    int nummberOfTrain;
    String route;
    int spaceForWagon = 0;

    public Train(int numOfWagons, Tractor tractor, String director, int nummberOfTrain, String route) {
        this.numOfWagons = numOfWagons;
        this.wagons = new Truck[numOfWagons];
        this.tractor = tractor;
        this.director = director;
        this.nummberOfTrain = nummberOfTrain;
        this.route = route;
    }

    boolean addInTheEndWagon(Truck truck){
        if (spaceForWagon <= numOfWagons){
            wagons[spaceForWagon] = truck;
            spaceForWagon++;
            return true;
        }return false;
    }

    boolean addInTheSpace(int space, Truck truck){
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
}
