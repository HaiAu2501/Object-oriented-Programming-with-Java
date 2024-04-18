// Tiếp tục về nội lớp.
// 2. Nội lớp (inner class) còn có thể được định nghĩa trong một phương thức.
/*
 * Quyền truy cập:
 * - Nội lớp có thể truy cập tất cả các biến và đối số của phương thức chứa nó.
 * - Nội lớp cũng có thể truy cập các thành viên của lớp chứa phương thức ấy.
 * Phạm vi sử dụng: Nội lớp chỉ có thể được sử dụng trong phương thức chứa nó.
 */

import java.util.ArrayList;
import java.util.List;

// Ví dụ:

// Lớp Car đại diện cho một chiếc xe, bao gồm trạng thái của động cơ và mức nhiên liệu.
// Chứa phương thức startEngine() để khởi động động cơ.
class Car {
    private boolean engineRunning = false;
    private int fuelLevel = 0;

    public Car(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public void startEngine() {
        // Nội lớp EngineStarter kiểm tra mức nhiên liệu trước khi khởi động động cơ.
        class EngineStarter {
            private void checkFuel() {
                if (fuelLevel <= 0) {
                    throw new IllegalStateException("Cannot start engine: No fuel");
                }
            }

            private void initiateStartup() {
                engineRunning = true;
                System.out.println("Engine is now running.");
            }

            public void start() {
                checkFuel();
                initiateStartup();
            }
        }

        /*
         * - EngineStarter có thể truy cập các thành viên nội bộ của Car và ngược lại,
         * nhưng không gian bên ngoài không thể truy cập trực tiếp đến EngineStarter.
         * - EngineStarter làm cho việc khởi động động cơ trở nên riêng biệt với phần
         * còn lại của lớp Car, giúp giảm sự phức tạp của phương thức startEngine() và
         * tập trung vào một nhiệm vụ cụ thể.
         */

        EngineStarter starter = new EngineStarter();
        starter.start();
    }

    public boolean isEngineRunning() {
        return engineRunning;
    }
}

public class WithinMethods {
    public static void main(String[] args) {
        Car myCar = new Car(10); // Khởi tạo xe với 10 đơn vị nhiên liệu
        myCar.startEngine(); // Khởi động động cơ
        System.out.println("Is the engine running? -> " + myCar.isEngineRunning());

        Car anotherCar = new Car(0); // Khởi tạo xe với 0 đơn vị nhiên liệu
        anotherCar.startEngine(); // Khởi động động cơ
        System.out.println("Is the engine running? -> " + anotherCar.isEngineRunning());
        // -> IllegalStateException: Cannot start engine: No fuel

        System.out.println("--------------------------------------------------");

        EventNotifier notifier = new EventNotifier();
        notifier.addUser("Alice");
        notifier.addUser("Bob");

        // Gửi thông điệp
        notifier.notifyUsers("System will be down for maintenance tonight.");
    }
}

// Có một số hạn chế khi sử dụng nội lớp trong phương thức:
/*
 * - Thời gian sống của biến: Khi một phương thức kết thúc, các biến địa phương
 * (local) của nó thường biến mất. Tuy nhiên, bất kỳ đối tượng nào được tạo ra
 * trong phương thức, bao gồm các instance của nội lớp vẫn tồn tại cho đến khi
 * chúng không còn được tham chiếu. Điều này dẫn đến, bất kỳ biến địa phương nào
 * được sử dụng trong nội lớp cũng phải tồn tại sau khi phuơng thức kết thúc.
 * -> Để đảm bảo các biến địa phương có thể được sử dụng an toàn bởi nội lớp sau
 * khi phương thức kết thúc, chúng phải được khai báo là final hoặc effectively
 * final.
 */

// Ví dụ khác:

// Lớp EventNotifier thông báo một thông điệp cụ thể đến một danh sách người
// dùng.
class EventNotifier {
    private List<String> userList = new ArrayList<>();

    // Phương thức thêm người dùng vào danh sách thông báo
    public void addUser(String user) {
        userList.add(user);
    }

    // Phương thức thông báo người dùng với một thông điệp cụ thể
    public void notifyUsers(final String message) {
        // Inner class để gửi thông báo
        class Notifier {
            // Phương thức gửi thông điệp
            public void sendNotification() {
                for (String user : userList) {
                    System.out.println("Notifying " + user + ": " + message);
                }
            }
        }

        // Tạo một instance của inner class và sử dụng nó
        Notifier notifier = new Notifier();
        notifier.sendNotification();
    }
}
