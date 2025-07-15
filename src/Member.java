import java.util.ArrayList;
import java.util.List;

public class Member {
    private String maNguoiDoc;
    private String ten;
    private String diaChi;
    private String soDienThoai;
    private List<Borrowing> danhSachMuon;  // Danh sách các phiếu mượn

    public Member(String maNguoiDoc, String ten, String diaChi, String soDienThoai) {
        this.maNguoiDoc = maNguoiDoc;
        this.ten = ten;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.danhSachMuon = new ArrayList<>();
    }

    // Getter và Setter
    public String getMaNguoiDoc() { return maNguoiDoc; }
    public String getTen() { return ten; }
    public String getDiaChi() { return diaChi; }
    public String getSoDienThoai() { return soDienThoai; }
    public List<Borrowing> getDanhSachMuon() { return danhSachMuon; }

    public void muonSach(Borrowing borrowing) {
        danhSachMuon.add(borrowing);
    }

    @Override
    public String toString() {
        return "Member{" +
                "maNguoiDoc='" + maNguoiDoc + '\'' +
                ", ten='" + ten + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", số sách mượn=" + danhSachMuon.size() +
                '}';
    }
}
