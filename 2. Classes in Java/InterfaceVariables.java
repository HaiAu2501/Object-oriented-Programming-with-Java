// Một interface có thể chứa các biến, nhưng các biến này mặc định là public, static và final;
/*
 * - Các biến này có thể được tham chiếu trực tiếp thông qua tên của interface.
 * - Các biến này xuất hiện trong tất cả các class implement interface đó.
 */

// Ví dụ:
interface Scaleable {
    static final int BIG = 0, MEDIUM = 1, SMALL = 2;

    void setScale(int size);
}

class Box implements Scaleable {
    private int size;

    @Override
    public void setScale(int size) {
        switch (size) {
            case BIG:
                this.size = 100;
                break;
            case MEDIUM:
                this.size = 50;
                break;
            case SMALL:
                this.size = 25;
                break;
            default:
                System.out.println("Invalid size");
        }
    }

    public void printSize() {
        System.out.println("Size: " + size);
    }
}

public class InterfaceVariables {
    public static void main(String[] args) {
        Box box = new Box();
        box.setScale(Scaleable.BIG);
        box.printSize(); // Size: 100
    }
}

// Interfaces trong lập trình hướng đối tượng nên chỉ được sử dụng để định nghĩa
// hành vi, không phải để lưu trữ trạng thái hay dữ liệu cụ thể. Việc sử dụng
// interfaces để chứa biến (các hằng số) làm mờ đi mục đích chính của chúng và
// có thể dẫn đến một thiết kế không sạch sẽ, khiến cho các hằng số và hành vi
// được gói gọn cùng nhau một cách không cần thiết.

/*
 * - Tất cả biến trong interface đều là public static final. Điều này có nghĩa
 * là
 * chúng luôn luôn công khai và có sẵn cho bất kỳ ai sử dụng interface. Điều này
 * cản trở khả năng đóng gói, khiến cho việc quản lý trạng thái của chương trình
 * trở nên khó khăn hơn.
 * - Việc mỗi lớp thực thi một interface kế thừa toàn bộ các hằng số có thể gây
 * rối loạn API của lớp đó, khiến cho API bao gồm nhiều thành phần không cần
 * thiết
 */

// -> Tóm lại, không nên sử dụng interface để chứa biến, hãy sử dụng class hoặc
// enum thay thế.