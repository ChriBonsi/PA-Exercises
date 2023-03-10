package it.unicam.cs.pa.budget.list;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SimpleLedger implements Ledger {

    private final FactoryRegistry<Ledger, Transaction> transactions;
    private final FactoryRegistry<AccountInfo, Account> accounts;

    public SimpleLedger() {
        // OLD STYLE
//        this.transactions = new FactoryRegistry<>(new BiFunction<Integer, Ledger, Transaction>() {
//            @Override
//            public Transaction apply(Integer integer, Ledger ledger) {
//                return new LedgerTransaction(integer, ledger);
//            }
//        });
        // LAMBDA EXPRESSION
//        this.transactions = new FactoryRegistry<>(
//                (id, ledger) -> new LedgerTransaction(id, ledger)
//        );
        this.transactions = new FactoryRegistry<>(LedgerTransaction::new);
        this.accounts = new FactoryRegistry<>((integer, info) -> new LedgerAccount(integer, this, info));
    }

    public Transaction newTransaction() {
        return transactions.create(this);
    }

    @Override
    public List<Transaction> getTransactions() {
        return transactions.getElements();
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
/*
        double sum = getOpeningBalance();
        for(Transaction t: getTransactions()) {
            sum += t.balance();
        }
        return sum;
*/
        return getOpeningBalance() + transactions.stream().mapToDouble(Transaction::balance).sum();
    }

    @Override
    public double getOpeningBalance() {
        double sum = 0.0;
        for (Account a : getAccounts()) {
            sum += a.getBalance();
        }
        return sum;
    }

    private double sumAccountBalances(Predicate<? super Account> pred) {
//        double sum = 0.0;
//        for (Account a: getAccounts()) {
//            if (pred.test(a)) {
//                sum += a.getBalance();
//            }
//        }
//        return sum;
        return accounts.stream().filter(pred).mapToDouble(Account::getBalance).sum();
    }

    @Override
    public double getTotalAssets() {
        return sumAccountBalances(a -> a.getAccountType() == AccountType.ASSET);
    }

    @Override
    public double getTotalLiabilities() {
        return sumAccountBalances(a -> a.getAccountType() == AccountType.LIABILITY);
    }


    @Override
    public List<Movement> getAccountMovement(Predicate<? super Account> pred) {
/*
        List<Movement> toReturn = new LinkedList<>();
        for(Transaction t: getTransactions()) {
            for(Movement m: t.getMovements()) {
                if (pred.test(m.account())) {
                    toReturn.add(m);
                }
            }
        }
        return toReturn;
*/
        return transactions.stream().parallel().map(Transaction::getMovements).flatMap(List::stream).filter(m -> pred.test(m.account())).collect(Collectors.toList());
    }

    @Override
    public List<Transaction> getTransactions(Predicate<? super Transaction> pred) {
/*
        List<Transaction> toReturn = new LinkedList<>();
        for(Transaction t: getTransactions()) {
            if (pred.test(t)) {
                toReturn.add(t);
            }
        }
        return toReturn;
*/
        return transactions.stream().filter(pred).collect(Collectors.toList());
    }

    @Override
    public Account newAccount(AccountType type, String name, double openingBalance, String description) {
        return accounts.create(new AccountInfo(type, name, openingBalance, description));
    }
}
