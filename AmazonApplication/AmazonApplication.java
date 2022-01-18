import java.util.*;

public class AmazonApplication {
    static Scanner input = new Scanner(System.in);
    static String Enter;
    static List<Merchant> Merchantslist = new ArrayList<>(); 
    static List<Products> Productslist = new ArrayList<>();
    static List<Customer> Customerlist = new ArrayList<>();
    static List<Orders> OrdersList = new ArrayList<>();
    static List<Cart> Cartlist = new ArrayList<>();
    
    public static void main(String[] args){
        Merchant MerchantTemp  = new Merchant("Sozi","Udhaya","5021",true);
        Merchantslist.add(MerchantTemp);
        Customer CustomerTemp  = new Customer("Udhaya","5021");
        Customerlist.add(CustomerTemp);
        Products ProductTemp1 = new Products("Udhaya", "RedmiNote9pro", "SmartPhone", 9999);
        Productslist.add(ProductTemp1);
        Products ProductTemp2 = new Products("Udhaya", "Realme8pro", "SmartPhone", 8999);
        Productslist.add(ProductTemp2);
        boolean MainLoop = true;
        while(MainLoop){
            clrscr();
            System.out.println("Amazon Shopping App\n\nChoose Any Option :\n----------------\n1.Admin\n2.Merchant\n3.Customer\n4.Exit\n----------------");
            int MainInput = input.nextInt();
            switch(MainInput){
                case 1:
                Admin();
                break;
                case 2:
                MerchantAuth();
                break;
                case 3:
                CustomerAuth();
                break;
            }

        }
    }
    
    public static void Admin(){
        boolean loop = true;
        while (loop) {
            clrscr();
            System.out.println("Admin Module\n\nChoose Any Option :\n----------------\n1.Add Merchant\n2.Remove Merchant\n3.Approve Merchant\n4.View Products\n5.Logout\n----------------");
            int AdminInput = input.nextInt(); 
            switch(AdminInput){
                case 1:
                CreateMerchant();
                break;
                case 2:
                RemoveMerchant();
                break;
                case 3:
                ApproveMerchant();
                break;
                default:
                System.out.println("Invalid Input Try Again\n Enter 1 to  Continue :");Enter = input.next();loop = false;

                
            }
        }
    }

    public static void ApproveMerchant(){
        clrscr();
        boolean ApproveMerchant = false;
        System.out.println("------Approve Merchant------");
        for(int i=0 ; i<Merchantslist.size();i++){
            if(Merchantslist.get(i).verification == false){
                System.out.println("Id : " + (i+1) + "\nBusiness Name : " + Merchantslist.get(i).businessName+"\nMerchant Name : "+Merchantslist.get(i).merchantName+"\n----------");
                ApproveMerchant = true;
            }
        }
        if(ApproveMerchant){
            System.out.print("Enter No to Approve : ");int id = input.nextInt()-1;
            Merchantslist.get(id).verification = true;
            if(Merchantslist.get(id).verification){
                clrscr();
                System.out.print("\nMerchant Approved :)\n\nEnter 1 to  Continue :");Enter = input.next();
            }else{
                clrscr();
                System.out.print("\nSomthing went wrong :(\n\nEnter 1 to  Continue :");Enter = input.next();
            }
        }else{
            System.out.print("\n\nNo user Found !\n\nEnter 1 to Continue : ");Enter = input.next();
        }


    }

    public static void MerchantAuth(){
        clrscr();
        System.out.println("Merchant Module\n\nChoose Any Option :\n----------------\n1.Already have Account\n2.Create Account\n3.Back\n----------------");
        int MerchantLoginInput = input.nextInt();
        switch(MerchantLoginInput){
            case 1:
            clrscr();
            System.out.print("Enter Merchant Name : ");String UserName = input.next();
            System.out.print("Enter Password      : ");String password = input.next();
            Merchant(UserName,password);
            break;
            case 2:
            clrscr();
            System.out.print("Enter Business Name : ");String newBusinessName = input.next();
            System.out.print("Enter Merchant Name : ");String newMerchantName = input.next();
            System.out.print("Enter Password      : ");String newPassword = input.next();
            Merchant temp  = new Merchant(newBusinessName,newMerchantName,newPassword);
            Merchantslist.add(temp);
            System.out.println("\nAccount Created Succesfully \nEnter 1 to Continue : ");Enter = input.next();
            break;
            default:
            break;

        }
        
    }

