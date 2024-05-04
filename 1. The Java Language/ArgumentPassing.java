// Khái niệm truyền tham trị và truyền tham chiếu có thể gây nhầm lẫn.
// Nhưng quan trọng là hiểu rằng, Java chỉ sử dụng truyền tham trị.
/*
 * - Truyền tham trị (pass by value): Trong Java, khi bạn truyền một biến vào một phương thức, 
 * giá trị của biến đó được sao chép vào một biến mới trong phương thức được gọi. Điều này có 
 * nghĩa là bất kỳ sự thay đổi nào đối với biến trong phương thức đó sẽ không ảnh hưởng đến biến ban đầu.
 * - Truyền tham chiếu (pass by reference): Đây là một khái niệm mà nhiều ngôn ngữ khác sử dụng, trong đó 
 * tham chiếu đến một đối tượng hoặc vùng nhớ được truyền vào phương thức, cho phép phương thức thay đổi 
 * trực tiếp đối tượng hoặc giá trị tại vùng nhớ đó.
 */

// Cách hoạt động của Java:
/*
 * - Với kiểu dữ liệu nguyên thủy: Các kiểu như int, double, char, v.v., khi được truyền vào một phương thức, 
 * giá trị của chúng được sao chép. Bất kỳ sự thay đổi nào trong phương thức đối với biến này không ảnh hưởng đến biến ban đầu.
 * - Với đối tượng: Khi truyền một đối tượng vào phương thức, địa chỉ (tham chiếu) của đối tượng đó được sao chép vào biến mới. 
 * Tuy nhiên, đây là một bản sao của tham chiếu, không phải của chính đối tượng. Do đó, bạn có thể thay đổi đối tượng qua tham 
 * chiếu này (ví dụ, thay đổi thuộc tính, gọi phương thức thay đổi trạng thái), và các thay đổi đó sẽ phản ánh trên đối tượng ban đầu. Tuy nhiên, nếu bạn cố gắng gán lại tham chiếu này (ví dụ, gán nó vào một đối tượng mới), tham chiếu ban đầu không thay đổi.
 */

public class ArgumentPassing {
    int x;

    // Truyền tham trị (pass by value)
    static void changeValue(int x) {
        x = 10;
    }

    // Truyền một đối tượng vào phương thức
    static void changeValue(ArgumentPassing obj) {
        obj.x = 10;
    }

    void changeValue() {
        this.x = 20;
    }

    public static void main(String[] args) {
        ArgumentPassing obj = new ArgumentPassing();
        obj.x = 5;

        // Truyền biến x vào phương thức changeValue (truyền tham trị)
        changeValue(obj.x);
        System.out.println(obj.x); // -> 5
        // Biến x (thuộc tính x của đối tượng obj) không thay đổi giá trị sau khi truyền
        // bởi vì giá trị của biến x được sao chép vào tham số x của phương thức
        // changeValue.

        // Truyền đối tượng obj vào phương thức changeValue
        changeValue(obj);
        System.out.println(obj.x); // -> 10
        // Đối tượng obj bị thay đổi giá trị thuộc tính x sau khi truyền vào phương thức
        // changeValue.

        obj.changeValue();
        System.out.println(obj.x); // -> 20
    }
}

// Đọc thêm
/*
 * 1. Kiểu nguyên thủy
 * Kiểu nguyên thủy bao gồm int, double, float, boolean, char, byte, short, và
 * long. Các kiểu này lưu trữ dữ liệu trực tiếp mà không lưu trữ tham chiếu đến
 * đối tượng.
 * 
 * -> Khi bạn truyền một biến kiểu nguyên thủy vào hàm, Java sẽ
 * tạo một bản sao của giá trị đó và lưu trữ trong stack của thread hiện hành.
 * Stack là một vùng nhớ được dùng để lưu trữ các thông tin cục bộ của mỗi
 * phương thức như tham số và biến cục bộ. Việc này đảm bảo rằng thay đổi giá
 * trị trong hàm không ảnh hưởng đến biến ban đầu.
 * 
 * 2. Kiểu đối tượng
 * Kiểu đối tượng bao gồm các lớp và mảng. Thay vì lưu giá trị trực tiếp, biến
 * của kiểu đối tượng lưu trữ tham chiếu đến một đối tượng trong heap.
 * 
 * -> Đối tượng thực sự được lưu trong vùng nhớ heap. Heap là
 * một vùng nhớ được quản lý bởi bộ thu gom rác của Java, dùng để lưu trữ dữ
 * liệu động tạo ra trong quá trình chạy chương trình.
 * -> Khi bạn truyền một đối tượng vào hàm, thực chất là
 * bạn truyền bản sao của tham chiếu đến đối tượng đó. Tham chiếu này được lưu
 * trên stack, nhưng nó trỏ đến cùng một đối tượng trên heap. Do đó, bất kỳ thay
 * đổi nào đối với thuộc tính của đối tượng qua tham chiếu này sẽ thay đổi trực
 * tiếp đối tượng trên heap.
 */