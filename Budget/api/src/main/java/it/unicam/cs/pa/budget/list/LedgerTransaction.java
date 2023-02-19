package it.unicam.cs.pa.budget.list;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class LedgerTransaction implements Transaction{

    private final Ledger ledger;
    private final int id;

    private Date date;

    private final List<Movement> movements;

    public LedgerTransaction(int id, Ledger ledger) {
        this(id, ledger, new Date(), new LinkedList<>());
    }

    public LedgerTransaction(int id, Ledger ledger, Date date, List<Movement> movements) {
        this.ledger = ledger;
        this.id = id;
        this.date = date;
        this.movements = movements;
    }

    public Ledger getLedger(){
        return ledger;
    };

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int getTransactionID() {
        return id;
    }

    @Override
    public double balance() {
        double toReturn = 0.0;
        for (Movement m :
                movements) {
            toReturn += m.getAmount();
        }
        return 0;
    }

    @Override
    public List<Movement> getMovements() {
        return movements;
    }

    @Override
    public List<Tag> getTags() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
