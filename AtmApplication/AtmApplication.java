import java.util.*;

public class AtmApplication {
    static Scanner input = new Scanner(System.in);
    static Admin Atm = new Admin();
    static List AtmCash = Atm.getAtmCash();
    static Customer Account = new Customer();
    static List MiniStatement  = Account.getStatement();
    static String  enter ;
    public static void main(String[] args) {
        boolean Mainflag = true;
        while (Mainflag){
            clrscr();
            System.out.println("Welcome to ATM Application $");System.out.println("----------------------------------");System.out.println("Choose any option:");System.out.println("1.Admin");System.out.println("2.Customer");System.out.println("3.Exit");System.out.println("----------------------------------");
            int MainInput = input.nextInt();
            if(MainInput==1){
                clrscr();
                boolean AdminFlag = true;
                System.out.print("Enter UserId : "); int UserId = input.nextInt();
                System.out.println("");
                System.out.print("Enter Pin    : "); int Pin = input.nextInt(); 
                if(UserId==825021 && Pin==5021){
                    while(AdminFlag){
                        clrscr();
                        System.out.println("Welcome Admin :)");System.out.println("----------------------------------");System.out.println("Choose any option:");System.out.println("1.Add Cash");System.out.println("2.View Cash");System.out.println("3.Logout");System.out.println("----------------------------------");
                        int AdminInput = input.nextInt();
                        if(AdminInput==1){
                            clrscr();
                            AddCashtoAtm();
                        }else if(AdminInput==2){
                            clrscr();
                            ViewCashinAtm();
                        }else if(AdminInput==3){
                            AdminFlag = false;
                            clrscr();
                        }
                    }
                }else{
                    clrscr();
                    System.out.println("Invalid User!");System.out.println("");System.out.println("Enter 1 to Exit");
                    enter = input.next();
                }
            }else if(MainInput==2){
                clrscr();
                boolean CustomerFlag = true;
                System.out.print("Enter UserId : "); int UserId = input.nextInt();
                System.out.println("");
                System.out.print("Enter Pin    : "); int Pin = input.nextInt(); 
                if(UserId==825021 && Pin==Account.getPin()){
                    clrscr();
                    while(CustomerFlag){
                        clrscr();
                        System.out.println("Welcome Customer :)");System.out.println("----------------------------------");System.out.println("Choose any option:");System.out.println("1.Withdraw");System.out.println("2.Check Balance");System.out.println("3.Pin Change");System.out.println("4.Mini Statement");System.out.println("5.Direct Deposit");System.out.println("6.Logout");System.out.println("----------------------------------");
                        int CustomerInput = input.nextInt();
                        switch(CustomerInput){
                            case 1:
                            clrscr();
                            System.out.println("------Witdraw------");
                            Withdraw();
                            break;
                            case 2:
                            clrscr();
                            System.out.println("------Check Balance------");
                            System.out.println("");
                            System.out.println("Avilable Balance : Rs "+Account.getAvlBalance());
                            System.out.println("");System.out.println("Enter 1 to Exit");
                            enter = input.next();
                            break;
                            case 3:
                            clrscr();
                            System.out.println("------Pin Change------");
                            PinChange();
                            break;
                            case 4:
                            clrscr();
                            System.out.println("------Mini Statement------");
                            MiniStatement();
                            break;
                            case 5:
                            clrscr();
                            System.out.println("------Direct Deposit------");
                            DirectDeposit();
                            break;
                            case 6:
                            clrscr();
                            CustomerFlag = false;
                            System.out.println("------Logout------");
                            System.out.println("");System.out.println(""); 
                            System.out.println("Enter 1 to Confirm Logout");
                            enter = input.next();
                            break;
                            default:
                            clrscr();
                            System.out.println("Invalid Input.");System.out.println("");System.out.println("Enter 1 to Exit");
                            enter = input.next();
                        }
                    
                    }
                }else{
                    clrscr();
                    System.out.println("Invalid Id or Pin");
                    System.out.println("");System.out.println(""); 
                    System.out.println("Enter 1 to Exit");
                    enter = input.next();
                }
            }else if(MainInput==3){
                clrscr();
                System.out.println("");System.out.println(""); 
                System.out.println("Enter 1 to Confirm Exit ");
                enter = input.next();
                Mainflag = false;
            }else{
                clrscr();
                System.out.println("Invalid Input Try Again");
                System.out.println("");System.out.println(""); 
                System.out.println("Enter 1 to Continue");
                enter = input.next();
            }
        }
    }
    public static void AddCashtoAtm(){
        System.out.println("Enter Amounts :");
        System.out.print("100s - ");int one = input.nextInt();
        System.out.print("200s - ");int two = input.nextInt();
        System.out.print("500s - ");int five = input.nextInt();
        System.out.print("2000s - ");int twenty = input.nextInt();
        Atm.setAtmCash(one ,two,five,twenty,true);
        for(int i=0;i<4;i++){
            System.out.print(AtmCash.get(i)+"  ");
          }
        System.out.println("");System.out.println("");  
        System.out.println("TotalCash in ATM : Rs "+ Atm.getTotalAtmCash());
        System.out.println("");
        System.out.println("Enter 1 to Exit");
        enter = input.next();
    }

