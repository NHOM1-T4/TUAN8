import java.util.Scanner;
public class TAIKHOANTHANHTOAN extends TAIKHOAN{
    private double hanMuc;
    private double khaDung;
    Scanner sc= new Scanner(System.in);
    public TAIKHOANTHANHTOAN(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, String soDienThoai,
            double hanMuc, double khaDung) {
        super(soTaiKhoan, chuTaiKhoan, soDu, matKhau, soDienThoai);
        this.hanMuc = hanMuc;
        this.khaDung = khaDung;
    } 
    //setter
    public void setHanMuc(double hanMuc) {
        this.hanMuc = hanMuc;
    }
    public void setKhaDung(double khaDung) {
        this.khaDung = khaDung;
    }
    //getter
    public double getHanMuc() {
        return hanMuc;
    }
    public double getKhaDung() {
        return khaDung;
    }
    public void rutTien(double tienRut,TAIKHOAN tk)
    {
        if(tienRut <= this.khaDung)
        {
            khaDung -= tienRut;
            tk.getSoDu -= tienRut;
            System.out.println("Rut "+tienRut+" thanh cong!");
            System.out.println("so du tai khoan: "+tk.getSoDu);
        }
        else
            System.out.print("So du khong du de rut!");
    }
    public void thanhToan(double tienTT,TAIKHOAN tk)
    {
        if(tienTT <= this.khaDung)
        {
            khaDung -= tienTT;
            tk.getSoDu -= tienTT;
            System.out.println("Thanh toan thanh cong!");
            System.out.println("so du tai khoan: "+tk.getSoDu);
        }
        else
            System.out.print("So du khong du de thanh toan!");
    }
}
