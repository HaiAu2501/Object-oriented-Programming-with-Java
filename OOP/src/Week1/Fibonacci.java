import java.util.Scanner;

public class Fibonacci {
    private int fib(int n) {
        // Tạo mảng lưu trữ các giá trị của dãy Fibonacci
        int[] fibCache = new int[1000000];

        fibCache[0] = 0;
        fibCache[1] = 1;

        // Quy hoạch động
        for (int i = 2; i <= n; i++) {
            fibCache[i] = fibCache[i - 1] + fibCache[i - 2];
        }

        return fibCache[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // -> Gọi đối tượng của lớp Scanner
        System.out.println("Enter n:"); // -> In ra màn hình
        int n = scanner.nextInt(); // -> Gán giá trị nhập vào cho biến n
        scanner.close(); // -> Đóng đối tượng của lớp Scanner
        Fibonacci fibonacci = new Fibonacci(); // -> Gọi đối tượng của lớp Fibonacci
        System.out.println("Answer:" + fibonacci.fib(n));
    }
}