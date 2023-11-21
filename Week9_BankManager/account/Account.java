package account;

public class Account{
    private int balance;

    public Account(){
        balance = 0;
    }
    
    public Account(int n){
        balance = n;
    }

    public void deposit(int money){
        if (money>=0)
            balance+=money;
        else
            throw new NegativeAmountException();
    }
    public void withdraw (int money){
        if(balance<money)
            throw new NotEnoughBalanceException();
        else if (money>=0)
            balance-=money;
        else
            throw new NegativeAmountException();
    }

    public int getBalance(){
        return balance;
    }
}

