@SuppressWarnings("unused")
class Superclass {
    int superVar = 5;
    private int privateVar = 10;

    void display() {
        System.out.println("This is the display method of superclass");
    }

    void print() {
        System.out.println("This is the print method of superclass");
    }
}

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

    // Lớp con có thể định nghĩa thêm thuộc tính và phương thức của riêng mình.
    // Lớp con cũng có thể ghi đè (override) phương thức của lớp cha.

    // Ghi đè phương thức print của lớp cha.
    @Override
    void print() {
        System.out.println("This is the print method of subclass");
    }

    // Sử dụng annotation @Override có tác dụng kiểm tra xem phương thức có thực sự
    // ghi đè phương thức của lớp cha hay không.

    public static void main(String[] args) {
        Subclass subObj = new Subclass();

        // Khi một lớp con kế thừa từ lớp cha, đối tượng của lớp con có thể được gán
        // cho một biến của lớp cha. -> Tính đa hình (Polymorphism)
        Superclass superObj = subObj;

        System.out.println("shadowed superVar: " + subObj.superVar);
        // -> 10 (biến của lớp con che phủ biến của lớp cha)

        System.out.println("superVar through super.superVar: " + subObj.var); // -> 5

        // System.out.println("privateVar: " + obj.privateVar);
        // Lỗi: privateVar has private access in Superclass

        subObj.display(); // -> This is the display method of superclass
        subObj.print(); // -> This is the print method of subclass

        superObj.print(); // -> This is the print method of subclass (gọi phương thức của lớp con)

        // Nếu là lớp cha
        Superclass obj = new Superclass();
        obj.print(); // -> This is the print method of superclass

        Subsubclass subsubObj = new Subsubclass();

        System.out.println("superVar of Subsubclass: " + subsubObj.superVar);
        // -> 10.0
    }

}

// Lớp con có thể được tiếp tục kế thừa bởi một lớp khác.
class Subsubclass extends Subclass {
    // Lớp SubSubclass kế thừa tất cả thuộc tính và phương thức của lớp Subclass.
    // Lớp SubSubclass cũng có thể định nghĩa thêm thuộc tính và phương thức của
    // riêng mình.

    double var = super.superVar;
}

// Phương thức đè (overridden method) trông như là chúng che phủ phương thức của
// lớp cha, như đối với biến.
/*
 * Nhưng một phương thức đè thực sự mạnh hơn thế:
 * - Khi có nhiều triển khai của 1 phương thức trong hệ thống phân cấp của đối
 * tượng, phương thức nào thuộc lớp "có nguồn gốc gần nhất" (hay là thấp nhất
 * trong hệ thống phân cấp) luôn luôn ghi đè tất cả các phương thức trước đó.
 * - Tham chiếu this, super trong phương thức đè sẽ lần lượt là tham chiếu của
 * lớp hiện tại và lớp cha của lớp hiện tại.
 */
