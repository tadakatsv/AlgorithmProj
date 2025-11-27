package app;

import java.util.Random;
import java.util.Scanner;

import static app.ArrayUtils.*;

public class Main {
    public static void main(String[] args) {
//        Створіть клас для виконання завдання:
//        a. Створіть клас ArrayUtils, який буде містити методи для реалізації сортування злиттям та бінарного пошуку.
//        Реалізуйте методи сортування та пошуку:
//        a. Метод mergeSort(int[] array), що реалізує сортування злиттям.
//        b. Метод binarySearch(int[] array, int target), що реалізує бінарний пошук.
//        Створіть методи, щоб продемонструвати роботу алгоритмів:
//        a. Створіть масив та випадковим чином заповніть його числами.
//        b. Застосуйте метод сортування злиттям до масиву та виведіть відсортований результат.
//        c. Використайте метод бінарного пошуку для знаходження певного значення у відсортованому масиві та виведіть результат пошуку.
        Scanner scanner = new Scanner(System.in);
        int[] data = mergeSort(getData());
        getOutput(data);
        System.out.println("Який елемент знайти: ");
        int key = scanner.nextInt(); // Цільовий (ключовий) елемент
        System.out.println(binarySearch(data, key));
    }

    private static int[] getData() {
//        return new int[]{2, 7, 3, 9, 12, 4, 10, 5, 14};
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть кількість елементів масиву: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {

            // Generate a random integer
            // between 0 and 99
            arr[i] = random.nextInt(20);
        }
        return arr;
    }
}
