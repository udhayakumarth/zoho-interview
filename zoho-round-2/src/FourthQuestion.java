import java.util.Scanner;

public class FourthQuestion {
    public static void main(String[] args){
        //int[] array = new int[]{2, 5, 7};
        //int[] array = new int[]{2, 4, 8, 90, 77, 54};
        int[] array = new int[]{1, -9, -7, 56, 0, -1, 42};
        int[] result = new int[array.length];
        for(int i=0;i< array.length;i++){
            int temp = 0;
            boolean b = false;
            for (int j=i+1;j< array.length;j++){
                if(array[j] > array[i]){
                    if(!b){
                        temp = array[j];
                        b = true;
                    }else if(temp > array[j]){
                        temp = array[j];
                    }
                }
            }
            if(b){
                result[i] = temp;
            }else{
                result[i] = -1;
            }
        }

        for (int i=0;i< result.length;i++){
            System.out.print(result[i]+" ");
        }

    }
}
