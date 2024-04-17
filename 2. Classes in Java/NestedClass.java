import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Lớp chồng nhau (nested class) là một lớp được định nghĩa bên trong một lớp khác.

// Ví dụ:
class ContactBook {
    public List<Contact> contacts = new ArrayList<>();
    public Map<String, Group> groups = new HashMap<>();

    class Contact {
        private String name;
        private String phone;

        public Contact(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        public void displayContact() {
            System.out.println("Name: " + name + ", Phone: " + phone);
        }
    }

    static class Group {
        String name;
        List<String> members = new ArrayList<>();

        public Group(String name) {
            this.name = name;
        }

        public void addMember(String contactName) {
            members.add(contactName);
        }

        public void displayGroup() {
            System.out.println("Group: " + name);
            System.out.println("Members:");
            for (String member : members) {
                System.out.println(member);
            }
        }
    }

    public void addContact(String name, String phone) {
        Contact contact = new Contact(name, phone);
        contacts.add(contact);
    }

    public void addGroup(String name) {
        Group group = new Group(name);
        groups.put(name, group);
    }
}

public class NestedClass {
    public static void main(String[] args) {
        ContactBook myBook = new ContactBook();
        myBook.addContact("Alice", "1234567890");
        myBook.addContact("Bob", "0987654321");

        myBook.addGroup("Friends");
        myBook.groups.get("Friends").addMember("Alice");
        myBook.groups.get("Friends").addMember("Bob");

        for (ContactBook.Contact contact : myBook.contacts) {
            contact.displayContact();
        }

        myBook.groups.get("Friends").displayGroup();
    }
}
