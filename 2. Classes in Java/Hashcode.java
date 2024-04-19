// Phương thức hashCode() trả về mã băm của đối tượng. 
/*
 * - Mã băm là một số nguyên duy nhất được tạo ra để đại diện cho một đối tượng.
 * - Mã băm được sử dụng trong các cấu trúc dữ liệu như bảng băm.
 * - Nếu hai đối tượng bằng nhau theo phương thức equals(Object), thì chúng phải có cùng một giá trị hash code.
 * - Nếu hai đối tượng có hash code khác nhau, chúng không được coi là bằng nhau.
 * - Nếu hai đối tượng có cùng hash code, chúng có thể bằng nhau hoặc không bằng nhau.
 */

// Ví dụ về phương thức hashCode():
class Laptop {
    private String brand;
    private String model;
    private int price;

    public Laptop(String brand, String model, int price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    @Override
    public int hashCode() {
        return brand.hashCode() + model.hashCode() + price;
    }
}

public class Hashcode {
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop("Dell", "Inspiron", 700);
        Laptop laptop2 = new Laptop("Dell", "Inspiron", 700);

        // So sánh hai đối tượng sử dụng hashCode().
        // Kết quả sẽ là true vì hai đối tượng giống nhau.
        System.out.println(laptop1.hashCode() == laptop2.hashCode()); // true
    }
}
