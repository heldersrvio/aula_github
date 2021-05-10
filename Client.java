public class Client {
    private String clientName;
    private String clientPassword;


    public Client(String name, String password) {
        this.clientName = name;
        this.clientPassword = password;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientPassword() {
        return clientPassword;
    }
}