    public static void ViewCashinAtm(){
        for(int i=0;i<4;i++){
            System.out.print(AtmCash.get(i)+"  ");
          }
        System.out.println("");System.out.println("");  
        System.out.println("TotalCash in ATM : Rs "+ Atm.getTotalAtmCash());
        System.out.println("");System.out.println(""); 
        System.out.println("Enter 1 to Exit");
        enter = input.next();

    }

    public static void Withdraw(){
        System.out.println("Note: Enter the amount in 100s ");
        System.out.println("");
        System.out.print("Enter Amount : ");int withdrawAmount = input.nextInt();
        if(withdrawAmount<Account.getAvlBalance()){
            if(withdrawAmount<Atm.getTotalAtmCash()){
                int one = 0;
                int two = 0;
                int five = 0;
                int twenty = 0;
                List<Integer> AtmCashTemp = new ArrayList<>();
                int withdrawAmountTemp = withdrawAmount; 
                for(int i=0;i<4;i++){
                    AtmCashTemp.add((Integer)AtmCash.get(i));
                  }
                while(withdrawAmount>0){
                    if(withdrawAmount>=2000 && (Integer)AtmCashTemp.get(3)>0){
                        twenty += + 1;
                        AtmCashTemp.set(3, AtmCashTemp.get(3)-1);
                        withdrawAmount -=2000;
                    }else if(withdrawAmount>=500 && (Integer)AtmCashTemp.get(2)>0){
                        five += 1;
                        AtmCashTemp.set(2, AtmCashTemp.get(2)-1);
                        withdrawAmount -=500;
                    }else if(withdrawAmount>=200 && (Integer)AtmCashTemp.get(1)>0){
                        two += 1;
                        AtmCashTemp.set(1, AtmCashTemp.get(1)-1);
                        withdrawAmount -=200;
                    }else if(withdrawAmount>=100 && (Integer)AtmCashTemp.get(1)>0){
                        one += 1;
                        AtmCashTemp.set(0, AtmCashTemp.get(0)-1);
                        withdrawAmount -=100;
                    }else{
                        System.out.println("Insufficient notes try driffent amount.");
                        System.out.println();
                        withdrawAmount=0;
                        one=0; two=0; five=0; twenty=0;
                    }
                } 
                Atm.setAtmCash(one, two, five, twenty,false);
                Account.setAvlBalance(withdrawAmountTemp,false);
                System.out.println("100s  - "+one);
                System.out.println("200s  - "+two);
                System.out.println("500s  - "+five);
                System.out.println("2000s - "+twenty);
                System.out.println("Current AvlBalance : Rs "+Account.getAvlBalance());
                System.out.println("");
                System.out.println("");System.out.println("Enter 1 to Exit");
                enter = input.next();
            }else{
                System.out.println("Atm Out of Cash");
                System.out.println("");System.out.println("Enter 1 to Exit");
                enter = input.next();
            }
        }else{
            System.out.println("Insufficient Balance In Your Account");
            System.out.println("");System.out.println("Enter 1 to Exit");
            enter = input.next();
        }

    }

