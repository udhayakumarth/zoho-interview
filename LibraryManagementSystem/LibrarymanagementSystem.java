import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibrarymanagementSystem {
    static String Enter;
    static Scanner input = new Scanner(System.in);
    static List<Admin> AdminList = new ArrayList<>();
    static List<Customer> CustomerList = new ArrayList<>();
    static List<Book> BooksList = new ArrayList<>();
    public static  void main(String[] args) {
        Admin AdminTemp = new Admin("Udhaya", "5021");
        AdminList.add(AdminTemp);
        Book BookTemp1 = new Book("OneNight@CallCenter", "Chetan Bhagat", "Story", "A girl said the story was about six people working in a call center", 978812910816L,95);
        BooksList.add(BookTemp1);
        Book BookTemp2 = new Book("OneNight@CallCenter", "Chetan Bhagat", "Story", "A girl said the story was about six people working in a call center", 978812910818L,95);
        BooksList.add(BookTemp2);
        Book BookTemp3 = new Book("ITooHadALoveStory", "Ravinder Singh", "Story", "A most heartfelt compliments for this story often came in two words : <I Cried>", 9780670090747L,399);
        BooksList.add(BookTemp3);
        Customer CustomerTemp = new Customer("udhayakumar@gmail.com", "5021", "Udhayakumar", "Avinashi,Tiruppur", 1500,CustomerList.size());
        CustomerList.add(CustomerTemp);
       boolean loop =true;
       while(loop){
           clrscr();
           System.out.println("Welcome to LibraryApplication :)\n\nChoose any option : \n----------\n1.Admin\n2.Customer\n3.Exit\n----------\n");
           int MainInput = input.nextInt();
           switch(MainInput){
               case 1:
                AdminAuth();
               break;
               default:
               loop = false;
               break;
           }
           
       }

    }

    public static void AdminAuth(){
        clrscr();
        System.out.println("Choose any option : \n----------\n1.Already have Account\n2.Create Account\n3.Back\n----------\n");
        int AuthInput = input.nextInt();
        switch(AuthInput){
            case 1:
            Admin();
            break;
            case 2:
            clrscr();
            System.out.print("Enter UserName : ");String UserName = input.next();
            System.out.print("Enter Password : ");String Password = input.next();
            Admin AdminTemp = new Admin(UserName, Password);
            AdminList.add(AdminTemp);
            System.out.println("\n\nAccount created Suscessfully");
            System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
            break;
            default:
            break;
        }
    }

    public static void Admin(){
        clrscr();
        boolean Auth = false;
        System.out.print("Enter UserName : ");String UserName = input.next();
        System.out.print("Enter Password : ");String Password = input.next();
        for(Admin i : AdminList){
            if(i.UserName.equals(UserName) && i.Password.equals(Password)){
                Auth = true;
            }
        }
        if(Auth){
            boolean loop =true;
            while(loop){
                clrscr();
                System.out.println("Welcome Admin " +UserName);
                System.out.println("\nChoose any option : \n----------\n1.Add Book\n2.View All Books\n3.Search Book By ISBN\n4.Search Book By Name\n5.Books Most Used\n6.Books Not Used\n7.Books need Refill\n8.Books Not Returned\n----------\n");
                int AdminInput = input.nextInt();
                switch(AdminInput){
                    case 1:
                    AddBook();
                    break;
                    case 2:
                    ViewAllBooks();
                    break;
                    case 3:
                    BookByIsbn();
                    break;
                    case 4:
                    BookByName();
                    break;
                    default:
                    loop = false;
                    break;
                }
            }
        }else{
            clrscr();
            System.out.println("\n\nInvalid Account!");
            System.out.println("\nEnter 1 to Continue : ");Enter = input.next();

        }

    }

    public static void CustomerAuth(){
        clrscr();
        System.out.println("Choose any option : \n----------\n1.Already have Account\n2.Create Account\n3.Back\n----------\n");
        int AuthInput = input.nextInt();
        switch(AuthInput){
            case 1:
            Customer();
            break;
            case 2:
            clrscr();
            System.out.print("Enter Email          : ");String Email = input.next();
            System.out.print("Enter Password       : ");String Password = input.next();
            System.out.print("Enter Name           : ");String Name = input.next();
            System.out.print("Enter Address        : ");String Address = input.next();
            System.out.print("InitialDeposit(1500) : ");int InitialDeposite = input.nextInt();
            Customer CustomerTemp = new Customer(Email, Password, Name, Address, InitialDeposite,CustomerList.size());
            CustomerList.add(CustomerTemp);
            System.out.println("\n\nAccount created Suscessfully");
            System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
            break;
            default:
            break;
        }
    }

    public static void Customer(){
        clrscr();
        boolean Auth = false;
        System.out.print("Enter Email : ");String Email = input.next();
        System.out.print("Enter Password : ");String Password = input.next();
        String UserName="" , Id = "";
        for(Customer i : CustomerList){
            if(i.Email.equals(Email) && i.Password.equals(Password)){
                Auth = true;
                UserName = i.Name;
                Id = i.Id;
            }
        }
        if(Auth){
            boolean loop =true;
            while(loop){
                clrscr();
                System.out.println("Welcome " + UserName);
                System.out.println("\nChoose any option : \n----------\n1.View Books\n2.Previous fines\n3.Previous Books\n4.Search Book By Name\n5.Your Profile\n6.Logout\n----------\n");
                int CustomerInput = input.nextInt();
                switch(CustomerInput){
                    case 1:
                    break;
                    case 2:
                    break;
                    case 3:
                    break;
                    case 4:
                    break;
                    default:
                    loop = false;
                    break;
                }
            }
        }else{
            clrscr();
            System.out.println("\n\nInvalid Account!");
            System.out.println("\nEnter 1 to Continue : ");Enter = input.next();

        }
    }

    public static void ViewAllBooks(){
        clrscr();
        System.out.println("------All Books------\n");
        for( Book i : BooksList){
            System.out.println("ISBN        : "+i.Isbn+"\nName        : "+i.BookName+"\nAuthor      : "+i.Author+"\nGenre       : "+i.Genre+"\nDescription : "+i.Description+"\n----------");
        }
        
        System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
    }

    public static void AddBook(){
        clrscr();
        System.out.print("Enter Book Name   : ");String BookName = input.next();
        System.out.print("Enter Author Name : ");String Author = input.next();
        System.out.print("Enter Genre       : ");String Genre = input.next();
        System.out.print("Enter Description : ");String Description = input.next();
        System.out.print("Enter Book Price  : ");int BookPrice = input.nextInt();
        System.out.print("Enter No Of Books : ");int BookCount = input.nextInt();
        System.out.println("----------\n");
        Long[] Isbns = new Long[BookCount];
        for(int i=0;i<BookCount;i++){  
            System.out.print("ISBN of Book "+(i+1)+" : ");Long Isbn = input.nextLong();
            Isbns[i] = Isbn;
        }
        for(int i=0;i<BookCount;i++){  
            Book BookTemp = new Book(BookName, Author, Genre, Description, Isbns[i],BookPrice);
            BooksList.add(BookTemp);
        }
        System.out.println("\n\nBooks Added Suscessfully");
        System.out.println("\nEnter 1 to Continue : ");Enter = input.next();


    }

    public static void BookByIsbn(){
        clrscr();
        System.out.println("-----Search Books By ISBN-----\n");
        System.out.print("Enter ISBN : ");Long isbn = input.nextLong();
        System.out.println("");
        boolean BooksNull = true;
        for( Book i : BooksList){
            if(i.Isbn.equals(isbn)){
                System.out.println("ISBN        : "+i.Isbn+"\nName        : "+i.BookName+"\nAuthor      : "+i.Author+"\nGenre       : "+i.Genre+"\nDescription : "+i.Description+"\n----------");
                BooksNull = false;
            }
        }
        if(BooksNull){   
            System.out.println("\nNo Books Found : ");
            System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
        }else{
            System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
        }
        
    }

    public static void BookByName(){
        clrscr();
        System.out.println("-----Search Books By Name-----\n");
        System.out.print("Enter Book Name : ");String BookName = input.next();
        System.out.println("");
        boolean BooksNull = true;
        for( Book i : BooksList){
            if(i.BookName.equals(BookName)){
                System.out.println("ISBN        : "+i.Isbn+"\nName        : "+i.BookName+"\nAuthor      : "+i.Author+"\nGenre       : "+i.Genre+"\nDescription : "+i.Description+"\n----------");
                BooksNull = false;
            }
        }
        if(BooksNull){   
            System.out.println("\nNo Books Found ");
            System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
        }else{
            System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
        }
    }

    public static void clrscr(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
}

class Book{
    String BookName , Author , Genre , Description , Borrower;
    int BookPrice ; 
    Long  Isbn ;

    public Book(String BookName , String Author , String Genre , String Description , Long Isbn ,int BookPrice){
        this.BookName = BookName;
        this.Author = Author;
        this.Genre = Genre;
        this.Description = Description;
        this.Isbn = Isbn;
        this.BookPrice = BookPrice;
    }
}

class Customer{
    String Email , Password , Name, Address ,Id;
    int InitialDeposite;
    public Customer(String Email , String Password ,String Name, String Address , int InitialDeposite,int Idnumber){
        this.Email = Email;
        this.Password = Password;
        this.Address = Address;
        this.InitialDeposite = InitialDeposite;
        this.Name = Name;
        this.Id =  "LA"+ (Idnumber+1);
    }

}

class Admin{
    String UserName , Password ;
    public Admin(String UserName , String Password){
        this.UserName = UserName;
        this.Password = Password;
    }
}
 