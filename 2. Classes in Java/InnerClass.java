// Tiếp tục về lớp chồng nhau (nested class, inner class).

// 1. Inner Classes as Adapters
/*
 * Một trong những ứng dụng phổ biến của inner class là sử dụng chúng như một adapter class (lớp tiếp hợp).
 * - Lớp tiếp hợp (adapter class) là một lớp giúp kết nối giữa hai lớp không liên quan với nhau.
 * - Việc sử dụng inner classes như là các adapter cho phép tách biệt rõ ràng giữa các chức năng 
 * và giữ gìn tính đóng gói, đồng thời cung cấp một cách linh hoạt để mở rộng chức năng của một 
 * lớp mà không làm phức tạp hoặc làm lộ dữ liệu nội bộ.
 */

// Ví dụ:

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Lớp Book chứa thông tin về một cuốn sách (tên sách, tác giả)
class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }
}

// Lớp BookList chứa một danh sách các cuốn sách.
class BookList {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public int getSize() {
        return books.size();
    }

    // Nội lớp cung cấp iterator để duyệt qua danh sách các cuốn sách.
    public class BookIterator implements Iterator<Book> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < books.size();
        }

        @Override
        public Book next() {
            return books.get(index++);
        }
    }

    public BookIterator getIterator() {
        return new BookIterator();
    }
}

public class InnerClass {
    public static void main(String[] args) {
        BookList myList = new BookList();

        myList.addBook(new Book("The Java Programming", "James Gosling"));
        myList.addBook(new Book("Learn Python Programming", "Guido van Rossum"));

        // Lấy ra một iterator để duyệt qua danh sách các cuốn sách.
        BookList.BookIterator iterator = myList.getIterator();

        // Duyệt qua danh sách các cuốn sách và in ra màn hình.
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

// Mục đích của ví dụ:
/*
 * Trong trường hợp này, BookList là một lớp quản lý một danh sách các sách.
 * Chúng ta muốn có thể duyệt qua các sách trong danh sách này một cách tuần tự,
 * nhưng BookList không tự nó cung cấp phương thức để làm điều đó. Để giải quyết
 * vấn đề này, chúng ta sử dụng một inner class (BookListIterator) để cung cấp
 * khả năng iterator mà không cần phải thay đổi cấu trúc hoặc công khai chi tiết
 * nội bộ của BookList.
 */

// Chú thích: Interator là một interface trong Java Collection Framework, nó
// cung cấp
// các phương thức để duyệt qua các phần tử của một Collection.
// - boolean hasNext(): Kiểm tra xem có phần tử tiếp theo không.
// - next(): Trả về phần tử tiếp theo trong Collection.
// - void remove(): Xóa phần tử hiện tại khỏi Collection.

/*
 * Cách Hoạt Động Của BookList và BookListIterator
 * i) Lớp BookList:
 * - Đây là lớp chính chứa danh sách các sách.
 * - Lớp này cung cấp phương thức addBook() để thêm sách vào danh sách và phương
 * thức getIterator() để lấy một iterator.
 * ii) Inner Class BookListIterator:
 * - Đây là một inner class được định nghĩa bên trong BookList. Nó cung cấp các
 * phương thức để duyệt qua danh sách sách.
 * - hasNext(): Kiểm tra xem có sách tiếp theo trong danh sách không.
 * - next(): Trả về sách tiếp theo và di chuyển chỉ mục tiếp theo. Nếu không còn
 * sách, phương thức này sẽ ném ra một NoSuchElementException.
 */

/*
 * Tại Sao BookListIterator Là Một Adapter?
 * 
 * BookListIterator đóng vai trò như một adapter vì nó "chuyển đổi" lớp BookList
 * từ một lớp không có khả năng iterator sang một lớp có thể được duyệt qua một
 * cách tuần tự. Nó làm điều này mà không yêu cầu BookList phải thực hiện trực
 * tiếp giao diện Iterable hoặc thay đổi thiết kế của nó để hỗ trợ duyệt. Thay
 * vào đó, BookListIterator cung cấp một cách để truy cập tuần tự đến các phần
 * tử của BookList từ bên trong lớp.
 */

// -> Xem thêm ví dụ ở file AdapterClass.java
