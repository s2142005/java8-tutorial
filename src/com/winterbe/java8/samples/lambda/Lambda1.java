package com.winterbe.java8.samples.lambda;

import java.util.*;

/**
 * @author Benjamin Winterberg
 */
public class Lambda1 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        //Sort1 > b.compareTo(a): [xenia, peter, mike, anna]
        System.out.println("Initial Arrays1: " + names);

        Collections.sort(names, (a, b) -> b.compareTo(a));
        //Sort1 > b.compareTo(a): [xenia, peter, mike, anna]
        System.out.println("Sort1 > b.compareTo(a): " + names);

        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        //Sort1 > b.compareTo(a): [xenia, peter, mike, anna]
        System.out.println("Sort2 > b.compareTo(a): " + names);

        Collections.sort(names, (String a, String b) -> b.compareTo(a));
        //Sort1 > b.compareTo(a): [xenia, peter, mike, anna]
        System.out.println("Sort3 > b.compareTo(a): " + names);

        Collections.sort(names, (a, b) -> b.compareTo(a));
        //Sort1 > b.compareTo(a): [xenia, peter, mike, anna]
        System.out.println("Sort4 > b.compareTo(a): " + names);

        names.sort(Collections.reverseOrder());
        //Sort > Collections.reverseOrder: [xenia, peter, mike, anna]
        System.out.println("Sort > Collections.reverseOrder: " + names);

        List<String> names2 = Arrays.asList("peter", null, "anna", "mike", "xenia");
        System.out.println("Initial Arrays2: " + names2);

        names2.sort(Comparator.nullsLast(String::compareTo));
        //Sort > Comparator.nullsLast(String::compareTo) = [anna, mike, peter, xenia, null]
        System.out.println("Sort > Comparator.nullsLast: " + names2);

        List<String> names3 = null;
        Optional.ofNullable(names3).ifPresent(list -> list.sort(Comparator.naturalOrder()));
        //Optional.ofNullable > list.sort>Comparator.naturalOrder: null
        System.out.println("Optional.ofNullable > list.sort>Comparator.naturalOrder: " + names3);
    }
}