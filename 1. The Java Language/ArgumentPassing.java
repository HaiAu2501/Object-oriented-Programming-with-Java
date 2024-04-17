public class ArgumentPassing {
    // Trong Java:
    /*
     * - Khi truyền một biến kiểu nguyên thủy (primitive) vào một phương thức, giá
     * trị của biến sẽ được sao chép vào tham số của phương thức -> truyền tham trị
     * (pass by value).
     * - Khi truyền một đối tượng vào một phương thức, thì tham chiếu của đối tượng
     * đó được truyền vào phương thức, tức là truyền địa chỉ của đối tượng. Nhưng
     * địa chỉ này vẫn được truyền theo kiểu tham trị.
     */

    // Phương thức thay đổi giá trị của biến x
    static void changeValue(int x) {
        x = 10;
    }

    // Phương thức thay đổi giá trị của đối tượng
    static void changeValue(ArgumentPassing obj) {
        obj.x = 10;
    }

    int x;

    public static void main(String[] args) {
        ArgumentPassing obj = new ArgumentPassing();
        obj.x = 5;

        // Truyền biến x vào phương thức changeValue
        changeValue(obj.x);
        System.out.println(obj.x); // -> 5

        // Truyền đối tượng obj vào phương thức changeValue
        changeValue(obj);
        System.out.println(obj.x); // -> 10
    }
}
