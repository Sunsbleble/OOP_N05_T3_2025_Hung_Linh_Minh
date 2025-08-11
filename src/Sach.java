public class Sach {
private String maSach;
private String tenSach;
private String tacGia;
private String theLoai;
private boolean daMuon;

public Sach(String maSach, String tenSach, String tacGia, String theLoai) {
this.maSach = maSach;
this.tenSach = tenSach;
this.tacGia = tacGia;
this.theLoai = theLoai;
this.daMuon = false;
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

public boolean isDaMuon() {
return daMuon;
}

public void setDaMuon(boolean daMuon) {
this.daMuon = daMuon;
}

@Override
public String toString() {
return maSach + " | " + tenSach + " | " + tacGia + " | " + theLoai + " | " + (daMuon ? "Đã mượn" : "Chưa mượn");

}
}

