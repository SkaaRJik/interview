package ru.filippov.sorter;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;


public class BubbleSorterTest {
    private final Sorter sorter = new BubbleSorter();
    @Test
    public void doubleBubbleSort() {
        List<Double> values = new ArrayList<>(21);
        for (double i = 10; i >=0 ; i-=0.5) {
            values.add(i);
        }

        this.sorter.sort(values, (Comparator<Double>) (o1, o2) -> {
            if (o1 > o2) {
                return 1;
            } else if(o1 < o2) {
                return -1;
            }
            return 0;
        });

        for (double i = 0, j = 0; j < values.size(); i+=0.5, j++) {
            Assert.assertEquals(Double.valueOf(i), values.get((int)j));

        }
    }

    @Test
    public void integerBubbleSort() {
        List<Integer> values = new ArrayList<>(10);
        for (int i = 10; i >=0 ; i--) {
            values.add(i);
        }

        this.sorter.sort(values, (Comparator<Integer>) (o1, o2) -> {
            if (o1 > o2) {
                return 1;
            } else if(o1 < o2) {
                return -1;
            }
            return 0;
        });

        for (int i = 0; i < values.size(); i++) {
            Assert.assertEquals(i, (int)values.get(i));
        }
    }

    @Test
    public void ObjectBubbleSort() {

        class Entity {
            int firstParam;
            float secondParam;


            public Entity(int firstParam, float secondParam) {
                this.firstParam = firstParam;
                this.secondParam = secondParam;
            }

            public int getFirstParam() {
                return firstParam;
            }

            public float getSecondParam() {
                return secondParam;
            }
        }

        List<Entity> values = new ArrayList<>(10);
        int i = 0;
        float j = 0f;
        for (i = 10, j = 20f; i >=0 ; i--, j-=0.3f) {
            values.add(new Entity(i, j));
        }

        this.sorter.sort(values, (Comparator<Entity>) (o1, o2) -> {
            if (o1.secondParam > o2.secondParam) {
                return 1;
            } else if(o1.secondParam < o2.secondParam) {
                return -1;
            }
            return 0;
        });

        //Using Float.valueOf() because Assert.assertEquals(float, float) method is deprecated
        for (i = 0, j = 17.000008f; i < values.size(); i++, j+=0.3) {
            Assert.assertEquals(Float.valueOf(j), Float.valueOf(values.get(i).getSecondParam()));
        }
    }

}