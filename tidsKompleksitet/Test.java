package tidsKompleksitet;
import java.time.Instant;

public class Test {
    public static void main(String[] args) {
        testTimeComplexity(4);
        testTimeComplexity(5);
        testTimeComplexity(6);
        testTimeComplexity(7);
        testTimeComplexity(8);
        testTimeComplexity(9);
        testTimeComplexity(10);
        testTimeComplexity(11);
    }
    public static void testTimeComplexity(int n) {
        long a = currentTimeMillis();
        long aPowN = (long)Math.pow(10, n);
        tid(aPowN);
        long b = currentTimeMillis();
        long c = b - a;
        System.out.println(c + "  " + 1000000000*c/aPowN);
    }
    public static long tid(long n) {
        long k = 0;
        for (long i = 1; i <= n; i++) {
            k = k + 5;
        }
        return k;
    }
    public static long currentTimeMillis() {
        return Instant.now().toEpochMilli();

    }
}
