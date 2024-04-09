import java.util.Scanner;

class Binomial {
    // static -> không cần tạo đối tượng mới, gọi trực tiếp từ tên class
    // public -> có thể gọi từ bất cứ đâu
    public static int binom(int k, int n) {
        Integer[][] C = new Integer[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i) {
                    C[i][j] = 1;
                } else {
                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
                }
            }
        }
        return C[n][k];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        int n = scanner.nextInt();

        scanner.close();

        System.out.print(binom(k, n));
        // Ngoài gọi là binom, còn có thể gọi là Binomial.binom, vì binom là static
    }
}