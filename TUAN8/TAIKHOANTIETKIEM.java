import java.util.Scanner;
public class TAIKHOANTIETKIEM extends TAIKHOAN{
    private double laiSuat;
    private int kyHan;
    private double soDuTietKiem;
    Scanner sc=new Scanner(System.in);
    public TAIKHOANTIETKIEM(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, String soDienThoai,
            double laiSuat, int kyHan, double soDuTietKiem) {
        super(soTaiKhoan, chuTaiKhoan, soDu, matKhau, soDienThoai);
        this.laiSuat = laiSuat;
        this.kyHan = kyHan;
        this.soDuTietKiem = soDuTietKiem;
    }
    //setter
    public void setLaiSuat(double laiSuat) {
        this.laiSuat = laiSuat;
    }
    public void setKyHan(int kyHan) {
        this.kyHan = kyHan;
    }
    public void setSoDuTietKiem(double soDuTietKiem) {
        this.soDuTietKiem = soDuTietKiem;
    }
    //getter
    public double getLaiSuat() {
        return laiSuat;
    }
    public int getKyHan() {
        return kyHan;
    }
    public double getSoDuTietKiem() {
        return soDuTietKiem;
    }
    public double tinhLai()
    {
        double s;
        s = this.getSoDuTietKiem();
        for(int i=1;i<=this.getKyHan();i++)
            s *= (1+this.getLaiSuat());
        return s;        
    }
    public void guiTietKiem(double tienTietKiem,TAIKHOAN tk)
    {
        if(tienTietKiem <= tk.getSoDu && tienTietKiem>0)
        {
            this.setSoDuTietKiem(this.getSoDuTietKiem()+tienTietKiem);
            tk.getSoDu -= tienTietKiem;
            System.out.println("Ban da gui tiet kiem: "+tienTietKiem+" VND");
            System.out.println("Sau ky han "+this.getKyHan()+" thang, se hoan tra "+this.tinhLai());
        }
        else
        {
            System.out.print("So tien khong hop le!");
            System.out.println("so du: "+getSoDu);
        }
    }
    
}
