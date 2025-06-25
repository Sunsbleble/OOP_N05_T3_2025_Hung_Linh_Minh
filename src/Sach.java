public class Sach{
    private String  masach;
    private String tensach;
    private String tacgia;
    private String nhaxuatban;
    private int namxuatban;
    private String theloaisach;
    private int soluong;

    //Constructor
    public Sach(String masach, String tensach, String tacgia, String nhaxuatban, int namxuatban, String theloaisach, int soluong ){
        this.masach = masach;
        this.tensach = tensach;
        this.tacgia = tacgia;
        this.nhaxuatban = nhaxuatban;
        this.namxuatban = namxuatban;
        this.theloaisach = theloaisach;
        this.soluong = soluong;
    }
    //Getter and Setter
    public String getmasach(){
        return masach;
    }
    public void setmasach(String masach){
        this.masach = masach;
    }
    public String gettensach(){
        return tensach;
    }
    public void settensach(String tensach){
        this.tensach = tensach;
    }
    public String gettacgia(){
        return tacgia;
    }
    public void settacgia(String tacgia){
        this.tacgia = tacgia;
    }
    public String getnhaxuatban(){
        return nhaxuatban;
    }
    public void setnhaxuatban(String nhaxuatban){
        this.nhaxuatban = nhaxuatban;
    }
    public int getnamxuatban(){
        return namxuatban;
    }
    public void setnamxuatban(int namxuatban){
        this.namxuatban = namxuatban;
    }
    public String gettheloaisach(){
        return theloaisach;
    }
    public void settheloaisach(String theloaisach){
        this.theloaisach = theloaisach;
    }
    public int getsoluong(){
        return soluong;
    }
    public void setsoluong(int soluong){
        this.soluong = soluong;
    }
    public void displayInfo(){
        System.out.println("Mã sách: " + masach);
        System.out.println("Tên sách: " + tensach);
        System.out.println("Tác giả: " + tacgia);
        System.out.println("Nhà xuất bản: " + nhaxuatban);
        System.out.println("Năm xuất bản: " + namxuatban);
        System.out.println("Thể loại sách: " + theloaisach);
        System.out.println("Số lượng sách: " + soluong);
    }
}