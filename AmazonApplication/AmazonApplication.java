import java.util.Scanner;

public class AmazonApplication {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        boolean MainLoop = true;
        while(MainLoop){
            clrscr();
            System.out.println("Amazon Shopping App\n\nChoose Any Option :\n----------------\n1.Admin\n2.Merchant\n3.Customer\n4.Exit\n----------------");
            int MainInput = input.nextInt();
            switch(MainInput){
                case 1:
                clrscr();
                System.out.println("Admin Module\n\nChoose Any Option :\n----------------\n1.Add Merchant\n2.Remove Merchant\n3.Approve Merchant\n4.Add Product\n5.View Products\n6.Logout\n----------------");
                int AdminInput = input.nextInt();
                break;
                case 2:
                clrscr();
                System.out.println("Merchant Module\n\nChoose Any Option :\n----------------\n1.View Sales Report\n2.Add Product\n3.View Products\n4.Update Products\n5.Frequent Customer\n6.Logout\n----------------");
                int MerchantInput = input.nextInt();
                break;
                case 3:
                clrscr();
                System.out.println("Customer Module\n\nChoose Any Option :\n----------------\n1.All Products\n2.View Cart\n3.Your Order\n4.Logout\n----------------");
                int CustomerInput = input.nextInt();
                break;

            }

        }
    }

    public static void clrscr(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
    
}
