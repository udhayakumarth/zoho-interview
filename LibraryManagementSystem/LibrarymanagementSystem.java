import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibrarymanagementSystem {
    static String Enter;
    static Scanner input = new Scanner(System.in);
    static List<Admin> AdminList = new ArrayList<>();
    static List<Customer> CustomerList = new ArrayList<>();
    static List<Book> BooksList = new ArrayList<>();
    static List<Cart> CartList = new ArrayList<>();
    static List<Borrowed> BorrowedList = new ArrayList<>();
    public static  void main(String[] args) {
        Admin AdminTemp = new Admin("Udhaya", "5021");
        AdminList.add(AdminTemp);
        Book BookTemp1 = new Book("OneNight@CallCenter", "Chetan Bhagat", "Story", 978812910816L,95);
        BooksList.add(BookTemp1);
        Book BookTemp2 = new Book("OneNight@CallCenter", "Chetan Bhagat", "Story", 978812910818L,95);
        BooksList.add(BookTemp2);
        Book BookTemp3 = new Book("ITooHadALoveStory", "Ravinder Singh", "Story", 9780670090747L,399);
        BooksList.add(BookTemp3);
        Book BookTemp4 = new Book("BriefAnswerstotheBigQuestions", "Stephen Hawking", "Science", 9780670090106L,247);
        BooksList.add(BookTemp4);
        Book BookTemp5 = new Book("ABriefHistoryOfTime", "Stephen Hawking", "Science", 9780670090509L,149);
        BooksList.add(BookTemp5);
        Customer CustomerTemp = new Customer("1", "1", "Udhayakumar", "Avinashi,Tiruppur", 1500,CustomerList.size());
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
               case 2:
               Customer();
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
                System.out.println("\nChoose any option : \n----------\n1.Add Book\n2.View All Books\n3.Search Book By ISBN\n4.Search Book By Name\n5.Books Most Used\n6.Books Not Used\n7.Books need Refill\n8.Books Not Returned\n9.Remove Books\n10.Edit Books\n----------");
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
        Customer Customer = new Customer("", "", "", "", 0, 0);
        for(Customer i : CustomerList){
            if(i.Email.equals(Email) && i.Password.equals(Password)){
                Customer = i;
                Auth = true;
            }
        }
        if(Auth){
            boolean loop =true;
            while(loop){
                clrscr();
                System.out.println("Welcome " + Customer.Name);
                System.out.println("\nChoose any option : \n----------\n1.View Books\n2.View Cart\n3.Borrowed History\n4.Fine History\n5.Search Book By Name\n6.Return Book\n7.Your Profile\n8.Logout\n----------\n");
                int CustomerInput = input.nextInt();
                switch(CustomerInput){
                    case 1:
                    ViewAllBooksCustomer(Customer);
                    break;
                    case 2:
                    ViewCart(Customer.Id);
                    break;
                    case 3:
                    BorrowedHistory(Customer.Id);
                    break;
                    case 4:
                    break;
                    case 6:
                    ReturnBook(Customer.Id);
                    break;
                    case 7:
                    YourProfile(Customer.Id);
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
            if(i.Borrowed){
                for(Borrowed j : BorrowedList){
                    if(i.Isbn.equals(j.Book.Isbn)){
                        System.out.println("ISBN        : "+i.Isbn+"\nName        : "+i.BookName+"\nAuthor      : "+i.Author+"\nGenre       : "+i.Genre+"\nBorrowed : by User "+j.Customer.Id+"\nBorrowedCount : "+i.BorrowedCount+"\n----------\n");
                    }
                }
            }else{
                System.out.println("ISBN        : "+i.Isbn+"\nName        : "+i.BookName+"\nAuthor      : "+i.Author+"\nGenre       : "+i.Genre+"\nBorrowed : No \nBorrowedCount : "+i.BorrowedCount+"\n----------\n");
            }
        }
        
        System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
    }

    public static void ViewAllBooksCustomer(Customer Customer){
        clrscr();
        System.out.println("------All Books------\n");
        for( Book i : BooksList){
            if(i.Borrowed == false){
                System.out.println("ISBN        : "+i.Isbn+"\nName        : "+i.BookName+"\nAuthor      : "+i.Author+"\nGenre       : "+i.Genre+"\n----------");
            }
        }
        System.out.println("\nEnter ISBN to Add Cart : ");Long Isbn = input.nextLong();
        AddToCart(Isbn, Customer );
    }

    public static void ViewCart( String UserId){
        clrscr();
        boolean BookNull = true;
        System.out.println("----------Your Cart----------");
        for(Cart i : CartList){
            if(i.Customer.Id.equals(UserId)){
                System.out.println("ISBN        : "+i.Book.Isbn+"\nName        : "+i.Book.BookName+"\nAuthor      : "+i.Book.Author+"\nGenre       : "+i.Book.Genre+"\n----------");
                BookNull = false;
            }
        }
        if(BookNull){
            System.out.println("\nNo Data Found");
            System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
        }else{
            System.out.print("\nEnter 1 to Checkout All \nOr Enter ISBN to delete\n");Long CartInput = input.nextLong();
            if(CartInput.equals(1L)){
                Checkout(UserId);
            }else{
                boolean Removed = false;
                for(int i=0 ;i<CartList.size();i++){
                    if(CartList.get(i).Customer.Id.equals(UserId) && CartList.get(i).Book.Isbn.equals(CartInput)){
                        CartList.remove(i);
                        for(Customer j : CustomerList){
                            if(j.Id.equals(UserId)){
                                j.CartItemCount-=1;
                                }
                        }
                        Removed = true;
                    }
                }
                if(Removed){
                    System.out.println("\nRemoved Sucessfully");
                    System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
                    ViewCart(UserId);
                }else{
                    System.out.println("\nTry Again");
                    System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
                }
            }
              
        }
        
    }

    public static void Checkout(String UserId){
        boolean CartNotNull = false;
        for(int i =0;i<CartList.size();i++){
            if(CartList.get(i).Customer.Id.equals(UserId)){
                Borrowed BorrowedTemp = new Borrowed(CartList.get(i).Book, CartList.get(i).Customer);
                BorrowedList.add(BorrowedTemp);
                for(int j=0 ;j<BooksList.size();j++){
                    if(BooksList.get(j).Isbn.equals(CartList.get(i).Book.Isbn) && BooksList.get(i).Borrowed==false){
                        BooksList.get(j).Borrowed = true ;
                        BooksList.get(j).BorrowedCount+=1;
                    }
                }
                CartList.remove(i);
            }
        }
        for(Cart i : CartList){
            if(i.Customer.Id.equals(UserId)){
                CartNotNull = true;
            }
        }
        if(CartNotNull){
            Checkout(UserId);
        }else{
            clrscr();
            for(Customer j : CustomerList){
                if(j.Id.equals(UserId)){
                    j.CartItemCount=0;
                    }
            }
            System.out.println("\nAll Books Checked Out :) ");
            System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
        }
        
    }

    public static void ReturnBook(String UserId){
        clrscr();
        System.out.println("------Return Book-------\n\n");
        boolean BooksNull = true;
        for(Borrowed i : BorrowedList){
            if(i.Customer.Id.equals(UserId) && i.Returned==false){
                System.out.println("ISBN        : "+i.Book.Isbn+"\nName        : "+i.Book.BookName+"\nAuthor      : "+i.Book.Author+"\nGenre       : "+i.Book.Genre+"\n----------");
                BooksNull = false;
            }
        }
        if(BooksNull){
            System.out.println("\nNo Data Found");
            System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
        }else{
            System.out.println("\n\nEnter ISBN to Continue : ");Long isbn = input.nextLong();
            boolean Booknull = true; 
            for(int i=0;i<BorrowedList.size();i++){
                if(BorrowedList.get(i).Book.Isbn.equals(isbn) && BorrowedList.get(i).Customer.Id.equals(UserId)){
                    BorrowedList.get(i).Returned = true;
                    for(Book j : BooksList){
                        if(j.Isbn.equals(isbn)){
                            j.Borrowed = false;
                        }
                    }
                    Booknull = false;
                }
            }
            if(Booknull){
                System.out.println("\nNo Data Found");
                System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
            }else{
                System.out.println("\nBook Returned Sucessfully");
                System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
            }
        }
    }

    public static void BorrowedHistory(String UserId){
        clrscr();
        System.out.println("------Borrowed History-------\n\n");
        boolean BooksNull = true;
        for(Borrowed i : BorrowedList){
            if(i.Customer.Id.equals(UserId)){
                System.out.println("ISBN        : "+i.Book.Isbn+"\nName        : "+i.Book.BookName+"\nAuthor      : "+i.Book.Author+"\nGenre       : "+i.Book.Genre+"\nReturned    : "+i.Returned+"\n----------");
                BooksNull = false;
            }
        }
        if(BooksNull){
            System.out.println("\nNo Data Found");
            System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
        }else{
            System.out.println("\n\nEnter 1 to Continue : ");Enter = input.next();
        }

    }

    public static void YourProfile(String UserId){
        clrscr();
        for(Customer i : CustomerList){
            if(i.Id.equals(UserId)){
                System.out.println("\n----------Your Profile----------\n\nUserID : "+i.Id+"\nName : "+i.Name+"\nEamil : "+i.Email +"\nAddress : "+i.Address);
                System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
            }
        }
    }

    public static void AddToCart(Long Isbn, Customer Customer){
        boolean Added =false;
        for(Book i : BooksList){
            if(i.Isbn.equals(Isbn)){
                if(i.Borrowed){
                    System.out.println("\nWrong Input");
                    System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
                }else{
                    boolean AlredyExist = false;
                    for(int j = 0 ; j<CartList.size();j++){
                        if(i.BookName.equals(CartList.get(j).Book.BookName)){
                            AlredyExist =true;
                        }
                    }
                    if(AlredyExist){
                        System.out.println("\nBook Already exist in Your cart");
                        System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
                        ViewAllBooksCustomer(Customer);
                    }else{
                        if(Customer.CartItemCount>=3){
                            System.out.println("\nCart Limit reached Checkout or delete Books");
                            System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
                        }else{
                            for(Customer k : CustomerList){
                                if(k.Id.equals(Customer.Id)){
                                    k.CartItemCount+=1;
                                    Cart CartTemp = new Cart(i,Customer);
                                    CartList.add(CartTemp);
                                    Added = true;
                                    clrscr();
                                    System.out.println("\nBook Added to Cart");
                                    System.out.println("\nEnter 1 to Continue \nEnter 2 to Exit \n ");int oneandtwo = input.nextInt();
                                    if(oneandtwo==1){
                                        ViewAllBooksCustomer(Customer);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
    }

    public static void AddBook(){
        clrscr();
        System.out.print("Enter Book Name   : ");String BookName = input.next();
        System.out.print("Enter Author Name : ");String Author = input.next();
        System.out.print("Enter Genre       : ");String Genre = input.next();
        System.out.print("Enter Book Price  : ");int BookPrice = input.nextInt();
        System.out.print("Enter No Of Books : ");int BookCount = input.nextInt();
        System.out.println("----------\n");
        Long[] Isbns = new Long[BookCount];
        for(int i=0;i<BookCount;i++){  
            System.out.print("ISBN of Book "+(i+1)+" : ");Long Isbn = input.nextLong();
            Isbns[i] = Isbn;
        }
        for(int i=0;i<BookCount;i++){  
            Book BookTemp = new Book(BookName, Author, Genre, Isbns[i],BookPrice);
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
                System.out.println("ISBN        : "+i.Isbn+"\nName        : "+i.BookName+"\nAuthor      : "+i.Author+"\nGenre       : "+i.Genre+"\n----------");
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
                System.out.println("ISBN        : "+i.Isbn+"\nName        : "+i.BookName+"\nAuthor      : "+i.Author+"\nGenre       : "+i.Genre+"\n----------");
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
    String BookName , Author , Genre ;
    int BorrowedCount = 0;
    boolean Borrowed = false;
    int BookPrice ; 
    Long  Isbn ;

    public Book(String BookName , String Author , String Genre  , Long Isbn ,int BookPrice){
        this.BookName = BookName;
        this.Author = Author;
        this.Genre = Genre;
        this.Isbn = Isbn;
        this.BookPrice = BookPrice;
    }
}

class Customer{
    String Email , Password , Name, Address ,Id;
    int InitialDeposite;
    int CartItemCount = 0;
    public Customer(String Email , String Password ,String Name, String Address , int InitialDeposite,int Idnumber){
        this.Email = Email;
        this.Password = Password;
        this.Address = Address;
        this.InitialDeposite = InitialDeposite;
        this.Name = Name;
        this.Id =  "LA00"+ (Idnumber+1);
    }

}

class Admin{
    String UserName , Password ;
    public Admin(String UserName , String Password){
        this.UserName = UserName;
        this.Password = Password;
    }
}
 
class Cart{
    Book Book ;
    Customer Customer;
    public Cart(Book Book , Customer Customer){
        this.Book =  Book;
        this.Customer = Customer;
    }
}

class Borrowed{
    Book Book ;
    Customer Customer;
    boolean Returned = false;
    public Borrowed(Book Book , Customer Customer){
        this.Book =  Book;
        this.Customer = Customer;
    }

}