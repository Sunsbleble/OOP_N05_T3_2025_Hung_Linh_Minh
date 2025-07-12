import java.util.ArrayList;
import java.util.Scanner;

public class MemberCRUD {
    // Lớp đại diện cho Người đọc
    static class Member {
        private String id;
        private String name;
        private String email;

        public Member(String id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Tên: " + name + ", Email: " + email;
        }
    }

    // Danh sách người đọc
    static ArrayList<Member> members = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== QUẢN LÝ NGƯỜI ĐỌC (Member CRUD) =====");
            System.out.println("1. Tạo người đọc");
            System.out.println("2. Đọc thông tin người đọc");
            System.out.println("3. Sửa thông tin người đọc");
            System.out.println("4. Xoá người đọc");
            System.out.println("5. Thoát");
            System.out.print("Chọn thao tác: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> createMember();
                case 2 -> readMember();
                case 3 -> updateMember();
                case 4 -> deleteMember();
                case 5 -> {
                    System.out.println(">> Kết thúc chương trình.");
                    return;
                }
                default -> System.out.println(">> Lựa chọn không hợp lệ!");
            }
        }
    }

    // Thêm người đọc
    public static void createMember() {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();
        System.out.print("Nhập tên: ");
        String name = sc.nextLine();
        System.out.print("Nhập email: ");
        String email = sc.nextLine();

        members.add(new Member(id, name, email));
        System.out.println(">> Đã thêm người đọc.");
    }

    // Đọc thông tin người đọc
    public static void readMember() {
        System.out.print("Nhập ID cần tìm: ");
        String id = sc.nextLine();
        Member m = findById(id);
        if (m != null) {
            System.out.println(">> Thông tin người đọc:");
            System.out.println(m);
        } else {
            System.out.println(">> Không tìm thấy người đọc.");
        }
    }

    // Sửa thông tin
    public static void updateMember() {
        System.out.print("Nhập ID cần sửa: ");
        String id = sc.nextLine();
        Member m = findById(id);
        if (m != null) {
            System.out.print("Nhập tên mới: ");
            m.setName(sc.nextLine());
            System.out.print("Nhập email mới: ");
            m.setEmail(sc.nextLine());
            System.out.println(">> Đã cập nhật thông tin.");
        } else {
            System.out.println(">> Không tìm thấy người đọc.");
        }
    }

    // Xoá người đọc
    public static void deleteMember() {
        System.out.print("Nhập ID cần xoá: ");
        String id = sc.nextLine();
        Member m = findById(id);
        if (m != null) {
            members.remove(m);
            System.out.println(">> Đã xoá người đọc.");
        } else {
            System.out.println(">> Không tìm thấy người đọc.");
        }
    }

    // Tìm người đọc theo ID
    public static Member findById(String id) {
        for (Member m : members) {
            if (m.getId().equalsIgnoreCase(id)) {
                return m;
            }
        }
        return null;
    }
}
