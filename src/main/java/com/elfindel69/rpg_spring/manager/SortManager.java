package com.elfindel69.rpg_spring.manager;

import com.elfindel69.rpg_spring.handler.SortHandler;
import com.elfindel69.rpg_spring.models.Sort;

import java.util.List;

public interface SortManager {
    Sort createSort(final SortHandler handler);

    Sort getSort(long id);

    List<Sort> getSorts();

    void deleteSort(long id);
}
