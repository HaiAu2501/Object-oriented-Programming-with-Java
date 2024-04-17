public class Enumerations {
    // Enumerations (Enums) trong Java:
    /*
     * - Là một kiểu dữ liệu đặc biệt trong Java, được sử dụng để định nghĩa một tập
     * hợp các hằng số.
     * - Enumerations giúp tạo ra một tập hợp các hằng số có ý nghĩa, giúp mã nguồn
     * dễ đọc hơn.
     * - Enumerations được khai báo bằng từ khóa enum.
     */

    enum Weekdays {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    // enum là kiểu public static final, nên có thể truy cập từ bất kỳ lớp nào

    // Có thể lấy danh sách theo thứ tự cho một biến thông qua phương thức values()
    Weekdays[] days = Weekdays.values();

    // Các enumerations có thể có giá trị với các constructor, phương thức, trường
    // giống như các lớp khác.

    enum Directions {
        EAST(1), WEST(2), NORTH(3), SOUTH(4);

        private int value;

        Directions(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        // Truy cập các hằng số trong enum
        System.out.println(Weekdays.MONDAY); // -> MONDAY

        // Lấy danh sách các hằng số trong enum
        Enumerations obj = new Enumerations();
        for (Weekdays day : obj.days) {
            System.out.println(day);
        }

        // Truy cập giá trị của enum
        System.out.println(Directions.EAST.getValue()); // -> 1
    }
}
