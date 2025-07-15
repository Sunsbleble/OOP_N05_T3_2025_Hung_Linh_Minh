public class App {
    public static void main(String[] args) {
        System.out.println("==== Chạy các bài kiểm thử Project Quản lý Thư viện ====\n");

        BookTest
        .runTests();
        MemberTest.runTests();
        BorrowingTest.runTests();

        System.out.println("\n==== Kết thúc chương trình ====");
    }
}
