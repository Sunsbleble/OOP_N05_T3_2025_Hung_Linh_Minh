public class TestSach {
    public static void main(String[] args) {
        Sach sach1 = new Sach("S001", "Lập trình Java", "Nguyễn Văn A", "NXB FPT", 2023, "Công nghệ", 100);
        Sach sach2 = new Sach("S002", "Lập trình Python", "Trần Thị B", "NXB Trẻ", 2022, "Công nghệ", 50);

        System.out.println("Thông tin sách 1:");
        sach1.displayInfo();
        System.out.println();

        System.out.println("Thông tin sách 2:");
        sach2.displayInfo();
        System.out.println();

        sach1.settensach("Lập trình Java nâng cao");
        sach1.setsoluong(120);
        
        System.out.println("Thông tin sách 1 sau khi cập nhật:");
        sach1.displayInfo();
    }
}
