// Một tác dụng khác thường thấy của anonymous inner class là xử lý sự kiện (event handling).
/*
 * - Sự kiện (event) là một hành động xảy ra trong ứng dụng, ví dụ nhấn nút chuột, gõ phím, kéo thả, ...
 * - Event handling là quá trình xử lý các sự kiện này.
 * - Trong Java, event handling thường được thực hiện thông qua các listener (người nghe) và adapter (bộ chuyển đổi).
 * - Listener là một interface chứa các phương thức để xử lý sự kiện.
 * - Adapter là một lớp trung gian giữa listener và component (thành phần) để xử lý sự kiện.
 * - Anonymous inner class thường được sử dụng để triển khai listener và adapter một cách nhanh chóng và tiện lợi.
 */

// Xét ví dụ sau:
/*
 * - Trong ví dụ này, chúng ta tạo một cửa sổ JFrame với một nút JButton.
 * - Khi người dùng nhấn nút, chúng ta muốn in ra màn hình dòng chữ "Button clicked!".
 * - Để xử lý sự kiện này, chúng ta sử dụng một anonymous inner class để triển khai ActionListener.
 * - ActionListener là một interface trong gói java.awt.event, nó chứa một phương thức actionPerformed() để xử lý sự kiện.
 * - Trong anonymous inner class, chúng ta triển khai phương thức actionPerformed() để in ra dòng chữ "Button clicked!".
 */

import java.awt.event.*;
import javax.swing.*;

// Sử dụng nội lớp vô danh để xử lý sự kiện khi người dùng nhấn nút.
public class EventHandling {
    public static void main(String[] args) {
        // Tạo một cửa sổ JFrame
        JFrame frame = new JFrame("Event Handling Example");

        // Tạo một nút JButton
        JButton button = new JButton("Click Me");

        // Thêm nút vào cửa sổ
        frame.add(button);

        // Đặt kích thước cửa sổ
        frame.setSize(300, 200);

        // Đặt cửa sổ hiển thị ở giữa màn hình
        frame.setLocationRelativeTo(null);

        // Đặt cửa sổ hiển thị
        frame.setVisible(true);

        // Sử dụng nội lớp vô danh để xử lý sự kiện khi người dùng nhấn nút
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked!");
            }
        });
    }
}

// Tác dụng của nội lớp vô danh trong ví dụ trên:
/*
 * - Anonymous inner class này được truyền vào phương thức addActionListener()
 * của JButton để xử lý sự kiện khi người dùng nhấn nút.
 * - Anonymous inner class giúp viết mã ngắn gọn và dễ hiểu hơn so với việc tạo
 * một lớp mới và triển khai ActionListener.
 */
