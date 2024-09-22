import java.io.*;
import java.util.*;

public class Main {
    private static int[] array, sorted;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int size = Integer.parseInt(reader.readLine());
        array = new int[size];
        sorted = new int[size];
        for (int i = 0; i < size; i++) array[i] = Integer.parseInt(reader.readLine());
        // quickSort(0, size - 1);
        mergeSort(0, size - 1);
        for (int number : array) builder.append(number + "\n");
        System.out.print(builder.toString());
    }

    private static void mergeSort(int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, mid, right);
    }

    private static void merge(int left, int mid, int right) {
        int low = left, middle = mid + 1, high = left;
        while (low <= mid && middle <= right) {
            if (array[low] <= array[middle]) {
                sorted[high] = array[low];
                low += 1;
            } else {
                sorted[high] = array[middle];
                middle += 1;
            }
            high += 1;
        }
        if (low > mid) 
            for (int i = middle; i <= right; i++) {
                sorted[high] = array[i];
                high += 1;
            }
        else 
            for (int i = low; i <= mid; i++) {
                sorted[high] = array[i];
                high += 1;
            }
        for (int i = left; i <= right; i++) array[i] = sorted[i];
    }
}