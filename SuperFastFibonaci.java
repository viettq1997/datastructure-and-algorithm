public class SuperFastFibonaci {
    
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(start);
        fastLoopFIB(0);
        System.out.println(System.currentTimeMillis() - start);

    }
    private static Integer fastLoopFIB(Integer n) {
        if (n == 1 || n == 2) return 1;
        int first = 1, second = 1;
        for (int i = 3; i <= n; i++) {
            second = first + second;
            first = second - first;
        }
        System.out.println(second);
        return second;
    }
}
