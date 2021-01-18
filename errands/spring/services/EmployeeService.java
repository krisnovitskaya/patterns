package ru.krisnovitskaya.errandstm.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.krisnovitskaya.errandstm.dtos.EmployeeDto;
import ru.krisnovitskaya.errandstm.entities.Department;
import ru.krisnovitskaya.errandstm.entities.Employee;
import ru.krisnovitskaya.errandstm.exceptions.ResourceNotFoundException;
import ru.krisnovitskaya.errandstm.repository.DepartmentRepository;
import ru.krisnovitskaya.errandstm.repository.EmployeeRepository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private Map<Long, Employee> cache;

    @PostConstruct
    private void init() {
        cache = new HashMap<>();
    }

    public EmployeeDto findById(Long id) {
        Employee employee = cache.get(id);
        if(employee == null){
            employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found employee with such id"));
            cache.put(employee.getId(), employee);
        }
        return new EmployeeDto(employee);

    }

    public List<EmployeeDto> findByDepartmentId(Long id){
        return employeeRepository.getAllByDepartmentId(id).stream().map(EmployeeDto::new).collect(Collectors.toList());
    }

    public void saveNewEmployee(Employee newEmployee, Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        newEmployee.setId(null);
        newEmployee.setDepartment(department);
        Employee employee = employeeRepository.save(newEmployee);
        cache.put(employee.getId(), employee);
    }

    public void updateEmployee(EmployeeDto changedEmployee, String departmentTitle ) {
        Employee employee = employeeRepository.findById(changedEmployee.getId()).get();
        Department department = employee.getDepartment();
        if(!employee.getDepartment().getTitle().equals(departmentTitle)){
            department = departmentRepository.findByTitle(departmentTitle).get();
        }
        employee.update(changedEmployee);
        employeeRepository.save(employee);
    }

    public void delete(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        Department department = employee.getDepartment();
        department.getEmployees().remove(employee);
        if(department.getMaster().equals(employee)){
            department.setMaster(null);
        }
        departmentRepository.save(department);
        employeeRepository.delete(employee);
        cache.remove(employee.getId());
    }
}
