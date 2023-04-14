package Java;

import java.util.Scanner;

public class task_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1, num2, result;
        char operator;

        // Ввод первого числа
        System.out.print("Введите первое число: ");
        num1 = scanner.nextInt();

        // Ввод оператора
        System.out.print("Введите оператор (+, -, *, /): ");
        operator = scanner.next().charAt(0);

        // Ввод второго числа
        System.out.print("Введите второе число: ");
        num2 = scanner.nextInt();

        // Выполнение операции и вывод результата
        switch (operator) {
            case '+':
                result = num1 + num2;
                System.out.println("Результат: " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println("Результат: " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println("Результат: " + result);
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Ошибка: деление на ноль!");
                } else {
                    result = num1 / num2;
                    System.out.println("Результат: " + result);
                }
                break;
            default:
                System.out.println("Ошибка: неверный оператор!");
                break;
        }
        
        scanner.close();
    }
}

