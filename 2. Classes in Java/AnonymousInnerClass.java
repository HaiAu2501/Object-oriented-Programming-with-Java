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

// Lớp Friend chứa thông tin về một người bạn, bao gồm tên và địa chỉ.
class Friend {
    private String name;
    private String address;

    public Friend(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Friend [name=" + name + ", address=" + address + "]";
    }
}

// Lớp FriendList chứa danh sách các người bạn.
class FriendList {
    private List<Friend> friends = new ArrayList<>();

    public void addFriend(Friend friend) {
        friends.add(friend);
    }

    public int getSize() {
        return friends.size();
    }

    // Nội lớp cung cấp iterator để duyệt qua danh sách các người bạn.
    public class FriendIterator implements Iterator<Friend> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < friends.size();
        }

        @Override
        public Friend next() {
            return friends.get(index++);
        }
    }

    public FriendIterator getIterator() {
        return new FriendIterator();
    }

    // Sử dụng nội lớp vô danh để tạo một Iterator mới mà không cần phải tạo lớp
    // mới.
    public Iterator<Friend> getReverseIterator() {
        return new Iterator<Friend>() {
            private int index = friends.size() - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public Friend next() {
                return friends.get(index--);
            }
        };
        // Đây là một nội lớp vô danh, không có tên, được khai báo và khởi tạo ngay
        // tại chỗ.
    }
}

public class AnonymousInnerClass {
    public static void main(String[] args) {
        FriendList myList = new FriendList();

        // Thêm các người bạn vào danh sách.
        myList.addFriend(new Friend("Alice", "USA"));
        myList.addFriend(new Friend("Bob", "UK"));
        myList.addFriend(new Friend("Carol", "France"));

        System.out.println("--Book list:");

        // Sử dụng Iterator để duyệt qua danh sách các cuốn sách.
        Iterator<Friend> iterator = myList.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\n--Book list in reverse order:");

        // Sử dụng Iterator để duyệt qua danh sách các cuốn sách theo thứ tự ngược lại.
        Iterator<Friend> reverseIterator = myList.getReverseIterator();
        while (reverseIterator.hasNext()) {
            System.out.println(reverseIterator.next());
        }
    }
}
