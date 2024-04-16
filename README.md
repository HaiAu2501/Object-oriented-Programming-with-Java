# Lập trình hướng đối tượng với Java

![intro](images/logo.png)

## Mục lục

<details>
<summary>Phần 1: Giới thiệu</summary>

- [**Enter Java**](#bắt-đầu-với-java)
  - Máy ảo Java
  - So sánh Java với các ngôn ngữ lập trình khác
  - Tính an toàn của thiết kế và triển khai
- [**Introduction**](1.%20Introduction/)
  - [HelloWorld](1.%20Introduction/HelloWorld.java)
  - [HelloJava](1.%20Introduction/HelloJava.java)
  - [DataTypes](1.%20Introduction/DataTypes.java)
  - [Wrappers](1.%20Introduction/Wrappers.java)
  - [Boxing](1.%20Introduction/Boxing.java)
  - [Arrays](1.%20Introduction/Arrays.java)
  - [ArgumentPassing](1.%20Introduction/ArgumentPassing.java)
  - [MethodOverloading](1.%20Introduction/MethodOverloading.java)
  - [ObjectsInJava](1.%20Introduction/ObjectsInJava.java)
  - [ObjectCreation](1.%20Introduction/ObjectCreation.java)
  - [ObjectDestruction](1.%20Introduction/ObjectDestruction.java)
  - [ThisReference](1.%20Introduction/ThisReference.java)

</details>

<details>

<summary>Phần 2: Nguyên lý lập trình hướng đối tượng</summary>

- [**Object-oriented Programming Principles**](2.%20Object-oriented%20Programming%20Principles/)
  - [Subclass](2.%20Object-oriented%20Programming%20Principles/Subclass.java)

</details>

<details>

<summary>Phần 3: Cấu trúc dữ liệu và thuật toán</summary>

- [**Data Structures and Algorithms**](3.%20Data%20Structures%20and%20Algorithms/)

</details>

<details>

<summary>Phụ lục</summary>

- [**Tài liệu tham khảo**](#tài-liệu-tham-khảo)

</details>

## Bắt đầu với Java

<details>

<summary>1. Máy ảo Java</summary>

Java vừa là ngôn ngữ lập trình vừa được **biên dịch** (complied) vừa được **thông dịch** (interpreted). Mã nguồn Java được chuyển thành các lệnh nhị phân đơn giản, giống như mã máy của vi xử lý thông thường. Tuy nhiên, trong khi mã nguồn C hoặc C++ được biến đổi thành các lệnh bản địa cho một mô hình vi xử lý cụ thể, mã nguồn Java được biên dịch thành một định dạng chung - các lệnh cho một máy ảo.

Bytecode Java được thực thi bởi JVM, một máy ảo tiêu chuẩn hóa hoạt động như một bộ xử lý giả lập. JVM giúp Java có khả năng chạy được trên nhiều nền tảng khác nhau mà không cần sửa đổi mã - tính *viết một lần, chạy mọi nơi* (write once, run anywhere).

JVM cung cấp một môi trường thực thi an toàn, nơi nó thực hiện các chức năng tương tự như một hệ điều hành. Nó quản lý bộ nhớ, thực thi các lệnh dựa trên ngăn xếp, và xử lý các kiểu dữ liệu nguyên thủy. Việc này giảm thiểu các rủi ro bảo mật và tăng tính ổn định của ứng dụng.

</details>

- *Đơn vị cơ bản của mã Java là lớp (class)*. Trong Java và các ngôn ngữ hướng đối tượng khác, lớp là thành phần ứng dụng chứa mã thực thi và dữ liệu.

- Lớp được lưu trữ và tải một cách động khi ứng dụng cần tới, điều này cho phép Java quản lý hiệu quả các tài nguyên và chỉ tải những gì cần thiết.

- Java mang lại một số tính năng quản lý bộ nhớ tiên tiến để cải thiện an toàn, khả năng di động, và khả năng tối ưu hóa. Java loại bỏ các con trỏ linh tinh có thể tham chiếu tới bất kỳ khu vực nào trong bộ nhớ và thêm thu gom rác (garbage collection) cùng mảng cấp cao vào ngôn ngữ.

- Mặc dù Java không có con trỏ theo nghĩa truyền thống, nó cung cấp các **tham chiếu**, một loại con trỏ an toàn. Tất cả đối tượng trong Java, ngoại trừ các kiểu số nguyên thủy, đều được truy cập qua các tham chiếu. Bạn có thể sử dụng các tham chiếu để xây dựng các cấu trúc dữ liệu thông thường mà một lập trình viên C sẽ làm với con trỏ, nhưng phải theo cách an toàn về kiểu dữ liệu. Khác với con trỏ, bạn không thể sử dụng các thao tác số học trên tham chiếu để thay đổi giá trị của chúng; chúng chỉ có thể chỉ đến các đối tượng cụ thể hoặc các phần tử của mảng. Tham chiếu là một thực thể nguyên tử; bạn không thể thao túng giá trị của một tham chiếu ngoài việc gán nó cho một đối tượng. Sự bảo vệ này là một trong những khía cạnh cơ bản nhất của an ninh Java, đảm bảo rằng mã Java phải tuân theo các quy tắc; nó không thể nhìn trộm vào những nơi không được phép.

## Tài liệu tham khảo

- Patrick Niemeyer, Jonathan Knudsen; *Learning Java*; Third Edition.
- Marc Loy, Patrick Niemeyer, Jonathan Knudsen; *Learning Java: An Introduction to Real-World Programming with Java*; Fifth Edition.
