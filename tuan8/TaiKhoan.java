package tuan7;

import java.util.Scanner;

public abstract class TaiKhoan {
	protected String soTaiKhoan;
	protected String chuTaiKhoan;
	protected double soDu;
	protected String matKhau;
	protected int maPin;

	public TaiKhoan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, int maPin) {
		super();
		this.soTaiKhoan = soTaiKhoan;
		this.chuTaiKhoan = chuTaiKhoan;
		this.soDu = soDu;
		this.matKhau = matKhau;
		this.maPin = maPin;
	}

	public TaiKhoan(String soTaiKhoan, String matKhau) {
		super();
		this.soTaiKhoan = soTaiKhoan;
		this.matKhau = matKhau;
	}

	public void nhap1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap chu tai khoan: ");
		this.chuTaiKhoan = sc.nextLine();
		System.out.println("nhap so Du: ");
		this.soDu = sc.nextDouble();
		sc.nextLine();
		System.out.println("nhap ma pin: ");
		this.maPin = sc.nextInt();
		sc.nextLine();
	}

	public TaiKhoan() {
	}

	public String getSoTaiKhoan() {
		return soTaiKhoan;
	}

	public void setSoTaiKhoan(String soTaiKhoan) {
		this.soTaiKhoan = soTaiKhoan;
	}

	public String getChuTaiKhoan() {
		return chuTaiKhoan;
	}

	public void setChuTaiKhoan(String chuTaiKhoan) {
		this.chuTaiKhoan = chuTaiKhoan;
	}

	public double getSoDu() {
		return soDu;
	}

	public void setSoDu(double soDu) {
		this.soDu = soDu;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public int getMaPin() {
		return maPin;
	}

	public void setMaPin(int maPin) {
		this.maPin = maPin;
	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap so tai khoan: ");
		this.soTaiKhoan = sc.nextLine();
		System.out.println("nhap chu tai khoan: ");
		this.chuTaiKhoan = sc.nextLine();
		System.out.println("nhap so Du: ");
		this.soDu = sc.nextDouble();
		sc.nextLine();
		System.out.println("nhap mat khau: ");
		this.matKhau = sc.nextLine();
		System.out.println("nhap ma pin: ");
		this.maPin = sc.nextInt();
		sc.nextLine();
	}

	public void doiMatKhau() {
		Scanner sc = new Scanner(System.in);
		String matKhauCu;
		int dem = 0;
		do {
			System.out.println("nhap mat khau cu: ");
			matKhauCu = sc.nextLine();
			if (this.matKhau.equals(matKhauCu)) {
				String matKhaumoi;
				System.out.println("nhap mat khau moi: ");
				matKhaumoi = sc.nextLine();
				if (matKhaumoi.length() < 4) {
					System.out.println("mat khau yeu !");
				} else {
					setMatKhau(matKhaumoi);
					System.out.println("thay doi mat khau thanh cong !");
					break;
				}
			} else {
				System.out.println("mat khau khong hop le");
				dem++;
			}
		} while (!this.matKhau.equals(matKhauCu) && dem <= 2);
		if (dem > 2)
			System.out.println("tai khai cua ban da bi khoa");
	}

	public void napTien() {
		Scanner sc = new Scanner(System.in);
		double soTienCanNap;
		System.out.println("nhap so tien can nap: ");
		soTienCanNap = sc.nextDouble();
		if (soTienCanNap > 0) {
			System.out.println("nap tien thanh cong !");
			setSoDu(this.soDu + soTienCanNap);
		} else
			System.out.println("so tien phai lon hon 0 !");
	}

	public void kiemTraSoDu() {
		System.out.println("tai khoan cua quy khach con: " + this.getSoDu());
	}

	public abstract void rutTien();
}
