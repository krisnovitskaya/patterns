package ru.krisnovitskaya.errandstm.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.krisnovitskaya.errandstm.dtos.ErrandDto;
import ru.krisnovitskaya.errandstm.dtos.ErrandSimpleDto;
import ru.krisnovitskaya.errandstm.entities.Errand;
import ru.krisnovitskaya.errandstm.repository.ErrandRepository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ErrandService {
    private final ErrandRepository errandRepository;
    private Map<Long, Errand> cache;

    @PostConstruct
    private void init() {
        cache = new HashMap<>();
    }

    public List<ErrandDto> getAllByEmployeeId(Long id) {
        return errandRepository.getAllByEmployeeId(id).stream().map(ErrandDto::new).collect(Collectors.toList());
    }

    public void delete(Long id) {
        Errand errand = cache.get(id);
        if (errand == null) {
            errand = errandRepository.findById(id).get();
        } else {
            cache.remove(errand.getId());
        }
        errandRepository.delete(errand);
    }

    public List<ErrandDto> getCurrentErrands(){
        return errandRepository.getCurrentErrands().stream().map(ErrandDto::new).collect(Collectors.toList());
    }

    public List<ErrandSimpleDto> getCurrentForPostSecurity(){
        return errandRepository.getCurrentErrands().stream().map(ErrandSimpleDto::new).collect(Collectors.toList());
    }
}
