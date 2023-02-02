package it.unicam.cs.pa.data;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
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
        return min(e -> true);
    }

    @Override
    public double min(T element) {
        return min(isEqual(element));
    }

    public static <T> Predicate<T> isEqual(T t) {
        if (t == null) {
            return Objects::isNull;
        } else {
            return t::equals;
        }
    }

    public String toString(Function<? super T, ? extends String> repr) {
        String str = "[";
        for (Element<T> elem : elements) {
            str += repr.apply(elem.element) + ":" + elem.value + "; ";
        }
        str += "]";
        return str;
    }

    public String toString() {
        return toString(Object::toString);
    }

    @Override
    public double min(Predicate<T> p) {
        return reduce(p, (current, value) -> (value < current ? value : current), Double.POSITIVE_INFINITY);
    }

    @Override
    public double max() {
        return max(e -> true);
    }

    @Override
    public double max(T element) {
        return max(isEqual(element));
    }

    @Override
    public double max(Predicate<T> p) {
        return reduce(p, (current, value) -> (value > current ? value : current), Double.NEGATIVE_INFINITY);
    }

    @Override
    public double sum() {
        return sum(e -> true);
    }

    @Override
    public double sum(Predicate<T> p) {
        return reduce(p, (total, toAdd) -> (total + toAdd), 0);
    }

    @Override
    public <R> DataSet<R> map(Function<T, R> f) {
        DataSet<R> result = new DefaultDataSet<>();
        for (Element<T> e : elements) {
            result.record(f.apply(e.element), e.value);
        }
        return result;
    }

    public double reduce(Predicate<T> p, BiFunction<Double, Double, Double> f, double init) {
        double current = init;
        for (Element<T> e : elements) {
            if (p.test(e.element)) {
                current = f.apply(current, e.value);
            }
        }
        return current;
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
