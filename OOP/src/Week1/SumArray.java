import java.io.*;

public class SumArray {
    public static void main(String[] args) throws IOException { // -> throws IOException để bắt lỗi
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