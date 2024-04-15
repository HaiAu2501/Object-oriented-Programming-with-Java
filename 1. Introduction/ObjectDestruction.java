@SuppressWarnings("unused")
public class ObjectDestruction {
    // Hủy đối tượng (Object Destruction) trong Java:
    /*
     * - Trong Java, việc hủy đối tượng được thực hiện tự động bởi garbage
     * collector.
     * - Garbage collector là một tiến trình chạy ngầm, quét các đối tượng không còn
     * sử dụng và giải phóng bộ nhớ của chúng.
     * - System.gc() là một phương thức được sử dụng để yêu cầu garbage collector
     * chạy.
     */

    // Trước khi một đối tượng bị hủy, phương thức finalize() sẽ được gọi.
    /*
     * - Phương thức finalize() là một phương thức của lớp Object, được gọi trước
     * khi một đối tượng bị hủy.
     * - Phương thức finalize() được sử dụng để thực hiện các tác vụ dọn dẹp hoặc
     * giải phóng tài nguyên trước khi đối tượng bị hủy.
     * - Phương thức finalize() có thể được ghi đè trong lớp con để thực hiện các
     * tác vụ dọn dẹp cụ thể.
     */

    public static void main(String[] args) {
        ObjectDestruction obj = new ObjectDestruction();
        obj = null;
        System.gc();
    }
}
