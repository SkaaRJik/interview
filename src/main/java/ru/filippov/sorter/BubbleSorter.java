package ru.filippov.sorter;

import java.util.Comparator;
import java.util.List;


public class BubbleSorter implements Sorter {

    @Override
    public void sort(List input, Comparator comparator) {
        int arraySize = input.size();
        boolean wasSwapped = true; //Sort completion marker
        Object temp; // temp value to help with sorting by swapping

        while (wasSwapped) {
            wasSwapped = false;
            for (int i = 0; i < arraySize - 1; i++) {
                if (i + 1 < arraySize) {
                    if (comparator.compare(input.get(i), input.get(i + 1)) == 1) {
                        /*Swapping elements*/
                        temp = input.get(i);
                        input.set(i, input.get(i+1));
                        input.set(i+1, temp);

                        wasSwapped = true; //Mark this to look for unsorted elements in next iteration
                    }
                }
            }
        }

    }

}
