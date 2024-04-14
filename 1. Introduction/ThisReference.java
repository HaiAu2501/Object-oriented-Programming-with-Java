class Display {
    public void displayObject(Object obj) {
        System.out.println(obj.toString());
    }
}

public class ThisReference {
    // Sử dụng tham chiếu đặc biệt 'this' để truy cập các biến và phương thức của
    // lớp hiện tại.

    private int x;
    private int y;

    // 1. Phân biệt giữa biến instance và biến local
    public void setVar(int x) {
        // Biến x ở đây là biến local
        // this.x ở đây là biến instance
        this.x = x;
    }

    // 2. Gọi một constructor khác trong cùng một lớp
    public ThisReference() {
        // Gọi constructor có tham số
        this(0, 0);
    }

    public ThisReference(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 3. Trả về chính đối tượng hiện tại
    public ThisReference setX(int x) {
        this.x = x;
        return this;
    }

    public ThisReference setY(int y) {
        this.y = y;
        return this;
    }

    // 4. Truyền đối tượng hiện tại cho phương thức khác
    public void display() {
        Display display = new Display();
        display.displayObject(this);
    }

    @Override // Override phương thức toString() để hiển thị thông tin của đối tượng
    public String toString() {
        return "ThisReference [x=" + x + ", y=" + y + "]";
    }

    public static void main(String[] args) {
        ThisReference obj = new ThisReference();
        System.out.println("x: " + obj.x); // -> 0
        System.out.println("y: " + obj.y); // -> 0

        obj.setX(30).setY(40);
        System.out.println("x: " + obj.x); // -> 30
        System.out.println("y: " + obj.y); // -> 40

        obj.display();
    }
}
