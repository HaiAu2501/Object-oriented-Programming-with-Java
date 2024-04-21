// Trong Java, mỗi class tại thời điểm chạy đều được biểu diễn bởi 1 instance của class java.lang.Class.
/*
 * - Class này cung cấp các phương thức để truy cập thông tin về class như tên class, các fields, methods, constructors, ...
 * - Mỗi loại đối tượng bạn sử dụng có một đối tượng Class tương ứng, và đối tượng này có trách nhiệm tạo ra cácinstance của loại đó.
 */

// Ví dụ sau:

@SuppressWarnings("rawtypes")
public class TheClassClass {
    public static void main(String[] args) {
        // Một đối tượng của class String
        String str = "Hello";

        // Lấy ra class của đối tượng str
        Class strClass = str.getClass();

        // Cung có thể tham chiếu trực tiếp tới class thông qua tên class
        Class strClass2 = String.class;

        // In ra tên class của đối tượng str
        System.out.println(strClass.getName()); // In ra: java.lang.String
        System.out.println(strClass2.getName()); // In ra: java.lang.String

        // Phương thức forName() của class Class dùng để tạo một đối tượng Class từ tên
        // class
        try {
            Class strClass3 = Class.forName("java.lang.String");
            System.out.println(strClass3.getName()); // In ra: java.lang.String
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
