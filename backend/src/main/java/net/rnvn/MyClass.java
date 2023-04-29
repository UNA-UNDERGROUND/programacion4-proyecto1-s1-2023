package net.rnvn;

import java.util.List;
import java.util.Map;

public class MyClass {
    public static void main(String[] args) {
        System.out.println(Map.of(
                "Hello", 1,
                "World", 2,
                "ABC", List.of("A", "B", "C")));
    }
}
