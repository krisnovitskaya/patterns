package krisnovitskaya.errands.testing;

import krisnovitskaya.errands.entities.Department;
import krisnovitskaya.errands.entities.Employee;
import krisnovitskaya.errands.entities.iterators.EmployeeIterator;

public class EmployeeIteratorTest {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1L);
        Employee emp2 = new Employee(2L);
        Employee emp3 = new Employee(3L);
        Employee emp4 = new Employee(4L);
        Employee emp5 = new Employee(5L);
        Employee emp6 = new Employee(6L);
        Employee emp7 = new Employee(7L);
        Employee emp8 = new Employee(8L);
        Employee emp9 = new Employee(9L);
        Employee emp10 = new Employee(10L);
        Employee emp11 = new Employee(11L);
        Employee emp12 = new Employee(12L);
        Employee emp13 = new Employee(13L);
        Employee emp14 = new Employee(14L);
        Employee emp15 = new Employee(15L);
        Employee emp16 = new Employee(16L);
        Employee emp17 = new Employee(17L);
        Employee emp18 = new Employee(18L);
        Employee emp19 = new Employee(19L);
        Employee emp20 = new Employee(20L);
        Employee emp21 = new Employee(21L);
        Employee emp22 = new Employee(22L);
        Employee emp23 = new Employee(23L);
        Employee emp24 = new Employee(24L);
        Employee emp25 = new Employee(25L);

        Department dep1 = new Department();
        Department dep2 = new Department();
        Department dep3 = new Department();
        Department dep4 = new Department();
        Department dep5 = new Department();
        Department dep6 = new Department();
        Department dep7 = new Department();
        Department dep8 = new Department();
        Department dep9 = new Department();
        Department dep10 = new Department();

        dep1.setMaster(emp1);
        dep1.getEmployees().add(emp2);
        dep1.getEmployees().add(emp3);
        dep1.getDirectlySubordinatedDepartments().add(dep2);
        dep1.getDirectlySubordinatedDepartments().add(dep3);

        dep2.setMaster(emp4);
        dep2.getEmployees().add(emp5);
        dep2.getEmployees().add(emp6);
        dep2.getEmployees().add(emp7);
        dep2.getDirectlySubordinatedDepartments().add(dep4);

        dep4.setMaster(emp8);
        dep4.getEmployees().add(emp9);
        dep4.getEmployees().add(emp10);

        dep3.setMaster(emp11);
        dep3.getDirectlySubordinatedDepartments().add(dep5);
        dep3.getDirectlySubordinatedDepartments().add(dep6);
        dep3.getDirectlySubordinatedDepartments().add(dep7);

        dep5.setMaster(emp12);
        dep5.getEmployees().add(emp13);
        dep5.getEmployees().add(emp14);
        dep5.getEmployees().add(emp15);
        dep5.getDirectlySubordinatedDepartments().add(dep8);


        dep8.setMaster(emp16);
        dep8.getEmployees().add(emp17);
        dep8.getEmployees().add(emp18);
        dep8.getDirectlySubordinatedDepartments().add(dep9);
        dep8.getDirectlySubordinatedDepartments().add(dep10);

        dep9.setMaster(emp19);
        dep9.getEmployees().add(emp20);

        dep10.setMaster(emp21);

        dep6.setMaster(emp22);
        dep6.getEmployees().add(emp23);

        dep7.setMaster(emp24);
        dep7.getEmployees().add(emp25);


        // 24	22	21	19	16	12	11	8	4
        EmployeeIterator iterMaster = dep1.createMasterIterator();

        while(iterMaster.hasNext()){
            System.out.print(iterMaster.getNext().getId() + "\t");
        }
        System.out.println();

        //25	24	23	22	21	20	19	18	17	16	15	14	13	12	11	10	9	8	7	6	5	4	3	2	1
        EmployeeIterator iterAll = dep1.createAllSubordinatedIterator();

        while(iterAll.hasNext()){
            System.out.print(iterAll.getNext().getId() + "\t");
        }
        System.out.println();

    }
}
