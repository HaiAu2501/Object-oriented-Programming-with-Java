// Trong Java, equals() là một phương thức của lớp Object được sử dụng để so sánh hai đối tượng.
/*
 * - Nó xem xét hai đối tượng là bằng nhau nếu chúng cùng tham chiếu đến cùng một vùng nhớ trong bộ nhớ.
 * - Phương thức equals() được ghi đè bởi các lớp con để so sánh dữ liệu của đối tượng.
 * - Nếu không ghi đè phương thức này, nó sẽ so sánh hai đối tượng bằng cách so sánh địa chỉ bộ nhớ của chúng. 
 * -> Kết quả sẽ giống như sử dụng toán tử ==.
 */

// Ví dụ về equals() mặc định:
@SuppressWarnings("unused")
class Footballer {
    private String name;
    private int age;

    public Footballer(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// Nếu ghi đè phương thức equals() để so sánh dữ liệu của đối tượng:
class Coach {
    private String name;
    private int age;

    public Coach(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        // Kiểm tra xem obj có phải là một instance của lớp Coach hay không.
        if (obj instanceof Coach) {
            // Ép kiểu obj về lớp Coach.
            Coach coach = (Coach) obj;
            // So sánh dữ liệu của hai đối tượng.
            return (name.equals(coach.name) && age == coach.age);
        }
        return false;
    }
}

@SuppressWarnings("unlikely-arg-type")
public class Equals {
    public static void main(String[] args) {
        Footballer footballer1 = new Footballer("Messi", 34);
        Footballer footballer2 = new Footballer("Messi", 34);

        // So sánh hai đối tượng sử dụng equals() mặc định.
        // Kết quả sẽ là false vì không ghi đè phương thức equals().
        System.out.println(footballer1.equals(footballer2)); // false

        // So sánh hai đối tượng sử dụng equals() đã được ghi đè.
        // Kết quả sẽ là true vì dữ liệu của hai đối tượng giống nhau.
        Coach coach1 = new Coach("Klopp", 54);
        Coach coach2 = new Coach("Klopp", 54);
        System.out.println(coach1.equals(coach2)); // true

        // Nếu so sánh giữa hai đối tượng khác nhau.
        System.out.println(coach1.equals(footballer1)); // false
        // -> false vì student1 không phải là một instance của lớp Teacher.

        // So sánh hai đối tượng sử dụng toán tử ==.
        // Kết quả sẽ là false vì toán tử == so sánh địa chỉ bộ nhớ của hai đối tượng.
        System.out.println(footballer1 == footballer2); // false
    }
}
