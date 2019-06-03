package seventhWork.setTests.seventhWork;

import org.junit.Test;
import seventhWork.ICarriage;
import seventhWork.MySet;
import sixthWork.Carriage;
import sixthWork.RandomSetter;
import sixthWork.SV;
import sixthWork.Train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.*;

public class MySetTest {
    private Train train;
    private MySet setOfWagons;

    public MySetTest() {
        RandomSetter randomSetter = new RandomSetter();
        train = randomSetter.makeNewPassengerTrain();
        setOfWagons = new MySet();


    }

    @Test
    public void isEmpty() {

        assertTrue(setOfWagons.isEmpty());
    }

    @Test
    public void size() {
        setOfWagons.addAll(new ArrayList<ICarriage>(Arrays.asList((ICarriage[])train.getWagons())));
        assertEquals(train.getWagons().length, setOfWagons.size());
    }

    @Test
    public void contains() {
        setOfWagons.addAll(new ArrayList<ICarriage>(Arrays.asList((ICarriage[]) train.getWagons())));
        assertTrue(setOfWagons.contains(train.getWagons()[train.getWagons().length-1]));
        assertFalse(setOfWagons.contains(train));
    }

    @Test
    public void iterator() {
        setOfWagons.addAll(new ArrayList<ICarriage>(Arrays.asList((ICarriage[]) train.getWagons())));
        Iterator<ICarriage> iterator = setOfWagons.iterator();
        int i = 0;
        while (iterator.hasNext()){
            System.out.println(iterator.next().nummber);
            i++;
        }
        assertEquals(setOfWagons.size()-1, i);
    }

    @Test
    public void toArray() {
        setOfWagons.addAll(new ArrayList<ICarriage>(Arrays.asList((ICarriage[]) train.getWagons())));

        ICarriage[] carriages = setOfWagons.toArray();
        for (ICarriage carriage : carriages){
            System.out.println(carriage.nummber);
        }
    }

    @Test
    public void toArray1() {
        setOfWagons.addAll(new ArrayList<ICarriage>(Arrays.asList((ICarriage[]) train.getWagons())));

        Object[] carriages = setOfWagons.toArray(new Object[5]);
        for (Object o: carriages){
            System.out.println(o.toString());
        }
    }

    @Test
    public void add() {

        SV sv = new SV(55);
        setOfWagons.add(sv);
        assertEquals(55, setOfWagons.toArray()[0].nummber);

    }

    @Test
    public void remove() {
        setOfWagons.addAll(new ArrayList<ICarriage>(Arrays.asList((ICarriage[]) train.getWagons())));
        Carriage carriage = train.getWagons()[train.getWagons().length-2];
        setOfWagons.remove(carriage);
        assertFalse(setOfWagons.contains(carriage));
    }

    @Test
    public void containsAll() {
        setOfWagons.addAll(new ArrayList<ICarriage>(Arrays.asList((ICarriage[]) train.getWagons())));
        Carriage[] newtrain = new ICarriage[5];
        System.arraycopy(train.getWagons(),train.getWagons().length-5,newtrain,0,5);
        System.out.println(newtrain[0].nummber);
        assertTrue(setOfWagons.containsAll(Arrays.asList((ICarriage[])newtrain)));

    }

    @Test
    public void addAll() {
        setOfWagons.addAll(new ArrayList<ICarriage>(Arrays.asList((ICarriage[]) train.getWagons())));

        assertTrue(setOfWagons.containsAll(Arrays.asList((ICarriage[])train.getWagons())));
    }

    @Test
    public void retainAll() {
        Carriage[] carriages = new ICarriage[10];
        System.arraycopy(train.getWagons(),0, carriages, 0,10);
        setOfWagons.addAll(new ArrayList<ICarriage>(Arrays.asList((ICarriage[]) carriages)));
        Carriage[] newtrain = new ICarriage[3];
        System.arraycopy(carriages,0,newtrain,0,3);

        setOfWagons.retainAll(Arrays.asList((ICarriage[])newtrain));
        assertTrue(setOfWagons.containsAll(Arrays.asList((ICarriage[])newtrain)));
        newtrain = new ICarriage[7];
        System.arraycopy(carriages,3, newtrain, 0,7);
        assertFalse(setOfWagons.contains(newtrain));
    }

    @Test
    public void removeAll() {
        setOfWagons.addAll(new ArrayList<ICarriage>(Arrays.asList((ICarriage[]) train.getWagons())));
        Carriage[] newtrain = new ICarriage[5];
        System.arraycopy(train.getWagons(),train.getWagons().length-5,newtrain,0,5);
        setOfWagons.removeAll(Arrays.asList((ICarriage[])newtrain));

        assertFalse(setOfWagons.containsAll(Arrays.asList((ICarriage[])newtrain)));
    }

    @Test
    public void clear() {
        setOfWagons.addAll(new ArrayList<ICarriage>(Arrays.asList((ICarriage[]) train.getWagons())));
        setOfWagons.clear();
        assertEquals(0, setOfWagons.size());
    }
}