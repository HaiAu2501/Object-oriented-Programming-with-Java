import javax.swing.*;

public class HelloJava {
    public static void main(String[] args) {
        // Tạo một cửa sổ (window) mới
        JFrame frame = new JFrame("Hello Java");

        // Tạo một nhãn (label) mới với nội dung là "Hello World"
        JLabel label = new JLabel("Hello Java", JLabel.CENTER);

        // Thêm nhãn vào cửa sổ
        frame.add(label);

        // Đặt kích thước cửa sổ
        frame.setSize(300, 200);

        // Hiển thị cửa sổ
        frame.setVisible(true);
    }
}
