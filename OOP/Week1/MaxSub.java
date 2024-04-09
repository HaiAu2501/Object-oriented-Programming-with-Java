import java.util.Scanner;

public class MaxSub {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Đọc số lượng phần tử của dãy số
        int n = scanner.nextInt();

        // Khởi tạo các biến cho quy hoạch động
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        // Duyệt qua từng phần tử của dãy số
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            maxEndingHere += num;

            // Nếu tổng dãy con tạm thời lớn hơn tổng lớn nhất hiện tại, cập nhật tổng lớn
            // nhất
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }

            // Nếu tổng dãy con tạm thời âm, bắt đầu lại từ 0
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }

        scanner.close();

        // In ra tổng dãy con lớn nhất
        System.out.println(maxSoFar);
    }
}
