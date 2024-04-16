abstract class Shape {
    abstract double area(); // -> Diện tích của hình.
    // Phương thức trừu tượng, không có phần thân. Mọi lớp con phải định nghĩa
    // phương thức này.

    abstract double perimeter(); // Phương thức trừu tượng.

    // Phương thức không trừu tượng.
    void display() {
        System.out.println("This is a shape.");
    }
}

// Phương thức trừu tượng (abstract method) là một phương thức mà không có phần
// thân (body).
/*
 * - Một phương thức trừu tượng không thể được gọi trực tiếp.
 * - Để khai báo một phương thức trừu tượng, bạn cần sử dụng từ khóa abstract
 * trước kiểu trả về.
 * - Mọi lớp con không trừu tượng của lớp chứa phải định nghĩa tất cả các phương
 * thức trừu tượng của lớp cha (bằng cách ghép đè chúng).
 * - Phương thức trừu tượng được sử dụng để xác định một giao diện mà tất cả các
 * lớp con của lớp trừu tượng phải tuân theo. Nó buộc các lớp con phải cung cấp
 * triển khai cụ thể cho các phương thức trừu tượng đó.
 */

// Lớp trừu tượng (abstract class) là một lớp mà không thể tạo đối tượng từ nó.
/*
 * - Một lớp được khai báo là trừu tượng có thể chứa một hoặc nhiều phương thức
 * trừu tượng. Lớp này cũng có thể chứa phương thức không trừu tượng (có thân
 * phương thức).
 * - Lớp trừu tượng có thể chứa các biến và phương thức thông thường, cung cấp
 * chức năng sẵn có cho các lớp con.
 * - Để khai báo một lớp trừu tượng, bạn cần sử dụng từ khóa abstract trước từ
 * khóa class.
 * - Lớp trừu tượng đóng vai trò như một khung sườn, xác định những tính năng cơ
 * bản mà lớp con có thể mở rộng hoặc tùy biến. Lớp này thường chứa một sự kết
 * hợp của phương thức trừu tượng (cần phải được triển khai bởi lớp con) và
 * phương thức không trừu tượng (đã được triển khai sẵn, có thể sử dụng ngay).
 */

class Circle extends Shape {
    double radius;

    // Hàm tạo của lớp Circle.
    Circle(double radius) {
        this.radius = radius;
    }

    // Định nghĩa phương thức area() của lớp cha.
    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    double width, length;

    Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    double area() {
        return width * length;
    }

    @Override
    double perimeter() {
        return 2 * (width + length);
    }
}

@SuppressWarnings("unused")
public class Abstract {
    public static void main(String[] args) {
        // Shape shape = new Shape() // -> Báo lỗi vì Shape là lớp trừu tượng.

        Shape point = new Shape() {
            @Override
            double area() {
                return 0;
            }

            @Override
            double perimeter() {
                return 0;
            }
        };
        // -> Không lỗi vì tạo đối tượng từ lớp trừu tượng Shape thông qua lớp con ẩn
        // danh.

        Circle circle = new Circle(5);

        System.out.println("Circle area: " + circle.area());
        System.out.println("Circle perimeter: " + circle.perimeter());
        circle.display(); // Sử dụng phương thức không trừu tượng display() của lớp cha.
    }
}
