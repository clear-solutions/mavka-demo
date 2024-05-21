package io.mavka.demo.collection;

import java.util.HashMap;
import java.util.Map;

public class NullPointerExceptionInMap {

    public static void main(String[] args) {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Alice", 25);
        int charliesAge = ages.get("Charlie");
        System.out.println(charliesAge + 10);
    }
}
