package krisnovitskaya.errands.database;

import krisnovitskaya.errands.entities.Employee;
import krisnovitskaya.errands.entities.Errand;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class DummyDataBase {
    private static DummyDataBase instance;
    private Set<Errand> confirmedErrands;


    private DummyDataBase(){
        confirmedErrands = new HashSet<>();
        addDummyErrand();
    }


    public static DummyDataBase getInstance(){
        DummyDataBase localInstance = instance;
        if(localInstance == null){
            synchronized (DummyDataBase.class){
                localInstance = instance;
                if(localInstance == null){
                    instance = localInstance = new DummyDataBase();
                }
            }
        }
        return  localInstance;
    }



    private void addDummyErrand(){
        confirmedErrands.add(new Errand(new Employee("Ivanov", "Ivan", "Nikitich"), new Date(), "Zavod1"));
        confirmedErrands.add(new Errand(new Employee("Ivanova", "Zoya", "Nikitichna"), new Date(), "Zavod2"));
        confirmedErrands.add(new Errand(new Employee("Danilov", "Lev", "Ivanovich"), new Date(), "Zavod1"));
        confirmedErrands.add(new Errand(new Employee("Kasatikov", "Oleg", "Alekseevich"), new Date(), "Zavod3"));
        confirmedErrands.add(new Errand(new Employee("Ilingina", "Eva", "Aleksandrovna"), new Date(), "Zavod1"));
    }


    public void addNewErrand(Errand errand){
        confirmedErrands.add(errand);
    }

    public boolean findByFullName(String fullName){
        for (Errand errand : confirmedErrands) {
            if(errand.getEmployee().getFullName().equals(fullName)){
                return true;
            }
        }
        return false;
    }

}
