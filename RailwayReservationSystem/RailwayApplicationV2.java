
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RailwayApplicationV2 {
    static Scanner input  = new Scanner(System.in);
    static String enter;
    static Train Train = new Train();
    static List Trains = Train.getTrains();
    static Customers Customers = new Customers();
    
    public static void main(String[] args) {
        List Train1Stations = Arrays.asList("1.Tiruppur","2.Erode","3.Salem","4.Jolarpettai","5.Katpadi","6.Arakkonam","7.Avadi","8.Chennai CTL");
        List Train2Stations = Arrays.asList("1.Tiruppur","2.Erode","3.Karur","4.Dindigul","5.Madurai");
        Train.setTrains("Chennai Exp","Tiruppur to Chennai", 8, Train1Stations );
        Train.setTrains("Madurai Exp","Tiruppur to Madurai", 10, Train2Stations );
        Customers.setUser("Udhaya", 5021);
        boolean Mainloop = true;
        while(Mainloop){
            clrscr();
            System.out.println();
            System.out.println("Welcome To Railway Ticket Booking App ===\n-----------------------\n1.Admin\n2.Customer\n3.Exit\n-----------------------");
            int MainInput = input.nextInt();
            switch(MainInput){
                case 1:
                clrscr();
                System.out.print("Enter UserName : ");String AdminUserName = input.next();
                System.out.print("Enter Pin      : ");int AdminPin = input.nextInt();
                if(AdminUserName.equals("Root") && AdminPin==5021){
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
                            break;
                            default:
                            clrscr();
                            System.out.println("Invalid Input\n\nTry Again \n\nEnter 1 to Continue\n");
                            enter = input.next();
                            break;
                        }
                    }
                }else{
                    System.out.println("Invalid User Name or Pin");
                    System.out.println("Logout\n\nEnter 1 to Continue");
                    enter = input.next();
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
                                clrscr();
                                System.out.println("Welcome "+UserName+" :)\n\nChoose any options\n----------------\n1.Book Tickets\n2.View Tickets\n3.Logout\n----------------\n");
                                int CustomerInput = input.nextInt();
                                switch(CustomerInput){
                                    case 1:
                                    clrscr();
                                    BookTickets(UserName);
                                    break;
                                    case 2:
                                    clrscr();
                                    TicketHistory(UserName);
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
            List TrainDetails = (List)Train.get(0);
            List BookedSeats = (List)Train.get(1);
            for(int j=0 ; j<TrainDetails.size();j++){
                if(j==3){
                    List Stations = (List)TrainDetails.get(3);
                    System.out.println("Stations :");
                    for(int k=0 ; k<Stations.size();k++){
                        System.out.println(Stations.get(k));
                    }
                }else if(j==2){
                    System.out.println("NoOfSeats : "+TrainDetails.get(2));
                }else if(j==1){
                    System.out.println("Route : "+TrainDetails.get(1));
                }else if(j==0){
                    System.out.println("Name : "+TrainDetails.get(0));
                }
            }
            System.out.println("\nSeats Booked :\n");
            for(int j =0;j<BookedSeats.size();j++){
                System.out.println(BookedSeats.get(j)+"\n");
            }
            System.out.println("----------------");

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

    public static void BookTickets(String UserName){
        clrscr();
        System.out.println("Choose the Train : \n----------------");
        for(int i=0 ; i<Trains.size() ; i++){
            List TrainTemp = (List)Trains.get(i);
            List TrainDetails = (List)TrainTemp.get(0);
            System.out.println(i+1+"."+TrainDetails.get(0));
        }
        System.out.println("\n----------------");
        int TrainNo = input.nextInt()-1;
        clrscr();
        List TrainTemp = (List)Trains.get(TrainNo);
        List TrainDetails = (List)TrainTemp.get(0);
        List Stations = (List)TrainDetails.get(3);
        System.out.println("Choose Start & End Stations :");
        for(int k=0 ; k<Stations.size();k++){
            System.out.println(Stations.get(k));
        }
        System.out.print("Start Station No : ");int Start = input.nextInt()-1;
        System.out.print("End Station No : ");int End = input.nextInt();
        clrscr();
        System.out.print("\nEnter No Of Ticket : ");int NoOfTicket = input.nextInt();
        int[] SeatNo = new int[NoOfTicket];
        for(int k=0;k<NoOfTicket;k++){
            List Seats = (List)TrainTemp.get(1);
            for(int i = 0 ;i<(Integer)TrainDetails.get(2);i++){
                int TicketConfirm =0;
                for(int j=Start;j<End;j++){
                    List S = (List)Seats.get(j);
                    if((Integer)S.get(i)==0){
                        TicketConfirm+=1;
                    }
                }
                if(Start==0){
                    if(TicketConfirm==Start+End){
                        SeatNo[k] = i+1;
                        for(int j=Start;j<End;j++){
                            List S = (List)Seats.get(j);
                            S.set(i, 1);
                            Seats.set(i, S);
                        }
                        i = (Integer)TrainDetails.get(2);
                    }
                }else{
                    if(TicketConfirm==End-Start){
                        SeatNo[k] = i+1;
                        for(int j=Start;j<End;j++){
                            List S = (List)Seats.get(j);
                            S.set(i, 1);
                            Seats.set(i, S);
                        }
                        i = (Integer)TrainDetails.get(2);
                    }
                }
                }
        }
        int Tickets = 0;
        for(int k=0 ;k<NoOfTicket;k++){
            if(SeatNo[k]!=0){
                Tickets+=1;
            }
        }
        if(Tickets==NoOfTicket){
            for(int k=0 ;k<NoOfTicket;k++){
            Train.setBookedSeats(TrainNo,Start,End,SeatNo[k]);
            Customers.setTicketHistory(UserName, (String)TrainDetails.get(0), Stations.get(Start)+" to "+Stations.get(End-1),SeatNo[k]);
            }
            System.out.println("\nTicket booked :)\n");
            System.out.print("seat No : ");
            for(int i=0; i<SeatNo.length;i++){
                System.out.print(" "+SeatNo[i]);
            }
            System.out.println("\n\nEnter 1 to Continue\n");
            enter = input.next();
        }else{
            System.out.println("Tickets Not Avilable ):");
            System.out.println("\n\nEnter 1 to Continue\n");
            enter = input.next();
        }
    }

    public static void TicketHistory(String UserName){
        List TicketHistory = Customers.getTicketHistory(UserName);
        System.out.println("Booked Tickets");
        for(int i =0 ; i<TicketHistory.size();i++){
            List Ticket = (List)TicketHistory.get(i);
            System.out.println("----------------\n");
            for(int j=0;j<Ticket.size();j++){
                if(j==0){
                    System.out.println("Train Name : " +Ticket.get(0));
                }else if(j==1){
                    System.out.println("Start & End : " +Ticket.get(1));
                }else if(j==2){
                    System.out.println("Seat No : " +Ticket.get(2));
                }
            }
        }
        System.out.println("\n\nEnter 1 to Continue\n");
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
        List  TrainDetails =  Arrays.asList(TrainName,Route,NoOfSeats,Stations);
        List<List<Integer>>  Seats = new ArrayList<>(); 
        for(int i=0; i<Stations.size();i++){
            List<Integer> seat = new ArrayList<>();
            for(int j = 0; j<NoOfSeats;j++){
                seat.add(0);
            }
            Seats.add(seat);
        }
        List<List> Train = Arrays.asList(TrainDetails,Seats);
        Trains.add(Train);
    }

    public List getTrains(){
        return Trains;
    }

    public void setBookedSeats(int TrainNo ,int StartStation, int EndStation,int SeatNo){
        List Train = (List)Trains.get(TrainNo);
        List Seats = (List)Train.get(1);
        for(int j=StartStation;j<EndStation;j++){
            List S = (List)Seats.get(j); 
            S.set(SeatNo-1, 1 ); 
            Seats.set(j, S);
        }
        Train.set(1, Seats);
        Trains.set(TrainNo, Train);
    }
}

class Customers{
    private static List<List> Users = new ArrayList<List>();

    public void setUser(String UserName , int Pin){
        List TicketHistory =new ArrayList<>();
        List User = Arrays.asList(UserName,Pin , TicketHistory);
        Users.add(User);
    }


    public void setTicketHistory(String UserName,String TrainName ,String StartEnd,int SeatNo){
        List Ticket = Arrays.asList(TrainName,StartEnd,SeatNo);
        for(int i=0;i<Users.size();i++){
            List User = Users.get(i);
            if(UserName.equals((String)User.get(0))){
                List TicketHistory = (List)User.get(2);
                TicketHistory.add(Ticket);
                User.set(2, TicketHistory);
                Users.set(i, User);
            }
        }
    }

    public List getTicketHistory(String UserName){
        List Ticket = Arrays.asList(0,0,0);
        for(int i=0;i<Users.size();i++){
            List User = Users.get(i);
            if(UserName.equals((String)User.get(0))){
                List TicketHistory = (List)User.get(2);
                return TicketHistory;
            }
        }
        return Ticket;
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
