package krisnovitskaya.errands.testing;

import krisnovitskaya.errands.controllers.ProxySecurityPostController;
import krisnovitskaya.errands.database.DummyDataBase;
import krisnovitskaya.errands.entities.Employee;
import krisnovitskaya.errands.entities.Errand;

import java.util.Date;

public class ProxyTest {
    public static void main(String[] args) {
        ProxySecurityPostController mainPost = new ProxySecurityPostController();
        ProxySecurityPostController backPost = new ProxySecurityPostController();
        DummyDataBase dummyDataBase = DummyDataBase.getInstance();

        //employee try to exit

        System.out.println("mainPost");
        mainPost.errandExist("Danilov Lev Ivanovich");
        mainPost.errandExist("Danilov Lev Ivanovich");
        mainPost.printCache();
        mainPost.errandExist("Kasatikov Oleg Alekseevich");
        mainPost.errandExist("Danileev Leonid Ivanovich");
        mainPost.printCache();
        mainPost.errandExist("Iliin Alex Aleksandrovich");
        //add new errand
        dummyDataBase.addNewErrand(new Errand(new Employee("Iliin", "Alex", "Aleksandrovich"), new Date(), "Zavod1"));
        mainPost.printCache();
        mainPost.errandExist("Iliin Alex Aleksandrovich");
        mainPost.printCache();


        System.out.println("backPost");
        backPost.printCache();
        backPost.errandExist("Danilov Lev Ivanovich");
        backPost.errandExist("Ivanova Zoya Nikitichna");
        backPost.errandExist("Danileev Leonid Ivanovich");
        backPost.printCache();
        backPost.errandExist("Iliin Alex Aleksandrovich");
        backPost.printCache();

    }
}
