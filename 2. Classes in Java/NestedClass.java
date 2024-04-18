import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Lớp chồng nhau (nested class) là một lớp được định nghĩa bên trong một lớp khác.

// Ví dụ:

// ContactBook là danh bạ điện thoại, bao gồm danh sách các liên hệ và các nhóm.
class ContactBook {
    public List<Contact> contacts = new ArrayList<>();
    public Map<String, Group> groups = new HashMap<>();

    // Lớp Contact đại diện cho một liên hệ trong danh bạ, gồm tên và số điện thoại.
    /*
     * Tương tác với lớp bên ngoài:
     * - Các inner class có thể truy cập đầy đủ tới tất cả các phương thức và biến
     * của lớp chứa nó.
     * - Inner class thường không thể truy cập một cách trực tiếp từ bên ngoài lớp
     * chứa nó nếu không thông qua một instance của lớp chứa.
     * - Ví dụ, để tạo một instance của lớp Contact, ta cần thông qua một instance
     * của lớp ContactBook như sau
     * ContactBook myBook = new ContactBook();
     * ContactBook.Contact contact = myBook.new Contact("Alice", "1234567890");
     */
    class Contact {
        private String name;
        private String phone;

        // Là một lớp, Contact cũng có hàm tạo.
        // Dùng this để tham chiếu đến biến của lớp Contact.
        public Contact(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        public void displayContact() {
            System.out.println("Name: " + name + ", Phone: " + phone);
        }
    }

    // Lớp Group đại diện cho một nhóm trong danh bạ, bao gồm tên nhóm và danh sách
    // các thành viên.
    class Group {
        String name;
        List<Contact> members = new ArrayList<>();

        public Group(String name) {
            this.name = name;
        }

        public void addMember(Contact contactName) {
            members.add(contactName);
        }

        public void displayGroup() {
            System.out.println("Group: " + name);
            System.out.println("Members:");
            for (Contact member : members) {
                System.out.println(member.name);
            }
        }
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void addGroup(String name) {
        Group group = new Group(name);
        groups.put(name, group);
    }
}

// Lớp NestedClass chứa hàm main để chạy chương trình.
public class NestedClass {
    public static void main(String[] args) {
        ContactBook myBook = new ContactBook();

        ContactBook.Contact contact1 = myBook.new Contact("Alice", "1234567890");
        ContactBook.Contact contact2 = myBook.new Contact("Bob", "0987654321");

        myBook.addContact(contact1);
        myBook.addContact(contact2);

        myBook.addGroup("Friends");
        myBook.groups.get("Friends").addMember(contact1);
        myBook.groups.get("Friends").addMember(contact2);

        System.out.println("_____________DISPLAY CONTACTS_____________");
        for (ContactBook.Contact contact : myBook.contacts) {
            contact.displayContact();
        }

        System.out.println("_____________DISPLAY GROUP_____________");
        myBook.groups.get("Friends").displayGroup();
    }
}
