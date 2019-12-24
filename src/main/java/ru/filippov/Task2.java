package ru.filippov;

import lombok.extern.log4j.Log4j;
import org.hibernate.SessionFactory;

import ru.filippov.entity.EntitySort;
import ru.filippov.repo.SortRepository;
import ru.filippov.repo.SortRepositoryImpl;
import ru.filippov.sorter.BubbleSorter;
import ru.filippov.utils.HibernateUtils;

import java.sql.SQLException;
import java.util.*;
@Log4j
public class Task2 {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        SortRepository sortRepository = new SortRepositoryImpl(sessionFactory);

        List<Double> values = new ArrayList<>(10);
        for (double i = 20; i >=0 ; i--) {
            values.add(i);
        }

        StringBuilder stringBuilder = new StringBuilder(30);
        values.stream().forEach(value -> stringBuilder.append(value + " "));




        new BubbleSorter().sort(values, (Comparator<Double>) (o1, o2) -> {
            if (o1 > o2) {
                return 1;
            } else if(o1 < o2) {
                return -1;
            }
            return 0;
        });

        StringBuilder stringBuilder2 = new StringBuilder(30);

        values.stream().forEach(value -> stringBuilder2.append(value + " "));

        EntitySort entity = new EntitySort();
        entity.setInputs(stringBuilder.toString());
        entity.setOutput(stringBuilder2.toString());
        entity.setDate(new Date());

        sortRepository.saveSort(entity);

        sessionFactory.close();



    }
}
