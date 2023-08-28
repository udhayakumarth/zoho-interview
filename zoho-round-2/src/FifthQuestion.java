public class FifthQuestion {

    public static void main(String[] args){
        int[] array = new int[]{1, 0, 1, 1, 1, 0, 0, 0};
        int Start =0;
        int End =0;
        boolean b = false;

        for (int i=0;i< array.length;i++){
            int tempStart = 0;
            while(tempStart!=array.length){
                int tempEnd = tempStart+1;
                int zeros = 0;
                int ones = 0;
                while(tempEnd!=array.length){
                    for (int j=tempStart;j<=tempEnd;j++){
                        if(array[j]==0){
                            zeros +=1;
                        } else if (array[j]==1) {
                            ones +=1;
                        }
                    }
                    if(!b && ones == zeros){
                        Start = tempStart;
                        End = tempEnd;
                        b = true;
                    }else if(ones == zeros){
                        if(Start < tempStart){
                            Start = tempStart;
                            End = tempEnd;
                        }
                    }
                    tempEnd++;
                }
                tempStart++;
            }

        }

        System.out.println(Start+" to "+End);

    }
}
