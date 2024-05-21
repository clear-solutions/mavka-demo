package io.mavka.demo.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemovingData {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
        for (String s : list) {
            if ("two".equals(s)) {
                list.remove(s);
            }
        }
    }
}
