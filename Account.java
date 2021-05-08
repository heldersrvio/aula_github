
public class Account {
    private String clientId;
    private Double amount;

    public Account(String id) {
        this.clientId = id;
        this.amount = 0.0;
    }

    public String getClientId() {
        return clientId;
    }

    public void deposit(Double value) {
        this.amount += value;
    }
}