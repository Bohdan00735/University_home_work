package sixthWork;

import seventhWork.ICarriage;
import seventhWork.MyExeption;
import seventhWork.MySet;

public class Carriage implements Truck  {

    int comfortable;
    int numOfSeats;
    int numOfLuggage;
    String[] seats;
    int[] baggage;
    public  int nummber;

    public Carriage(int comfortable, int numOfSeats, int numOfLuggage, int nummber) throws MyExeption {
        if(comfortable<=0 | numOfSeats<=0 | numOfLuggage<=0 | nummber <= 0){
            throw new MyExeption();
        }
        this.comfortable = comfortable;
        this.numOfSeats = numOfSeats;
        this.numOfLuggage = numOfLuggage;
        this.seats = new String[numOfSeats];
        this.baggage = new int[numOfSeats];
        this.nummber = nummber;
    }

    public Carriage() {
    }

    public int addPassanger(String name, String surname, int numOfPassport, int luggage, int place) {
        try {
            try {
                seats[place].equals(" ");
                System.out.println("this place was occupied earlier");
                return -1;
            } catch (NullPointerException ex) {
                String passport = String.valueOf(numOfPassport);
                seats[place] = name + " " + surname + ": " + passport;
                if (luggage <= this.numOfLuggage / numOfSeats) {
                    baggage[place] = luggage;
                } else {
                    System.out.println("there is too match of lugagge");
                    return -2;
                }
            }

        } catch (IndexOutOfBoundsException exeption) {
            System.out.println("this place out of bound of num of places");
            return 0;

        }
        return 1;
    }

    public int calculateNumOfPassanger() {
        int result = 0;
        for (String name : seats) {
            try {
                name.equals(" ");
                result++;
            } catch (NullPointerException n) {
            }
        }
        return result;

    }

    public int calculateNuOfLuggage() {
        int result = 0;
        try {
            for (int luggage : baggage) {
                result += luggage;
            }
        } catch (NullPointerException n) {
        }
        return result;
    }

}
