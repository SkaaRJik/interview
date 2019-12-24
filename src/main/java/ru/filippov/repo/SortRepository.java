package ru.filippov.repo;

import ru.filippov.entity.EntitySort;

import java.util.List;
import java.util.Optional;

public interface SortRepository {
    Optional<EntitySort> getSortById(Long id);
    Optional<List<EntitySort>> getPageableSorts(int limitPerPage, int page);
    boolean saveSort(EntitySort entitySort);
    boolean deleteSort(EntitySort entitySort);
}
