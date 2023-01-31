package it.unicam.cs.pa.data;

public class Main {
    public static void main(String[] argv) {

        DataSet<String> dataSet = new DefaultDataSet<>();

        dataSet.record("pippo", 7);
        dataSet.record("pluto", 28);
        dataSet.record("paperino", 39);

        DataSet<Integer> newDataSet = dataSet.map(s -> s.length());

    }
}
