package ru.filippov.repo;

import lombok.extern.log4j.Log4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.filippov.entity.EntitySort;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
@Log4j
public class SortRepositoryImpl implements SortRepository {

    SessionFactory sessionFactory;

    public SortRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<EntitySort> getSortById(Long id) {
        Session session = sessionFactory.openSession();
        EntitySort user = (EntitySort) session.load(EntitySort.class, id);
        session.close();

        return Optional.ofNullable(user);
    }

    @Override
    public Optional<List<EntitySort>> getPageableSorts(int limitPerPage, int page) {
        Session session = sessionFactory.openSession();



        Query query = session.createQuery("FROM EntitySort ").setFirstResult(calculateOffset(page, limitPerPage))
                .setMaxResults(limitPerPage);;
        List developers = query.list();
        session.close();
        return Optional.ofNullable(developers);
    }

    private int calculateOffset(int page, int limit) {
        return ((limit * page) - limit);
    }

    @Override
    public boolean saveSort(EntitySort entitySort) {
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.saveOrUpdate(entitySort);
            session.flush();
            session.getTransaction().commit();
        } catch (Exception ex) {

            ex.printStackTrace();
            log.error(ex.getMessage());
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean deleteSort(EntitySort entitySort) {
        Session session = sessionFactory.openSession();
        try {
            session.delete(entitySort);
            session.flush();
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return false;
        } finally {
            session.close();
        }
        return true;
    }
}
