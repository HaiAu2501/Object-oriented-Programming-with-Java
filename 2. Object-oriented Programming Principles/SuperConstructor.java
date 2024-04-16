class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Student extends Person {
    int studentID;

    Student(String name, int age, int studentID) {
        super(name, age);
        // Gọi constructor của lớp cha (Person) để khởi tạo name và age.
        // Phương thức khởi tạo này phải được gọi đầu tiên trong constructor của lớp
        // con.
        this.studentID = studentID;
    }
}

class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
        // super(name, age); // -> báo lỗi nếu không đặt dòng này ở đầu constructor
    }

    Teacher(String name, int age) {
        this(name, age, "Professional"); // -> gọi constructor khác trong cùng lớp
    }
}

public class SuperConstructor {
    public static void main(String[] args) {
        Student student = new Student("John", 21, 1001);
        Teacher teacher = new Teacher("Alice", 30, "Math");

        System.out.println("Student: " + student.name + " - " + student.age + " - " + student.studentID);
        System.out.println("Teacher: " + teacher.name + " - " + teacher.age + " - " + teacher.subject);
    }
}

// Quy tắc đầy đủ: phương thức tạo (constructor) và khởi tạo (initialization).
/*
 * - Nếu constructor không bắt đầu bằng một lời gọi đến constructor khác của lớp
 * hiện tại (qua this()) hoặc lớp cha (qua super()), Java sẽ tự động chèn một
 * lời gọi ngầm định đến constructor mặc định (không có tham số) của lớp cha
 * (super()).
 * - Nếu constructor bắt đầu bằng một lời gọi đến constructor của lớp cha qua
 * super(), điều này cho phép truyền các tham số cụ thể và chọn constructor phù
 * hợp của lớp cha để gọi.
 * - Nếu constructor bắt đầu bằng một lời gọi đến constructor khác trong cùng
 * lớp qua this(), điều này cho phép tái sử dụng mã trong các constructor khác
 * nhau.
 */