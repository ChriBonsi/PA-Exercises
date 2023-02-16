package it.unicam.cs.pa.budget.list;

/**
 * This class is used to create and retrieve objects that are distinctively identified by an ID.
 */
public interface Registry<R, T extends ElementWithID > {


    /**
     * Creates an element with a newly generated ID.
     * @param args parameters used to create the new element
     * @return an element with a newly generated ID.
     */
    T create(R args);

    /**
     * Creates an element with the specified ID.
     * @param id the identifier
     * @param args parameters used to create the new element
     * @return an element with the specified ID.
     * @throws IllegalArgumentException if the given ID is not valid.
     */
    T create(int id, R args);

    /**
     * Returns the greatest ID used in the registry.
     * @return the greatest ID used in the registry.
     */
    int maxID();

    /**
     * Checks if the given ID is valid.
     * @param id the identifier to check
     * @return true if the ID is valid in this registry, false otherwise.
     */
    boolean isValid(int id);

    /**
     * Returns the element with the specified ID, if it exists.
     * @param id the identifier
     * @return the element with the specified ID, {@code null} otherwise.
     */
    T get(int id);

    /**
     * Deletes teh element with the specified ID, if it exists.
     * Returns true if the element has been deleted, false otherwise.
     *
     * @param id the identifier
     * @return true if the element has been deleted, false otherwise.
     */
    boolean delete(int id);
}
