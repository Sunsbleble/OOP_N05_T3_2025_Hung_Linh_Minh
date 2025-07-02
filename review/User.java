public class User {
    private String ten;
    private int tuoi;
    private String email;

    public User(String ten, int tuoi, String email){
        this.ten = ten;
        this.tuoi = tuoi;
        this.email = email;
    }
     
    public String  getTen(){
        return ten;
    }

    public void setTen(String ten){
        this.ten = ten;
    }

    public int getTuoi(){
        return tuoi;
    }

    public void setTuoi(int tuoi){
        this.tuoi = tuoi;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
