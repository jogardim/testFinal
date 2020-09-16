package test;

import java.time.Duration;
import java.time.Instant;

/**
 * Testing "final" performance using Java 1.8
 */
public class TestFinal {

    public static final int ITERATIONS = 1_000_000;

    public static String testFinal() {
        final String a = "a";
        final String b = "b";
        return a + b;
    }

    public static String testNonFinal() {
        String a = "a";
        String b = "b";
        return a + b;
    }

    public static void main(String... args) {
        Instant initFinal = Instant.now();
        for (int i = 0; i < ITERATIONS; i++) {
            testFinal();
        }
        Instant endFinal = Instant.now();
        System.out.println("With final: " + Duration.between(initFinal, endFinal).toMillis());

        Instant initNonFinal = Instant.now();
        for (int i = 0; i < ITERATIONS; i++) {
            testNonFinal();
        }
        Instant endNonFinal = Instant.now();
        System.out.println("Without final: " + Duration.between(initNonFinal, endNonFinal).toMillis());
    }

}
