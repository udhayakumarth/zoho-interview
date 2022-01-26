import java.util.*;

public class SplitWiseApplication{
    static Scanner input  = new Scanner(System.in);
    static String Enter ; 
    static List<User> UserList = new ArrayList<>();
    static String UserID="SW001";
    public static void main(String[] args){
        User User = new User("Udhaya", "dev.udhayakumar@gmail.com", "5021",UserList.size()+1);
        UserList.add(User);
        boolean loop = true;
        while(loop){
            clrscr();
            System.out.println("Choose Any option : \n1.Add an Expense\n2.Add Money to Wallet\n3.Pending Dues\n4.Balance & History\n5.View Groups\n6.Create Group\n7.Add Contact\n");
            int MainInput  =  input.nextInt();

            switch(MainInput){
                case 1:
                break;
                case 2:
                AddMoney();
                break;
                case 3:
                break;
                case 4:
                WalletBalance();
                break;
                case 5:
                break;
                case 6:
                break;
                case 7:
                break;
                default:
                loop =false;
                break;
            }
        }
    }
    public static void AddMoney(){
        clrscr();
        System.out.print("Enter the Amount : ");int AddAmount = input.nextInt();
        for(User i : UserList){
            if(i.USERID.equals(UserID)){
                i.WALLETBAL += AddAmount;
                System.out.println("\nRs : "+AddAmount+"   Add to your Wallet");
                System.out.print("\nEnter 1 to Continue : ");Enter  = input.next();
            }
        }
    }

    public static void WalletBalance(){
        clrscr();
        for(User i : UserList){
            if(i.USERID.equals(UserID)){
                System.out.println("Your Wallet Balance is Rs : "+i.WALLETBAL);
                System.out.print("\nEnter 1 to Continue : ");Enter  = input.next();
            }
        }
    }

    public static void clrscr(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
    
}

class User{
    String USERID , USERNAME ,EMAIL ,PASSWORD ;
    int WALLETBAL ;
    public User(String UserName , String Email , String Password ,int UserID){
        this.USERNAME = UserName;
        this.EMAIL = Email;
        this.PASSWORD = Password;
        this.USERID = "SW00" + UserID;
    }

}

class Transaction{
    String TRANSACTIONID , DATETIME , AMOUNT , TYPE ,  FROMID , TOID ,GROUPNAME , REQUESTEDBY ;

    public Transaction(String TranscationId , String DateTime , String Amount , String Type , String FromId ,String  ToId){
        this.TRANSACTIONID = TranscationId;
        this .DATETIME = DateTime;
        this.AMOUNT = Amount;
        this.TYPE = Type;
        this.FROMID = FromId;
        this.TOID = ToId;
    } 
    public Transaction(String TranscationId , String DateTime , String Amount , String Type , String FromId ,String  ToId ,String GroupName , String RequestedBy){
        this.TRANSACTIONID = TranscationId;
        this .DATETIME = DateTime;
        this.AMOUNT = Amount;
        this.TYPE = Type;
        this.FROMID = FromId;
        this.TOID = ToId;
        this.GROUPNAME = GroupName;
        this.REQUESTEDBY = RequestedBy;
    }
}

class Group{
    String GROUPID;
    List GROUPMEMBERS = new ArrayList<>();
    public Group(List GroupMember , String GroupId){
        this.GROUPID = GroupId;
        this.GROUPMEMBERS = GroupMember;
    }
}