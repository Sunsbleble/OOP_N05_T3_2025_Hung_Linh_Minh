public class Book {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private String nhaXuatBan;
    private int namXuatBan;
    private String theLoaiSach;
    private int soLuong;

    public Book(String maSach, String tenSach, String tacGia, String nhaXuatBan, int namXuatBan, String theLoaiSach, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.nhaXuatBan = nhaXuatBan;
        this.namXuatBan = namXuatBan;
        this.theLoaiSach = theLoaiSach;
        this.soLuong = soLuong;
    }

    // Getters và setters
    public String getMaSach() { return maSach; }
    public String getTenSach() { return tenSach; }
    public String getTacGia() { return tacGia; }
    public String getNhaXuatBan() { return nhaXuatBan; }
    public int getNamXuatBan() { return namXuatBan; }
    public String getTheLoaiSach() { return theLoaiSach; }
    public int getSoLuong() { return soLuong; }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "Book{" +
                "maSach='" + maSach + '\'' +
                ", tenSach='" + tenSach + '\'' +
                ", tacGia='" + tacGia + '\'' +
                ", nhaXuatBan='" + nhaXuatBan + '\'' +
                ", namXuatBan=" + namXuatBan +
                ", theLoaiSach='" + theLoaiSach + '\'' +
                ", soLuong=" + soLuong +
                '}';
    }
}
