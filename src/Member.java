
public class Member {
    private String memberID;   // Mã người đọc duy nhất
    private String name;       // Tên người đọc
    private String address;    // Địa chỉ
    private String phone;      // Số điện thoại

    public Member(String memberID, String name, String address, String phone) {
        this.memberID = memberID;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    // Getter và Setter
    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
