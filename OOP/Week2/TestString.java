public class TestString {
    public static void main(String[] args) {
        // String
        long l1 = System.currentTimeMillis();
        String s1 = "Hello";
        for (int i = 0; i < 100000; i++) {
            s1 = s1 + "World";
            // -> Thêm chuỗi "World" vào cuối chuỗi s, chậm hơn so với StringBuffer và
            // StringBuilder
        }
        System.out.println(System.currentTimeMillis() - l1);

        // StringBuffer
        long l2 = System.currentTimeMillis();
        StringBuffer s2 = new StringBuffer("Hello");
        // -> StringBuffer là một lớp trong Java giúp thực hiện các thao tác với chuỗi
        for (int i = 0; i < 100000; i++) {
            s2.append("World"); // -> Thêm chuỗi "World" vào cuối chuỗi s, nhanh hơn so với String
        }
        System.out.println(System.currentTimeMillis() - l2);

        // So sánh với StringBuilder
        long l3 = System.currentTimeMillis();
        StringBuilder s3 = new StringBuilder("Hello");
        // -> StringBuilder tương tự như StringBuffer, nhưng không đồng bộ, nhanh hơn so
        // với StringBuffer
        for (int i = 0; i < 100000; i++) {
            s3.append("World");
        }
        System.out.println(System.currentTimeMillis() - l3);
    }
}

/*
 * Trong Java, StringBuffer là một lớp được sử dụng để tạo ra chuỗi có thể thay
 * đổi (mutable string).
 * 
 * Khác với chuỗi String thông thường không thay đổi (immutable), mọi thay đổi
 * được áp dụng lên đối tượng
 * StringBuffer sẽ không tạo ra một đối tượng mới mà chỉ thay đổi nội dung của
 * chính đối tượng đó.
 * 
 * Điều này làm cho StringBuffer trở thành lựa chọn thích hợp khi bạn cần thực
 * hiện nhiều thao tác chỉnh sửa chuỗi,
 * như thêm (append), xoá (delete), hoặc chèn (insert) các ký tự,
 * vì nó sẽ hiệu quả hơn nhiều so với việc sử dụng chuỗi String thông thường.
 */