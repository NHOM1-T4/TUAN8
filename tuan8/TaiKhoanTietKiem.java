package tuan7;

import java.util.Scanner;

public class TaiKhoanTietKiem extends TaiKhoan {
	private int soNamGui;
	private double lai;
	private double soTienTietKiemGui;
	private double soTienRut;

	public TaiKhoanTietKiem(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, int maPin, int soNamGui,
			double lai, double soTienTietKiemGui) {
		super(soTaiKhoan, chuTaiKhoan, soDu, matKhau, maPin);
		this.soNamGui = soNamGui;
		this.lai = lai;
		this.soTienTietKiemGui = soTienTietKiemGui;
		super.setSoDu(super.getSoDu() - this.soTienTietKiemGui);// số tiền tiết kiệm gửi sẽ bị trừ vào tk gốc
	}

	public TaiKhoanTietKiem(String soTaiKhoan, String matKhau) {
		super(soTaiKhoan, matKhau);
	}

	public TaiKhoanTietKiem(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, int maPin) {
		super(soTaiKhoan, chuTaiKhoan, soDu, matKhau, maPin);
	}

	public void nhap1() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("nhap so tien gui: ");
			this.soTienTietKiemGui = sc.nextDouble();
			if (this.soTienTietKiemGui > super.getSoDu())
				System.out.println("so tien gui tiet kiem khong hop le !, vui long nhap lai");
			else {
				// sau khi gửi tiết kiệm thì số tiền gốc sẽ bị trừ vào tài khoản tiết kiệm
				super.setSoDu(super.getSoDu() - this.soTienTietKiemGui);
				System.out.println("nhap lai suat hang thang: ");
				this.lai = sc.nextDouble();
				System.out.println("nhap so thang gui: ");
				this.soNamGui = sc.nextInt();
				sc.nextLine();
			}
		} while (this.soTienTietKiemGui > super.getSoDu());
	}

	public TaiKhoanTietKiem() {
		super();
	}

	public int getSoNamGui() {
		return soNamGui;
	}

	public void setSoNamGui(int soNamGui) {
		this.soNamGui = soNamGui;
	}

	public double getLai() {
		return lai;
	}

	public void setLai(double lai) {
		this.lai = lai;
	}

	public double getSoTienTietKiemGui() {
		return soTienTietKiemGui;
	}

	public void setSoTienTietKiemGui(double soTienTietKiemGui) {
		this.soTienTietKiemGui = soTienTietKiemGui;
	}

	public double tinhSoTienLaiDon() {
		double tienLaiDon;
		tienLaiDon = this.soTienTietKiemGui * (1 + this.lai * this.soNamGui);
		return tienLaiDon;
	}

	public double tinhSoTienLaiKep() {
		double tienLaiKep;
		tienLaiKep = this.soTienTietKiemGui * Math.pow((1 + this.lai), this.soNamGui);
		return tienLaiKep;
	}

	public void rutTien() {
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("nhap so tien can rut !");
			this.soTienRut = sc.nextDouble();
			if (this.soTienRut > this.soTienTietKiemGui) {
				System.out.println("so tien rut phai nho hon son tien tiet kiem !");
			} else {
				this.soTienTietKiemGui = this.soTienTietKiemGui - this.soTienRut;
				super.setSoDu(super.getSoDu() + this.soTienRut);
				System.out.println("rut tien thanh cong !");
				break;
			}
		} while (this.soTienRut > this.soTienTietKiemGui);
	}

	public void congTienRutVaoTktt(TaiKhoanThanhToan tktt) {
		tktt.setSoDu(tktt.getSoDu() + this.soTienRut);
	}

	public void congTienLaiDon(TaiKhoanThanhToan tktt) {
		tktt.setSoDu(tktt.getSoDu() + this.tinhSoTienLaiDon());
	}

	public void congTienLaiKep(TaiKhoanThanhToan tktt) {
		tktt.setSoDu(tktt.getSoDu() + this.tinhSoTienLaiKep());
	}

	public void updateSoDu(TaiKhoanThanhToan tktt) {
		tktt.setSoDu(tktt.getSoDu() - this.soTienTietKiemGui);
	}
}
