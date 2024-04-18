// Tiếp tục về lớp chồng nhau (nested class, inner class).
// 3. Static Inner Classes
/*
 * - Một inner class có thể được định nghĩa là static.
 * - Một static inner class không yêu cầu một instance của lớp bên ngoài để tồn tại. Nó có thể tồn tại độc lập với lớp chứa nó.
 * - Static inner class có thể được sử dụng giống như một lớp độc lập ở cấp cao nhất (top-level class). 
 * -> Bạn có thể tạo một instance của static inner class mà không cần một thể hiện của lớp bên ngoài.
 * - static inner class giúp cấu trúc mã nguồn gọn gàng hơn bằng cách nhóm các lớp liên quan mật thiết vào với nhau, 
 * thay vì phải tạo nhiều lớp độc lập, từ đó làm tăng số lượng lớp trong gói.
 */

import java.util.ArrayList;
import java.util.List;

// Xét ví dụ sau:
/*
 * - Class Department chứa một static inner class Employee.
 * - Department quản lý thông tin về một phòng ban trong công ty, bao gồm tên phòng ban và danh sách nhân viên.
 * - Employee chứa thông tin về một nhân viên, bao gồm tên, mã số và chức vụ.
 */

class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String empName, String empId, String position) {
        Employee newEmployee = new Employee(empName, empId, position);
        employees.add(newEmployee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    // Static inner class
    public static class Employee {
        private String name;
        private String id;
        private String position;

        public Employee(String name, String id, String position) {
            this.name = name;
            this.id = id;
            this.position = position;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public String getPosition() {
            return position;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", id='" + id + '\'' +
                    ", position='" + position + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}

public class StaticInnerClass {
    public static void main(String[] args) {
        Department itDepartment = new Department("IT");
        itDepartment.addEmployee("John", "0001", "Developer");
        itDepartment.addEmployee("Jane", "0002", "Designer");

        System.out.println(itDepartment);

        // Khởi tạo Employee không thông qua Department
        Department.Employee manager = new Department.Employee("Alice", "0010", "Manager");
        System.out.println("Manager: " + manager);
    }
}
