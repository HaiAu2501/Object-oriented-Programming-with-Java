class Animal {
    void eat() {
        System.out.println("eating...");
    }
}

// Lớp Dog kế thừa từ lớp Animal.
class Dog extends Animal {
    void bark() {
        System.out.println("barking...");
    }
}

public class Casting {
    // Ép kiểu (Casting) trong Java là quá trình chuyển đổi giữa các kiểu dữ liệu.
    // Có hai loại ép kiểu: ép kiểu ngầm định (implicit casting) và ép kiểu tường
    // minh (explicit casting).
    /*
     * - Ép kiểu ngầm định (implicit casting): Java tự động chuyển đổi giữa các kiểu
     * dữ liệu.
     * - Ép kiểu tường minh (explicit casting): Chuyển đổi giữa các kiểu dữ liệu một
     * cách thủ công.
     * Để thực hiện ép kiểu tường minh, bạn cần sử dụng cú pháp: (type) expression.
     * Trong đó, type là kiểu dữ liệu mà bạn muốn chuyển đổi và expression là giá
     * trị cần chuyển đổi.
     */

    // Trong kế thừa đối tượng, một đối tượng của lớp con có thể được gán cho một
    // đối tượng của lớp cha.
    // Điều này được gọi là ép kiểu ngầm định.
    // Tuy nhiên, một đối tượng của lớp cha không thể được gán cho một đối tượng của
    // lớp con mà không có ép kiểu tường minh.

    // Ví dụ:
    public static void main(String[] args) {
        Animal anAnimal = new Animal();
        Dog aDog = new Dog();

        anAnimal = aDog; // Ép kiểu ngầm định
        // aDog = anAnimal;
        // Lỗi: incompatible types: Animal cannot be converted to Dog
        aDog = (Dog) anAnimal; // Ép kiểu tường minh

        // lệnh instanceof kiểm tra xem một đối tượng có phải là một thể hiện của một
        // lớp cụ thể hay không.

        // Ví dụ:
        if (anAnimal instanceof Dog) {
            aDog = (Dog) anAnimal;
            aDog.bark();
        } // -> Nếu anAnimal là một thể hiện của lớp Dog, thì gọi phương thức bark()

    }
}
