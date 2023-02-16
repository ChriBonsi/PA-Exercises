package it.unicam.cs.pa.budget.list;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * Default implementation of a registry.
 */
public class FactoryRegistry<R, T extends ElementWithID> implements Registry<R,T>{

    private final Map<Integer,T> elements = new HashMap<>();
    private int lastID = -1;
    private final BiFunction<Integer, R, T> factoryFunction;

    public FactoryRegistry(BiFunction<Integer, R, T> factoryFunction) {
        this.factoryFunction = factoryFunction;
    }

    @Override
    public T create(R args) {
        return create(lastID+1,args);
    }

    @Override
    public T create(int id, R args) {
        if (!isValid(id)){
            throw new IllegalArgumentException("Illegal ID");
        }

        T newElement = factoryFunction.apply(id, args);
        elements.put(id,newElement);
        lastID = id;
        return newElement;
    }

    @Override
    public int maxID() {
        return lastID - 1;
    }

    @Override
    public boolean isValid(int id) {
        return id > lastID;
    }

    @Override
    public T get(int id) {
        return elements.get(id);
    }

    @Override
    public boolean delete(int id) {
        return elements.remove(id) != null;
    }
}
