package it.unibo.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }
    private static final int INITIAL_VALUE = 1000;
    private static final int FINAL_VALUE = 2000;
    private static final int ELEMS_ADD = 100_000;
    private static final int ELEMS2_ADD = 1000;
    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        ArrayList<Integer> arr = new ArrayList<>();
        //magic numbers occhio
        for (int i = INITIAL_VALUE; i < FINAL_VALUE; i++) {
            arr.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer> list = new LinkedList<>(arr);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final int tmp = arr.get(arr.size() - 1);
        arr.set(arr.size() - 1, arr.get(0));
        arr.set(0, tmp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        System.out.print("[");
        for (int elem : arr) {
            System.out.print(elem + ", ");
        }
        System.out.println("\b\b]");
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for (int i = 0; i < ELEMS_ADD; i++) {
            list.add(0, i);
        }
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);

        System.out.println("Time to add " + ELEMS_ADD + " elements in the head of a list: " + time + "ns (" + millis + " ms)");

        time = System.nanoTime();
        for (int i = 0; i < ELEMS_ADD; i++) {
            arr.add(0, 10);        
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("Time to add " + ELEMS_ADD + " elements in the head of an array: " + time + "ns (" + millis + " ms)");        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */
        time = System.nanoTime();
        int index = arr.size() / 2;
        for (int i = 0; i < ELEMS2_ADD; i++) {
            list.get(index);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);

        System.out.println("Time to add " + ELEMS2_ADD + " elements in the middle of a list: " + time + "ns (" + millis + " ms)");
        time = System.nanoTime();
        for (int i = 0; i < ELEMS2_ADD; i++) {
            arr.get(index);        
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("Time to add " + ELEMS2_ADD + " elements in the middle of an array: " + time + "ns (" + millis + " ms)");
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String, Long> map = new HashMap<>();
        map.put("Africa", 1_110_635_000L);
        map.put("Americas", 972_005_000L);
        map.put("Antartica", 0L);  
        map.put("Asia", 4_298_723_000L);  
        map.put("Europe", 742_452_000L);  
        map.put("Oceania", 38_304_000L);  
        /*
         * 8) Compute the population of the world
         */
        long total = 0;
        Collection<Long> val = map.values();
        for (long elem : val) {
            total += elem;
        }
        System.out.println("Total population of the world: " + total + " people");
        
    }
}
