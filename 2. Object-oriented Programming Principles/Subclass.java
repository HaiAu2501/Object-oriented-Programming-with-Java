@SuppressWarnings("unused")
class Superclass {
    int superVar = 5;
    private int privateVar = 10;

    void display() {
        System.out.println("This is the display method of superclass");
    }
}

@SuppressWarnings("unused")
public class Subclass extends Superclass {
    // Lớp trong Java tồn tại trong một hệ thống phân cấp.
    /*
     * - Một lớp có thể kế thừa từ một lớp khác, được gọi là lớp cha (superclass).
     * - Lớp con (subclass) kế thừa tất cả các thuộc tính và phương thức (mà không
     * phải private) của lớp cha và có thể sử dụng chúng như thể chúng được khai báo
     * ngay trong chính lớp đó.
     * - Sử dụng từ khóa extends để kế thừa từ một lớp cha.
     */

    // Một class chỉ có thể kế thừa từ một class khác.

    // Shadowed variable (biến bị che phủ) là một biến cục bộ hoặc biến của lớp
    // con có cùng tên với một biến của lớp cha.
    // Biến của lớp con sẽ che phủ biến của lớp cha.

    double superVar = 10;

    // Gọi đến biến superVar của lớp cha -> dùng tham chiếu super
    int var = super.superVar;

    public static void main(String[] args) {
        Subclass subObj = new Subclass();

        // Khi một lớp con kế thừa từ lớp cha, đối tượng của lớp con có thể được gán
        // cho một biến của lớp cha. -> Tính đa hình (Polymorphism)
        Superclass superObj = subObj;

        System.out.println("superVar: " + subObj.superVar);
        // -> 10 (biến của lớp con che phủ biến của lớp cha)

        System.out.println("superVar: " + subObj.var); // -> 5

        // System.out.println("privateVar: " + obj.privateVar);
        // Lỗi: privateVar has private access in Superclass
        subObj.display(); // -> This is the display method of superclass

    }

}

// Lớp con có thể được tiếp tục kế thừa bởi một lớp khác.
class Subsubclass extends Subclass {
    // Lớp SubSubclass kế thừa tất cả thuộc tính và phương thức của lớp Subclass.
    // Lớp SubSubclass cũng có thể định nghĩa thêm thuộc tính và phương thức của
    // riêng mình.
}
