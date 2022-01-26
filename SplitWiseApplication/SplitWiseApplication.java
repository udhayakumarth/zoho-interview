import java.util.*;

public class SplitWiseApplication{
    public static void main(String[] args){
        
    }

    class User{
        String USERID , USERNAME ,EMAIL ,PASSWORD ;
        int WALLETBAL ;
        public User(String UserName , String Email , String Password){
            this.USERNAME = UserName;
            this.EMAIL = Email;
            this.PASSWORD = Password;
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
}