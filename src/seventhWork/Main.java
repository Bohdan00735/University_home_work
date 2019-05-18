package seventhWork;

public class Main {
    public static void main(String[] args) {
        MySet mySet = new MySet();
        ICarriage first = new ICarriage(4,5,5,5);
        ICarriage second = new ICarriage(2,5,4,8);
        mySet.add(first);
        mySet.add(second);
        System.out.println(mySet.size());
    }


}
