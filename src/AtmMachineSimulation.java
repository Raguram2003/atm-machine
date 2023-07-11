
import java.util.Scanner;
class Balance_amount{
    private int Balance = 200000 ;
    public int  getBalance(){
        return Balance;
    }
    public void setBalance(int Balance){
        this.Balance = Balance;
    }
    public void validateRightAmount(int user_needed_amount,int check) throws InsufficientFundException {
        if(check==1){
            if (user_needed_amount <= Balance) {
                Balance = Balance - user_needed_amount;
                System.out.println("you can take your amount Rupee: " + user_needed_amount + " and Balance amount is :" + Balance);
                setBalance(Balance);
                System.out.println();
            } else {
                throw new InsufficientFundException(" your required amount is greater than the balance amount");
            }
        }
        else
        {
            Balance = Balance + user_needed_amount;
            System.out.println("your deposited amount is : " + user_needed_amount + " and Balance amount is :" + Balance);
            setBalance(Balance);
            System.out.println();

        }
    }

    public  void validateGivenAmount(int user_needed_amount,int check) throws InvalidAmountException, InsufficientFundException {
        if(user_needed_amount > 0 ){
            validateRightAmount(user_needed_amount,check);
        }
        else{
            throw new InvalidAmountException(" please type valid amount");
        }

    }

}
//-----------------------------------------------------------------------------------------------------------------------------------------------------------

public class AtmMachineSimulation extends Balance_amount{
    //private static int Balance=20000;
    static int Balance1;
    public static void main(String[] argv) {
        try {
            Scanner sc = new Scanner(System.in);
            Balance_amount balance = new Balance_amount();


            while (true)
            {
                System.out.println("welcome sir");
                Balance1 = balance.getBalance();
                System.out.println("1.Withdraw");
                System.out.println("2.Deposit");
                System.out.println("3.CheckBalance");
                System.out.println("4.exit");
                System.out.print("choose the option : ");
                int user_input = sc.nextInt();
                int user_required_amount;
                int check=0;


                switch(user_input) {
                    case 1:
                        System.out.print("\nhow much money for you required : ");
                        user_required_amount = sc.nextInt();
                        check = 1;
                        balance.validateGivenAmount(user_required_amount, check);
                        break;
                    case 2:
                        System.out.print("\nhow much money for you going to deposit : ");
                        user_required_amount = sc.nextInt();
                        balance.validateGivenAmount(user_required_amount, check);
                        break;
                    case 3:
                        System.out.println("your balance amount is " + Balance1);
                        System.out.println();
                        break;
                    case 4:
                        break;
                    default :
                    {
                        System.out.println("Enter a valid input");
                        System.out.println();
                    }
                }

                if(user_input==4)
                {
                    System.out.println("Transaction ended");
                    break;
                }
            }
        }
        catch(InvalidAmountException | InsufficientFundException e){
            System.out.println(e.getMessage());
        }
    }
}
//---------------------------------------------------------------------------------------------------------------------------------------------------
class InsufficientFundException extends Exception {
    public InsufficientFundException(String errorMessage) {
        super(errorMessage);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String errorMessage) {
        super(errorMessage);
    }
}

//---------------------------------------------------------------------------------------------------------------------------------------------------