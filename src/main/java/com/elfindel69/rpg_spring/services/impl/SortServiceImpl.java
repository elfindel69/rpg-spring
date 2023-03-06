package com.elfindel69.rpg_spring.services.impl;

import com.elfindel69.rpg_spring.models.Sort;
import com.elfindel69.rpg_spring.repository.SortRepository;
import com.elfindel69.rpg_spring.services.SortService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SortServiceImpl implements SortService {
    private final SortRepository repository;
    @Override
    public Sort createSort(Sort sort) {
        return repository.save(sort);
    }

    @Override
    public Sort getSort(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Sort> getSorts() {
        return repository.findAll();
    }

    @Override
    public void deleteSort(long id) {
        repository.deleteById(id);
    }
}
