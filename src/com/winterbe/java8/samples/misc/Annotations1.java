package com.winterbe.java8.samples.misc;

import java.lang.annotation.*;

/**
 * @author Benjamin Winterberg
 */
public class Annotations1 {

    public static void main(String[] args) {
        Hint hint = Person.class.getAnnotation(Hint.class);
        System.out.println(hint);   // null

        Hints hints1 = Person.class.getAnnotation(Hints.class);
        System.out.println(hints1.value().length);  // 2

        Hint[] hints2 = Person.class.getAnnotationsByType(Hint.class);
        System.out.println(hints2.length);  // 2

    }

    @Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
    @interface MyAnnotation {

    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface Hints {
        Hint[] value();
    }

    @Repeatable(Hints.class)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Hint {
        String value();
    }

    @Hint("hint1")
    @Hint("hint2")
    class Person {

    }
}