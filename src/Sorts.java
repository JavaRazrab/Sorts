import java.util.*;

public class Sorts {

    private static int digit(int num, int pos){
        return num/(int)(Math.pow(10,pos))%10;
    }

    private static void doSortBy(Collection<Integer> collection, int pos, List<Queue<Integer>> numbers){
        collection.forEach(x -> {
            numbers.get(digit(x, pos)).add(x);
        });
        collection.clear();
        numbers.forEach(x -> {
            while(!x.isEmpty())
                collection.add(x.poll());
        });
    }

    public static void radixSort(Collection<Integer> collection){
        int maxL = 1;
        List<Queue<Integer>> numbers = List.of(
                new PriorityQueue<>(), new PriorityQueue<>(),
                new PriorityQueue<>(), new PriorityQueue<>(),
                new PriorityQueue<>(), new PriorityQueue<>(),
                new PriorityQueue<>(), new PriorityQueue<>(),
                new PriorityQueue<>(), new PriorityQueue<>());
        for(int num:collection){
            numbers.get(digit(num, 0)).add(num);
            maxL = (int)Math.max(Math.log10(num), maxL);
        }
        System.out.println(1);
        collection.clear();
        numbers.forEach(x -> {
            while(!x.isEmpty())
                collection.add(x.poll());
        });
        System.out.println(maxL);
        for(int i = 1; i<=maxL; i++){
            doSortBy(collection, i, numbers);
        }
    }


    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        int opora = array[middle];
        int i = low, j = high;

        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
    static void radixSort(int arr[], int n)
    {
        int m=-1;
        for (int i : arr) {
            if(i>m)
                m = i;
        }
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
}
