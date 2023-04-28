package java_HW6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Scanner;

public class task_1_HW6{

    public class Laptop {
        // Поля класса
        private String brand;
        private String model;
        private int ram;
        private int storage;
        private String os;
        private double price;
        private String color;
    
        // Конструкторы
        public Laptop(String brand, String model, int ram, int storage, String os, double price, String color) {
            this.brand = brand;
            this.model = model;
            this.ram = ram;
            this.storage = storage;
            this.os = os;
            this.price = price;
            this.color = color;
        }
    
        // Геттеры и сеттеры
        public String getBrand() {
            return brand;
        }
    
        public void setBrand(String brand) {
            this.brand = brand;
        }
    
        public String getModel() {
            return model;
        }
    
        public void setModel(String model) {
            this.model = model;
        }
    
        public int getRam() {
            return ram;
        }
    
        public void setRam(int ram) {
            this.ram = ram;
        }
    
        public int getStorage() {
            return storage;
        }
    
        public void setStorage(int storage) {
            this.storage = storage;
        }
    
        public String getOs() {
            return os;
        }
    
        public void setOs(String os) {
            this.os = os;
        }
    
        public double getPrice() {
            return price;
        }
    
        public void setPrice(double price) {
            this.price = price;
        }
    
        public String getColor() {
            return color;
        }
    
        public void setColor(String color) {
            this.color = color;
        }
    
        // Метод для вывода информации о ноутбуке
        @Override
        public String toString() {
            return "Ноутбук " + brand + " " + model + ", " + ram + " ГБ озу, " +
                    storage + " ГБ ЖД, " + os + ", цена: " + price + ", цвет: " + color;
        }
    }

    Set<Laptop> laptops = new HashSet<>();
    // Создаем несколько ноутбуков
    Laptop laptop1 = new Laptop("Lenovo IdeaPad", "Intel Core i5", 8, 512, "Windows 10", 0, "Silver");
    Laptop laptop2 = new Laptop("Dell XPS", "Intel Core i7", 16, 1_024, "Windows 11", 0, "Black");
    Laptop laptop3 = new Laptop("HP Pavilion", "AMD Ryzen 5", 12, 256, "Windows 10", 0, "Gold");


    // Добавляем ноутбуки в множество
    public void adding() {
        laptops.add(laptop1);
        laptops.add(laptop2);
        laptops.add(laptop3);
    }

    public static void filterLaptops(Set<Laptop> laptops) {
        Scanner scanner = new Scanner(System.in);
    
        // Создаем карту фильтров
        Map<String, Object> filters = new HashMap<>();
    
        // Запрашиваем у пользователя критерии фильтрации
        System.out.println("Введите цифру, соответствующую необходимому критерию:\n" +
                "1 - озу\n" +
                "2 - Объём ЖД\n" +
                "3 - Операционная система\n" +
                "4 - Цвет");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Считываем лишний перенос строки
    
        switch (choice) {
            case 1:
                System.out.println("Введите количество озу:");
                int minRam = scanner.nextInt();
                scanner.nextLine(); // Считываем лишний перенос строки
                filters.put("RAM", minRam);
                break;
            case 2:
                System.out.println("Введите объем жесткого диска:");
                int minStorage = scanner.nextInt();
                scanner.nextLine(); // Считываем лишний перенос строки
                filters.put("Storage", minStorage);
                break;
            case 3:
                System.out.println("Введите операционную систему:");
                String os = scanner.nextLine();
                filters.put("OS", os);
                break;
            case 4:
                System.out.println("Введите цвет:");
                String color = scanner.nextLine();
                filters.put("Color", color);
                break;
            default:
                System.out.println("Некорректный выбор критерия фильтрации.");
                return;
        }
    
        // Фильтруем ноутбуки по критериям
        List<Laptop> filteredLaptops = laptops.stream()
                .filter(laptop -> {
                    boolean matchesCriteria = true;
                    for (Map.Entry<String, Object> entry : filters.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (key.equals("RAM")) {
                            matchesCriteria = matchesCriteria && (laptop.getRam() >= (int) value);
                        } else if (key.equals("Storage")) {
                            matchesCriteria = matchesCriteria && (laptop.getStorage() >= (int) value);
                        } else if (key.equals("OS")) {
                            matchesCriteria = matchesCriteria && laptop.getOs().equalsIgnoreCase((String) value);
                        } else if (key.equals("Color")) {
                            matchesCriteria = matchesCriteria && laptop.getColor().equalsIgnoreCase((String) value);
                        }
                    }
                    return matchesCriteria;
                })
                .collect(Collectors.toList());
    
        // Выводим результаты
        if (filteredLaptops.size() > 0) {
            System.out.println("Результаты фильтрации:");
            for (Laptop laptop : filteredLaptops) {
                System.out.println(laptop.toString());
            }
        } else {
            System.out.println("По заданным критериям ноутбуки не найдены.");
        }
    
    // Запрашиваем критерии фильтрации у пользователя
    Scanner scanner = new Scanner(System.in);
    Map<String, Object> filters = new HashMap<>();

    while (true) {
        System.out.println("Введите цифру, соответствующую необходимому критерию:\n" +
        "1 - озу\n" +
        "2 - Объём ЖД\n" +
        "3 - Операционная система\n" +
        "4 - Цвет\n" +
        "5 - Завершить ввод критериев");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 5) {
            break;
        }

        switch (choice) {
            case 1:
                System.out.println("Введите минимальный объем озу:");
                int minRam = scanner.nextInt();
                filters.put("RAM", minRam);
                break;
            case 2:
                System.out.println("Введите минимальный объем жесткого диска:");
                int minStorage = scanner.nextInt();
                filters.put("Storage", minStorage);
                break;
            case 3:
                System.out.println("Введите операционную систему:");
                String os = scanner.nextLine();
                filters.put("OS", os);
                break;
            case 4:
                System.out.println("Введите цвет:");
                String color = scanner.nextLine();
                filters.put("Color", color);
                break;
            default:
                System.out.println("Некорректный выбор критерия фильтрации.");
                break;
        }
    }
}