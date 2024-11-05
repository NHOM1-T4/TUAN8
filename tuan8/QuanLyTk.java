package tuan7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class QuanLyTk {
	private ArrayList<String> listDangNhap;
	private ArrayList<TaiKhoan> listTk;
	public HashMap<ArrayList<String>, ArrayList<TaiKhoan>> taiKhoanMap;

	public QuanLyTk(ArrayList<String> listDangNhap, ArrayList<TaiKhoan> listTk,
			HashMap<ArrayList<String>, ArrayList<TaiKhoan>> taiKhoanMap) {
		super();
		this.listDangNhap = listDangNhap;
		this.listTk = listTk;
		this.taiKhoanMap = taiKhoanMap;
	}

	public QuanLyTk() {
		this.listDangNhap = new ArrayList<String>();
		this.listTk = new ArrayList<TaiKhoan>();
		this.taiKhoanMap = new HashMap<ArrayList<String>, ArrayList<TaiKhoan>>();
	}

	public ArrayList<TaiKhoan> taiKhoanDangNhap(String Tk, String Mk) {
		for (ArrayList<String> key : taiKhoanMap.keySet())
			if (key.get(0).equals(Tk) && key.get(1).equals(Mk))
				return taiKhoanMap.get(key);
		return null;
	}

	public boolean timKiem(String tktimkiem) {
		if (taiKhoanMap == null)
			return false;
		for (ArrayList<String> list : taiKhoanMap.keySet())
			if (list.get(0).equals(tktimkiem))
				return true;
		return false;
	}

	public void dangKy() {
		String soTk;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("nhap tai khoan: ");
			soTk = sc.nextLine();
			if (timKiem(soTk) == true)
				System.out.println("tai khoan nay da ton tai !");
			else {
				String mk;
				System.out.println("nhap mat khau: ");
				mk = sc.nextLine();
				System.out.println("tai khoan thanh toan: ");
				TaiKhoan taiKhoanThanhToan = new TaiKhoanThanhToan(soTk, mk);
				taiKhoanThanhToan.nhap();
				System.out.println("tai khoan tiet kiem: ");
				TaiKhoan taiKhoanTietKiem = new TaiKhoanTietKiem(soTk, mk, taiKhoanThanhToan.getSoDu(),
						taiKhoanThanhToan.getMatKhau(), taiKhoanThanhToan.getMaPin());
				taiKhoanTietKiem.nhap1();
				// thêm tk mk vào list dang nhap(tk, mk)
				listDangNhap = new ArrayList<String>();
				listDangNhap.add(soTk);
				listDangNhap.add(mk);
				// thêm tktt, tktk vào listtk
				listTk = new ArrayList<TaiKhoan>();
				listTk.add(taiKhoanThanhToan);
				listTk.add(taiKhoanTietKiem);
				// đưa vào hashpmap
				taiKhoanMap.put(listDangNhap, listTk);
				System.out.println("dang ky tai khoan thanh cong !");
				break;
			}
		} while (timKiem(soTk) == true);
	}

	public TaiKhoanThanhToan tkNhanTien(String tk) {
		for (ArrayList<String> key : taiKhoanMap.keySet())
			if (key.get(0).equals(tk)) {
				for (TaiKhoan tktt : taiKhoanMap.get(key))
					if (tktt instanceof TaiKhoanThanhToan)
						return ((TaiKhoanThanhToan) tktt);
			}
		return null;
	}

	public void menu() {
		int luaChon;
		ArrayList<TaiKhoan> DstaiKhoan = new ArrayList<TaiKhoan>();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1. dang ky");
			System.out.println("2. dang nhap");
			luaChon = sc.nextInt();
			sc.nextLine();
			switch (luaChon) {
			case 1:
				this.dangKy();
				break;
			case 2:
				String taiKhoan;
				String matKhau;
				int count = 0;
				do {
					System.out.println("nhap tai khoan: ");
					taiKhoan = sc.nextLine();
					System.out.println("nhap mat khau: ");
					matKhau = sc.nextLine();
					if (taiKhoanDangNhap(taiKhoan, matKhau) == null)
						System.out.println("thong tin tai khoan hoac mat khau khong chinh xac");
					else {
						System.out.println("dang nhap thanh cong !");
						DstaiKhoan = taiKhoanDangNhap(taiKhoan, matKhau);
						TaiKhoanTietKiem taikhoantietkiem = null;
						for (int i = 0; i < DstaiKhoan.size(); i++)
							if (DstaiKhoan.get(i) instanceof TaiKhoanTietKiem)
								taikhoantietkiem = ((TaiKhoanTietKiem) DstaiKhoan.get(i));

						System.out.println("xin chao " + DstaiKhoan.get(0).getChuTaiKhoan());
						int choice;
						do {
							System.out.println("1. tai khoan thanh toan: ");
							System.out.println("2. tai khoan tiet kiem: ");
							System.out.println("3. quay lai: ");
							System.out.println("nhap lua chon: ");
							TaiKhoanThanhToan tkthanhtoan = null;
							for (int i = 0; i < DstaiKhoan.size(); i++)
								if (DstaiKhoan.get(i) instanceof TaiKhoanThanhToan)
									tkthanhtoan = ((TaiKhoanThanhToan) DstaiKhoan.get(i));
							taikhoantietkiem.updateSoDu(tkthanhtoan);
							choice = sc.nextInt(); // Added missing input for choice
							switch (choice) {
							case 1:
								int lc;
								do {
									System.out.println("1. nap tien: ");
									System.out.println("2. kiem tra so du: ");
									System.out.println("3. doi mat khau: ");
									System.out.println("4. chuyen tien: ");
									System.out.println("5. rut tien: ");
									System.out.println("6. quay lai: ");
									System.out.println("nhap lua chon: ");
									lc = sc.nextInt();
									sc.nextLine();
									switch (lc) {
									case 1:
										DstaiKhoan.get(0).napTien();
										break;
									case 2:
										DstaiKhoan.get(0).kiemTraSoDu();
										break;
									case 3:
										DstaiKhoan.get(0).doiMatKhau();
										break;
									case 4:
										String tkNhanTien;
										System.out.println("nhap tai khoan can chuyen: ");
										tkNhanTien = sc.nextLine(); // Added this line to capture input for tkNhanTien
										if (tkNhanTien(tkNhanTien) == null) {
											System.out.println("khong tim thay so tai khoan !");
										} else {
											for (TaiKhoan tktt : DstaiKhoan) {
												if (tktt instanceof TaiKhoanThanhToan) {
													tkthanhtoan = (TaiKhoanThanhToan) tktt;
													tkthanhtoan.chuyenTien(tkNhanTien(tkNhanTien));
												}
											}
										}
										break; // Added missing break for case 4
									case 5:
										for (TaiKhoan tktt : DstaiKhoan) {
											if (tktt instanceof TaiKhoanThanhToan) {
												tkthanhtoan = (TaiKhoanThanhToan) tktt;
												tkthanhtoan.rutTien();
											}
										}
										break;
									default:
										break;
									}

								} while (lc != 6); // End of do-while for lc
								break; // End of case 1 for choice
							case 2:
								int nhap;
								for (TaiKhoan tktk : DstaiKhoan) {
									if (tktk instanceof TaiKhoanTietKiem) {
										taikhoantietkiem = (TaiKhoanTietKiem) tktk;
										break;
									}
								}
								do {
									System.out.println("1. tinh lai don: ");
									System.out.println("2. tinh lai kep: ");
									System.out.println("3. rut tien: ");
									System.out.println("4. nap tien: ");
									System.out.println("5. kiem tra so du: ");
									System.out.println("6. quay lai");
									System.out.println("nhap lua chon: ");
									nhap = sc.nextInt();
									switch (nhap) {
									case 1:
										if (taikhoantietkiem != null) {
											for (TaiKhoan tktt2 : DstaiKhoan) {
												if (tktt2 instanceof TaiKhoanThanhToan) {
													tkthanhtoan = (TaiKhoanThanhToan) tktt2;
													taikhoantietkiem.congTienLaiDon(tkthanhtoan);
													System.out.println(
															"tien lai don: " + taikhoantietkiem.tinhSoTienLaiDon());
												}
											}
										}
										break;
									case 2:
										if (taikhoantietkiem != null) {
											for (TaiKhoan tktt2 : DstaiKhoan) {
												if (tktt2 instanceof TaiKhoanThanhToan) {
													tkthanhtoan = (TaiKhoanThanhToan) tktt2;
													taikhoantietkiem.congTienLaiKep(tkthanhtoan);
													System.out.println(
															"tien lai don: " + taikhoantietkiem.tinhSoTienLaiKep());
												}
											}
										}
										break;
									case 3:
										if (taikhoantietkiem != null) {
											for (TaiKhoan tktt2 : DstaiKhoan) {
												if (tktt2 instanceof TaiKhoanThanhToan) {
													tkthanhtoan = (TaiKhoanThanhToan) tktt2;
													taikhoantietkiem.rutTien();
													taikhoantietkiem.congTienRutVaoTktt(tkthanhtoan);
												}
											}
										}
										break;
									case 4:
										tkthanhtoan.napTien();
										break;
									case 5:
										tkthanhtoan.kiemTraSoDu();
										break;
									}
								} while (nhap != 6); // End of do-while for nhap
								break; // End of case 2 for choice
							}
						} while (choice != 3); // End of do-while for choice
						break;
					}
					count++;
				} while (count < 3); // End of do-while for count
				if (count >= 3) {
					System.out.println("tai khoan cua ban da bị khoa");
					return;
				}
				break;
			}
		} while (luaChon != 0); // End of do-while for luaChon (assuming exit on 0)
		sc.close(); // Close the scanner
	}
}
