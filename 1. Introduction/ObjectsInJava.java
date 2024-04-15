// Lớp (class) là các khối xây dựng của một ứng dụng Java.
/*
 * Một lớp có thể chứa: các phương thức (methods), các biến (variables), mã khởi tạo (initialization code) và các lớp khác.
 * Từ khóa public và private xác định phạm vi truy cập của lớp:
 * - public: lớp có thể được truy cập từ bên ngoài package.
 * - private: lớp chỉ có thể được truy cập từ bên trong lớp đó.
 */

@SuppressWarnings("static-access")
public class ObjectsInJava {
    int var;
    double number;
    static int staticVar = 10;
    final int finalVar = 100;

    int getVar() {
        return var;
    }

    static int print10() {
        return 10;
    }

    // Từ khóa public và private xác định phạm vi truy cập của biến và phương thức:
    // - public: biến hoặc phương thức có thể được truy cập từ bên ngoài package.
    // - private: biến hoặc phương thức chỉ có thể được truy cập từ bên trong lớp
    // đó.
    // - protected: biến hoặc phương thức chỉ có thể được truy cập từ bên trong
    // package hoặc từ lớp con.

    public static void main(String[] args) {
        // Khi định nghĩa một lớp, ta có thể tạo ra đối tượng (object) từ lớp đó.
        // Đối tượng là một thể hiện (instance) của một lớp.
        // Để tạo một đối tượng, ta sử dụng từ khóa new.
        ObjectsInJava obj = new ObjectsInJava();

        // Gán giá trị cho các biến của đối tượng
        obj.var = 10;

        // Gọi phương thức của đối tượng
        System.out.println("getVar method: " + obj.getVar()); // -> 10

        // Lớp DataTypes ở dưới đây là một lớp public, nên có thể được truy cập từ bên
        // ngoài package.
        DataTypes data = new DataTypes();

        // Gọi đến biến grade (public) của đối tượng data
        System.out.println("grade variable: " + data.grade); // -> 'A

        // Gọi đến biến name (private) của đối tượng data
        // System.out.println(data.name); // Lỗi: name has private access in DataTypes

        // Từ khóa static:
        /*
         * - Biến static: biến static được chia sẻ giữa tất cả các đối tượng của lớp,
         * nếu thay đổi giá trị của biến static từ một đối tượng, giá trị của biến
         * static sẽ thay đổi cho tất cả các đối tượng khác.
         * - Phương thức static: phương thức static có thể được gọi mà không cần tạo
         * đối tượng từ lớp đó.
         */

        // Gọi biến staticVar thông qua tên lớp
        System.out.println("staticVar: " + ObjectsInJava.staticVar); // -> 10

        // Trong cùng một lớp, ta có thể gọi biến static trực tiếp mà không cần tiền tố
        // tên lớp
        System.out.println("staticVar: " + staticVar); // -> 10

        // Gọi phương thức static print10 từ lớp ObjectsInJava
        System.out.println("print10 method: " + ObjectsInJava.print10()); // -> 10

        // Thay đổi giá trị của biến staticVar
        ObjectsInJava.staticVar = 20;

        // Gọi biến staticVar thông qua một đối tượng
        ObjectsInJava otherObject = new ObjectsInJava();

        System.out.println("staticVar from otherObject: " + otherObject.staticVar); // -> 20

        // Gọi phương thức static sumOfArray từ lớp Arrays
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println("sumOfArray method: " + Arrays.sumOfArray(arr)); // -> 15

        // Từ khóa final:
        /*
         * - Biến final: biến final là hằng số, giá trị của biến final không thể thay
         * đổi sau khi đã gán giá trị.
         * - Phương thức final: phương thức final không thể bị ghi đè (override) trong
         * lớp con.
         */

        // Gọi biến finalVar thông qua đối tượng obj
        System.out.println("finalVar: " + obj.finalVar); // -> 100
        // obj.finalVar = 200; // Lỗi: cannot assign a value to final variable finalVar
    }
}

/*
 * - Nếu một biến hoặc phương thức không được khai báo là public, private hoặc
 * protected, nó chỉ có thể được truy cập từ cùng một package.
 */
