package by.mishelby.bankapplication.model.bankAccount;


public enum BankAccountAction implements Descriable {
    TOP_UP("top-up"),
    WITHDRAW("withdraw"),
    TRANSFER("transfer");

    private final String name;

    BankAccountAction(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return name + " type of bank account action";
    }
}
