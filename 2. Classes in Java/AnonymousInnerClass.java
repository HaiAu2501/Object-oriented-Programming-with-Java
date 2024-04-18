// Tiếp tục về nội lớp (inner class).
// 4. Nội lớp vô danh (anonymous inner class):
/*
 * - Là một loại nội lớp không có tên, được khai báo và khởi tạo ngay tại chỗ.
 * - Dùng khi bạn cần tạo một lớp mà chỉ sử dụng một lần duy nhất.
 */

// Xét ví dụ sau:

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

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

    // Sử dụng nội lớp vô danh để tạo một Iterator mới mà không cần phải tạo lớp
    // mới.
    public Iterator<Book> getReverseIterator() {
        return new Iterator<Book>() {
            private int index = books.size() - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public Book next() {
                return books.get(index--);
            }
        };
        // Đây là một nội lớp vô danh, không có tên, được khai báo và khởi tạo ngay
        // tại chỗ.
    }
}

public class AnonymousInnerClass {
    public static void main(String[] args) {
        BookList myList = new BookList();

        myList.addBook(new Book("The Alchemist", "Paulo Coelho"));
        myList.addBook(new Book("The Little Prince", "Antoine de Saint-Exupéry"));
        myList.addBook(new Book("The Da Vinci Code", "Dan Brown"));

        System.out.println("--Book list:");

        // Sử dụng Iterator để duyệt qua danh sách các cuốn sách.
        BookList.BookIterator iterator = myList.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\n--Book list in reverse order:");

        // Sử dụng Iterator để duyệt qua danh sách các cuốn sách theo thứ tự ngược lại.
        Iterator<Book> reverseIterator = myList.getReverseIterator();
        while (reverseIterator.hasNext()) {
            System.out.println(reverseIterator.next());
        }
    }
}
