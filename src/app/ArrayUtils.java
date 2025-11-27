package app;

public class ArrayUtils {
    public static int binarySearch(int[] array, int target) {
        // Нижній (початковий) індекс
        int low = 0;
        // Верхній (кінцевий) індекс
        int high = array.length - 1;

        while (low <= high) {
            // Середній індекс
            int mid = (low + high) / 2;

            if (array[mid] < target) {
                low = mid + 1;
            } else if (array[mid] > target) {
                high = mid - 1;
            } else if (array[mid] == target) {
                return mid;
            }
        }
        return -1;
    }
    public static int[] mergeSort(int[] array){
        return mergeSortTech(array,0,
                array.length - 1);
    }
    private static int[] mergeSortTech(int[] elements, int low,
                                      int high) {
        // Список, що містить принаймні 2 елементи
        if (low < high) {
            int mid = (low + high) / 2;
            // Рекурсія: сортування першої половини
            mergeSortTech(elements, low, mid);
            // Рекурсія: сортування другої половини
            mergeSortTech(elements, mid + 1, high);
            // Об'єднання відсортованих половин
            merge(elements, low, mid, high);
        }
        return elements;
    }


    // Метод об'єднання відсортованого масиву елементів
    // від low до mid та mid+1.
    // low - найлівіше положення підмножини елементів.
    // high - найправіша позиція підмножини елементів.
    private static void merge(int[] subset, int low,
                              int mid, int high) {

        int n = high - low + 1;
        int[] temp = new int[n];

        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid || j <= high) {
            if (i > mid)
                temp[k++] = subset[j++];
            else if (j > high)
                temp[k++] = subset[i++];
            else if (subset[i] < subset[j])
                temp[k++] = subset[i++];
            else
                temp[k++] = subset[j++];
        }
        for (j = 0; j < n; j++)
            subset[low + j] = temp[j];
    }

    public static void getOutput(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}
