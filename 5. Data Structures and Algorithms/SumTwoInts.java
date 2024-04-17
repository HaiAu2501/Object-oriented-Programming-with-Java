import java.math.BigInteger;
import java.util.Scanner;

public class SumTwoInts {
    // Cộng hai số nguyên lớn (BigInteger) trong Java:

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number: ");
        BigInteger num1 = scanner.nextBigInteger();

        System.out.println("Enter the second number: ");
        BigInteger num2 = scanner.nextBigInteger();

        // Cộng hai số nguyên lớn
        BigInteger sum = num1.add(num2);

        System.out.println("Sum of two numbers: " + sum);

        scanner.close();
    }
}
