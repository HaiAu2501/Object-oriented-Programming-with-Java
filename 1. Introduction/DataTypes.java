public class DataTypes {
    /*
     * Các kiểu dữ liệu trong Java chia thành 2 loại:
     * 1. Kiểu dữ liệu nguyên thủy (Primitive Data Types)
     * - Kiểu số nguyên: byte, short, int, long
     * - Kiểu số thực: float, double
     * - Kiểu ký tự: char
     * - Kiểu boolean: boolean
     * 2. Kiểu dữ liệu tham chiếu (Reference Data Types)
     * - Trong ngôn ngữ hướng đối tượng, chúng ta có thể tạo ra các kiểu dữ liệu
     * mới, phức tạp hơn từ các kiểu dữ liệu cơ bản bằng cách sử dụng class.
     * - Mỗi class được coi như một kiểu dữ liệu mới.
     */

    public char grade = 'A'; // Kiểu ký tự
    private String name = "Java"; // Kiểu chuỗi

    public static void main(String[] args) {
        // Khai báo biến kiểu số nguyên
        byte b = 100;
        short s = 1000;
        int i = 100000;

        // Hằng số kiểu long phải kết thúc bằng "L" hoặc "l"
        long l = 1000000000L;

        // Hằng số thực kiểu float phải kết thúc bằng "F" hoặc "f"
        float f = 10.5F;

        // Một giá trị số thực không có hậu tố sẽ mặc định là kiểu double
        double d = 10.5;

        // Chuyển đổi kiểu dữ liệu (casting)
        /*
         * Java là ngôn ngữ định kiểu chặt.
         * JVM có thể tự động chuyển đổi kiểu dữ liệu nhỏ hơn sang kiểu dữ liệu lớn hơn.
         * Để chuyển đổi ngược lại, chúng ta cần sử dụng phép ép kiểu tường minh
         * (explicit casting).
         */
        // Ví dụ:
        int x = 100;
        long y = x; // tự động chuyển đổi kiểu dữ liệu
        int z = (int) y; // ép kiểu tường minh, nếu viết int z = y; sẽ báo lỗi

        // Chuyển đổi kiểu dữ liệu được xảy ra tự động nếu không có mất mát dữ liệu
        // byte -> short -> int -> long -> float -> double
    }
}
