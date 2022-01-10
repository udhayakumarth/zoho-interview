import java.util.*;

public class AtmApplication {
    public static void main(String[] args) {
        boolean Mainflag = true;
        while (Mainflag){
            clrscr();
            Scanner input = new Scanner(System.in);
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
                        Admin Atm = new Admin();
                        List AtmCash = Atm.getAtmCash();
                        System.out.println("Welcome Admin :)");System.out.println("----------------------------------");System.out.println("Choose any option:");System.out.println("1.Add Cash");System.out.println("2.View Cash");System.out.println("3.Logout");System.out.println("----------------------------------");
                        int AdminInput = input.nextInt();
                        if(AdminInput==1){
                            clrscr();
                            System.out.println("Enter Amounts :");
                            System.out.print("100s - ");int one = input.nextInt();
                            System.out.print("200s - ");int two = input.nextInt();
                            System.out.print("500s - ");int five = input.nextInt();
                            System.out.print("2000s - ");int twenty = input.nextInt();
                            Atm.setAtmCash(one ,two,five,twenty);
                            for(int i=0;i<4;i++){
                                System.out.print(AtmCash.get(i)+"  ");
                              }
                            System.out.println("");System.out.println("");  
                            System.out.println("TotalCash in ATM : Rs "+ Atm.getTotalAtmCash());
                            System.out.println("");
                            System.out.println("Enter 1 to Exit");
                            String  enter = input.next();
                        }else if(AdminInput==2){
                            clrscr();
                            for(int i=0;i<4;i++){
                                System.out.print(AtmCash.get(i)+"  ");
                              }
                            System.out.println("");System.out.println("");  
                            System.out.println("TotalCash in ATM : Rs "+ Atm.getTotalAtmCash());
                            System.out.println("");System.out.println(""); 
                            System.out.println("Enter 1 to Exit");
                            String  enter = input.next();
                        }else if(AdminInput==3){
                            AdminFlag = false;
                            clrscr();
                        }
                    }
                }else{
                    clrscr();
                    System.out.println("Invalid User!");System.out.println("");System.out.println("Enter 1 to Exit");
                    String  enter = input.next();
                }
            }else if(MainInput==2){
                clrscr();
                boolean CustomerFlag = true;
                System.out.print("Enter UserId : "); int UserId = input.nextInt();
                System.out.println("");
                System.out.print("Enter Pin    : "); int Pin = input.nextInt(); 
                if(UserId==825021 && Pin==5021){
                    clrscr();
                    System.out.println("Welcome Customer :)");System.out.println("----------------------------------");System.out.println("Choose any option:");System.out.println("1.Withdraw");System.out.println("2.Check Balance");System.out.println("3.Pin Change");System.out.println("4.Mini Statement");System.out.println("5.Direct Deposit");System.out.println("6.Amount Transfer");System.out.println("7.Logout");System.out.println("----------------------------------");
                    int CustomerInput = input.nextInt();
                }
            }else{
                System.out.println("Invalid");
                 Mainflag = false;
            }
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
    public void setAtmCash(int one ,int two ,int five , int twenty){
        AtmCash.set(0,( AtmCash.get(0)+one));
        AtmCash.set(1, (AtmCash.get(1)+two));
        AtmCash.set(2, (AtmCash.get(2)+five));
        AtmCash.set(3, (AtmCash.get(3)+twenty));
    }
}

class Customer{

}


