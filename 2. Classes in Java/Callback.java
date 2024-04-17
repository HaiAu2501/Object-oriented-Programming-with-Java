// Callback (gọi lại) là một cơ chế trong lập trình cho phép một đối tượng truyền tham chiếu đến một 
// hoặc nhiều phương thức của nó cho một đối tượng khác, để sau này đối tượng được gọi có thể gọi lại các phương thức đó. 
// Hiểu đơn giản là, truyền một phương thức vào một phương thức khác để thực thi nó sau này.
/*
 * - Đây là một phương pháp thường được sử dụng trong các ngôn ngữ như C hay C++ thông qua con trỏ hàm, 
 * nhưng trong Java, cách tiếp cận này được thực hiện bằng cách sử dụng interfaces.
 * - Callback giúp chúng ta giảm sự phụ thuộc giữa các đối tượng với nhau, giúp chúng ta dễ dàng mở rộng
 * ứng dụng của mình hơn.
 */

// Ví dụ:

// Định nghĩa interface TaskListener với phương thức onTaskCompleted() để xử lý kết quả trả về từ một Task nào đó.
interface TaskListener {
    void onTaskCompleted(String result);
}

// Tạo class Task mà sẽ sử dụng interface TaskListener để thông báo cho đối
// tượng khác khi nó hoàn thành công việc.
class Task {
    private TaskListener listener;

    public void setTaskListener(TaskListener listener) {
        this.listener = listener;
    }

    public void completeTask() {
        // Do something
        // Sau khi hoàn thành công việc, gọi phương thức onTaskCompleted() của interface
        // TaskListener
        if (listener != null) {
            listener.onTaskCompleted("Task completed");
        }
    }
}

// Triển khai class Application mà triển khai interface TaskListener và đăng ký
// nhận sự kiện từ Task.
class Application implements TaskListener {
    @Override
    public void onTaskCompleted(String result) {
        System.out.println("Notification from Task:: " + result);
    }

    public static void main(String[] args) {

        Task task = new Task();
        Application app = new Application();

        // Đăng ký nhận sự kiện từ Task
        task.setTaskListener(app);

        // Thực thi Task
        task.completeTask();
    }
}

// Trong ví dụ này:
/*
 * - TaskListener là interface chứa phương thức onTaskCompleted() để xử lý kết
 * quả trả về từ Task.
 * - Task là class chứa phương thức completeTask() để thực thi công việc và
 * thông báo kết quả trả về thông qua interface TaskListener.
 * - Application là class triển khai interface TaskListener để xử lý kết quả trả
 * về từ Task.
 */

// Như vậy, interface TaskListener có ý nghĩa:
/*
 * - Task không cần biết đối tượng nào sẽ xử lý kết quả trả về của nó.
 * - Task chỉ cần gọi phương thức onTaskCompleted() của interface TaskListener
 * để thông báo kết quả trả về.
 * - Application sẽ triển khai interface TaskListener để xử lý kết quả trả về từ
 * Task.
 * -> Từ đó, chúng ta có thể dễ dàng thay đổi hoặc mở rộng ứng dụng mà không cần
 * sửa đổi Task.
 * -> Callback giúp chúng ta giảm sự phụ thuộc giữa các đối tượng với nhau, giúp
 * chúng ta dễ dàng mở rộng ứng dụng của mình hơn.
 */

public class Callback {
    public static void main(String[] args) {
        Application.main(args);
    }
}
