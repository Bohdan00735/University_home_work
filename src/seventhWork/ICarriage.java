package seventhWork;

import sixthWork.Carriage;

public class ICarriage extends Carriage {
ICarriage nextICariage;

    ICarriage(int comfortable, int numOfSeats, int numOfLuggage, int nummber) {
        super(comfortable, numOfSeats, numOfLuggage, nummber);
    }

    public void addNext(ICarriage nextICariage) {
        this.nextICariage = nextICariage;
    }

    int size(){
    int result=1;
    try {
        result+=nextICariage.size();
    }catch (NullPointerException exeption){
        result+=0;
    }return result;


}
}