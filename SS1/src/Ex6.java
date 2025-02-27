public class Ex6 {
    public static void main(String[] args) {
        /*
1. Vai trò và sự khác biệt giữa JDK, JRE và JVM trong hệ sinh thái Java
JVM (Java Virtual Machine): Đây là máy ảo Java, một thành phần cốt lõi trong hệ sinh thái Java, chịu trách nhiệm thực thi mã bytecode (mã được biên dịch từ mã nguồn Java). JVM đóng vai trò như một "môi trường chạy" độc lập với nền tảng, giúp chương trình Java có thể hoạt động trên bất kỳ hệ điều hành nào miễn là có JVM tương ứng được cài đặt. JVM bao gồm các thành phần như bộ nạp lớp (class loader), bộ quản lý bộ nhớ (garbage collector), và bộ thực thi (execution engine).
JRE (Java Runtime Environment): Đây là môi trường chạy Java, bao gồm JVM và các thư viện chuẩn (Java Class Library) cần thiết để chạy các ứng dụng Java. JRE được thiết kế dành cho người dùng cuối, những người chỉ cần chạy chương trình Java mà không cần phát triển chúng. Nói cách khác, nếu bạn chỉ muốn sử dụng một ứng dụng Java đã được viết sẵn, bạn chỉ cần cài JRE.
JDK (Java Development Kit): Đây là bộ công cụ phát triển Java, bao gồm JRE (với JVM bên trong) và các công cụ bổ sung như trình biên dịch Java (javac), công cụ gỡ lỗi (debugger), và các tiện ích khác để lập trình viên viết, biên dịch, và kiểm tra mã Java. JDK dành cho các nhà phát triển muốn tạo ứng dụng Java từ đầu.
Mối quan hệ giữa JDK, JRE và JVM:

JVM là một phần của JRE, cung cấp khả năng thực thi chương trình.
JRE là một phần của JDK, cung cấp môi trường chạy chương trình.
JDK bao gồm tất cả: JRE (với JVM) và các công cụ phát triển.
Tóm lại: JDK ⊃ JRE ⊃ JVM.
2. Khái niệm "Write once, run anywhere" trong Java
"Write once, run anywhere" (WORA) là triết lý cốt lõi của Java, nghĩa là một chương trình Java được viết một lần có thể chạy trên bất kỳ nền tảng nào (Windows, macOS, Linux, v.v.) mà không cần viết lại mã hoặc biên dịch lại cho từng hệ điều hành.

Cơ chế giúp Java đạt được WORA:

Mã bytecode trung gian: Khi bạn viết mã Java và biên dịch bằng trình biên dịch javac (trong JDK), mã nguồn không được chuyển trực tiếp thành mã máy (machine code) mà thành mã bytecode (.class files). Bytecode là một dạng mã trung gian, độc lập với phần cứng và hệ điều hành.
JVM đa nền tảng: Mỗi hệ điều hành có một phiên bản JVM riêng, được thiết kế để dịch bytecode thành mã máy phù hợp với phần cứng và hệ điều hành đó. Do đó, chỉ cần cài đặt JVM tương ứng, chương trình Java sẽ chạy được mà không cần thay đổi mã nguồn.
Thư viện chuẩn Java: Các thư viện trong JRE được thiết kế để hoạt động nhất quán trên mọi nền tảng, giúp loại bỏ sự khác biệt về hệ điều hành.
Ví dụ: Một tệp .class được biên dịch trên Windows có thể chạy trên Linux miễn là Linux có JVM tương thích.

3. Quy trình cài đặt và chạy chương trình Java đầu tiên bằng IntelliJ IDEA
Dưới đây là các bước cơ bản để tạo và chạy một dự án Java đơn giản trong IntelliJ IDEA:

Bước 1: Cài đặt môi trường
Tải và cài JDK: Truy cập trang web chính thức của Oracle hoặc AdoptOpenJDK, tải phiên bản JDK mới nhất (ví dụ: JDK 17 hoặc 21), và cài đặt trên máy tính.
Tải IntelliJ IDEA: Tải phiên bản Community (miễn phí) hoặc Ultimate (trả phí) từ trang web JetBrains, sau đó cài đặt.
Bước 2: Tạo dự án Java cơ bản
Mở IntelliJ IDEA: Khởi động phần mềm.
Tạo dự án mới:
Nhấn "File" > "New" > "Project".
Chọn "Java" trong danh sách bên trái.
Trong phần "Project SDK", chọn phiên bản JDK đã cài (nếu chưa có, nhấn "New" để thêm đường dẫn đến JDK).
Nhấn "Next", đặt tên dự án (ví dụ: "HelloWorld"), và nhấn "Finish".
Tạo lớp Java:
Trong thư mục src, nhấp chuột phải > "New" > "Java Class".
Đặt tên lớp (ví dụ: Main) và chọn "Class".
IntelliJ sẽ tạo một tệp Main.java.
Bước 3: Viết mã đơn giản
Thay nội dung tệp Main.java bằng đoạn mã sau:
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
Bước 4: Chạy chương trình
Nhấn nút "Run" (biểu tượng tam giác xanh) bên cạnh phương thức main hoặc chọn "Run" > "Run 'Main'".
IntelliJ sẽ biên dịch và chạy chương trình. Kết quả "Hello, World!" sẽ hiển thị trong cửa sổ Console bên dưới.
Lưu ý:
Nếu gặp lỗi, kiểm tra lại cấu hình JDK trong "File" > "Project Structure" > "SDKs".
Đảm bảo tệp .java nằm trong thư mục src của dự án.
4. Các phiên bản Java và sự khác biệt giữa Java SE, Java EE, Java ME
Java được chia thành ba phiên bản chính, mỗi phiên bản phục vụ mục đích và đối tượng khác nhau:

Java SE (Standard Edition):
Mục đích: Là phiên bản tiêu chuẩn, cung cấp nền tảng cơ bản để phát triển và chạy các ứng dụng Java trên máy tính cá nhân hoặc máy chủ đơn giản.
Đối tượng: Lập trình viên phát triển ứng dụng desktop, ứng dụng console, hoặc các chương trình cơ bản.
Tính năng: Bao gồm JVM, JRE, các thư viện chuẩn như java.util, java.io, và các công cụ như javac.
Ví dụ: Ứng dụng quản lý file, trò chơi đơn giản.
Java EE (Enterprise Edition):
Mục đích: Dành cho phát triển các ứng dụng doanh nghiệp lớn, phân tán, và chạy trên máy chủ (web, ứng dụng quản lý dữ liệu lớn).
Đối tượng: Các lập trình viên và doanh nghiệp xây dựng hệ thống phức tạp như website thương mại điện tử, hệ thống ngân hàng.
Tính năng: Xây dựng trên Java SE, bổ sung các API như Servlet, JSP, EJB, JPA để hỗ trợ phát triển web và quản lý cơ sở dữ liệu.
Ví dụ: Ứng dụng web như Apache Tomcat, hệ thống ERP.
Java ME (Micro Edition):
Mục đích: Thiết kế cho các thiết bị hạn chế tài nguyên như điện thoại di động cũ, thiết bị nhúng, hoặc IoT.
Đối tượng: Nhà phát triển ứng dụng cho thiết bị nhỏ gọn, ít bộ nhớ và sức mạnh xử lý.
Tính năng: Là phiên bản rút gọn của Java SE, tập trung vào hiệu suất và kích thước nhỏ, với các API tối ưu như MIDP (Mobile Information Device Profile).
Ví dụ: Game di động thời kỳ đầu (như Snake trên Nokia), ứng dụng nhúng.
*/
    }
}
