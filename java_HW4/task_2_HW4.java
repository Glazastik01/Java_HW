package java_HW4;

import java.util.ArrayDeque;
import java.util.Deque;

public class task_2_HW4 {
    public static void main(String[] args) {
        Deque<Integer> deque1 = new ArrayDeque<>();
        deque1.add(2);
        deque1.add(4);
        deque1.add(3);

        Deque<Integer> deque2 = new ArrayDeque<>();
        deque2.add(5);
        deque2.add(6);
        deque2.add(4);

        Deque<Integer> result = addTwoNumbers(deque1, deque2);

        while (!result.isEmpty()) {
            System.out.print(result.removeLast() + " "); // 7 0 8
        }
    }

    public static Deque<Integer> addTwoNumbers(Deque<Integer> deque1, Deque<Integer> deque2) {
        Deque<Integer> sum = new ArrayDeque<>();
        int carry = 0;

        while (!deque1.isEmpty() || !deque2.isEmpty() || carry != 0) {
            int digit1 = deque1.isEmpty() ? 0 : deque1.removeFirst();
            int digit2 = deque2.isEmpty() ? 0 : deque2.removeFirst();
            int digitSum = digit1 + digit2 + carry;
            carry = digitSum / 10;
            digitSum %= 10;
            sum.add(digitSum);
        }

        return sum;
    }
}


