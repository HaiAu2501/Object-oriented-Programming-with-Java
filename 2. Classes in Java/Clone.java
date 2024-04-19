// Phương thức clone() được sử dụng để tạo một bản sao của đối tượng hiện tại.
/*
 * - Bản sao đó có cùng giá trị với đối tượng gốc, nhưng nó không phải là cùng một đối tượng (không cùng một vùng nhớ).
 * - Để sử dụng phương thức clone(), lớp của đối tượng cần phải triển khai giao diện Cloneable.
 * - Phương thức clone() là protected, nghĩa là nó chỉ có thể được gọi từ bên trong lớp, lớp con hoặc các lớp cùng gói.
 * -> Do đó nếu muốn sử dụng phương thức clone() từ bên ngoài, bạn cần phải ghi đè phương thức clone() và đặt nó là public.
 * - Phương thức clone() trả về một đối tượng, do đó cần phải ép kiểu đối tượng trả về về kiểu của đối tượng gốc.
 */

import java.util.ArrayList;
import java.util.List;

class Robot implements Cloneable {
    String model;
    int weight;
    List<String> skills;

    public Robot(String model, int weight, List<String> skills) {
        this.model = model;
        this.weight = weight;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Robot [model=" + model + ", weight=" + weight + ", skills=" + skills + "]";
    }

    @Override
    public Robot clone() {
        try {
            Robot robot = (Robot) super.clone();
            return robot;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

public class Clone {
    public static void main(String[] args) {
        System.out.println("--Shallow copy:");
        Robot robot1 = new Robot("R2D2", 100, List.of("walk", "talk"));
        Robot robot2 = robot1.clone();

        System.out.println(robot1.toString()); // Robot [model=R2D2, weight=100, skills=[walk, talk]]
        System.out.println(robot2.toString()); // Robot [model=R2D2, weight=100, skills=[walk, talk]]

        System.out.println(robot1 == robot2); // false

        // -> Như vậy, robot2 là một bản sao của robot1, chúng có cùng giá trị nhưng
        // không cùng một vùng nhớ.
        // Tuy nhiên, đây là bản sao nông (shallow copy), nghĩa là các tham chiếu bên
        // trong đối tượng vẫn trỏ đến cùng một vùng nhớ.
        // Khi sử dụng phương thức clone() để tạo bản sao, Java mặc định tạo một bản
        // sao nông. Do đó, nếu muốn tạo bản sao sâu (deep copy), bạn cần phải tự viết
        // mã để sao chép các trường tham chiếu bên trong đối tượng.

        System.out.println(robot1.skills == robot2.skills); // true

        System.out.println("\n--Deep copy:");
        // Ví dụ về bản sao sâu (deep copy):
        Automaton automaton1 = new Automaton("T-800", 200, List.of("walk", "talk"));
        Automaton automaton2 = automaton1.clone();

        System.out.println(automaton1.toString()); // Automaton [model=T-800, weight=200, skills=[walk, talk]]

        // Thay đổi skills của automaton2.
        automaton2.skills.add("shoot");

        System.out.println(automaton2.toString()); // Automaton [model=T-800, weight=200, skills=[walk, talk, shoot]]
    }
}

// Sử dụng bản sao sâu (deep copy) để sao chép các trường tham chiếu bên trong
// đối tượng.
class Automaton implements Cloneable {
    String model;
    int weight;
    List<String> skills;

    public Automaton(String model, int weight, List<String> skills) {
        this.model = model;
        this.weight = weight;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Automaton [model=" + model + ", weight=" + weight + ", skills=" + skills + "]";
    }

    @Override
    public Automaton clone() {
        try {
            Automaton automaton = (Automaton) super.clone();
            // Tạo một bản sao sâu (deep copy) của skills.
            automaton.skills = new ArrayList<>(skills);
            return automaton;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
