import java.util.Scanner;

public class BinaryGen {
    // Hàm đệ quy để sinh ra các chuỗi nhị phân
    public static void generate(int n, String s) {
        // Khi độ dài = n -> in ra và quay lui
        if (s.length() == n) {
            System.out.println(s);
            return;
        }

        // Gọi đệ quy để thêm 0 và 1 vào chuỗi
        generate(n, s + "0");
        generate(n, s + "1");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        generate(n, "");
    }
}

/*
 * Ví dụ n = 4
 * s = ""
 * s.length() != n -> generate(4, "0")
 * -> generate(4, "00"), generate(4, "01")
 * -> generate(4, "000"), generate(4, "001"), generate(4, "010"), generate(4,
 * "011")
 * -> generate(4, "0000"), generate(4, "0001"), generate(4, "0010"), generate(4,
 * "0011"), generate(4, "0100"), generate(4, "0101"), generate(4, "0110"),
 * generate(4, "0111")
 */
