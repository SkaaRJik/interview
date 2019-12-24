package ru.filippov.sorter;

import java.util.Comparator;
import java.util.List;

public interface Sorter {
    /**
     * Sort objects with help of {@link Comparator}
     * @param input
     * @param comparator
     */
    void sort(List input, Comparator comparator);
}
