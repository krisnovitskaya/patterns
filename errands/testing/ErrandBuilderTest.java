package krisnovitskaya.errands.testing;


import krisnovitskaya.errands.entities.Employee;
import krisnovitskaya.errands.entities.Errand;
import krisnovitskaya.errands.entities.ErrandBuilder;

import java.util.Date;

public class ErrandBuilderTest {
    public static void main(String[] args) {
        Errand err1 = new ErrandBuilder(new Employee("Ivanov", "Ivan", "Semenovich"), new Date(System.currentTimeMillis() + 1000000L), "Zavod")
                .id(145L)
                .status(Errand.Status.CONFIRMED)
                .matter(Errand.Matter.LOCAL)
                .create();

        err1.print();
    }
}
