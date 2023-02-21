package it.unicam.cs.pa.budget.list;

/**
 * A tag represents a label associated with transactions and movements.
 */
public interface Tag {

    /**
     * Returns the index that univocally identifying this tag.
     *
     * @return the index that univocally identifying this tag.
     */
    int getTagIndex();

    /**
     * Returns the name of this tag.
     *
     * @return the name of this tag.
     */
    String getTagName();

}
