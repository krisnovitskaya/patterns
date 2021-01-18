package ru.krisnovitskaya.errandstm.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.krisnovitskaya.errandstm.dtos.DepartmentDto;
import ru.krisnovitskaya.errandstm.entities.Department;
import ru.krisnovitskaya.errandstm.exceptions.ResourceNotFoundException;
import ru.krisnovitskaya.errandstm.repository.DepartmentRepository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private Map<Long, Department> cache;

    @PostConstruct
    private void init(){
        cache = new HashMap<>();
    }

    public List<DepartmentDto> getAll() {
        return departmentRepository.findAll().stream().map(DepartmentDto::new).collect(Collectors.toList());
    }

    public DepartmentDto findById(Long id){
        Department department = cache.get(id);
        if(department == null){
            department = departmentRepository.findById(id).get();
        }
        return new DepartmentDto(department);
    }


    public boolean deleteById(Long id){
        Department department = cache.get(id);
        if(department == null) {
            department = departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found department"));
        }
        if(checkReferences(department)){
            departmentRepository.delete(department);
            cache.remove(id);
            return true;
        }
        return false;
    }

    private boolean checkReferences(Department department){
        if(department.getMaster() != null){
            return false;
        }
        if(department.getEmployees().size() > 0){
            return false;
        }
        return true;
    }
}
