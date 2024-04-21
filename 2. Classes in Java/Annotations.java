// Annotations (hay chú thích) là một cách để thêm metadata vào code của bạn.
/*
 * - Metadata (siêu dữ liệu) là dữ liệu mô tả dữ liệu khác.
 * - Các chú thích này không ảnh hưởng trực tiếp đến hoạt động của chương trình, nhưng chúng có thể được sử dụng bởi các công cụ hoặc frameworks khác để thực hiện một số công việc.
 * - Chú thích cung cấp thông tin bổ sung mà không thay đổi chương trình của bạn.
 * - Các chú thích tích hợp sẵn trong Java:
 *   + @Override: chỉ ra 1 phương thức sẽ ghi đè 1 phương thức trong lớp cha.
 *   + @Deprecated: chỉ ra rằng phương thức hoặc lớp đã bị lỗi thời và không nên được sử dụng.
 *   + @SuppressWarnings: nói cho bộ biên dịch Java bỏ qua cảnh báo cụ thể.
 *   + @FunctionalInterface: chỉ ra rằng một interface được thiết kế để hỗ trợ các lambda expression (chỉ chứa một phương thức trừu tượng).
 *   + ...
 * - Người dùng cũng có thể tạo chú thích của riêng mình bằng cách sử dụng @interface.
 */

// Ví dụ việc tạo chú thích:
@interface MyAnnotation {
    String author();

    String date();

    int currentRevision() default 1;

    String lastModified() default "N/A";

    String lastModifiedBy() default "N/A";

    String[] reviewers();
}

// Sử dụng chú thích:
@MyAnnotation(author = "Nguyen Van A", date = "3/4/2021", currentRevision = 2, lastModified = "4/4/2021", lastModifiedBy = "Nguyen Van B", reviewers = {
        "Nguyen Van C", "Nguyen Van D" })
class MyClass {
    // code
}

public class Annotations {

}
