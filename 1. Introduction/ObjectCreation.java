// Các đối tượng trong Java được lưu trữ trong vùng nhớ heap. 
/*
 * - Không như các ngôn ngữ khác, chúng ta không phải quản lý bộ nhớ thủ công.
 * - Java cấp phát bộ nhớ tự động và giải phóng bộ nhớ khi không cần thiết.
 */

public class ObjectCreation {
    // Hàm tạo (Constructor) trong Java:
    /*
     * - Hàm tạo (Constructor) là một phương thức đặc biệt trong Java, được sử dụng
     * để khởi tạo đối tượng của lớp.
     * - Hàm tạo có tên giống với tên lớp và không có kiểu trả về.
     * - Khi một đối tượng được khởi tạo, hàm tạo sẽ được gọi tự động.
     * - Nếu không có hàm tạo nào được định nghĩa trong lớp, Java sẽ tạo một hàm
     * tạo mặc định (default constructor) không có tham số và không thực hiện
     * công việc gì.
     * - Một lớp có thể có nhiều hàm tạo, nhưng phải khác nhau về số lượng tham số
     * hoặc kiểu dữ liệu của tham số.
     * - Hàm tạo có thể gọi hàm tạo khác của cùng lớp bằng từ khóa this.
     */

    int x;

    // Hàm tạo không tham số
    ObjectCreation() {
        x = 5;
    }

    // Hàm tạo có tham số
    ObjectCreation(int y) {
        x = y;
    }

    public static void main(String[] args) {
        // Khởi tạo đối tượng obj1 với hàm tạo không tham số
        ObjectCreation obj1 = new ObjectCreation();
        System.out.println("Value of x in obj1: " + obj1.x); // -> 5

        // Khởi tạo đối tượng obj2 với hàm tạo có tham số
        ObjectCreation obj2 = new ObjectCreation(10);
        System.out.println("Value of x in obj2: " + obj2.x); // -> 10
    }
}
