public class Sorter{
    public static int bubleSort(SortInfce o, int b, int e){
        int max = b;
        int i;
        for (i=b; i<=e; i++){
            if(o.isGreater(i, max)){
                max=i;
            }
        }
        return max;
    }
}