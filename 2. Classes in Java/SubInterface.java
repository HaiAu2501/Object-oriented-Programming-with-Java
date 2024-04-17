// Một interface có thể extends một hoặc nhiều interface khác. 
// Điều này giúp chúng ta tạo ra một cấu trúc phân cấp của các interface, giúp chúng ta quản lý và sắp xếp các hành vi một cách có tổ chức.

/*
 * - Lưu ý, khác với class chỉ kế thừa từ một class cha duy nhất, một class có thể
 * implements nhiều interface; còn một interface có thể extends nhiều interface khác.
 * - Một interface không thể kế thừa từ class khác.
 * - Một class implement một interface thì cũng phải implement tất cả interface mà
 * interface đó extends.
 */

// Ví dụ:

// Interface Vehicle định nghĩa các hành vi cơ bản của một phương tiện giao thông.
interface Vehicle {
    void start();

    void stop();
}

// Interface FlyingVehicle định nghĩa các hành vi của một phương tiện bay.
interface FlyingVehicle extends Vehicle {
    void fly();

    void land();
}

// Interface LandVehicle định nghĩa các hành vi của một phương tiện đường bộ.
interface LandVehicle extends Vehicle {
    void drive();

    void brake();
}

// Interface AmphibiousVehicle kế thừa từ cả FlyingVehicle và LandVehicle, định
// nghĩa
// thêm hành vi floatOnWater().
interface AmphibiousVehicle extends FlyingVehicle, LandVehicle {
    void floatOnWater();
}

// Lớp HybridDrone thực thi interface AmphibiousVehicle.
// -> Nó phải override tất cả các phương thức của các interface mà nó implement.
class HybridDrone implements AmphibiousVehicle {
    @Override
    public void start() {
        System.out.println("HybridDrone is starting...");
    }

    @Override
    public void stop() {
        System.out.println("HybridDrone is stopping...");
    }

    @Override
    public void fly() {
        System.out.println("HybridDrone is flying...");
    }

    @Override
    public void land() {
        System.out.println("HybridDrone is landing...");
    }

    @Override
    public void drive() {
        System.out.println("HybridDrone is driving...");
    }

    @Override
    public void brake() {
        System.out.println("HybridDrone is braking...");
    }

    @Override
    public void floatOnWater() {
        System.out.println("HybridDrone is floating on water...");
    }
}

public class SubInterface {
    public static void main(String[] args) {
        HybridDrone drone = new HybridDrone();
        drone.start();
        drone.fly();
        drone.land();
        drone.drive();
        drone.brake();
        drone.floatOnWater();
        drone.stop();
    }
}
