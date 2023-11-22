import java.util.Random;

public class IntData implements SortInfce{
    public int[] arr;
    public IntData(){
        arr= new int[10];
        Random random =new Random();
        for(int i=0;i<10;i++){
            arr[i]=random.nextInt(0,100);
        }
    }
    public static void main(String[] a){
        IntData i =new IntData();
        System.out.println(Sorter.bubleSort(i, 0,i.arr.length-1));
    }
}