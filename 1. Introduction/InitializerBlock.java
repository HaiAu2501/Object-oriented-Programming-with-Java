public class InitializerBlock {
    // Có thể khai báo một khối khởi tạo (initializer block) trong một lớp.
    /*
     * - Khối khởi tạo được sử dụng để khởi tạo dữ liệu của đối tượng.
     * - Khối khởi tạo được chạy trước khi hàm tạo của lớp được chạy.
     * - Một lớp có thể có nhiều khối khởi tạo, nhưng chúng sẽ được thực thi theo
     * thứ tự xuất hiện trong lớp.
     * - Khối này không thuộc về bất kỳ phương thức nào và được đặt trong dấu ngoặc
     * nhọn.
     * - Nếu sử dụng từ khóa static trước khối khởi tạo, nó sẽ trở thành khối khởi
     * tạo static, dùng để khởi tạo biến static.
     */

    // Ví dụ về khối khởi tạo
    int x;
    static int y;

    // Khối khởi tạo
    {
        x = 5;
        y = 5;
    }

    // Khối khởi tạo static
    // Khối static được thực thi trước bất kỳ khối non-static nào và bất kỳ hàm tạo
    // nào.
    static {
        y = 10;
    }

    public static void main(String[] args) {
        InitializerBlock obj = new InitializerBlock();
        System.out.println("Value of x: " + obj.x); // -> 5
        System.out.println("Value of y: " + y); // -> 5 (khối static được thực thi trước khối non-static)
    }
}
