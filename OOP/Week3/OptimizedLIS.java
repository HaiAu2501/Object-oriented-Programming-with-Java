import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class OptimizedLIS {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine()); // Đọc số lượng phần tử của dãy
        int[] arr = new int[n]; // Mảng chứa dãy số

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        // Gọi hàm để tìm và in ra độ dài của LIS
        System.out.println(lengthOfLIS(arr));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0; // Độ dài của LIS

        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0)
                i = -(i + 1); // Nếu không tìm thấy, tìm kiếm nhị phân sẽ trả về -(vị trí chèn) - 1
            dp[i] = num;
            if (i == len)
                len++; // Nếu chèn vào cuối, tăng độ dài của LIS
        }

        return len;
    }
}
