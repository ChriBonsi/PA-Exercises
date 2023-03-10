package it.unicam.cs.pa.budget.list;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Stream;

/**
 * This class is used to create and store objects that are identified by a single integer. The class guarantees
 * that each object is identified by an integer that can be used to retrieve the corresponding value.
 *
 * @param <R> type of parameters used to build the handled elements.
 * @param <T> type of handled elements.
 */
public class FactoryRegistry<R, T extends ElementWithId> implements Registry<R, T> {

    private final Map<Integer, T> elements = new TreeMap<>();
    private int lastId = -1;
    private final BiFunction<Integer, R, T> factoryFunction;

    public FactoryRegistry(BiFunction<Integer, R, T> factoryFunction) {
        this.factoryFunction = factoryFunction;
    }

    @Override
    public T create(R arguments) {
        return create(lastId + 1, arguments);
    }

    @Override
    public T create(int id, R args) {
        if (!isValidForNewId(id)) {
            throw new IllegalArgumentException("Illegal identifier!");
        }
        T newElement = factoryFunction.apply(id, args);
        elements.put(id, newElement);
        lastId = id;
        return newElement;
    }

    @Override
    public boolean isValidForNewId(int id) {
        return id > lastId;
    }

    @Override
    public T get(int id) {
        return elements.get(id);
    }

    @Override
    public boolean delete(int id) {
        return (elements.remove(id) != null);
    }

    @Override
    public boolean contains(int id) {
        return elements.containsKey(id);
    }

    @Override
    public List<T> getElements() {
        return new LinkedList<>(elements.values());
    }

    @Override
    public Stream<T> stream() {
        return elements.values().stream();
    }

}
