import java.util.ArrayList;
import java.util.Arrays;

public class QuickServer {
    private ArrayList<Integer> data;

    public QuickServer() {
        data = new ArrayList<>(10);
    }

    public void addNumber(int number) {
        data.add(number);
    }

    public int getSize() {
        return data.size();
    }

    public String outPut() {
        String str = "";
        Integer[] array = new Integer[data.size()];
        array = data.toArray(array);
        str += "UnSorted: \n" + Arrays.toString(array) + '\n';
        quickSort(array, 0, array.length - 1);
        str += "Sorted: \n" + Arrays.toString(array);
        return str;
    }

    private int partition3(Integer arr[], int low, int high) {
        int pivot = arr[low];
        int position = (low + 1); // index of smaller element
        for (int i = low + 1; i <= high; i++) {
            if (arr[i] < pivot) {
                // swap arr[i] and arr[j]
                int temp = arr[position];
                arr[position] = arr[i];
                arr[i] = temp;
                position++;
                System.out.println(Arrays.toString(Arrays.copyOfRange(arr, low, high + 1)));
            }
        }
        arr[low] = arr[position - 1];
        arr[position - 1] = pivot;
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, low, high + 1)));

        return position - 1;
    }

    /* The main function that implements QuickSort()
     arr[] --> Array to be sorted,
     low  --> Starting index,
     high  --> Ending index */
    private void quickSort(Integer[] arr, int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition3(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}