    public static void DirectDeposit(){
        System.out.println("Note: Enter the amount in 100s ");
        System.out.println("");
        System.out.println("Enter Amount : ");
        System.out.print("100s - ");int one = input.nextInt();
        System.out.print("200s - ");int two = input.nextInt();
        System.out.print("500s - ");int five = input.nextInt();
        System.out.print("2000s - ");int twenty = input.nextInt();
        int TotalDepositAmount = (one*100)+(two*200)+(five*500)+(twenty*2000);
        System.out.println("");
        System.out.println("Total Deposit Amount :"+TotalDepositAmount);
        Account.setAvlBalance(TotalDepositAmount,true);
        System.out.println("");
        System.out.println("New Avilable Balance : Rs "+Account.getAvlBalance());
        System.out.println("");System.out.println(""); 
        System.out.println("Enter 1 to Exit");
        enter = input.next();
    }

    public static void MiniStatement(){
        System.out.println("   Date   "+ "   "+"Des"+"     "+"  $ "+"   "+"Balance");
        for (int i = 0; i < MiniStatement.size(); i++) {
            System.out.println(MiniStatement.get(i));
        }
        System.out.println("");System.out.println(""); 
        System.out.println("Enter 1 to Exit");
        enter = input.next();
    }

    public static void PinChange(){
        System.out.println("");
        System.out.print("Enter Current Pin : ");int CurrentPin = input.nextInt();
        if(CurrentPin==Account.getPin()){
            clrscr();
            System.out.println("");
            System.out.print("Enter New Pin : ");int NewPin = input.nextInt();
            Account.setPin(NewPin);
            clrscr();
            System.out.println("");
            System.out.println("Pin Changed Succesfully.");
            System.out.println("");System.out.println(""); 
            System.out.println("Enter 1 to Exit");
            enter = input.next();
        }else{
            clrscr();
            System.out.println("Invalid Current Pin!");
            System.out.println("");System.out.println(""); 
            System.out.println("Enter 1 to Exit");
            enter = input.next();
        }
    }
    public static void clrscr(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }


}
class Admin{
    private static List<Integer> AtmCash = Arrays.asList(100,100,100,100);
    public List  getAtmCash(){
        return  AtmCash;
    }
    public Integer getTotalAtmCash(){
        int one = AtmCash.get(0) *100;
        int two = AtmCash.get(1) *200;
        int five = AtmCash.get(2) *500;
        int twenty = AtmCash.get(3) *2000;
        return one+two+five+twenty;   
    }
    public void setAtmCash(int one ,int two ,int five , int twenty,boolean type){
        if(type){
            AtmCash.set(0,( AtmCash.get(0)+one));
            AtmCash.set(1, (AtmCash.get(1)+two));
            AtmCash.set(2, (AtmCash.get(2)+five));
            AtmCash.set(3, (AtmCash.get(3)+twenty));
        }else{
            AtmCash.set(0,( AtmCash.get(0)-one));
            AtmCash.set(1, (AtmCash.get(1)-two));
            AtmCash.set(2, (AtmCash.get(2)-five));
            AtmCash.set(3, (AtmCash.get(3)-twenty));
        }
    }
}



class Customer{
    private static int AvlBalance = 16000;
    private static List<String> Statement = new ArrayList<String>();
      

    private static int Pin = 5021;

    public int getPin(){
        return Pin;
    } 

    public void setPin(int n){
        Pin = n;
    }

    public long getAvlBalance(){
        return AvlBalance;
    }
    public  void   setAvlBalance(int n,boolean type){
        if(type){
            AvlBalance = AvlBalance+n;
            System.out.println();
            Statement.add(java.time.LocalDate.now()+"   "+"Credit"+"   "+ n +"   "+AvlBalance);

        }else{
            AvlBalance = AvlBalance-n;
            System.out.println();
            Statement.add(java.time.LocalDate.now()+"   "+"Debit "+"   "+ n +"   "+AvlBalance);
        }
    }

    public List getStatement(){
        return Statement;
    }

}


