import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThirdQuestion {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        //String s = scan.nextLine();
        //String s = "12345*+-+";
        //String s = "374291--*+-";
        String s = "67542-/+-";
        String[] array = s.split("");
        List<Integer> nums = new ArrayList<>();
        List<String> opr = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>48 ){
                nums.add((int)s.charAt(i)-48);
            }else{
                opr.add(String.valueOf(s.charAt(i)));
            }
        }
        int temp = nums.get(0);
        for (int i=0;i< opr.size();i++){
            if(opr.get(i).equals("*")){
                temp = temp * nums.get(i+1);
            }else if(opr.get(i).equals("+")){
                temp = temp + nums.get(i+1);
            }else if(opr.get(i).equals("-")){
                temp = temp - nums.get(i+1);
            }else if(opr.get(i).equals("/")){
                temp = temp / nums.get(i+1);
            }
        }
        System.out.println(temp);
    }
}
