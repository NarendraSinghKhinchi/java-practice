package Bank;

public class Main {
    public static  void main(String []args){
        Account narendraAccount = new Account("Narendra", "narendra@email.com", "7693922071");

        double balance = narendraAccount.getAccountBalance();
        System.out.println(balance);

        narendraAccount.depositFunds(3000);
        balance = narendraAccount.getAccountBalance();
        System.out.println(balance);

        narendraAccount.withdrawFunds(4000);
        balance = narendraAccount.getAccountBalance();
        System.out.println(balance);
    }
}
