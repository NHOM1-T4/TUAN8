import java.util.Random;
import java.util.Scanner;
public class TAIKHOAN 
{
    private String soTaiKhoan;
    private String chuTaiKhoan;
    private double soDu;
    private String matKhau;
    private String soDienThoai;
    Scanner sc= new Scanner(System.in);
    public double getSoDu;
    public TAIKHOAN(){
    }
    public TAIKHOAN(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, String soDienThoai) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
        this.matKhau = matKhau;
        this.soDienThoai = soDienThoai;
    }
    //setter
    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }
    public void setChuTaiKhoan(String chuTaiKhoan) {
        this.chuTaiKhoan = chuTaiKhoan;
    }
    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    //getter
    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }
    public String getChuTaiKhoan() {
        return chuTaiKhoan;
    }
    public double getSoDu() {
        return soDu;
    }
    public String getMatKhau() {
        return matKhau;
    }
    public String getSoDienThoai() {
        return soDienThoai;
    }
    public static boolean kiemTraMatKhauManh(String matKhau) 
    {
        return matKhau.length() >=5 &&
                matKhau.matches(".*\\d.*") && 
                matKhau.matches(".*[a-zA-Z].*") &&
                matKhau.matches(".*[!@#$%^&*()].*");
    }
    public boolean kiemTraMatKhau(String matKhau)
    {
        return this.matKhau.equals(matKhau);
    }
    // Phương thức đổi mật khẩu
    public void doiMatKhau()
    {
        System.out.println("nhap mat khau cu: ");
        String matKhauCu = sc.nextLine();
        if(kiemTraMatKhau(matKhauCu))
        {
            System.out.println("nhap mat khau moi: ");
            String matKhauMoi = sc.nextLine();
            if(kiemTraMatKhauManh(matKhauMoi))
            {
                matKhau = matKhauMoi;
                System.out.println("doi mat khau thanh cong");
            }
            else
                System.out.println("mat khau moi khong du manh");
        }
        else    
            System.out.println("mat khau cu khong chinh xac");
    }
    public void guiTien(double tienGui) {
        this.soDu += tienGui;
        System.out.println("Da gui "+tienGui+" vao stk: "+this.soTaiKhoan);
        System.out.println("So du hien tai: "+this.soDu);
    }

    public void rutTien(double tienRut) {
        if(tienRut <= this.soDu) {
            this.soDu -= tienRut;
            System.out.println("Da rut "+tienRut);
            System.out.println("So du hien tai: "+this.soDu);
        } else
            System.out.println("So du khong cua ban khong du de thuc hien giao dich!");
    }
    public void kiemTraSoDu() {
        System.out.println("So tai khoan   : "+this.soTaiKhoan);
        System.out.println("Chu tai khoan  : "+this.chuTaiKhoan);
        System.out.println("So du          : "+this.soDu);
    }
    // Phương thức tạo OTP
    public String taoOTP()
    {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        System.out.println("OTP da gui toi so dien thoai "+soDienThoai+": "+otp);
        return String.valueOf(otp);
    }
    // Phương thức quên mật khẩu (OTP)
    public void quenMatKhau()
    {
        String otp = taoOTP();
        System.out.println("nhap ma OTP: ");
        String otpNhap = sc.nextLine();
        if(otp.equals(otpNhap))
        {
            System.out.println("nhap mat khau moi: ");
            String matKhauMoi = sc.nextLine();
            if(kiemTraMatKhauManh(matKhauMoi))
            {
                matKhau = matKhauMoi;
                System.out.println("doi mat khau thanh cong");
            }
            else   
                System.out.println("mat khau moi khong du manh");
        }
        else
            System.out.println("OTP khong chinh xac");
    }
}
