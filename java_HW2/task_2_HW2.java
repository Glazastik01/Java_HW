package java_HW2;

import java.util.Scanner;

public class task_2_HW2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] book = new String[n];
        for (int i = 0; i < n; i++) {
            book[i] = scanner.nextLine();
        }
        int m = scanner.nextInt();
        scanner.nextLine();
        String[] allergies = new String[m];
        String[] replacements = new String[m];
        for (int i = 0; i < m; i++) {
            String[] line = scanner.nextLine().split(" - ");
            allergies[i] = line[0];
            replacements[i] = line[1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                book[i] = book[i].replaceAll(allergies[j], replacements[j]);
                book[i] = book[i].replaceAll(firstLetterToUpper(allergies[j]), firstLetterToUpper(replacements[j]));
            }
            System.out.println(book[i]);
        }
    }
    // метод для замены первой буквы строки на заглавную
    public static String firstLetterToUpper(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        } else {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
    }  
}
