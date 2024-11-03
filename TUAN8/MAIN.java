import java.util.Scanner;
public class MAIN {
    static String soTaiKhoan;
    static String password;
    static int soLanSai=0;

    static void thanhCong(TAIKHOAN tk)
    {
        Scanner sc =new Scanner(System.in);
        int luaChon;
        System.out.println("Xin chao chu tai khoan: "+tk.getChuTaiKhoan()+"!");
        final TAIKHOANTIETKIEM tktk =new TAIKHOANTIETKIEM(tk.getSoTaiKhoan(),tk.getChuTaiKhoan(),tk.getSoDu(),tk.getMatKhau(),tk.getSoDienThoai(),0.05,12,0);
        TAIKHOANTHANHTOAN tktt=new TAIKHOANTHANHTOAN(tk.getSoTaiKhoan(), tk.getChuTaiKhoan(),tk.getSoDu(),tk.getMatKhau(),tk.getSoDienThoai(),5000000,2000000);
        tktk.setLaiSuat(0.05);
        do
        {
            System.out.println("\n---TAI KHOAN NGAN HANG---");
            System.out.println("1. Rut tien");
            System.out.println("2. Gui tien");
            System.out.println("3. Kiem tra so du");
            System.out.println("4. Doi mat khau");
            System.out.println("5. Quen mat khau");
            System.out.println("6. Tai khoan thanh toan");
            System.out.println("7. Tai khoan tiet kiem");
            System.out.println("8. Dang xuat");
            System.out.println("Nhap vao lua chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch(luaChon)
            {
                case 1:
                    System.out.println("Nhap so tien can rut: ");
                    double tienRut = sc.nextDouble();
                    tk.rutTien(tienRut);
                    break;
                case 2:
                    System.out.println("Nhap vao so tien can gui: ");
                    double tienGui = sc.nextDouble();
                    tk.guiTien(tienGui);
                    break;
                case 3:
                    tk.kiemTraSoDu();
                    break;
                case 4:
                    tk.doiMatKhau();
                    break;
                case 5:
                    tk.quenMatKhau();
                    break;
                case 6:
                    int luaChonThanhToan;
                    System.out.println("--TAI KHOAN THANH TOAN---");
                    System.out.println("so du tai khoan: "+tk.getSoDu);
                    System.out.println("Han muc kha dung: "+tktt.getHanMuc());
                    System.out.println("""
                        1. Rut tien
                        2. Thanh toan
                        Nhap vao lua chon:
                    """);
                    luaChonThanhToan = sc.nextInt();
                    sc.nextLine();
                    switch (luaChonThanhToan) {
                        case 1:
                            System.out.println("Nhap vao so tien can rut: ");
                            double tienRutTT = sc.nextDouble();
                            sc.nextLine();
                            tktt.rutTien(tienRutTT, tk);
                            break;
                        case 2:
                            System.out.println("Nhap vao so tien can thanh toan: ");
                            double tienTT = sc.nextDouble();
                            sc.nextLine();
                            tktt.thanhToan(tienTT,tk);
                            break;
                        default:
                            break;
                    }
                    break;
                case 7:
                    System.out.println("---TAI KHOAN TIET KIEM---");
                    if(tktk.getSoDuTietKiem() == 0)
                    {
                        double tienTietKiem;
                        int kyHan;
                        System.out.println("lai suat la: "+tktk.getLaiSuat()*100+"%/thang");
                        System.out.println("Nhap so tien ban muon gui tiet kiem: ");
                        tienTietKiem = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Nhap vao ky han(thang): ");
                        kyHan = sc.nextInt();
                        sc.nextLine();
                        tktk.setKyHan(kyHan);
                        tktk.guiTietKiem(tienTietKiem, tk);
                    }
                    break;
                case 8:
                    System.out.println("Ban da chon dang xuat tai khoan!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        }while(luaChon != 8);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        TAIKHOAN tk = new TAIKHOAN("15112005","Bach Ngoc My Duyen",5000000,"Duyen123@","0947530167");
        do
        {
            System.out.println("Nhap vao so tai khoan: ");
            soTaiKhoan=sc.nextLine();
            System.out.println("Nhap vao mat khau: ");
            password=sc.nextLine();

            if(soTaiKhoan.equals(tk.getSoTaiKhoan()) && password.equals(tk.getMatKhau()))
            {
                thanhCong(tk);
                break;
            }
            else
            {
                soLanSai++;
                if(soLanSai >= 3)
                {
                    System.out.println("Tai khoan cua ban da bi khoa!");
                    break;
                }
                else
                {
                    System.out.println("Ban da nhap sai so tai khoan hoac mat khau");
                    System.out.println("Ban con "+ (3-soLanSai)+ " lan thu!");
                }
            }   
        }while (true);
        sc.close();
    }
}
