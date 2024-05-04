public class ArgumentPassing {
    int x;

    // Trong Java:
    /*
     * - Khi truyền một biến kiểu nguyên thủy (primitive) vào một phương thức, giá
     * trị của biến sẽ được sao chép vào tham số của phương thức -> truyền tham trị
     * (pass by value).
     * - Khi truyền một đối tượng vào một phương thức, thì tham chiếu của đối tượng
     * đó được truyền vào phương thức, tức là truyền địa chỉ của đối tượng (pass by
     * reference).
     */

    // Truyền tham trị (pass by value)
    static void changeValue(int x) {
        x = 10;
    }

    // Truyền tham chiếu (pass by reference)
    static void changeValue(ArgumentPassing obj) {
        obj.x = 10;
    }

    void changeValue() {
        this.x = 20;
    }

    public static void main(String[] args) {
        ArgumentPassing obj = new ArgumentPassing();
        obj.x = 5;

        // Truyền biến x vào phương thức changeValue (truyền tham trị)
        changeValue(obj.x);
        System.out.println(obj.x); // -> 5
        // Biến x (thuộc tính x của đối tượng obj) không thay đổi giá trị sau khi truyền
        // bởi vì giá trị của biến x được sao chép vào tham số x của phương thức
        // changeValue.

        // Truyền đối tượng obj vào phương thức changeValue (truyền tham chiếu)
        changeValue(obj);
        System.out.println(obj.x); // -> 10
        // Đối tượng obj bị thay đổi giá trị thuộc tính x sau khi truyền vào phương thức
        // changeValue.

        obj.changeValue();
        System.out.println(obj.x); // -> 20
    }
}
