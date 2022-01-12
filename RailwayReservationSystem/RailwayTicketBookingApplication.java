import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RailwayTicketBookingApplication {
    static Scanner input  = new Scanner(System.in);
    static String enter;
    static Train Train = new Train();
    static List Trains = Train.getTrains();
    static Customers Customers = new Customers();
    
    public static void main(String[] args) {
        List Train1Stations = Arrays.asList("1.Tiruppur","2.Erode","3.Salem","4.Jolarpettai","5.Katpadi","6.Arakkonam","7.Avadi","8.Chennai CTL");
        List Train2Stations = Arrays.asList("1.Tiruppur","2.Erode","3.Karur","4.Dindigul","5.Madurai");
        Train.setTrains("Chennai Exp","Tiruppur to Chennai", 30, Train1Stations );
        Train.setTrains("Madurai Exp","Tiruppur to Madurai", 40, Train2Stations );
        Customers.setUser("Udhaya", 5021);
        boolean Mainloop = true;
        while(Mainloop){
            clrscr();
            System.out.println();
            System.out.println("Welcome To Railway Ticket Booking App ===\n-----------------------\n1.Admin\n2.Customer\n3.Exit\n-----------------------");
            int MainInput = input.nextInt();
            switch(MainInput){
                case 1:
                boolean Adminloop = true;
                while(Adminloop){
                    clrscr();
                    System.out.println("Welcome Admin :)\n\nChoose any options\n----------------\n1.View Trains\n2.Add Trains\n3.Logout\n----------------\n");
                    int AdminInput = input.nextInt();
                    switch(AdminInput){
                        case 1:
                        clrscr();
                        ViewTrains();
                        break;
                        case 2:
                        AddTrains();
                        break;
                        case 3:
                        clrscr();
                        System.out.println("------Logout------\n\nEnter 1 to Confirm\n");
                        enter = input.next();
                        Adminloop=false;
                        default:
                        clrscr();
                        System.out.println("Invalid Input\n\nTry Again \n\nEnter 1 to Continue\n");
                        enter = input.next();
                    }
                }
                break;
                case 2:
                clrscr();
                boolean Authloop = true;
                while(Authloop){
                    clrscr();
                    System.out.println("Choose any options\n----------------\n1.Already Have An Account\n2.Create An Account\n3.Back\n----------------\n");
                    int AuthInput = input.nextInt();
                    switch(AuthInput){
                        case 1:
                        clrscr();
                        System.out.print("Enter User Name : ");String UserName = input.next();
                        System.out.print("Enter Pin : ");int Pin = input.nextInt();
                        if(Customers.AuthUser(UserName, Pin)){
                            clrscr();
                            boolean Customerloop = true;
                            while(Customerloop){
                                System.out.println("Welcome "+UserName+" :)\n\nChoose any options\n----------------\n1.Book Tickets\n2.View Tickets\n3.Logout\n----------------\n");
                                int CustomerInput = input.nextInt();
                                switch(CustomerInput){
                                    case 1:
                                    clrscr();
                                    System.out.println("Book Tickets");
                                    break;
                                    case 2:
                                    clrscr();
                                    System.out.println("View Tickets");
                                    break;
                                    case 3:
                                    Customerloop = false;
                                    Authloop =false;
                                    break;
                                }
                            }
                        }else{
                            System.out.println("\nInvalid User Name or Pin");
                            System.out.println("\n\nEnter 1 to Continue\n");
                            enter = input.next();
                        }
                        break;
                        case 2:
                        clrscr();
                        System.out.print("Enter New User Name : ");String NewUserName = input.next();
                        System.out.print("Enter New Pin : ");int NewPin = input.nextInt();
                        Customers.setUser(NewUserName, NewPin);
                        System.out.println("Account Created Succesfully.");
                        System.out.println("\n\nEnter 1 to Continue\n");
                        enter = input.next();
                        break;
                        case 3:
                        Authloop = false;
                        break;
                        
                    }
                }
                break;
                case 3:
                clrscr();
                System.out.println("Logout\n\nEnter 1 to Exit");
                enter = input.next();
                Mainloop = false;
                break;
                default:
                clrscr();
                System.out.println("Invalid Input  Try Again\n\nEnter 1 to exit");
                enter = input.next();
                break;
            }
        }        
    }

    public static void ViewTrains(){
        clrscr();
        for(int i=0 ; i<Trains.size() ; i++){
            List Train = (List)Trains.get(i);
            System.out.println("----------------");
            for(int j=0 ; j<Train.size();j++){
                if(j==3){
                    List Stations = (List)Train.get(3);
                    System.out.println("Stations :");
                    for(int k=0 ; k<Stations.size();k++){
                        System.out.println(Stations.get(k));
                    }
                }else if(j==2){
                    System.out.println("NoOfSeats : "+Train.get(2));
                }else if(j==1){
                    System.out.println("Route : "+Train.get(1));
                }else if(j==0){
                    System.out.println("Name : "+Train.get(0));
                }
            }
        }

        System.out.println("\n\nEnter 1 to exit");
        enter = input.next();

        
        
    }

    public static void AddTrains(){
        clrscr();
        System.out.print("Enter Train Name : ");String TrainName = input.next();
        clrscr();
        System.out.println("Enter Train Route\n");
        System.out.print("Start  : ");String Start = input.next();
        System.out.print("End   : ");String End = input.next();
        clrscr();
        System.out.print("Enter No Of Seats : ");int NoOfSeats = input.nextInt();
        clrscr();
        System.out.print("Enter No of Stations :");int NoOfStations = input.nextInt();
        List<String> Stations = new ArrayList<>();
        for(int i =0;i<NoOfStations;i++){
            System.out.print((i+1)+".");String Station = input.next();
            Stations.add(i, (i+1)+"."+Station);
        }
        Train.setTrains(TrainName,Start+" to "+End,NoOfSeats, Stations );
        System.out.println("Train Added Sucessfully \n\nEnter 1 to exit");
            enter = input.next();


    }

    public static void clrscr(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

}


class Train{
    private static List<List> Trains = new ArrayList<List>();

    public void setTrains(String TrainName ,String Route, int NoOfSeats , List Stations ){
        List  Train =  Arrays.asList(TrainName,Route,NoOfSeats,Stations);
        Trains.add(Train);
    }

    public List getTrains(){
        return Trains;
    }
}

class Customers{
    private static List<List> Users = new ArrayList<List>();

    public void setUser(String UserName , int Pin){
        List User = Arrays.asList(UserName,Pin);
        Users.add(User);
    }

    public boolean AuthUser(String UserName , int Pin){
        boolean Auth = false;
        for(int i=0;i<Users.size();i++){
            List User = Users.get(i);
            if(UserName.equals((String)User.get(0)) && Pin==(Integer)User.get(1)){
                Auth = true;
            }
        }
        return Auth;
    }
}
