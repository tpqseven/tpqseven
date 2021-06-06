package giadinh.edu.vn;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class TestDrivePhongHoc {
	static Scanner sc = new Scanner(System.in);
	static List<TaiKhoan> listTK = new ArrayList<TaiKhoan>();

	public static void main(String[] args) {

		DanhSachPhongHoc ds = new DanhSachPhongHoc();

		while (true) {
			// cauHinh();
			cauHinh1();
			boolean n = true;
			do {
				menu();
				switch (sc.nextInt()) {
				case 1:
					ds.nhap();
					break;
				case 2:
					ds.inDSPhong();
					break;
				case 3:
					ds.xoaPhong();
					break;
				case 4:
					ds.timKiemPhong();
					break;
				case 5:
					ds.inTongSoPhong();
					break;
				case 6:
					ds.inSLTungPhong();
					break;
				case 7:
					ds.sapXemTheoMaPhongTang();
					break;
				case 8:
					ds.sapXemTheoMaPhongGiam();
					break;
				case 9:
					ds.suaMaPhong();
					break;
				case 10:
					ds.inDSPhongDatChuan();
					break;
				case 11:
					ds.inDSPhongLT();
					break;
				case 12:
					ds.inDSPhongTN();
					break;
				case 13:
					ds.inDSPhongMT();
					break;
				case 14:
					System.out.println("Nhập vào dãy nhà cần tìm: ");
					sc.nextLine();
					String a = sc.nextLine();
					System.out.println("Nhập vào mã phòng cần tìm: ");
					int b = sc.nextInt();
					ds.timKiemPhong(a, b);
					break;
				case 15:
					System.out.println("Nhập vào dãy nhà cần tìm: ");
					sc.nextLine();
					String a1 = sc.nextLine();
					System.out.println("Nhập vào mã phòng cần tìm: ");
					int b1 = sc.nextInt();
					System.out.println("Nhập vào diện tích cần tìm: ");
					double c = sc.nextDouble();
					if (ds.timKiemPhong(a1, b1, c) == null) {
						System.out.println("Không tìm thấy phòng");
					} else {
						System.out.println("tìm thấy " + ds.timKiemPhong(a1, b1, c));
					}
					break;
				default:
					n = false;
					break;
				}
			} while (n);
		}

	}

	static void menu() {
		System.out.println("==============MENU==============");
		System.out.println("1- Thêm phòng ");
		System.out.println("2- Hiển thị thông tin danh sách phòng học");
		System.out.println("3- Xóa phòng theo mã phòng");
		System.out.println("4- Tìm kiếm phòng theo mã phòng");
		System.out.println("5- In tổng số lượng tất cả các phòng");
		System.out.println("6- In tổng số lượng từng loại phòng");
		System.out.println("7- Sắp xếp tăng dần theo mã phòng");
		System.out.println("8- Sắp xếp giảm dần theo mã phòng");
		System.out.println("9- Sửa phòng thông tin phòng theo mã phòng");
		System.out.println("10- In danh sách phòng đạt chuẩn và không đạt chuẩn");
		System.out.println("11- In danh sách phòng lý thuyết");
		System.out.println("12- In danh sách phòng thí nghiệm");
		System.out.println("13- In danh sách phòng lý máy tính");
		System.out.println("14- Tìm phòng theo dãy nhà, mã phòng");
		System.out.println("15- Tìm phong theo dãy nhà, mã phòng và diện tích");
		System.out.println("0- Đăng xuất");
	}

	/*
	 * static void cauHinh() { boolean a = false; boolean check = true; do {
	 * TaiKhoan tk = new TaiKhoan(); System.out.println("1- Đăng nhâp tài khoản");
	 * System.out.println("2- Đăng ký tài khoản (nếu chưa có)"); if (sc.nextInt() ==
	 * 1) { if (listTK.size() < 1) { System.out.
	 * println("Không có tài khoản nào trong hệ thống vui lòng đăng ký!!!"); a =
	 * true; } else { do { for (TaiKhoan taiKhoan : listTK) {
	 * System.out.println("ds tk" + taiKhoan.toString()); } tk.nhap(); for (TaiKhoan
	 * taiKhoan : listTK) { if
	 * (tk.getTaiKhoan().equals(listTK.get(listTK.indexOf(taiKhoan)).getTaiKhoan())
	 * && tk .getMatkhau().equalsIgnoreCase(listTK.get(listTK.indexOf(taiKhoan)).
	 * getMatkhau())) { System.out.println("Đăng nhập thành công!!!"); return; } }
	 * System.out.println("Sai mật khẩu hoặc tài khoản vui long nhập lại!!!"); }
	 * while (check); } } else { if (listTK.size() >= 1) { boolean kt = false; do {
	 * tk.nhap(); kt = false; for (TaiKhoan taiKhoan : listTK) { if
	 * (tk.getTaiKhoan().equalsIgnoreCase(listTK.get(listTK.indexOf(taiKhoan)).
	 * getTaiKhoan())) {
	 * System.out.println("Tên tài khoản đã tồn tại vui lòng nhập lại"); kt = true;
	 * } } } while (kt); listTK.add(tk);
	 * System.out.println("Đăng ký thành công!!!"); } else { tk.nhap();
	 * listTK.add(tk); System.out.println("Đăng ký thành công!!"); } a = true; } }
	 * while (a); }
	 */
	static void cauHinh1() {
		boolean kt = true;
		while (true) {
			TaiKhoan taikhoan = new TaiKhoan("taikhoan1", "123445");
			System.out.println("1_Đăng nhập tài khoản trường cấp: ");
			System.out.println("2_Quên tài khoản mật khẩu ");
			int n = sc.nextInt();
			sc.nextLine();
			if (n == 1) {
				boolean a = true;
				while (a) {
					System.out.println("Nhập tài khoản: ");
					String tk = sc.nextLine();
					System.out.println("Nhập mật khẩu: ");
					String mk = sc.nextLine();
					if (tk.equals(taikhoan.getTaiKhoan()) && mk.equals(taikhoan.getMatkhau())) {
						System.out.println("Đăng nhập thành công!!!!!");
						return;

					} else {
						System.out.println("Tài khoản hoặc mật khẩu không chính xác vui lòng nhập lại^^");
					}
				}

			} else {
				System.out.println(taikhoan.toString());
			}

		}
	}
}
