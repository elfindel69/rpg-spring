package com.elfindel69.rpg_spring.services;

import com.elfindel69.rpg_spring.models.Sort;

import java.util.List;

public interface SortService {
    Sort editSort(Sort sort);

    Sort getSort(long id);

    List<Sort> getSorts();

    void deleteSort(long id);
}
