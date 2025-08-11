public class Time {
    int gio;
    int phut;
    int giay;
    
    Time() {setTime(0,0,0);}
    Time(int h) {setTime(h,0,0);}
    Time(int h,int p) {setTime(h,p,0);}
    Time(int h, int p, int s) {setTime(h,p,s);}
}
Time setTime(int h, int p, int s) {
    setgio(h);
    setphut(p);
    setgiay(s);
    return this;
}
Time setgio(int h) {
    gio = ((h >= 0 && h< 24) ? h:0);
    return this;
}
Time setphut(int p) {
    phut = ((p >= 0 && p < 60) ? p:0);
    return this;
}
Time setgiay(int s) {
    giay = ((s >= 0 && s < 24) ? s:0);
    return this;
}
int getgio() { retrun gio;}
int getphut() { retrun phut;}
int getgiay() {retrun giay;}
public String toString() {
    return (""(gio == 12 || gio == 0) ? 12 : gio % 12)+":" +(phut < 10 ? "0" :"")+ phut + ":" + (giay < 10 ? "0" : "") + giay + ( gio < 12 ? "AM" : "PM");
}