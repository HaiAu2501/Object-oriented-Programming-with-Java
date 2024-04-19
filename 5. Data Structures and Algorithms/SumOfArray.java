// Đề bài: Tính tổng của mảng số nguyên
// Đầu vào: n, mảng số nguyên arr[] chứa n phần tử.
// Đầu ra: Tổng của mảng arr[].

/* Nhận xét:
 * - Nếu sử dụng scanner để đọc dữ liệu input sẽ rất chậm và bị TLE.
 * -> Sử dụng BufferedReader để đọc dữ liệu input.
 * - BufferedReader là một class trong Java để đọc dữ liệu từ input stream (như file, console, socket).
 * - Đọc dữ liệu từ input stream nhanh hơn so với Scanner.
 * - Đọc dữ liệu từ input stream theo dòng (line) bằng phương thức readLine().
 * - Để đọc dữ liệu từ input stream, cần tạo một đối tượng InputStreamReader để đọc dữ liệu từ input stream.
 * - Để tạo một đối tượng BufferedReader, cần truyền một đối tượng InputStreamReader vào constructor của BufferedReader.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfArray {
    // throws IOException có tác dụng bắt lỗi nếu có ngoại lệ xảy ra
    public static void main(String[] args) throws IOException {
        // Sử dụng BufferedReader để đọc dữ liệu từ bàn phím nhanh hơn
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Sử dụng phương thức parseInt để chuyển chuỗi thành số nguyên
        int n = Integer.parseInt(reader.readLine());

        long sum = 0;
        // Sử dụng phương thức split để tách chuỗi thành mảng
        String[] arr = reader.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            sum += Long.parseLong(arr[i]);
        }

        System.out.println(sum);
    }
}
