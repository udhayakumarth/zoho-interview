import java.util.Scanner;

public class SecondQuestion {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int count =1;
        for (int i=0; i<n; i++){
            for(int j=0;j<n-(i+1);j++){
                System.out.print(" ");
            }
            if((i+1)%2==0){
                for (int j=3;j>=0;j--){
                    System.out.print(count+j);
                }
                count +=4;
            }else{
                for (int j=0;j<n;j++){
                    System.out.print(count++);
                }
            }
            for (int j=0;j<i;j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
