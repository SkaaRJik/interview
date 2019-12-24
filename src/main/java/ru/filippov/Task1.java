package ru.filippov;

import ru.filippov.sorter.BubbleSorter;
import ru.filippov.sorter.Sorter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {

        List<Double> values = new ArrayList<>(10);
        for (double i = 10; i >=0 ; i--) {
            values.add(i);
        }
        values.forEach(value -> System.out.print(value + " " ));

        Sorter sorter = new BubbleSorter();

        sorter.sort(values, (Comparator<Double>) (o1, o2) -> {
            if (o1 > o2) {
                return 1;
            } else if(o1 < o2) {
                return -1;
            }
            return 0;
        });
        values.forEach(value -> System.out.print(value + " " ));

    }
}
