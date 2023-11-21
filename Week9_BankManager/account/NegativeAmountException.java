package account;

public class NegativeAmountException extends IllegalArgumentException{
    public String getMessage(){
        return "입력된 값이 음수입니다.";
    }
}