// Giao diện (interface) trong Java là một nhóm các phương thức trừu tượng mà
// không chứa triển khai (implementation) cụ thể nào cả. Interface chỉ định rõ
// các phương thức mà một lớp phải triển khai nếu lớp đó tuyên bố thực thi
// (implements) interface đó.

/* 
 * - Khác với lớp trừu tượng, một lớp khi thực thi một interface không cần phải kế
 * thừa từ một phần cụ thể nào của hệ thống kế thừa. Điều này giúp tăng tính
 * linh hoạt và khả năng sử dụng lại mã lệnh, do interface không yêu cầu một cấu
 * trúc kế thừa cụ thể nào.
 * - Để khai báo một interface, sử dụng từ khóa interface, sau đó là tên của interface
 * và một tập hợp các phương thức trừu tượng. Một lớp có thể thực thi nhiều interface
 * bằng cách sử dụng từ khóa implements.
 * - Một lớp thực thi một interface phải cung cấp triển khai cho tất cả các phương thức
 * trừu tượng trong interface đó.
 * - Interface không thể chứa các biến instance, nhưng có thể chứa các biến static
 * và final.
 */

// 

interface Movable {
    // Hàm move() để di chuyển đối tượng theo vector (x, y, z).
    // Không cần khai báo từ khóa abstract vì tất cả các phương thức trong interface
    // đều mặc định là trừu tượng và public.
    void move(double x, double y, double z);

    // Một interface có thể chứa các biến static và final.
    static final double MAX_DISTANCE = 100;
}

interface Trackable {
    // Hàm getTrackerID() trả về ID của tracker.
    String getTrackerID();

    // Hàm getCurrentPosition() trả về mảng chứa tọa độ hiện tại (x, y, z).
    double[] getCurrentPosition();

    // Hàm isClose() kiểm tra xem đối tượng có ở gần không.
    boolean isClose(double x, double y, double z);
}

// Lớp Drone thực thi cả hai interface Movable và Trackable.
class Drone implements Movable, Trackable {
    private String trackerID;
    private double x, y, z;

    public Drone(String trackerID) {
        this.trackerID = trackerID;
        x = 0.0;
        y = 0.0;
        z = 0.0;
    }

    @Override
    public void move(double x, double y, double z) {
        this.x += x;
        this.y += y;
        this.z += z;
    }

    @Override
    public String getTrackerID() {
        return trackerID;
    }

    @Override
    public double[] getCurrentPosition() {
        return new double[] { x, y, z };
    }

    @Override
    public boolean isClose(double x, double y, double z) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2) + Math.pow(this.z - z, 2)) < MAX_DISTANCE;
    }

    public void printPosition() {
        System.out.println("Car " + trackerID + " is at position (" + x + ", " + y + ", " + z + ")");
    }
}

public class Interface {
    public static void main(String[] args) {
        Drone drone = new Drone("DR001");

        drone.move(10, 20, 30);
        drone.printPosition();

        System.out.println("Tracker ID: " + drone.getTrackerID()); // -> DR001
        System.out.println(
                "Current position: " + drone.getCurrentPosition()[0] + ", " + drone.getCurrentPosition()[1] + ", "
                        + drone.getCurrentPosition()[2]); // -> 10.0, 20.0, 30.0

        System.out.println("Is close: " + drone.isClose(10, 20, 30)); // -> true

        // Có thể khai báo một biến kiểu interface và gán cho nó một đối tượng của lớp
        // thực thi interface đó.
        Movable movable;

        movable = drone; // -> Đúng vì Drone thực thi cả hai interface Movable và Trackable
        movable.move(5, 5, 5); // -> Di chuyển drone 5 đơn vị theo vector (5, 5, 5)

        // movable.printPosition();
        // -> Lỗi vì phương thức printPosition() không thuộc interface Movable

        Drone otherDrone = new Drone("DR002");
        // otherDrone = movable; // -> Sai, phải ép kiểu tường minh
        otherDrone = (Drone) movable;

        otherDrone.printPosition();
        // -> DR001 is at position (15.0, 25.0, 35.0)
        // Không phải (0.0, 0.0, 0.0) vì otherDrone đã nhận giá trị của movable
    }
}