    public static void CustomerAuth(){
        clrscr();
        System.out.println("Customer Module\n\nChoose Any Option :\n----------------\n1.Already have Account\n2.Create Account\n3.Back\n----------------");
        int CustomerLoginInput = input.nextInt();
        switch(CustomerLoginInput){
            case 1:
            clrscr();
            System.out.print("Enter User Name : ");String UserName = input.next();
            System.out.print("Enter Password      : ");String Password = input.next();
            Customer(UserName, Password);
            break;
            case 2:
            clrscr();
            System.out.print("Enter User Name : ");String newUserName = input.next();
            System.out.print("Enter Password      : ");String newPassword = input.next();
            Customer temp  = new Customer(newUserName,newPassword);
            Customerlist.add(temp);
            System.out.println("\nAccount Created Succesfully \nEnter 1 to Continue : ");Enter = input.next();
            break;
            default:
            break;

        }
    }

    public static void Merchant(String UserName , String Password){
        boolean Auth = false;
        for(Merchant i : Merchantslist){
            if(i.merchantName.equals(UserName) && i.merchantPassword.equals(Password) && i.verification==true){
                Auth = true;
            }
        }
        if(Auth){
            boolean loop = true;
            while(loop){
                clrscr();
                System.out.println("Merchant Module\n\nChoose Any Option :\n----------------\n1.View Sales Report\n2.Add Product\n3.View Products\n4.Delete Products\n5.Frequent Customer\n6.Logout\n----------------");
                int MerchantInput = input.nextInt();
                switch(MerchantInput){
                    case 1:
                    SalesReport(UserName);
                    break;
                    case 2:
                    AddProducts(UserName);
                    break;
                    case 3:
                    ViewProducts(UserName);
                    break;
                    case 4:
                    DeleteProduct(UserName);
                    break;
                    default:
                    loop = false;
                    break;

                    
                }
            }
        }else{
            System.out.println("UserName or Password is Invalid :(");
            System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
        }
    }

    public static void Customer(String UserName , String Password){
        boolean Auth = false;
        for(Customer i : Customerlist){
            if(i.username.equals(UserName) && i.password.equals(Password)){
                Auth = true;
            }
        }
        if(Auth){
            boolean loop = true;
            while(loop){
                clrscr();
                System.out.println("Customer Module\n\nChoose Any Option :\n----------------\n1.All Products\n2.View Cart\n3.Your Order\n4.Logout\n----------------");
                int CustomerInput = input.nextInt();
                switch(CustomerInput){
                    case 1:
                    AllProducts(UserName);
                    break;
                    case 2:
                    ViewCart(UserName);
                    break;
                    case 3:
                    YourOrder(UserName);
                    break;
                    default:
                    loop = false;
                    break;

                }
            }
        }else{
            System.out.println("UserName or Password is Invalid :(");
            System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
        }
    }

