package it.unicam.cs.pa.budget.list;

import java.util.List;
import java.util.function.BiFunction;

public class SimpleLedger implements Ledger{

    private final FactoryRegistry<Ledger,Transaction> transactions;

    public SimpleLedger() {
        //Previous concept with hidden class
        /*this.transactions = new FactoryRegistry<>(new BiFunction<Integer, Ledger, Transaction>() {
            @Override
            public Transaction apply(Integer integer, Ledger ledger) {
                return new LedgerTransaction(integer,ledger);
            }
        });*/

        //Lambda expression
        //this.transactions = new FactoryRegistry<>((id, ledger) -> new LedgerTransaction(id, ledger));

        //Reference method
        this.transactions = new FactoryRegistry<>(LedgerTransaction::new);

    }

    public Transaction newTransaction(){
return transactions.create(this);
    }

    @Override
    public List<Transaction> getTransactions() {
        return null;
    }

    @Override
    public List<Account> getAccounts() {
        return null;
    }

    @Override
    public List<Tag> getTags() {
        return null;
    }

    @Override
    public double getTotalBalance() {
        return 0;
    }

    @Override
    public double getTotalAssets() {
        return 0;
    }

    @Override
    public double getTotalLiabilities() {
        return 0;
    }
}
