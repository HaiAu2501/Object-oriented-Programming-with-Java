# Lập trình hướng đối tượng với Java

![intro](images/logo.png)

Chào mừng bạn đến với kho lưu trữ **Lập trình hướng đối tượng với Java**! Nơi đây cung cấp một nguồn tài nguyên toàn diện để khám phá và học hỏi lập trình hướng đối tượng qua ngôn ngữ Java.

> Lập trình hướng đối tượng (OOP - Object-Oriented Programming) là một mô hình lập trình phổ biến được sử dụng rộng rãi trong phát triển phần mềm. Nó được dựa trên các khái niệm về "đối tượng", là các thực thể kết hợp cả dữ liệu (thuộc tính) và các phương thức (hành vi). OOP tập trung vào việc thiết kế phần mềm dựa trên các đối tượng tương tác với nhau, thay vì quy trình và logic như trong lập trình hướng thủ tục.

<details>

<summary> Các nguyên tắc cơ bản của lập trình hướng đối tượng</summary>
<br/>

Lập trình hướng đối tượng dựa trên 4 nguyên tắc cơ bản, đó là: Đóng gói, Kế thừa, Đa hình, và Trừu tượng hóa. Mỗi nguyên tắc này cung cấp một cách tiếp cận để giải quyết các vấn đề trong phát triển phần mềm và giúp quản lý mã nguồn một cách hiệu quả hơn.

- **Đóng gói** (Encapsulation): Đây là khái niệm che giấu chi tiết triển khai bên trong của đối tượng, ngăn người dùng trực tiếp truy cập vào dữ liệu bên trong. Đóng gói giúp bảo vệ dữ liệu và hành vi của đối tượng khỏi sự can thiệp không mong muốn và cung cấp một giao diện thống nhất để tương tác với đối tượng.

- **Kế thừa** (Inheritance): Kế thừa cho phép một lớp mới kế thừa các thuộc tính và phương thức từ một lớp đã có sẵn. Lớp mới này có thể bổ sung thêm hoặc sửa đổi các thành phần thừa kế để đáp ứng nhu cầu riêng của nó, giúp tái sử dụng và mở rộng mã nguồn một cách hiệu quả.

- **Đa hình** (Polymorphism): Đa hình là khả năng mà theo đó các lớp khác nhau có thể được sử dụng thông qua cùng một giao diện. Phương thức có thể được định nghĩa trong một lớp cơ sở và được thay thế bởi các phương thức có cùng tên trong các lớp dẫn xuất, cho phép các đối tượng được xử lý thông qua giao diện chung mà không cần biết kiểu dữ liệu cụ thể của chúng.

- **Trừu tượng hóa** (Abstraction): Trừu tượng hóa cho phép lập trình viên tập trung vào những gì một đối tượng làm mà không cần quan tâm đến cách thực hiện. Nó tạo ra một lớp cơ sở mô tả một giao diện tổng quát mà các lớp dẫn xuất sẽ thực thi, đơn giản hóa việc quản lý sự phức tạp của hệ thống.

</details>

<details>

<summary>Ưu điểm của lập trình hướng đối tượng</summary>
<br/>

Lập trình hướng đối tượng mang lại nhiều ưu điểm vượt trội trong phát triển phần mềm, giúp nó trở thành một trong những mô hình thiết kế và lập trình chính trong ngành công nghệ thông tin. Dưới đây là những ưu điểm của nó:

- **Tái sử dụng mã**: OOP cho phép lập trình viên sử dụng lại mã nguồn thông qua cơ chế kế thừa. Lớp con có thể kế thừa tính năng từ lớp cha mà không cần phải viết lại mã đó. Điều này giúp giảm bớt lượng công việc lập trình, giảm thiểu các lỗi tiềm ẩn và tăng tốc độ phát triển phần mềm.

- **Dễ dàng bảo trì và sửa lỗi**: Cấu trúc đóng gói trong OOP giúp che giấu chi tiết triển khai, chỉ cung cấp giao diện (interface) cần thiết cho người dùng. Điều này làm cho việc bảo trì và cập nhật hệ thống trở nên dễ dàng hơn, vì thay đổi bên trong một đối tượng không ảnh hưởng tới các đối tượng khác.

