// String trong Java là một class trong Java.
/* Tính chất của String:
 * - String là bất biến (immutable), không thể thay đổi giá trị của String sau khi đã tạo. 
 * - Mỗi khi cố gắng thay đổi giá trị của String, một đối tượng mới sẽ được tạo ra.
 * - String được lưu trữ trong String Pool, một vùng nhớ đặc biệt trong bộ nhớ Heap. 
 * Khi một chuỗi được tạo thông qua dấu ngoặc kép mà không sử dụng từ khóa new, Java sẽ 
 * kiểm tra xem chuỗi đó đã tồn tại trong Pool chưa. Nếu có, Java sẽ sử dụng lại đối tượng đó thay vì tạo mới.
 * - String là final class, không thể kế thừa.
 * - Các phương thức thông dụng của lớp String:
 *   # Kiểm tra, so sánh:
 *     + boolean equals(Object obj): So sánh chuỗi hiện tại với chuỗi obj.
 *     + boolean equalsIgnoreCase(String anotherString): So sánh chuỗi hiện tại với chuỗi anotherString, không phân biệt chữ hoa chữ thường.
 *     + int compareTo(String str): So sánh chuỗi hiện tại với chuỗi str, theo thứ tự từ điển.
 *     + int compareToIgnoreCase(String str): So sánh chuỗi hiện tại với chuỗi str, không phân biệt chữ hoa chữ thường.
 *     + boolean startsWith(String prefix): Kiểm tra xem chuỗi có bắt đầu bằng tiền tố chỉ định không.
 *     + boolean endsWith(String suffix): Kiểm tra xem chuỗi có kết thúc bằng hậu tố chỉ định không.
 *     + boolean contains(CharSequence s): Kiểm tra xem chuỗi có chứa chuỗi s không.
 *   # Tìm kiếm, truy xuất:
 *     + int indexOf(int ch): Trả về vị trí đầu tiên của ký tự ch trong chuỗi.
 *     + int lastIndexOf(int ch): Trả về vị trí cuối cùng của ký tự ch trong chuỗi.
 *     + String substring(int beginIndex, int endIndex): Trả về chuỗi con từ vị trí beginIndex đến vị trí endIndex - 1.
 *     + char charAt(int index): Trả về ký tự ở vị trí index trong chuỗi.
 *   # Chỉnh sửa, thay thế:
 *     + String replace(char oldChar, char newChar): Thay thế tất cả các ký tự oldChar trong chuỗi bằng ký tự newChar.
 *     + String trim(): Xóa khoảng trắng ở đầu và cuối chuỗi.
 *   # Chuyển đổi:
 *     + String toLowerCase(): Chuyển đổi chuỗi thành chữ thường.
 *     + String toUpperCase(): Chuyển đổi chuỗi thành chữ hoa.
 *     + String valueOf(int i): Chuyển đổi một số nguyên sang chuỗi.
 */

// StringBuffer là một lớp trong Java được sử dụng để tạo và quản lý chuỗi có thể thay đổi (mutable).
/* Tính chất của StringBuffer:
 * - StringBuffer là mutable, có thể thay đổi giá trị của chuỗi sau khi đã tạo.
 * - StringBuffer được lưu trữ trong bộ nhớ Heap.
 * - Hiệu quả hơn String khi thực hiện nhiều thao tác chỉnh sửa chuỗi do không tạo ra nhiều đối tượng mới mỗi lần chỉnh sửa.
 * - Các phương thức thông dụng của lớp StringBuffer:
 *   # Thêm, chèn:
 *     + StringBuffer append(String s): Thêm chuỗi s vào cuối chuỗi hiện tại.
 *     + StringBuffer insert(int offset, String s): Chèn chuỗi s vào vị trí offset trong chuỗi hiện tại.
 *   # Xóa, thay thế:
 *     + StringBuffer delete(int startIndex, int endIndex): Xóa chuỗi con từ vị trí startIndex đến vị trí endIndex - 1.
 *     + StringBuffer deleteCharAt(int index): Xóa ký tự ở vị trí index.
 *     + StringBuffer replace(int startIndex, int endIndex, String s): Thay thế chuỗi con từ vị trí startIndex đến vị trí endIndex - 1 bằng chuỗi s.
 *   # Đảo ngược:
 *     + StringBuffer reverse(): Đảo ngược chuỗi.
 *   # Chuyển đổi:
 *     + String toString(): Chuyển đổi StringBuffer thành String.
 *     + StringBuffer append(int i): Thêm một số nguyên vào cuối chuỗi.
 *     + StringBuffer append(double d): Thêm một số thực vào cuối chuỗi.
 * ...
 */

public class StringTips {
    public static void main(String[] args) {
        System.out.println("--- String");
        // Khởi tạo String
        String str1 = "Hello World!";
        String str2 = "Hello World!";

        // So sánh String
        System.out.println(str1 == str2); // true (vì str1 và str2 cùng trỏ đến một đối tượng trong String Pool)
        System.out.println(str1.equals(str2)); // true

        String str3 = new String("Hello World!"); // -> dùng new thì sẽ tạo ra một đối tượng mới trong Heap

        System.out.println(str1 == str3); // false (vì str3 trỏ đến một đối tượng mới được tạo ra trong Heap)

        // Chuyển sang chữ hoa
        str1.toUpperCase();
        System.out.println(str1); // Hello World! (vì String là immutable, nên giá trị của str1 không thay đổi)
        System.out.println(str1.toUpperCase()); // HELLO WORLD!

        System.out.println("--- String Buffer");
        // String Buffer
        // StringBuffer sb1 = "Hello World!"; // -> lỗi vì không thể gán một String vào
        // một StringBuffer trực tiếp
        StringBuffer sb1 = new StringBuffer("Hello");

        // Thêm chuỗi vào cuối
        sb1.append(" World!");
        System.out.println(sb1); // Hello World! (vì StringBuffer là mutable, nên giá trị của sb1 thay đổi)

        System.out.println("--- Compare String and StringBuffer");

        // So sánh hiệu suất giữa String và StringBuffer
        String str = "Hello";

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            str += "World";
        }
        long end = System.currentTimeMillis();

        System.out.println("Time for String: " + (end - start) + "ms"); // -> Khoảng 100 ms

        StringBuffer sb = new StringBuffer("Hello");

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            sb.append("World");
        }
        end = System.currentTimeMillis();

        System.out.println("Time for StringBuffer: " + (end - start) + "ms"); // -> Chỉ khoảng dưới 1 ms
    }
}
