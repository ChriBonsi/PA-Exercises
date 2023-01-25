package it.unicam.cs.pa.battleship;

import java.util.HashSet;
import java.util.Set;

/**
 * Default implementation of a ship.
 */
public class DefaultShip implements Ship {

    private final int size;
    private int strength;
    private final String name;
    private final Set<FieldPosition> statusMap;

    public DefaultShip(String name, int size) {
        this.name = name;
        this.size = size;
        this.strength = size;
        this.statusMap = new HashSet<>();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int shots() {
        return this.size - this.strength;
    }

    @Override
    public int strength() {
        return this.strength;
    }

    @Override
    public boolean isDestroyed() {
        return this.strength == 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ShotResult hitAt(FieldPosition p) {
        if (this.statusMap.contains(p)) {
            this.statusMap.add(p);
            this.strength--;
        }
        return status();
    }

    private ShotResult status() {
        if (isDestroyed()) {
            return ShotResult.SUNK;
        } else {
            return ShotResult.HIT;
        }
    }

    @Override
    public ShotResult status(FieldPosition p) {
        if (this.statusMap.contains(p)) {
            return status();
        }
        return null;
    }
}