    public static void clrscr(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    public static void CreateMerchant(){
        clrscr();
        System.out.print("Enter Business Name : ");String newBusinessName = input.next();
        System.out.print("Enter Merchant Name : ");String newMerchantName = input.next();
        System.out.print("Enter Password      : ");String newPassword = input.next();
        Merchant temp  = new Merchant(newBusinessName,newMerchantName,newPassword,true);
        Merchantslist.add(temp);
        System.out.println("\nAccount Added Succesfully \nEnter 1 to Continue : ");Enter = input.next();
    }
    
    public static void RemoveMerchant(){
        clrscr();
        boolean Merchant = false;
        System.out.println("------Remove Merchant------");
        for(int i=0 ; i<Merchantslist.size();i++){
            if(Merchantslist.get(i).verification){
                System.out.println("Id : " + (i+1) + "\nBusiness Name : " + Merchantslist.get(i).businessName+"\nMerchant Name : "+Merchantslist.get(i).merchantName+"\n----------");
            Merchant = true;
            }
        }
        if(Merchant){
            System.out.print("Enter No to Remove : ");int id = input.nextInt()-1;
            for(int i =0 ;i<Productslist.size();i++){
                if(Merchantslist.get(id).merchantName.equals(Productslist.get(i).seller)){
                    Productslist.remove(i);
                }
            }
            for(int i =0 ;i<Cartlist.size();i++){
                if(Merchantslist.get(id).merchantName.equals(Cartlist.get(i).Product.seller)){
                    Cartlist.remove(i);
                }
            }
            Merchantslist.remove(id);

            clrscr();
            System.out.println("\nMerchant Removed Susccesfully\n\nEnter 1 to Continue : ");Enter = input.next();
        }else{
            System.out.print("\n\nNo user Found !\n\nEnter 1 to Continue : ");Enter = input.next();
        }
    }

    public static void SalesReport(String UserName){
        clrscr();
        System.out.println("------Sales Report------\n");
        boolean ProductsNull =true;
        int TotalSalesCount =0;
        int RevenueGenerated = 0;
        for(Products i : Productslist){
            if(i.seller.equals(UserName)){
                int SoldCount = 0; 
                int Earned = 0;
                for(int j=0 ; j<OrdersList.size();j++){
                    if(i.name.equals(OrdersList.get(j).Product.name)){
                        SoldCount+=1;
                        Earned = Earned + (i.price);
                    }
                }
                System.out.println("Product Name : "+ i.name+"\nProduct Detail : "+i.detail+"\nSold Times :"+SoldCount+"  Earned Rs: "+Earned);
                System.out.println("------------");
                ProductsNull = false;
                RevenueGenerated += Earned;
                TotalSalesCount += SoldCount;
            }
        }
        System.out.println("\nTotal Revenue Rs: "+RevenueGenerated+"\nTotal Sold Count : "+TotalSalesCount);
        if(ProductsNull){
            System.out.println("\n\nNo Data found !");
            System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
        }else{
            System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
        }

    }

    public static void AddProducts(String UserName){
        clrscr();
        System.out.println("------Add Product------");
        System.out.print("Enter Product Name   : ");String name = input.next();
        System.out.print("Enter Product Detail : ");String detail = input.next();
        System.out.print("Enter Price        :");int price = input.nextInt();
        Products temp = new Products(UserName, name, detail, price);
        Productslist.add(temp);
        System.out.println("\nProduct Added sucessfully ");
        System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
    }

    public static void ViewProducts(String UserName){
        clrscr();
        System.out.println("------All Product------\n");
        boolean ProductsNull =true;
        for(Products i : Productslist){
            if(i.seller.equals(UserName)){
                System.out.println("Product Name : "+ i.name+"\nProduct Detail : "+i.detail);
                System.out.println("------");
                ProductsNull = false;
            }
        }
        if(ProductsNull){
            System.out.println("\n\nNo Product found !");
            System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
        }else{
            System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
        }
    }

    public static void DeleteProduct(String UserName){
        clrscr();
        System.out.println("------All Product------\n");
        boolean ProductsNull =true;
        for(int i =0 ;i<Productslist.size();i++){
            if(Productslist.get(i).seller.equals(UserName)){
                System.out.println("No : "+(i+1)+"Product Name : "+ Productslist.get(i).name+"\nProduct Detail : "+Productslist.get(i).detail);
                ProductsNull = false;
            }
        }
        if(ProductsNull){
            System.out.println("\n\nNo Product found !");
            System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
        }else{
            System.out.print("\nEnter No to Delete : ");int no = input.nextInt()-1;
            for(int i =0 ;i<Cartlist.size();i++){
                if(Productslist.get(no).seller.equals(Cartlist.get(i).Product.seller)){
                    Cartlist.remove(i);
                }
            }
            Productslist.remove(no);
            System.out.println("\nProduct suscessfully Deleted\n\nEnter 1 to Continue");Enter = input.next();
        }
    }

    public static void AllProducts(String UserName){
        clrscr();
        System.out.println("------All Product------\n");
        for(int i=0 ; i<Productslist.size();i++){
            System.out.println("No : "+(i+1)+"\nProduct Name : "+ Productslist.get(i).name+"\nDetail : "+Productslist.get(i).detail+"\nSeller : "+Productslist.get(i).seller+"\nPrice Rs: "+Productslist.get(i).price);
            System.out.println("------");
        }
        if(Productslist.size()==0){
            System.out.println("\n\nNo Product found !");
            System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
        }else{
            System.out.print("\nEnter No to Add cart : ");int no = input.nextInt()-1;
            Cart CartTemp = new Cart(UserName ,Productslist.get(no));
            Cartlist.add(CartTemp);
            clrscr();
            System.out.println("\nAdded to Cart Suscessfully");
            System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
        }
    }

    public static void ViewCart(String UserName){
        clrscr();
        boolean ProductsNull =true;
        System.out.println("------Your Cart------");
        for(int i=0 ; i<Cartlist.size();i++){
            if(Cartlist.get(i).Customer.equals(UserName)){
                System.out.println("No : "+(i+1)+"\nProduct Name : "+Cartlist.get(i).Product.name+"\nPrice : "+Cartlist.get(i).Product.price);
                System.out.println("------");
                ProductsNull = false;
            }
        }
        if(ProductsNull){
            System.out.println("\n\nNo Product found !");
            System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
        }else{
            System.out.print("\nEnter No to CheckOut : ");int no = input.nextInt()-1;
            Orders OrderTemp = new Orders(UserName ,Cartlist.get(no).Product);
            OrdersList.add(OrderTemp);
            Cartlist.remove(no);
            clrscr();
            System.out.println("\nOrder placed Suscessfully");
            System.out.println("\nEnter 1 to Continue : ");Enter = input.next();
        }

    }

    public static void YourOrder(String UserName){
        clrscr();
        boolean ProductsNull =true;
        System.out.println("------Your Orders------");
        for(int i=0 ; i<OrdersList.size();i++){
            if(OrdersList.get(i).Customer.equals(UserName)){
                System.out.println("No : "+(i+1)+"\nProduct Name : "+OrdersList.get(i).Product.name+"\nPrice : "+OrdersList.get(i).Product.price);
                System.out.println("------");
                ProductsNull = false;
            }
        }
        if(ProductsNull){
            System.out.println("\n\nNo Product found !");
            System.out.print("\nEnter 1 to Continue : ");Enter = input.next();
        }else{
            System.out.print("\nEnter 1 to Continue : ");Enter = input.next();
        }
    }

}


class Merchant{
    String businessName , merchantName ,  merchantPassword ;
    boolean verification = false;
    public Merchant( String BusinessName ,String MerchantName , String MerchantPassword){
        this.businessName = BusinessName;
        this.merchantPassword = MerchantPassword;
        this.merchantName = MerchantName;
    }
    public Merchant( String BusinessName ,String MerchantName , String MerchantPassword,Boolean Verification){
        this.businessName = BusinessName;
        this.merchantPassword = MerchantPassword;
        this.merchantName = MerchantName;
        this.verification = Verification;
    }
}

class Customer{
    String   username ,  password ;
    int Wallet = 0 ;
    public Customer(String UserName , String Password){
        this.username = UserName;
        this.password = Password;
    }
}

class Products{
    String name ,detail, seller ; 
    int price;
    public Products(String Seller , String Name , String Details , int Price){
        this.name = Name;
        this.detail = Details;
        this.seller = Seller;
        this.price = Price;
    }
}

class Orders{
    String Customer;
    Products Product ;
    public Orders(String UserName , Products Product){
        this.Customer = UserName;
        this.Product = Product;
    }
}

class Cart{
    String Customer;
    Products Product ;
    public Cart(String UserName , Products Product){
        this.Customer = UserName;
        this.Product = Product;
    }
}
