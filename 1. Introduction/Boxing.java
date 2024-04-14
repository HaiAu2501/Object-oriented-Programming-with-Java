import java.lang.Double;

public class Boxing {
    // Tự đóng gói (autoboxing) và mở gói (unboxing) trong Java:
    /*
     * - Tự đóng gói (autoboxing): là quá trình chuyển đổi một kiểu dữ liệu nguyên
     * thủy (primitive) sang một đối tượng của lớp Wrapper tương ứng.
     * - Mở gói (unboxing): là quá trình chuyển đổi một đối tượng của lớp Wrapper
     * sang một kiểu dữ liệu nguyên thủy tương ứng.
     */

    public static Double multiply(Double a, Double b) {
        return a.doubleValue() * b.doubleValue();
    }

    public static void main(String[] args) {
        // Tự đóng gói (autoboxing)
        // Cú pháp khởi tạo một đối tượng Wrapper:
        // <Wrapper> obj = <primitive_value>
        Integer i = 10;

        // Mở gói (unboxing)
        // Chuyển đối tượng Integer sang kiểu dữ liệu nguyên thủy int
        int value = i;

        System.out.println("Value: " + value); // -> 10

        double d = multiply(5.0, 5.0);
        System.out.println("5.0 x 5.0 = " + d); // -> 25.0
        // Trường hợp sử dụng hàm multiply này xảy ra 3 trường hợp boxing:
        /*
         * - Đầu tiên: hai giá trị nguyên thủy kiểu double 5.0 được đóng gói thành hai
         * đối tượng Double.
         * - Tiếp theo: kết quả của phép nhân 5.0 * 5.0 là 25.0 là một giá trị nguyên
         * thủy kiểu double, nó được đóng gói thành một đối tượng Double.
         * - Cuối cùng: giá trị trả này được mở gói thành một giá trị nguyên thủy kiểu
         * double để gán cho d.
         */

    }
}
