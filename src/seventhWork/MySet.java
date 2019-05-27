package seventhWork;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MySet implements Set<ICarriage> {
    private ICarriage startCarige;

    @Override
    public int size() {
        return startCarige.size();
    }

    @Override
    public boolean isEmpty() {
        try{
            startCarige.equals(startCarige);
            return false;
        }catch (NullPointerException ex){
            return true;
        }
    }

    @Override
    public boolean contains(Object o) {
        try {
            if(startCarige.equals(o)){
                return true;
            }else {
                return startCarige.CheakNext(o);
            }
        }catch (NullPointerException ex){
            System.out.println("there isn`t any Objects");
        }
        return false;
    }

    @Override
    public Iterator<ICarriage> iterator() {
        return null;
    }

    @Override
    public ICarriage[] toArray() {
        ICarriage[] iCarriages = new ICarriage[size()];
        try {
            iCarriages[0] = startCarige;
        }catch (NullPointerException ex){
            return iCarriages;

        }
        return startCarige.addToArray(iCarriages, 1);
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        
        return null;
    }

    @Override
    public boolean add(ICarriage iCarriage) {
        try {
            iCarriage.addNext(startCarige);
            startCarige = iCarriage;
            return true;
        }catch (NullPointerException ex){
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends ICarriage> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }
}
