public class Sach {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private String theLoai;

    public Sach(String maSach, String tenSach, String tacGia, String theLoai) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.theLoai = theLoai;
    }

    public String getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public String getTheLoai() {
        return theLoai;
    }

    @Override
    public String toString() {
        return maSach + " | " + tenSach + " | " + tacGia + " | " + theLoai;
    }
}
