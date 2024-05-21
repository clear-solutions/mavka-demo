package io.mavka.demo.collection;

import java.util.List;

public class UnsupportedOperationExceptionInList {

    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        names.add("David");
    }
}
