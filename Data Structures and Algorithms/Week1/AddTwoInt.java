import java.util.Scanner;
import java.math.BigInteger; // -> BigInteger là một lớp trong Java giúp thực hiện các phép toán với số nguyên lớn

public class AddTwoInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String A = scanner.next(); // -> Đọc theo chuỗi ký tự
        String B = scanner.next();

        scanner.close();

        BigInteger a = new BigInteger(A); // -> Chuyển chuỗi ký tự thành số nguyên lớn
        BigInteger b = new BigInteger(B);

        BigInteger sum = a.add(b); // -> Cộng 2 số nguyên lớn

        System.out.println(sum);
    }
}