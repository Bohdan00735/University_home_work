package forthWork;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class School {
    int number;
    int specialisation;
    int numOfpupil;
    int numOfTeachers;
    String district;

    School(int number, int specialisation, int numOfpupil, int numOfTeachers, String district){
        this.number = number;
        this.specialisation = specialisation;
        this.numOfpupil = numOfpupil;
        this.numOfTeachers = numOfTeachers;
        this.district = district;
    }

    public String toString(){
        return  String.format("number %s specislisation %s num of pupil %s, num of teachers %s district :\'%s\'",
                this.number, this.specialisation, this.numOfpupil, this.numOfTeachers, this.district);
    }
}

class SortByNum implements Comparator<School>{
    public int compare(School schoola, School schoolb){
        return schoola.number - schoolb.number;
    }
        }

class SortByPupils implements Comparator<School>{
    public int compare(School schoola, School schoolb){
        return schoolb.numOfpupil - schoola.numOfpupil;
    }
}

class Main{
    public static void main(String[] args) {
        School [] schools = new School[6];
        schools[1] = new School(1,3,503,25,"Podil");
        schools[2] = new School(6,2,725,33,"Pecherkiy");
        schools[0] = new School(271, 2,500,27,"Schevchenkivkiy");
        schools[3] = new School(2, 1, 260, 9, "Desnyankiy");
        schools[4] = new School(8,3,1011,56,"Obolon");
        schools[5] = new School(17,2,666,37,"Dartynskiy");

        System.out.println("unsorted array");

        for (School i:schools){
            System.out.println(i);
        }

        Arrays.sort(schools, new SortByNum());

        System.out.println("sorted array by number : \n");

        for (School i:schools){
            System.out.println(i);
        }

        Arrays.sort(schools, new SortByPupils());

        System.out.println("sorted array by num of pupils in reversed order : \n");

        for (School i:schools){
            System.out.println(i);
        }
    }
}