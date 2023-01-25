package it.unicam.cs.pa.battleship;

import java.util.Map;

/**
 * Default implementation of the attack field.
 */
public class DefaultAttackField implements AttackField{

    private final Map<FieldPosition, ShotResult> map;

    public DefaultAttackField(Map<FieldPosition, ShotResult> map) {
        this.map = map;
    }

    @Override
    public void set(FieldPosition p, ShotResult result) {
this.map.put(p, result);
    }

    @Override
    public ShotResult get(FieldPosition p) {
        return this.map.get(p);
    }
}
