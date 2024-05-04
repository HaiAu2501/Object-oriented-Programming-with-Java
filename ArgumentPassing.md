# Truyền tham số trong Java

Hãy luôn nhớ rằng, **Java chỉ sử dụng truyền tham trị**. Khi bạn truyền tham số vào hàm trong Java, tùy thuộc vào kiểu dữ liệu của tham số (kiểu nguyên thủy hay kiểu không nguyên thủy), việc tương tác với vùng nhớ stack và heap sẽ khác nhau.

## 1. Kiểu nguyên thủy

Xét đoạn mã sau đây:

```java
public class Main {
    public static void setX(int y){
        y = 2;
    }

    public static void main(String args[]){
        int x = 1;
        System.out.println(x); // -> 1

        setX(x);
        System.out.println(x); // -> 1
    }  
}
```

Trong ví dụ này:

- Biến `x` được khai báo và khởi tạo giá trị là `1` trong phương thức `main()`.
- `x` là biến địa phương của phương thức `main()` được lưu trữ trên vùng nhớ stack của phương thức `main()`.
- Khi gọi phương thức `setX(x)`, giá trị của `x` được sao chép vào một biến mới tên là `y` của phương thức `setX()`.
- Trong phương thức `setX()`, biến `y` được thay đổi giá trị thành `2`. Tuy nhiên, sự thay đổi này chỉ ảnh hưởng đến `y`, biến địa phương trong `setX()`, và không ảnh hưởng gì đến `x` ở trong `main()` vì `y` là một bản sao riêng biệt của `x`.
- Do đó, khi in ra giá trị của `x` sau khi gọi `setX()`, kết quả vẫn là `1` như giá trị ban đầu.

<div align = "center">

![Minh họa 4](images\04.png)

</div>

Xét tiếp đoạn mã sau:

```java
public class Main {
    public static void setX(int x) {
        x = 2;
    }

    public static void main(String args[]) {
        int x = 1;
        System.out.println(x); // -> 1

        setX(x);
        System.out.println(x); // -> 1
    }  
}
```

Mặc dù phương thức `setX()` sử dụng tham số tên là `x` (giống như tên biến `x` trong phương thức `main()`) nhưng nó vẫn là biến địa phương của phương thức `setX()`. Việc đặt tên tham số trong phương thức `setX()` là `x` hoặc `y` (hoặc bất kỳ tên nào khác) không ảnh hưởng đến cơ chế truyền tham trị của Java, nhưng nó có thể ảnh hưởng đến tính rõ ràng và dễ đọc của mã. Việc chọn tên tham số có thể làm tăng hoặc giảm sự rõ ràng của mã, đặc biệt là trong việc hiểu rằng các biến trong các phương thức khác nhau là độc lập với nhau.

- Khi dùng cùng tên `x`: Trong ví dụ gần nhất, cả biến địa phương trong `main()` và tham số của `setX()` đều được đặt tên là `x`. Điều này có thể gây ra nhầm lẫn khi đọc và hiểu mã, vì có vẻ như cùng một biến `x` đang được sử dụng trong cả hai phương thức, mặc dù thực tế chúng là hai biến hoàn toàn độc lập.

- Khi dùng tên khác nhau (`y`): Trong ví dụ trước đó, biến trong `main()` là `x` và tham số trong `setX()` là `y`. Sự khác biệt trong đặt tên này giúp làm rõ rằng biến `y` trong `setX()` chỉ là một bản sao của giá trị của `x` và là một biến hoàn toàn độc lập. Điều này làm giảm khả năng gây nhầm lẫn về việc liệu thay đổi `y` có ảnh hưởng đến `x` hay không.

## 2. Kiểu không nguyên thủy

Xét đoạn mã sau đây:

```java
public class Main {
    int x;

    Main(int y) {
        x = y;
    }

    static void changeX(int x) {
        x = 10;
    }

    static void changeX(Main object) {
        object.x = 10;
    }

    void changeX() {
        this.x = 20;
    }

    public static void main(String[] args) {
        Main obj = new Main(5);

        changeX(obj.x);
        System.out.println(obj.x); // -> 5

        changeX(obj);
        System.out.println(obj.x); // -> 10, thực sự bị thay đổi

        obj.changeX();
        System.out.println(obj.x); // -> 20, thực sự bị thay đổi
    }
}
```

- Phương thức `changeX(int x)`:
  - Gọi phương thức: `changeX(obj.x)`: Trong phương thức này, `x` là một tham số kiểu nguyên thủy. Khi phương thức này được gọi, giá trị của `obj.x` (là `5`) được truyền vào phương thức. Trong stack của thread, một khung mới (stack frame) được tạo cho lời gọi `changeX(int)`, và giá trị `5` được sao chép vào biến địa phương `x` của khung này.
  - Thực thi: Giá trị của biến địa phương `x` trong phương thức được thay đổi thành `10`, nhưng điều này không ảnh hưởng đến biến `x` của đối tượng `obj` trong `main`, vì chỉ bản sao của giá trị được thay đổi.
  - Kết quả: `System.out.println(obj.x); // -> 5` - Giá trị của `x` trong đối tượng `obj` không thay đổi vì chỉ giá trị sao chép trong stack của phương thức `changeX(int)` được thay đổi.

- Phương thức `changeX(Main obj)`:
  - Gọi phương thức: `changeX(object)`: Ở đây, tham chiếu đến đối tượng `Main` được truyền vào. Trong stack, một khung mới được tạo cho `changeX(Main)`, và tham chiếu tới `obj` được sao chép vào biến địa phương.
  - Thực thi: Tham chiếu này trỏ đến cùng một đối tượng trên heap như tham chiếu ban đầu trong `main`. Do đó, khi thuộc tính `x` của đối tượng được thay đổi thành `10` trong phương thức, nó thực sự thay đổi đối tượng trên heap.
  - Kết quả: `System.out.println(obj.x); // -> 10` - Giá trị của `x` trong đối tượng `obj` được cập nhật thành `10` do sự thay đổi trực tiếp trên đối tượng trên heap.

Chi tiết như sau:

<div align = "center">

![Minh họa 5](images\05.png)

</div>

- Phương thức `changeX()` của lớp `Main`:
  - Gọi phương thức: `obj.changeX()`: Phương thức này là một phương thức phi tĩnh của lớp `Main`, do đó nó cần một thực thể của lớp để gọi.
  - Thực thi: Trong phương thức này, `this.x = 20`; đề cập đến biến `x` của đối tượng `obj` thông qua từ khóa `this`, chỉ thị rằng thay đổi nên áp dụng cho đối tượng mà phương thức được gọi từ.
  - Kết quả: `System.out.println(obj.x); // -> 20` - Giá trị của `x` được thay đổi thành `20` trên cùng một đối tượng `obj` trên heap.
