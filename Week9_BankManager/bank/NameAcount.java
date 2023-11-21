package bank;

import account.Account;

public class NameAcount extends Account{
    private String Name;

    public NameAcount(String Name){
        super();
        this.Name=Name;
    }

    public NameAcount(String Name, int n){
        super(n);
        this.Name=Name;
    }
    
    public String getName(){
        return Name;
    }
}
