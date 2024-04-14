import java.lang.Float;

public class Wrappers {
    // Trình bao bọc (Wrapper) trong Java là các lớp được sử dụng để bao bọc các
    // kiểu dữ liệu nguyên thủy (primitive data types).
    /*
     * - Lớp Wrapper cung cấp một cách để sử dụng các kiểu dữ liệu nguyên thủy như
     * một đối tượng.
     * - Các lớp Wrapper trong Java:
     * + Void -> java.lang.Void
     * + Boolean -> java.lang.Boolean
     * + Char -> java.lang.Character
     * + Byte -> java.lang.Byte
     * + Short -> java.lang.Short
     * + Integer -> java.lang.Integer
     * + Long -> java.lang.Long
     * + Float -> java.lang.Float
     * + Double -> java.lang.Double
     * - Các lớp Wrapper cung cấp các phương thức để chuyển đổi giữa kiểu dữ liệu
     * nguyên thủy và kiểu dữ liệu Wrapper.
     * - Các lớp Wrapper cung cấp các phương thức để thực hiện các phép toán số học,
     * so sánh, chuyển đổi, ...
     */

    public static void main(String[] args) {
        // Cú pháp khởi tạo một đối tượng Wrapper:
        // <primitive_type> x = <Wrapper>.valueOf(<primitive_value>)

        // Khởi tạo một đối tượng Float
        Float f = Float.valueOf(10.5f);

        // Chuyển đổi giá trị của đối tượng Float sang kiểu dữ liệu nguyên thủy float
        float value = f.floatValue();
        System.out.println("Value: " + value); // -> 10.5

        // Chuyển đổi giá trị của đối tượng Float sang kiểu dữ liệu nguyên thủy int
        int intValue = f.intValue();
        System.out.println("Int value: " + intValue); // -> 10

        // Chuyển đổi giá trị của đối tượng Float sang kiểu dữ liệu nguyên thủy double
        double doubleValue = f.doubleValue();
        System.out.println("Double value: " + doubleValue); // -> 10.5

        // So sánh hai đối tượng Float
        Float f1 = Float.valueOf(10.5f);
        Float f2 = Float.valueOf(10.5f);
        System.out.println("f1 == f2: " + (f1 == f2)); // -> false

        // So sánh giá trị của hai đối tượng Float
        System.out.println("f1.equals(f2): " + f1.equals(f2)); // -> true

    }
}
