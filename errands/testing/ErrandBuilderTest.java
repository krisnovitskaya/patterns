package testing;

import entities.Employee;
import entities.Errand;
import entities.ErrandBuilder;

import java.util.Date;

public class ErrandBuilderTest {
    public static void main(String[] args) {
        Errand err1 = new ErrandBuilder(new Employee("Vasya"), new Date(System.currentTimeMillis() + 1000000L), "Zavod")
                .id(145L)
                .status(Errand.Status.CONFIRMED)
                .matter(Errand.Matter.LOCAL)
                .create();

        err1.print();
    }
}
