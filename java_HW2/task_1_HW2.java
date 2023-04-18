package java_HW2;

public class task_1_HW2 {
    public static String shuffleString(String s, int[] index) {
        char[] res = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            res[index[i]] = s.charAt(i);
        }
        return new String(res);
    }
}
