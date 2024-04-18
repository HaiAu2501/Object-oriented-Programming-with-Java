// Trong Java, mọi lớp đều kế thừa từ lớp Object. 
/* - Lớp Object là lớp cha của tất cả các lớp trong Java. 
 * - Nó chứa các phương thức mà mọi lớp kế thừa từ nó. 
 * - Lớp Object cung cấp một số phương thức mặc định, nhưng chúng có thể được ghi đè bởi các lớp con để cung cấp cài đặt cụ thể.
 * - Dưới đây là một số phương thức static quang trọng của lớp Object:
 *   + Object clone(): Trả về một bản sao của đối tượng hiện tại.
 *   + boolean equals(Object obj): So sánh hai đối tượng.
 *   + void finalize(): Được gọi trước khi một đối tượng bị thu hồi bởi garbage collector.
 *   + Class<?> getClass(): Trả về đối tượng Class của đối tượng hiện tại.
 *   + int hashCode(): Trả về mã băm của đối tượng.
 *   + void notify(): Thức tỉnh một luồng đang chờ đợi trên đối tượng hiện tại.
 *   + void notifyAll(): Thức tỉnh tất cả các luồng đang chờ đợi trên đối tượng hiện tại.
 *   + String toString(): Trả về chuỗi biểu diễn của đối tượng.
 *   + void wait(): Chờ cho đến khi một luồng khác gọi notify() hoặc notifyAll() trên đối tượng hiện tại.
 */

// Ví dụ về phương thức toString():
class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Ghi đè phương thức toString() để trả về thông tin của đối tượng.
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
}

@SuppressWarnings("unused")
class Teacher {
    private String name;
    private int age;

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class TheObjectClass {
    public static void main(String[] args) {
        Student student = new Student("Alice", 20);
        System.out.println(student.toString());

        // Lớp Object cung cấp phương thức toString() mặc định.
        // Khi không ghi đè phương thức này,
        // kết quả sẽ là: <tên gói>.<tên lớp>@<địa chỉ bộ nhớ>
        Object obj = new Object();
        System.out.println(obj.toString());

        Teacher teacher = new Teacher("Bob", 30);
        System.out.println(teacher.toString());
    }
}
