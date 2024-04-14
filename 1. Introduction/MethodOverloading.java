public class MethodOverloading {
    // Nạp chồng phương thức (Method Overloading) trong Java:
    /*
     * - Nạp chồng phương thức (Method Overloading) là cách tạo nhiều phương thức
     * cùng tên trong một lớp nhưng có số lượng tham số hoặc kiểu dữ liệu tham số
     * khác nhau.
     * - Khi gọi một phương thức, Java sẽ xác định phương thức cần gọi dựa trên
     * số lượng tham số hoặc kiểu dữ liệu của tham số.
     * - Nạp chồng phương thức giúp tăng cường tính linh hoạt cho lớp và giúp người
     * lập trình dễ dàng sử dụng phương thức mà không cần nhớ tên phương thức.
     * - Khi nạp chồng phương thức, các phương thức cùng tên phải khác nhau về
     * số lượng tham số hoặc kiểu dữ liệu của tham số.
     * - Các phương thức cùng tên có thể khác nhau về kiểu trả về.
     */

    // Phương thức sum với 2 tham số kiểu int
    static int sum(int a, int b) {
        return a + b;
    }

    // Phương thức sum với 3 tham số kiểu int
    static int sum(int a, int b, int c) {
        return a + b + c;
    }

    // Phương thức sum với 2 tham số kiểu double
    static double sum(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        // Gọi phương thức sum với 2 tham số kiểu int
        System.out.println("Sum of 10 and 20: " + sum(10, 20)); // -> 30

        // Gọi phương thức sum với 3 tham số kiểu int
        System.out.println("Sum of 10, 20 and 30: " + sum(10, 20, 30)); // -> 60

        // Gọi phương thức sum với 2 tham số kiểu double
        System.out.println("Sum of 10.5 and 20.5: " + sum(10.5, 20.5)); // -> 31.0
    }
}
