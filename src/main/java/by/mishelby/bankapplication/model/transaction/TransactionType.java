package by.mishelby.bankapplication.model.transaction;

import by.mishelby.bankapplication.model.bankAccount.Descriable;

public enum TransactionType implements Descriable {
    DEPOSIT("deposit"),
    TRANSFER("transfer"),
    WITHDRAW("withdraw"),
    REPLENISHMENT("replenishment");

    private final String NAME;

    TransactionType(String name) {
        this.NAME = name;
    }

    @Override
    public String getDescription() {
        return NAME + " type of transaction";
    }
}
