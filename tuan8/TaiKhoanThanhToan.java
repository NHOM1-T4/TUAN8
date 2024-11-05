package tuan7;

import java.util.Scanner;

public class TaiKhoanThanhToan extends TaiKhoan {
	private double soTienRutToiThieu;
	private double hanMucThauChi;
	private double thoiHan;

	public TaiKhoanThanhToan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, int maPin,
			double soTienRutToiThieu, double hanMucThauChi, double thoiHan) {
		super(soTaiKhoan, chuTaiKhoan, soDu, matKhau, maPin);
		this.soTienRutToiThieu = soTienRutToiThieu;
		this.hanMucThauChi = hanMucThauChi;
		this.thoiHan = thoiHan;
	}

	public TaiKhoanThanhToan(String soTaiKhoan, String matKhau) {
		super(soTaiKhoan, matKhau);
	}

	public TaiKhoanThanhToan() {
		super();
	}

	public double getSoTienRutToiThieu() {
		return soTienRutToiThieu;
	}

	public void setSoTienRutToiThieu(double soTienRutToiThieu) {
		this.soTienRutToiThieu = soTienRutToiThieu;
	}

	public double getHanMucThauChi() {
		return hanMucThauChi;
	}

	public void setHanMucThauChi(double hanMucThauChi) {
		this.hanMucThauChi = hanMucThauChi;
	}

	public double getThoiHan() {
		return thoiHan;
	}

	public void setThoiHan(double thoiHan) {
		this.thoiHan = thoiHan;
	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		super.nhap1();
		System.out.println("nhap so tien rut toi thieu: ");
		this.soTienRutToiThieu = sc.nextDouble();
		System.out.println("nhap han muc thau chi: ");
		this.hanMucThauChi = sc.nextDouble();
		System.out.println("nhap thoi han muc thau chi: ");
		this.thoiHan = sc.nextDouble();
		sc.nextLine();
	}

	public void rutTien() {

		int maPin;
		int count = 0;
		double soTienRut;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("nhap so tien can rut: ");
			soTienRut = sc.nextDouble();
			sc.nextLine();
			if (soTienRut < this.soTienRutToiThieu)
				System.out.println("so tien phai lon hon: " + soTienRutToiThieu);
			else if (super.getSoDu() > -this.hanMucThauChi && (super.getSoDu() + soTienRut) < this.hanMucThauChi) {
				do {
					System.out.println("nhap ma pin: ");
					maPin = sc.nextInt();
					if (super.getMaPin() != maPin) {
						System.out.println("ma pin sai !");
						count++;
					} else {
						System.out.println("rut tien thanh cong !");
						super.setSoDu(super.getSoDu() - soTienRut);
						break;
					}
				} while (count < 3);
				if (count >= 3)
					System.out.println("ban da nhap sai 3 lan, vui long thu lai sau 5 phut nua !");
				break;
			} else {
				System.out.println("tai khoan da dung qua muc thau chi !");
				break;
			}
		} while (soTienRut < this.soTienRutToiThieu || super.getSoDu() <= -this.hanMucThauChi);
	}

	public void chuyenTien(TaiKhoanThanhToan tktt) {
		double soTienCanChuyen;
		int maPin;
		int count = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("nhap so tien can chuyen: ");
			soTienCanChuyen = sc.nextDouble();
			if (soTienCanChuyen > 0 && soTienCanChuyen < this.getSoDu()) {
				do {
					System.out.println("nhap ma pin: ");
					maPin = sc.nextInt();
					if (super.getMaPin() != maPin) {
						System.out.println("ma pin sai !");
						count++;
					} else {
						this.setSoDu(this.getSoDu() - soTienCanChuyen);// trừ số tiền từ tk chuyển
						tktt.setSoDu(tktt.getSoDu() + soTienCanChuyen);// cộng thêm tiền từ số tiền nhận
						System.out.println("chuyen tien thanh cong !");
						break;
					}
				} while (count < 3);
				if (count >= 3)
					System.out.println("ban da nhap sai 3 lan, vui long thu lai sau 5 phut nua !");
			} else
				System.out.println("so tien khong hop le ! vui long nhap lai");
		} while (soTienCanChuyen < 0 && soTienCanChuyen > this.getSoDu());
	}
}
