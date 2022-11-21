import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    final static int length = 1_000_000_000;

    public static void main(String[] args) {
        //List<Integer> array = new ArrayList<>();

        int[] arr = new int[length];
        Random random = new Random();
        System.out.println(1);
        double sum = 0;
        for(int i=0;i<10;i++){
            for(int j=0;j<length;j++){
                arr[j] = random.nextInt(Integer.MAX_VALUE);
            }
            Long time1 = System.nanoTime();
            Sorts.radixSort(arr, arr.length);
            Long time2 = System.nanoTime();
            sum+=(time2-time1)/1_000_000_000.0;
            System.out.println((time2-time1)/1_000_000_000.0+"s");
        }
        System.out.println("Average for Radix: "+sum/10+"s");
        sum = 0;
        for(int i=0;i<10;i++){
            for(int j=0;j<length;j++){
                arr[j] = random.nextInt(Integer.MAX_VALUE);
            }
            Long time1 = System.nanoTime();
            Sorts.quickSort(arr, 0, arr.length-1);
            Long time2 = System.nanoTime();
            sum+=(time2-time1)/1_000_000_000.0;
            System.out.println((time2-time1)/1_000_000_000.0+"s");
        }
        System.out.println("Average for Quick: "+sum/10+"s");
    }
}
