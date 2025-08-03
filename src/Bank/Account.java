package Bank;

import java.util.Random;

public class Account {
    private long accountNumber;
    private double accountBalance;
    private String phoneNumber;
    private String email;
    private String customerName;

    public  Account(String name, String email, String phoneNumber){
        this.customerName = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.accountBalance = 0.0d;
        this.accountNumber = 1238798989;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void depositFunds(double amount){
        this.accountBalance += amount;
    }

    public String withdrawFunds(double amount){
        if(this.accountBalance - amount < 0)return "Withdrawal not allowed";
        this.accountBalance -= amount ;
        return "Withdrawal success.";
    }
}
