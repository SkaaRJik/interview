package ru.filippov.task3.JPARepos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.filippov.entity.EntitySort;

@Repository
public interface SortRepo extends CrudRepository<EntitySort, Long> {
}