- **Mô hình hóa thực tiễn**: OOP cho phép lập trình viên mô hình hóa các thực thể thực tế dưới dạng đối tượng phần mềm, làm cho mã nguồn dễ hiểu và quản lý hơn. Việc sử dụng các đối tượng như là biểu diễn của dữ liệu và hành vi trong thế giới thực giúp phát triển phần mềm trở nên trực quan và gần gũi hơn với người lập trình.

- **Tính mở rộng**: Nhờ vào khả năng kế thừa và đóng gói, OOP dễ dàng mở rộng. Một lớp mới có thể được tạo ra với sự kế thừa từ một hoặc nhiều lớp đã tồn tại mà không làm ảnh hưởng tới những lớp đó. Điều này giúp hệ thống phát triển một cách linh hoạt và thích ứng với nhu cầu mới một cách nhanh chóng.

- **Tính bảo mật**: Đóng gói không chỉ giúp ẩn đi chi tiết triển khai mà còn cung cấp một lớp bảo mật. Dữ liệu bên trong một đối tượng được bảo vệ khỏi sự truy cập trực tiếp từ bên ngoài, đảm bảo tính toàn vẹn và an toàn của dữ liệu.

</details>

<details>

<summary>Lý do bắt đầu học lập trình hướng đối tượng bằng Java</summary>
<br/>

Java là một trong những ngôn ngữ lập trình phổ biến nhất được sử dụng để giảng dạy lập trình hướng đối tượng vì nhiều lý do chính đáng.

- **Java là một ngôn ngữ thuần túy hướng đối tượng**, nghĩa là mọi thứ trong Java đều là đối tượng hoặc lớp. Các khái niệm như kế thừa, đóng gói, đa hình, và trừu tượng hoàn toàn được tích hợp sẵn trong ngôn ngữ. Điều này giúp người học dễ dàng tiếp cận và thực hành các nguyên lý OOP một cách tự nhiên trong quá trình lập trình.

- **Java có cú pháp khá rõ ràng và dễ hiểu.** Cú pháp của Java dựa trên C/C++, nhưng đã loại bỏ một số tính năng phức tạp như con trỏ trực tiếp, làm cho nó trở thành ngôn ngữ lý tưởng để giảng dạy cho người mới bắt đầu. Việc loại bỏ những tính năng phức tạp này giúp người học tập trung vào việc hiểu các khái niệm cốt lõi của OOP mà không bị sa lầy vào các chi tiết khó hiểu.

- **Java là ngôn ngữ độc lập nền tảng**, có thể chạy trên bất kỳ hệ điều hành nào có máy ảo Java (JVM). Điều này có nghĩa là các chương trình Java có thể phát triển và thực thi một cách nhất quán trên các nền tảng khác nhau mà không cần thay đổi mã. Sự linh hoạt này là lý tưởng cho môi trường học tập, nơi sinh viên và giáo viên có thể sử dụng nhiều loại phần cứng và phần mềm.

</details>

## Mục lục

Trong khi sử dụng kho lưu trữ này cho việc học tập, bạn nên tuân theo nguyên tắc sắp xếp được đề cập sau đây. Hãy đọc các mục theo đúng quy tắc từ trên xuống dưới, những phần đầu tiên sẽ là cơ sở của những nội dung tiếp theo. Riêng phần *Phụ lục* bạn có thể tham khảo bất cứ lúc nào, nó chứa một số cuốn sách tôi sử dụng cho việc thiết kế nên kho lưu trữ này.<br/>

<details>
<summary>Phần 1: Giới thiệu</summary>
<br/>

- [**Bắt đầu với Java**](#bắt-đầu-với-java)
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
<br/>

- [**Object-oriented Programming Principles**](2.%20Object-oriented%20Programming%20Principles/)
  - [Subclass](2.%20Object-oriented%20Programming%20Principles/Subclass.java)

</details>

<details>

<summary>Phần 3: Cấu trúc dữ liệu và thuật toán</summary>
<br/>

- [**Data Structures and Algorithms**](3.%20Data%20Structures%20and%20Algorithms/)

</details>

<details>

<summary>Phụ lục</summary>
<br/>

- [**Tài liệu tham khảo**](#tài-liệu-tham-khảo)
- [**Tải xuống tài liệu tham khảo**](documents)

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
