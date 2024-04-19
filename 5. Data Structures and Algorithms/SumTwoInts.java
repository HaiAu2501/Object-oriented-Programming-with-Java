import java.math.BigInteger;
import java.util.Scanner;

// Đề bài: Cộng 2 số nguyên a, b (0 <= a, b <= 10^19).
// Đầu vào: 2 số nguyên a, b.
// Đầu ra: Tổng của 2 số nguyên a, b.

// Nhận xét:
/* - Tổng của 2 số nằm trong khoảng từ 0 đến 2 * 10^19.
 * - Kiểu số nguyên trong Java lớn nhất là Long (64 bit) với giá trị tối đa là 2^63 - 1 < 2 * 10^19.
 * - Do đó, không thể lưu trữ số nguyên lớn trong kiểu dữ liệu Long.
 * -> Sử dụng class BigInteger trong Java để lưu trữ số nguyên lớn.
 * - Class này cung cấp một số phương thức để thực hiện các phép toán số học trên số nguyên lớn.
 *   + add(BigInteger val) -> (this + val): Tổng.
 *   + subtract(BigInteger val) -> (this - val): Hiệu.
 *   + multiply(BigInteger val) -> (this * val): Tích.
 *   + divide(BigInteger val) -> (this / val): Thương (phép chia nguyên).
 *   + mod(BigInteger val) -> (this % val): Phần dư.
 *   + pow(int exponent) -> (this ^ exponent): Lũy thừa.
 *   + abs() -> |this|: Trị tuyệt đối.
 *   ...
 */

// #################################################################
// ################ Sum of Two Integers in Java  ###################
// #################################################################
public class SumTwoInts {
    // Cộng hai số nguyên lớn (BigInteger) trong Java:

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--Using BigInteger class");
        BigInteger num1 = scanner.nextBigInteger();
        BigInteger num2 = scanner.nextBigInteger();

        // Cộng hai số nguyên lớn
        BigInteger sum = num1.add(num2);

        System.out.println("Sum: " + sum);

        System.out.println("--Using SumByString");
        String num1Str = scanner.next();
        String num2Str = scanner.next();

        SumByString sumByString = new SumByString(num1Str, num2Str);
        System.out.println("Sum: " + sumByString.add());

        scanner.close();
    }
}

// Sử dụng phép cộng thông thường số nguyên (nhập vào duới dạng chuỗi kí tự).
/*
 * - Đọc 2 số nguyên a, b vào 2 chuỗi kí tự.
 * - Thực hiện phép cộng từ hàng đơn vị đến hàng cao nhất.
 */
class SumByString {
    private String num1;
    private String num2;

    public SumByString(String num1, String num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public String add() {
        StringBuilder result = new StringBuilder();
        int carry = 0; // Số nhớ
        int i = num1.length() - 1; // Vị trí hàng đơn vị của số thứ nhất, là (length - 1) vì index bắt đầu từ 0
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            // Cộng từ hàng đơn vị đến hàng cao nhất
            if (i >= 0) {
                sum += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += num2.charAt(j--) - '0';
            }

            carry = sum / 10;
            result.append(sum % 10);
        }

        if (carry > 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }
}
