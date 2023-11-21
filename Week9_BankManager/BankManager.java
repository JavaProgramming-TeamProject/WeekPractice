import bank.NameAcount;
import account.NegativeAmountException;
import account.NotEnoughBalanceException;

import java.util.Scanner;

class BankManager{
    public static int getNunber(){
        Scanner Input = new Scanner(System.in);
        String InBalance = Input.nextLine();
        int balance;
        if(InBalance==""){
            balance = 0;
        }
        else{
            balance = Integer.parseInt(InBalance);
        }
        return balance;
    }

    public static void main(String[] a){
        System.out.print("이름을 입력해주세요: ");
        Scanner Input = new Scanner(System.in,"EUC-KR");
        
        String Name = Input.next();

        System.out.print("\n초기 예금액을 입력해주세요: ");
       
        int balance =getNunber();

        NameAcount NA = new NameAcount(Name,balance);

        System.out.print("\n\t메뉴\n");
        System.out.println("[1] 입금\n[2] 출금\n[3] 잔액 확인\n[0]종료");

        do {
            System.out.print("\n번호를 입력해주세요: ");
            int MenuNum=getNunber();
            int money=0;

            if(MenuNum==1){
                try {
                    System.out.print("\n입금할 금액을 입력해주세요: ");
                    money = getNunber();
                    NA.deposit(money);
                } catch (NegativeAmountException e) {
                    System.out.println(e.getMessage());
                }
            }

            else if(MenuNum==2){
                try {
                    System.out.print("\n출금할 금액을 입력해주세요: ");
                    money = getNunber();
                    NA.withdraw(money);
                }
                catch (NegativeAmountException e )
                {
                   System.out.println(e.getMessage());
                }
                catch (NotEnoughBalanceException e) 
                {
                    System.out.println(e.getMessage());
                }                
            }
            else if(MenuNum==3){
                System.out.println("\n"+NA.getName()+"님의 현재 잔액은 : "+NA.getBalance()+"원입니다.");
            }
            else if(MenuNum==0){
                System.out.println("\n종료합니다");
                break;
            }
            else{
                System.out.println("\n다시 입력해주세요");
            }
        }while(true);
        Input.close();
    }
}