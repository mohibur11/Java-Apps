package model;

public class Account {
    private String user_id;
    private String name;
    private String email;
    private Double balance;

    public Account(String user_id, String name, String email, Double balance) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.balance = balance;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                '}';
    }
}
