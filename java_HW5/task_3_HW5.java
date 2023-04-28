package java_HW5;

import java.util.Arrays;

public class task_3_HW5 {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Строим Max Heap из массива
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    // Функция для превращения поддерева с корнем i в Max Heap
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2 * i + 1; // Индекс левого потомка
        int r = 2 * i + 2; // Индекс правого потомка

        // Если левый потомок больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Если правый потомок больше, чем самый большой элемент на данный момент
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // Если самый большой элемент не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно превращаем поддерево в Max Heap
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(arr));

        heapSort(arr);

        System.out.println("Отсортированный массив:");
        System.out.println(Arrays.toString(arr));
    }
}
