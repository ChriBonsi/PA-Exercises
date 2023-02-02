package it.unicam.cs.pa.data;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] argv) {

        DataSet<String> dataSet = new DefaultDataSet<>();

        dataSet.record("pippo", 7);
        dataSet.record("pluto", 28);
        dataSet.record("paperino", 39);

        Predicate<Object> p = Objects::isNull;

        //The type of the function is String -> int
        Function<String, Integer> f1 = String::length;

        //The type of the length method is void -> int, but whenever an instance method is called,
        //an additional parameter (the Class) is added, so it becomes (String * void) -> int
        Function<String, Integer> f2 = String::length;

        String pippo = "PIPPO";
        Function<Integer, Character> f3 = pippo::charAt;

        DataSet<Integer> newDataSet = dataSet.map(String::length);

        Function<Object,String> f = s -> s.toString();
        dataSet.toString(f);

    }
}
