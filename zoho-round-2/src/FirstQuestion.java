import java.util.Scanner;

public class FirstQuestion {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        for (int i=0; i<n; i++){
            int temp = 1;
            int temp2 = i+1;
            for (int j=0;j<i+1;j++){
                if(j==0){
                    System.out.print(temp2+" ");
                } else{
                    int val = (temp2 +(n-temp)+1);
                    System.out.print( val + " ");
                    temp2 = val;
                }
                temp++;
            }
            System.out.println();
        }
    }
}
