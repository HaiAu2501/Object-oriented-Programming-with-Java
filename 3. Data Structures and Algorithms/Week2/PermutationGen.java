import java.util.Scanner;

public class PermutationGen {
    public static void permutationGen(int n, String s) {
        if (s.length() == n) {
            System.out.println(s);
            return;
        }

        // Nếu chuỗi s chưa chứa số i thì thêm i vào chuỗi
        for (int i = 1; i <= n; i++) {
            if (s.contains(Integer.toString(i))) {
                continue;
            }
            permutationGen(n, s + i); // Gọi đệ quy
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        permutationGen(n, "");
    }
}

/*
 * Giải thích:
 * Ví dụ n = 3
 * s = ""
 * s.length() != n -> permutationGen(3, "1") -> chưa chứa 2, 3
 * -> permutationGen(3, "12"), permutationGen(3, "13")
 * -> permutationGen(3, "123"), permutationGen(3, "132")
 */