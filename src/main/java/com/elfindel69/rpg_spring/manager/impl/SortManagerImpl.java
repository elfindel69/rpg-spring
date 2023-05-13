package com.elfindel69.rpg_spring.manager.impl;

import com.elfindel69.rpg_spring.handler.SortHandler;
import com.elfindel69.rpg_spring.manager.SortManager;
import com.elfindel69.rpg_spring.models.Sort;
import com.elfindel69.rpg_spring.services.SortService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SortManagerImpl implements SortManager {

    private final SortService sortService;

    @Override
    public Sort createSort(final SortHandler handler) {
        Sort sort = new Sort(handler);
        return sortService.editSort(sort);
    }

    @Override
    public Sort getSort(long id) {
        return sortService.getSort(id);
    }

    @Override
    public List<Sort> getSorts() {
        return sortService.getSorts();
    }

    @Override
    public void deleteSort(long id) {
        sortService.deleteSort(id);
    }
}
