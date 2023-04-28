package java_HW5;

import java.util.*;

public class task_2_HW5 {
    public static void main(String[] args) {
        String[] names = {"Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов",
        "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"};

        Map<String, Integer> nameCount = new HashMap<>();

        // считаем количество повторений для каждого имени
        for (String fullName : names) {
            String[] splitName = fullName.split(" ");
            String firstName = splitName[0];
            if (nameCount.containsKey(firstName)) {
                nameCount.put(firstName, nameCount.get(firstName) + 1);
            } else {
                nameCount.put(firstName, 1);
            }
        }

        // выводим результат
        for (Map.Entry<String, Integer> entry : nameCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
