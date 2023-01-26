package it.unicam.cs.pa.data;

import java.util.LinkedList;
import java.util.List;

/**
 * A default implementation of a DataSet.
 *
 * @param <T>
 */
public class DefaultDataSet<T> implements DataSet<T> {
    private final List<Element<T>> elements;

    public DefaultDataSet() {
        this.elements = new LinkedList<>();
    }


    @Override
    public void record(T element, double value) {
        elements.add(new Element<>(element, value));
    }

    @Override
    public double min() {
        double currentMin = Double.POSITIVE_INFINITY;
        for (Element e : elements) {
            if (e.value < currentMin) {
                currentMin = e.value;
            }
        }
        return currentMin;
    }

    @Override
    public double min(T element) {
        double currentMin = Double.POSITIVE_INFINITY;
        for (Element e : elements) {
            if (element.equals(e) && e.value < currentMin) {
                currentMin = e.value;
            }
        }
        return currentMin;
    }

    @Override
    public double max() {
        double currentMax = Double.NEGATIVE_INFINITY;
        for (Element e : elements) {
            if (e.value > currentMax) {
                currentMax = e.value;
            }
        }
        return currentMax;
    }

    @Override
    public double max(T element) {
        double currentMax = Double.NEGATIVE_INFINITY;
        for (Element e : elements) {
            if (element.equals(e) && e.value > currentMax) {
                currentMax = e.value;
            }
        }
        return currentMax;
    }

    private class Element<T> {
        private final T element;
        private final double value;

        private Element(T element, double value) {
            this.element = element;
            this.value = value;
        }
    }
}
