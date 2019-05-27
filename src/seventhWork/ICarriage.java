package seventhWork;

import sixthWork.Carriage;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Objects;

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

    boolean CheakNext(Object o){
        try{
            if (nextICariage.equals(o)){
                return true;
            }else {
                nextICariage.CheakNext(o);
            }
        }catch (NullPointerException ex){
            return false;
        }return false;
    }

    ICarriage[] addToArray(ICarriage[] iCarriages, int position){
        try {
            iCarriages[position] = nextICariage;
            return nextICariage.addToArray(iCarriages, position+1);
        }catch (NullPointerException ex){
            System.out.println("All carriages packed");
        }return iCarriages;
    }

    boolean haveNext(){
        try {
            if (!nextICariage.equals(null)){
                return true;
            }
        }catch (NullPointerException e){}return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ICarriage iCarriage = (ICarriage) o;
        return Objects.equals(nextICariage, iCarriage.nextICariage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nextICariage);
    }

    void f(HashMap map, int size){
        map.put(size()- size, this);
    }
}
