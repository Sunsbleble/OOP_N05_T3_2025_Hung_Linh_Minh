import java.text.SimpleDateFormat;
import java.util.Date;

public class Borrowing {
    private String maMuon;
    private Books sachMuon;
    private Member nguoiMuon;
    private Date ngayMuon;

    public Borrowing(String maMuon, Books sachMuon, Member nguoiMuon, Date ngayMuon) {
        this.maMuon = maMuon;
        this.sachMuon = sachMuon;
        this.nguoiMuon = nguoiMuon;
        this.ngayMuon = ngayMuon;
    }

    // Getter và Setter
    public String getMaMuon() { return maMuon; }
    public Books getSachMuon() { return sachMuon; }
    public Member getNguoiMuon() { return nguoiMuon; }
    public Date getNgayMuon() { return ngayMuon; }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Borrowing{" +
                "maMuon='" + maMuon + '\'' +
                ", sachMuon=" + sachMuon.getTenSach() +
                ", nguoiMuon=" + nguoiMuon.getTen() +
                ", ngayMuon=" + sdf.format(ngayMuon) +
                '}';
    }
}
