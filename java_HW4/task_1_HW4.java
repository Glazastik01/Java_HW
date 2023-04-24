package java_HW4;

import java.util.ArrayDeque;
import java.util.Deque;

public class task_1_HW4 {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(2);
        deque.add(1);

        boolean isPalindrome = checkPalindrome(deque);

        System.out.println(isPalindrome); // true
    }

    public static boolean checkPalindrome(Deque<Integer> deque) {
        while (deque.size() > 1) {
            int first = deque.removeFirst();
            int last = deque.removeLast();
            if (first != last) {
                return false;
            }
        }
        return true;
    }
}
