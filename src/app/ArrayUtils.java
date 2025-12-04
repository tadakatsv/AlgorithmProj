package app;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class ArrayUtils {

    @Author(name = "Михайло", surname = "Чекмарьов")
    @MethodInfo(name = "binarySearch", returnType = "int",description = "Пошук елементу в відсортованому масиві")
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

    @Author(name = "Максим", surname = "Привалов")
    @MethodInfo(name = "mergeSort", returnType = "int",description = "Ссилка на сортування злиттям для інкапсуляції")
    public static int[] mergeSort(int[] array){
        return mergeSortTech(array,0,
                array.length - 1);
    }

    @Author(name = "Владіслав", surname = "Шуковілов")
    @MethodInfo(name = "mergeSortTech", returnType = "int",description = "Сортування злиттям")
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
    @Author(name = "Максим", surname = "Шляхтін")
    @MethodInfo(name = "merge", returnType = "void",description = "Саме злиття масивів")
    public static void merge(int[] subset, int low,
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

    public static void getAnnot(AnnotatedElement element) {
        try  {
            System.out.println("\nAnnotation on " +
                    element.getClass().getName());
            // Метод getAnnotations() повертає анотації,
            // присутні у цьому елементі
            Annotation[] annotations = element.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Author authorInfo) {
                    System.out.println("Name: " + authorInfo.name());
                    System.out.println("Surname: " + authorInfo.surname());
                }
                if (annotation instanceof MethodInfo methodInfo) {
                    System.out.println("Name: " + methodInfo.name());
                    System.out.println("returnType: " + methodInfo.returnType());
                    System.out.println("description: " + methodInfo.description());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Author(name = "Святослав", surname = "Навроцький")
    @MethodInfo(name = "getOutput", returnType = "void",description = "вивід масива")
    public static void getOutput(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}

