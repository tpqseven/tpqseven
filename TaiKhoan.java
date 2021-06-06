package giadinh.edu.vn;

import java.util.Scanner;

public class TaiKhoan {
	private String taiKhoan, matkhau;
	Scanner sc = new Scanner(System.in);

	public TaiKhoan() {
		super();
	}

	public TaiKhoan(String taiKhoan, String matkhau) {
		super();
		this.taiKhoan = taiKhoan;
		this.matkhau = matkhau;
	}

	
	@Override
	public String toString() {
		return "TaiKhoan [taiKhoan=" + taiKhoan + ", matkhau=" + matkhau  + "]";
	}

	void nhap() {
		System.out.println("Tên tên tài khoản");
		this.taiKhoan = sc.nextLine();
		System.out.println("Nhập mật khẩu: ");
		this.matkhau = sc.nextLine();
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

}
