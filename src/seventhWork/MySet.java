package seventhWork;

import sixthWork.Carriage;

import javax.lang.model.type.NullType;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

public class MySet implements Set<ICarriage> {
    private ICarriage head;

    @Override
    public int size() {
        try{return head.size();
        }catch (NullPointerException e){
            return 0;
        }
    }

    @Override
    public boolean isEmpty() {
        try{
            return head.haveNext();
        }catch (NullPointerException ex){
            return true;
        }
    }

    @Override
    public boolean contains(Object o) {
        try {
            if(head.equals(o)){
                return true;
            }else {
                return head.CheakNext(o);
            }
        }catch (NullPointerException ex){
            System.out.println("there isn`t any Objects");
        }
        return false;
    }

    @Override
    public Iterator<ICarriage> iterator() {

        return new Iterator<ICarriage>() {
            ICarriage current = head;
            @Override
            public boolean hasNext() {
                return current.haveNext();
            }

            @Override
            public ICarriage next() throws IndexOutOfBoundsException{
                if (!current.haveNext()) throw new IndexOutOfBoundsException("End of set.");
                ICarriage returnable = current;
                current = current.nextICariage;
                return returnable;
            }
        };
    }

    @Override
    public ICarriage[] toArray() {
        ICarriage[] iCarriages = new ICarriage[size()+1];
        try {
            iCarriages[0] = head;
        }catch (NullPointerException ex){
            return iCarriages;

        }
        return head.addToArray(iCarriages, 1);
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        ICarriage current = null;
        try {
            current = head;
        }catch (NullPointerException n){

            return (T[]) new Object[0];
        }

        if (ts.length < this.size()){
            ts = (T[]) new Object[this.size()];
                    }
        for (int i = 0; i< this.size(); i++){
            ts[i] = (T) current;
            current = current.nextICariage;
        }
        return ts;
    }

    @Override
    public boolean add(ICarriage iCarriage) {
        if (this.contains(iCarriage)){return false;}
        try {
            iCarriage.addNext(head);
            head = iCarriage;
            return true;
        }catch (NullPointerException ex){
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
        if (head.equals(o)){
            head = head.nextICariage;
            return true;
        }else {
            ICarriage carrent = head;
            while (true){
                if (carrent.haveNext()){
                    if(carrent.nextICariage.equals(o)) {
                        try {
                            carrent.nextICariage = carrent.nextICariage.nextICariage;
                        }catch (NullPointerException e){
                            carrent.nextICariage = null;
                        }
                        return true;
                    }
                }else{
                    return false;
                }
            }
        }
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> i = collection.iterator();
        while (i.hasNext()){
            if (!this.contains(i.next())){return false;}
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends ICarriage> collection) {

        for (Iterator<? extends ICarriage> i = collection.iterator(); i.hasNext();) {
            this.add(i.next());
        }

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()){
            ICarriage current = (ICarriage) iterator.next();
            if (!collection.contains(current)){
                remove(current);
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()){
            Object o = iterator.next();
            if (collection.contains(o)){
                remove(o);

            }
        }
        return true;
    }

    @Override
    public void clear() {
        head = null;
    }
}
