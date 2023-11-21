package account;

public class NotEnoughBalanceException extends IllegalArgumentException{
    public String getMessage(){
        return "잔액보다 많은 값을 입력했습니다.";
    }
}
