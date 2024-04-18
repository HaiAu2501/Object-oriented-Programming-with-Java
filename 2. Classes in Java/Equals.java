// Trong Java, equals() là một phương thức của lớp Object được sử dụng để so sánh hai đối tượng.
/*
 * - Nó xem xét hai đối tượng là bằng nhau nếu chúng cùng tham chiếu đến cùng một vùng nhớ trong bộ nhớ.
 * - Phương thức equals() được ghi đè bởi các lớp con để so sánh dữ liệu của đối tượng.
 * - Nếu không ghi đè phương thức này, nó sẽ so sánh hai đối tượng bằng cách so sánh địa chỉ bộ nhớ của chúng. 
 * -> Kết quả sẽ giống như sử dụng toán tử ==.
 */

// Ví dụ về equals() mặc định:
@SuppressWarnings("unused")
class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// Nếu ghi đè phương thức equals() để so sánh dữ liệu của đối tượng:
class Teacher {
    private String name;
    private int age;

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Ghi đè phương thức equals() để so sánh dữ liệu của đối tượng.
    @Override
    public boolean equals(Object obj) {
        // Nếu hai đối tượng cùng tham chiếu đến cùng một vùng nhớ.
        if (this == obj) {
            return true;
        }

        // Nếu obj là null hoặc không phải là một instance của lớp Teacher.
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // Ép kiểu obj về lớp Teacher.
        Teacher teacher = (Teacher) obj;
        return age == teacher.age && name.equals(teacher.name);
    }
}

@SuppressWarnings("unlikely-arg-type")
public class Equals {
    public static void main(String[] args) {
        Student student1 = new Student("Alice", 20);
        Student student2 = new Student("Alice", 20);

        // So sánh hai đối tượng sử dụng equals() mặc định.
        // Kết quả sẽ là false vì không ghi đè phương thức equals().
        System.out.println(student1.equals(student2));

        // So sánh hai đối tượng sử dụng equals() đã được ghi đè.
        // Kết quả sẽ là true vì dữ liệu của hai đối tượng giống nhau.
        Teacher teacher1 = new Teacher("Bob", 30);
        Teacher teacher2 = new Teacher("Bob", 30);
        System.out.println(teacher1.equals(teacher2));

        // Nếu so sánh giữa hai đối tượng khác nhau.
        System.out.println(teacher1.equals(student1));
        // -> false vì student1 không phải là một instance của lớp Teacher.
    }
}
