import java.util.ArrayList;
import java.util.List;

public class task2 {
    public static void main(String[] args){
        System.out.println(findSimpleNumbers(10));
    }

    public static List<Integer> findSimpleNumbers(int lastNumber) {
        List<Integer> result = new ArrayList<Integer>();
        boolean simple = true;
        for (int i = 1; i <= lastNumber; i++) {
            simple = true;
            for (int j = 2; j < i / 2   ; j++) {
                if (i % j == 0) {
                    simple = false;
                    break;
                }
            }
            if (simple) {
                result.add(i);
            }
        }
        return result;
    }
}
