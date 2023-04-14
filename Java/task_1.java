package Java;
import java.util.Scanner;


public class task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество чисел: ");
        int count = scanner.nextInt();

        // Создаем массив заданного размера
        int[] numbers = new int[count];

        System.out.println("Введите " + count + " чисел(а): ");
        for (int i = 0; i < count; i++) {
            System.out.print("Число " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Кубы введенных чисел: ");
        for (int num : numbers) {
            double cube = Math.pow(num, 3); // Возведение числа в куб с использованием Math.pow()
            System.out.println("Число: " + num + ", Куб: " + cube);
        }
        
    }
}

