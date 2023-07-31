public class task4 {
    public static void main(String[] args) {
        System.out.println(fb(6));//1 1 2 3 5 8
    }
    public static int fb(int num) {
        if (num <= 2) {
            return 1;
        } else {
            return fb(num-1) + fb(num-2);
        }
    }
}
