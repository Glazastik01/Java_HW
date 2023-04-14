package Java;
import java.util.Scanner;

public class task_2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количесто чисел: ");
        int count = scanner.nextInt();

        int[] numbers = new int[count];

        System.out.println("Введите " + count + " чисел(а): ");
        for (int i = 0; i < count; i++) {
            System.out.print("Число " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Введите число на которое надо умножить: ");
        int num_user = scanner.nextInt();

        for (int num : numbers){
            int x = num * num_user;
            System.out.println("Число: " + num + " Результат умножения: " + x);
        }
        
    }
}