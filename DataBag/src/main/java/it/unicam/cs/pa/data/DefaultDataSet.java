package it.unicam.cs.pa.data;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

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
            if (element.equals(e) && (e.value < currentMin)) {
                currentMin = e.value;
            }
        }
        return currentMin;
    }

    @Override
    public double max() {
        return max(e -> true);
    }

    @Override
    public double max(T element) {
        return max(Predicate.isEqual(element));
    }

    @Override
    public double max(Predicate<T> p) {
        double currentMax = Double.NEGATIVE_INFINITY;
        for (Element<T> e : elements) {
            if (p.test(e.element)) {
                currentMax = (e.value>currentMax?e.value:currentMax);
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Element<?> element1 = (Element<?>) o;
            return Double.compare(element1.value, value) == 0 && Objects.equals(element, element1.element);
        }

        @Override
        public int hashCode() {
            return Objects.hash(element, value);
        }
    }
}
